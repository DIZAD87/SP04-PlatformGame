/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class
    public class PowerupHealth
        {
            //Properties
                private double xPos; //Anchor dim, does not change with scroll
                private double yPos; //Anchor dim, does not change with scroll
                private boolean active;
                private int polyCount;
                private double[] xBoxArray;
                private double[] yBoxArray;
                private double[] xVerticaCrossArray;
                private double[] yVerticalCrossArray;
                private double[] xHorizontalCrossArray;
                private double[] yHorizontalCrossArray;
                private Camera camera;
                private double collisionWidth;
                private double phase;
                PlaySound playSound = new PlaySound();

            //Constructor
                PowerupHealth(double xPos, double yPos, double Phase, Camera camera)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.active = true;
                        this.polyCount = 4;
                        this.xBoxArray = new double[polyCount];
                        this.yBoxArray = new double[polyCount];
                        this.xVerticaCrossArray = new double[polyCount];
                        this.yVerticalCrossArray = new double[polyCount];
                        this.xHorizontalCrossArray = new double[polyCount];
                        this.yHorizontalCrossArray = new double[polyCount];
                        this.camera = camera;
                        this.collisionWidth = 80;
                        this.phase = phase;
                    }

            //Methods
                //Mutators
                    public void setXPos(double xPosEntry)
                        {xPos = xPosEntry;}
                    public void setYPos(double yPosEntry)
                        {yPos = yPosEntry;} 
                    public void setActive(boolean activeEntry)
                        {active = activeEntry;}

                //Accessors
                    public double getXPos()
                        {return xPos;}
                    public double getYPos()
                        {return yPos;}
                    public boolean getActive()
                        {return active;}
                    public double getCollisionWidth()
                        {return collisionWidth;}

               //Custom methods
                    public void checkCollision(Player playerEntry, PlayerStatus playerStatusEntry, int bonusEntry)
                        {
                            if(
                                   playerEntry.body.getXPos() > (getXPos() + camera.getScrollX()) &&
                                   playerEntry.body.getXPos() < (getXPos() + camera.getScrollX()) + collisionWidth &&
                                   playerEntry.body.getYPos() > (getYPos() + camera.getScrollY()) &&
                                   playerEntry.body.getYPos() < (getYPos() + camera.getScrollY()) + collisionWidth &&
                                   getActive() == true
                              )
                               {
                                   playSound.healthSound();
                                   setActive(false);
                                   playerStatusEntry.setHealth(playerStatusEntry.getHealth() + bonusEntry);
                                  // camera.shake(100);
                               }
                        }

                    public void updatePositions(double timeEntry)
                        {
                            double hoverOscillator = 20 * Math.cos((timeEntry + phase + Math.PI) * 3); //Amp, speed
                            //Box
                                xBoxArray[0] = xPos + 0 + camera.getScrollX();
                                yBoxArray[0] = yPos + 0 + camera.getScrollY() + hoverOscillator;

                                xBoxArray[1] = xPos + 70 + camera.getScrollX();
                                yBoxArray[1] = yPos + 0 + camera.getScrollY() + hoverOscillator;

                                xBoxArray[2] = xPos + 70 + camera.getScrollX();
                                yBoxArray[2] = yPos + 70 + camera.getScrollY() + hoverOscillator;      

                                xBoxArray[3] = xPos + 0 + camera.getScrollX();
                                yBoxArray[3] = yPos + 70 + camera.getScrollY() + hoverOscillator;

                            //Vertical cross
                                xVerticaCrossArray[0] = xPos + 27 + camera.getScrollX();
                                yVerticalCrossArray[0] = yPos + 12 + camera.getScrollY() + hoverOscillator;

                                xVerticaCrossArray[1] = xPos + 27 + 16 + camera.getScrollX();
                                yVerticalCrossArray[1] = yPos + 12 + camera.getScrollY() + hoverOscillator;

                                xVerticaCrossArray[2] = xPos + 27 + 16 + camera.getScrollX();
                                yVerticalCrossArray[2] = yPos + 70 - 12 + camera.getScrollY() + hoverOscillator;      

                                xVerticaCrossArray[3] = xPos + 27 + camera.getScrollX();
                                yVerticalCrossArray[3] = yPos + 70 - 12 + camera.getScrollY() + hoverOscillator;

                            //Horizontal cross
                                xHorizontalCrossArray[0] = xPos + 12 + camera.getScrollX();
                                yHorizontalCrossArray[0] = yPos + 27 + camera.getScrollY() + hoverOscillator;

                                xHorizontalCrossArray[1] = xPos + 12 + 46 + camera.getScrollX();
                                yHorizontalCrossArray[1] = yPos + 27 + camera.getScrollY() + hoverOscillator;

                                xHorizontalCrossArray[2] = xPos + 12 + 46 + camera.getScrollX();
                                yHorizontalCrossArray[2] = yPos + 27 + 16 + camera.getScrollY() + hoverOscillator;      

                                xHorizontalCrossArray[3] = xPos + 12 + camera.getScrollX();
                                yHorizontalCrossArray[3] = yPos + 27 + 16 + camera.getScrollY() + hoverOscillator;
                        }

                    public void draw(GraphicsContext gcEntry, double timeEntry)
                        {
                            double opacityOscillator = Math.abs(Math.cos(timeEntry * 1.5));
                            updatePositions(timeEntry);
                            if (active == true)
                                {   
                                    //Back white fill
                                        gcEntry.setFill(Color.web("#338A6A", 1.0));
                                        gcEntry.fillPolygon(xBoxArray , yBoxArray , polyCount);   
                                    //Fore yellow highlight fill
                                        gcEntry.setFill(Color.web("#3DB872", opacityOscillator));
                                        gcEntry.fillPolygon(xBoxArray , yBoxArray , polyCount); 
                                    //Cross
                                        gcEntry.setFill(Color.web("#FFFFFF", 1.0));
                                        gcEntry.fillPolygon(xVerticaCrossArray , yVerticalCrossArray , polyCount); 
                                        gcEntry.fillPolygon(xHorizontalCrossArray , yHorizontalCrossArray , polyCount); 
                                }
                        }
        }//End of class
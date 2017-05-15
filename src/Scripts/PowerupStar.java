/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/
//Package
    package Scripts;

//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;
    import javafx.scene.paint.CycleMethod;
    import javafx.scene.paint.LinearGradient;
    import javafx.scene.paint.Stop;

//Class    
    public class PowerupStar
        {
            //Properties
                private double xPos; //Anchor dim, does not change with scroll
                private double yPos; //Anchor dim, does not change with scroll
                private boolean active;
                private int polyCount;
                private double[] xArray;
                private double[] yArray;
                private Camera camera;
                private double collisionWidth;
                private double phase;
                PlaySound playSound = new PlaySound();

            //Constructor
                PowerupStar(double xPos, double yPos, double Phase, Camera camera)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.active = true;
                        this.polyCount = 10;
                        this.xArray = new double[polyCount];
                        this.yArray = new double[polyCount];
                        this.camera = camera;
                        this.collisionWidth = 80;
                        this.phase = phase;
                    }

            //Methods
                //Mutators
                    public void setXPos(double xPosEntry)
                        { xPos = xPosEntry; }
                    public void setYPos(double yPosEntry)
                        { yPos = yPosEntry; } 
                    public void setActive(boolean activeEntry)
                        { active = activeEntry; }

                //Accessors
                    public double getXPos()
                        { return xPos; }
                    public double getYPos()
                        { return yPos; }
                    public boolean getActive()
                        { return active; }
                    public double getCollisionWidth()
                        { return collisionWidth; }

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
                                   playSound.pickupStarSound();
                                   setActive(false);
                                   playerStatusEntry.setPoints(playerStatusEntry.getPoints() + bonusEntry);
                                  // camera.shake(100);
                               }
                        }

                    public void updatePositions(double timeEntry)
                        {
                            double hoverOscillator = 20 * Math.cos((timeEntry + phase) * 3); //Amp, speed

                            xArray[0] = xPos + 42 + camera.getScrollX();
                            yArray[0] = yPos + 0 + camera.getScrollY() + hoverOscillator;

                            xArray[1] = xPos + 53 + camera.getScrollX();
                            yArray[1] = yPos + 30 + camera.getScrollY() + hoverOscillator;

                            xArray[2] = xPos + 83 + camera.getScrollX();
                            yArray[2] = yPos + 33 + camera.getScrollY() + hoverOscillator;      

                            xArray[3] = xPos + 60 + camera.getScrollX();
                            yArray[3] = yPos + 51 + camera.getScrollY() + hoverOscillator;

                            xArray[4] = xPos + 68 + camera.getScrollX();
                            yArray[4] = yPos + 84 + camera.getScrollY() + hoverOscillator;

                            xArray[5] = xPos + 42 + camera.getScrollX();
                            yArray[5] = yPos + 66 + camera.getScrollY() + hoverOscillator; 

                            xArray[6] = xPos + 17 + camera.getScrollX();
                            yArray[6] = yPos + 83 + camera.getScrollY() + hoverOscillator;      

                            xArray[7] = xPos + 23 + camera.getScrollX();
                            yArray[7] = yPos + 51 + camera.getScrollY() + hoverOscillator;

                            xArray[8] = xPos + 0 + camera.getScrollX();
                            yArray[8] = yPos + 33 + camera.getScrollY() + hoverOscillator;

                            xArray[9] = xPos + 30 + camera.getScrollX();
                            yArray[9] = yPos + 30 + camera.getScrollY() + hoverOscillator;

                        }

                    public void draw(GraphicsContext gcEntry, double timeEntry)
                        {
                            double opacityOscillator = Math.abs(Math.cos(timeEntry * 1.5));
                            updatePositions(timeEntry);
                            if (active == true)
                                {   

                                    //Back white fill
                                        gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#FFFFFF", 1.0)), new Stop(1.0, Color.web("#FFFFFF", 1.0))));
                                        gcEntry.fillPolygon(xArray , yArray , polyCount);   
                                    //Fore yellow highlight fill
                                        gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#FFF700", opacityOscillator)), new Stop(1.0, Color.web("#FFF700", opacityOscillator))));
                                        gcEntry.fillPolygon(xArray , yArray , polyCount);   
                                }
                        }
        }//End of class
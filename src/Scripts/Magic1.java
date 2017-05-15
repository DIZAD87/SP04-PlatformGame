/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries    
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class    
    public class Magic1
        {
            //Properties
                private double xPos; //Anchor dim, does not change with scroll
                private double yPos; //Anchor dim, does not change with scroll
                private double x1;
                private double y1;
                private boolean active;
                private int radius;
                private Camera camera;
                private Player player;
                private double collisionWidth;
                private double xSpeed;
                private double ySpeed;
                private double startTime;
                private double xDestination;
                private double yDestination;
                private double magicSpeed;
                
            //Constructor
                Magic1(double xPos, double yPos, Camera camera, Player player)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.x1 = 0;
                        this.y1 = 0;
                        this.active = false;
                        this.camera = camera;
                        this.player = player;
                        this.collisionWidth = 80;
                        this.radius = 25;
                        this.xSpeed = 500;
                        this.magicSpeed = 750;
                    }

            //Methods
                //Mutators
                    public void setXPos(double xPosEntry)
                        {xPos = xPosEntry;}
                    public void setYPos(double yPosEntry)
                        {yPos = yPosEntry;} 
                    public void setActive(boolean activeEntry)
                        {active = activeEntry;}
                    public void setStartTime(double startTimeEntry)
                        {startTime = startTimeEntry;}
                    public void setXDestination(double xDestinationEntry)
                        {xDestination = xDestinationEntry;}
                    public void setYDestination(double yDestinationEntry)
                        {yDestination = yDestinationEntry;}

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
                    public void checkCollisionWithBadGuy(Player playerEntry, PlayerStatus playerStatusEntry, int bonusEntry)
                        {
                            if(
                                   playerEntry.body.getXPos() > (getXPos() + camera.getScrollX()) &&
                                   playerEntry.body.getXPos() < (getXPos() + camera.getScrollX()) + collisionWidth &&
                                   playerEntry.body.getYPos() > (getYPos() + camera.getScrollY()) &&
                                   playerEntry.body.getYPos() < (getYPos() + camera.getScrollY()) + collisionWidth &&
                                   getActive() == true
                              )
                               {
                                   setActive(false);
                                   playerStatusEntry.setHealth(playerStatusEntry.getHealth() + bonusEntry);
                                  // camera.shake(100);
                               }
                        }

                    public void deactivateOutsideWindow(double windowWidthEntry, double windowHeightEntry)
                        {
                            double deactivateMargin = 0;
                            if(
                                    (x1 > (windowWidthEntry + deactivateMargin)) ||
                                    (x1 < -deactivateMargin) ||
                                    (y1 > windowHeightEntry + deactivateMargin) ||
                                    (y1 < -deactivateMargin)

                              )
                               {
                                   setActive(false);
                               }
                        }

                    public void updatePositions(double timeEntry)
                        {
                            int magicDirection = 1;
                            if (xDestination > xPos + camera.getScrollX())
                                { magicDirection = 1; }
                            else if (xDestination <= xPos + camera.getScrollX())
                                { magicDirection = -1; }
                            xSpeed = magicDirection * magicSpeed * Math.cos(Math.atan((yDestination - yPos)/(xDestination - xPos)));
                            ySpeed = magicDirection * magicSpeed * Math.sin(Math.atan((yDestination - yPos)/(xDestination - xPos))); 
                            x1 = xPos + camera.getScrollX() + timeEntry * xSpeed;
                            y1 = yPos + camera.getScrollY() + 5 * Math.sin(timeEntry * 20) + timeEntry * ySpeed;
                        }

                    public void draw(GraphicsContext gcEntry, double timeEntry)
                        {
                            double radiiReduce = 1.0;
                            double delay = 0.02;
                            double opacityReduce = 0.15;
                            double elapsedTime = timeEntry - startTime;
                            if (active == true)
                                {  
                                    updatePositions(elapsedTime - delay * 5);
                                        gcEntry.setFill(Color.web("#FF69ED", 1.0 - opacityReduce * 5));
                                        gcEntry.fillOval(x1, y1, radius - (radiiReduce * 5), radius - (radiiReduce * 5));
                                    updatePositions(elapsedTime - delay * 4);
                                        gcEntry.setFill(Color.web("#FC7CED", 1.0 - opacityReduce * 4));
                                        gcEntry.fillOval(x1, y1, radius - (radiiReduce * 4), radius - (radiiReduce * 4));
                                    updatePositions(elapsedTime - delay * 3);
                                        gcEntry.setFill(Color.web("#FF96F3", 1.0 - opacityReduce * 3));
                                        gcEntry.fillOval(x1, y1, radius - (radiiReduce * 3), radius - (radiiReduce * 3));
                                    updatePositions(elapsedTime - delay * 2);
                                        gcEntry.setFill(Color.web("#FCA7F2", 1.0 - opacityReduce * 2));
                                        gcEntry.fillOval(x1, y1, radius - (radiiReduce * 2), radius - (radiiReduce * 2));
                                    updatePositions(elapsedTime - delay * 1);
                                        gcEntry.setFill(Color.web("#FFBAF7", 1.0 - opacityReduce * 1));
                                        gcEntry.fillOval(x1, y1, radius - (radiiReduce * 1), radius - (radiiReduce * 1));
                                    updatePositions(elapsedTime);
                                        gcEntry.setFill(Color.web("#FFFFFF", 1.0));
                                        gcEntry.fillOval(x1, y1, radius, radius);
                                }
                        }
        }//End of class
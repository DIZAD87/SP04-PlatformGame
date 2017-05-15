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
    public class Badguy
        {
            //Properties
                //Variables
                    private double xPos; //Anchor dim, does not change with scroll
                    private double yPos; //Anchor dim, does not change with scroll
                    private boolean active;
                    private int polyCount;
                    private double[] xArray;
                    private double[] yArray;
                    private Camera camera;
                    private double collisionWidth;
                    private double xHead;
                    private double yHead;
                    private double rotationAmp;
                    private double rotationSpeed;
                    private double phase;

            //Constructor
                Badguy(double xPos, double yPos, double phase, Camera camera)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.active = true;
                        this.polyCount = 5;
                        this.xArray = new double[polyCount];
                        this.yArray = new double[polyCount];
                        this.camera = camera;
                        this.collisionWidth = 80;
                        this.xHead = 0;
                        this.yHead = 0;
                        this.rotationAmp = 100;
                        this.rotationSpeed = 1;
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
                    public void checkCollision(Player playerEntry, PlayerStatus playerStatusEntry, int deductionEntry)
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
                                   playerStatusEntry.setHealth(playerStatusEntry.getHealth() - deductionEntry);
                                  // camera.shake(100);
                               }
                        }

                    public void updatePositions(double timeEntry)
                        {
                            xHead = xPos + 18 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yHead = yPos + 18 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);

                            xArray[0] = xPos + 42 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yArray[0] = yPos + 0 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);

                            xArray[1] = xPos + 83 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yArray[1] = yPos + 33 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);      


                            xArray[2] = xPos + 68 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yArray[2] = yPos + 84 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);


                            xArray[3] = xPos + 17 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yArray[3] = yPos + 83 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);      


                            xArray[4] = xPos + 0 + camera.getScrollX() + rotationAmp * Math.cos(timeEntry * rotationSpeed + phase);
                            yArray[4] = yPos + 33 + camera.getScrollY() + rotationAmp * Math.sin(timeEntry * rotationSpeed + phase);
                        }

                    public void draw(GraphicsContext gcEntry, double timeEntry)
                        {
                            updatePositions(timeEntry);
                            if (active == true)
                                {

                                    gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#FF0000",1.0)), new Stop(1.0, Color.web("#FF0000",1.0))));
                                    gcEntry.fillPolygon(xArray , yArray , polyCount); //Spikes
                                    gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#8C56B8",1.0)), new Stop(1.0, Color.web("#8C56B8",1.0))));
                                    gcEntry.fillOval(xHead, yHead, 50, 50); //Head
                                    gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#66FF00",1.0)), new Stop(1.0, Color.web("#66FF00",1.0))));
                                    gcEntry.fillOval(xHead + 5, yHead + 5, 40, 40); //Eyeball
                                    gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web("#454545",1.0)), new Stop(1.0, Color.web("#454545",1.0))));
                                    gcEntry.fillOval(xHead + 20, yHead + 20, 5, 15); //Pupil
                                }
                        }
        }//End of class
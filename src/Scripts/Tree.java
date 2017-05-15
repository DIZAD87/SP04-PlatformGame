/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries      
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class
    public class Tree
        {
            //Properties
                private double xPos; //Anchor dim, does not change with scroll
                private double yPos; //Anchor dim, does not change with scroll
                private double angle;
                private double trunkWidth;
                private double trunkLength;
                private double crownDiameter;
                private String trunkColor;
                private String crownColor;
                private Camera camera;
                private double x1;
                private double y1;
                private double x2;
                private double y2;

            //Constructor
                Tree(double xPos, double yPos, double angle, double trunkWidth, double trunkLength, double crownDiameter, String trunkColor, String crownColor, Camera camera)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.angle = angle;
                        this.trunkWidth = trunkWidth;
                        this.trunkLength = trunkLength;
                        this.crownDiameter = crownDiameter;
                        this.trunkColor = trunkColor;
                        this.crownColor = crownColor;
                        this.camera = camera;
                        this.x1 = xPos;
                        this.y1 = yPos;
                        this.x2 = xPos + (trunkLength * Math.cos(Math.toRadians(angle)));
                        this.y2 =  yPos + (trunkLength * Math.sin(Math.toRadians(angle)));
                    }

            //Methods
                //Mutators
                    public void setXPos(double xPosEntry)
                        { xPos = xPosEntry; }
                    public void setYPos(double yPosEntry)
                        { yPos = yPosEntry; } 

                //Accessors
                    public double getXPos()
                        { return xPos; }
                    public double getYPos()
                        { return yPos; }

               //Custom methods
                    public void updatePositions()
                        {
                            x1 = xPos + camera.getScrollX();
                            y1 = yPos + camera.getScrollY();
                            x2 = xPos + (trunkLength * Math.cos(Math.toRadians(angle))) + camera.getScrollX();
                            y2 = yPos + (trunkLength * Math.sin(Math.toRadians(angle))) + camera.getScrollY();
                        }

                    public void draw(GraphicsContext gcEntry)
                        {
                            updatePositions();
                            //Trunk
                                gcEntry.setStroke(Color.web(trunkColor,1.0));
                                gcEntry.setLineWidth(trunkWidth);
                                gcEntry.strokeLine(x1, y1, x2, y2); //x1, y1, x2, y2
                            //Branch
                            //Crown
                                gcEntry.setFill(Color.web(crownColor, 1.0));
                                gcEntry.fillOval(x2 - crownDiameter/2, y2 - crownDiameter/2, crownDiameter, crownDiameter);          
                        }
        }//End of class
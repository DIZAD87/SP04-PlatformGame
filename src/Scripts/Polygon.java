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
    public class Polygon
        {
            //Properties
                private int arrayLength;
                private double[] refArrayX;
                private double[] refArrayY;
                private double[] xArray;
                private double[] yArray;
                private String color1;
                private String color2;
                private String depth;
                private double depthAdjustedScrollX;
                private double depthAdjustedScrollY;
                private Camera camera;
                private double xMin;
                private double xMax;
                private double yMin;
                private double yMax;

            //Instances
                GlobalVariables globalVariables = new GlobalVariables();

            //Constructor
                Polygon(int arrayLength , String color1, String color2, String depth, Camera camera)
                    {
                        this.arrayLength = arrayLength;
                        this.xArray = new double[arrayLength];
                        this.yArray = new double[arrayLength];
                        this.refArrayX = new double [arrayLength];
                        this.refArrayY = new double [arrayLength];
                        this.color1 = color1;
                        this.color2 = color2;
                        this.depth = depth;
                        this.camera = camera;
                    }
                
            //Methods
                public boolean checkCollision(Player playerEntry)
                    {
                        if ( 
                             (isPolyUnder(playerEntry.body.getXPos()) == false) || //no platform under
                             ((playerEntry.body.getYPos() + 80) < returnYGivenX(playerEntry.body.getXPos())) //Or above a platform //yArray[2]
                           )
                            { return false; }
                        else
                            { return true; }        
                    }

                    //Return the height using y = mx + b
                        public double returnYGivenX(double xEntry)
                            {
                                int peek = 2;
                                double x1 = xArray[peek - 1];
                                double y1 = yArray[peek - 1];
                                double x2 = xArray[peek];
                                double y2 = yArray[peek];
                                double x3 = xEntry;
                                double slope = (y2 - y1)/(x2 - x1);
                                double y3 = slope * x3 + y1;
                                return y3; 
                            }

                    //Checks to see if a platform is under the player
                        public boolean isPolyUnder(double xEntry)
                            {
                                findXMin();
                                findXMax();
                                if (xEntry < xMin || xEntry > xMax)
                                    { return false; }
                                else
                                    { return true; }      
                            }

                    public void findXMin()
                        {
                            for (int i = 0; i < xArray.length; i++)
                            { 
                                for (int j = 0; j < xArray.length; j++)
                                {
                                    if (xArray[i] < xArray[j])
                                    { xMin = xArray[i]; }   
                                } 
                            } 
                        }

                    public void findXMax()
                        {
                            for (int i = 0; i < xArray.length; i++)
                            { 
                                for (int j = 0; j < xArray.length; j++)
                                {
                                    if (xArray[i] > xArray[j])
                                    { xMax = xArray[i]; }   
                                } 
                            }
                        }

                    public void findYMin()
                        {
                            for (int i = 0; i < yArray.length; i++)
                            { 
                                for (int j = 0; j < yArray.length; j++)
                                {
                                    if (yArray[i] < yArray[j])
                                    { yMin = yArray[i]; }   
                                } 
                            }
                        }

                    public void findYMax()
                        {
                            for (int i = 0; i < yArray.length; i++)
                            { 
                                for (int j = 0; j < yArray.length; j++)
                                {
                                    if (yArray[i] > yArray[j])
                                    { yMax = yArray[i]; }   
                                } 
                            }
                        }

                    public void defineCoordinate(int indexEntry, double xEntry, double yEntry)
                        {
                            refArrayX[indexEntry] = xEntry;
                            refArrayY[indexEntry] = yEntry;
                            xArray[indexEntry] = xEntry;
                            yArray[indexEntry] = yEntry;
                        }

                    //Update positions
                        public void updatePositions()
                            {
                                 //Add scroll
                                    for (int i = 0; i < xArray.length; i++)
                                        { xArray[i] = refArrayX[i] + camera.getDepthAdjustedScrollX(depth); }
                                    for (int i = 0; i < yArray.length; i++)
                                        { yArray[i] = refArrayY[i] + camera.getDepthAdjustedScrollY(depth); }    
                            }

                    //Draw polygon
                        public void draw(GraphicsContext gcEntry)
                            {        
                               updatePositions();
                               gcEntry.setFill(new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT,  new Stop(0.0, Color.web(color1 , 1.0)), new Stop(1.0, Color.web(color2 , 1.0))));
                               gcEntry.fillPolygon(xArray , yArray , arrayLength);
                            }
        }//End of class
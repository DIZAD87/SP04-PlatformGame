/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class
    public class Cloud
        {
            //Properties
                private double xOffset; //Anchor dim, does not change with scroll
                private double yOffset; //Anchor dim, does not change with scroll
                private double[] wArray;
                private double[] hArray;
                private double[] xArray;
                private double[] yArray;
                private double[] xArrayRef;
                private double[] yArrayRef;
                private double depthAdjustedScrollX;
                private double depthAdjustedScrollY;
                private Camera camera;
                private String color;
                private String depth;
                
            //Instances
                GlobalVariables globalVariables = new GlobalVariables();

            //Constructor
                Cloud(double xOffset, double yOffset, int arrayLength, String depth, Camera camera)
                    {
                        this.xOffset = xOffset;
                        this.yOffset = yOffset;
                        this.xArray = new double[arrayLength];
                        this.yArray = new double[arrayLength];
                        this.wArray = new double[arrayLength];
                        this.hArray = new double[arrayLength];
                        this.xArrayRef = new double[arrayLength];
                        this.yArrayRef = new double[arrayLength];
                        this.camera = camera;
                        this.depth = depth;
                        switch(depth)
                            {
                                case "fore": color = "#edfcff"; break;
                                case "mid": color = "#d9f8ff"; break;
                                case "back": color = "#b3f2ff"; break;
                                case "back2": color = "#8debfe"; break;
                                case "matte": color = "#8debfe"; break;
                                default: break;
                            }
                    }

            //Methods
               //Custom methods
                    public void defineCircle(int indexEntry, double widthEntry, double heightEntry)
                        {
                            wArray[indexEntry] = widthEntry;
                            hArray[indexEntry] = heightEntry;
                        }

                    public void updatePositions()
                        {
                                for (int i = 0; i < xArray.length; i++)
                                    { double shift = 0;
                                        if (i == 0)
                                            { shift = i * wArray[i]/2; }
                                        else
                                            { shift = i * wArray[i - 1]/2; }

                                        xArray[i] = xOffset + shift + camera.getDepthAdjustedScrollX(depth); 
                                    }

                                for (int i = 0; i < yArray.length; i++)
                                    { yArray[i] = yOffset - (hArray[i]/2) + camera.getDepthAdjustedScrollY(depth); }  
                        }

                    public void draw(GraphicsContext gcEntry)
                        {
                            updatePositions();
                            gcEntry.setFill(Color.web(color, 1.0));
                            for (int i = 0; i < xArray.length; i++)
                                {  gcEntry.fillOval(xArray[i], yArray[i], wArray[i], hArray[i]); }
                        }
        }//End of class
/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Class
    public class Camera
        {
            //Properties
                //Variables
                    private double scrollX;
                    private double scrollY; 
                    private double depthAdjustedScrollX;
                    private double depthAdjustedScrollY;
                    
                //Instances
                    GlobalVariables globalVariables = new GlobalVariables();
                    
            //Constructor
                Camera()
                    {
                        this.scrollX = 0;
                        this.scrollY = 0;
                    }
                
            //Methods
                //Accessors
                    public double getScrollX()
                        { return scrollX; }
                    public double getScrollY()
                        { return scrollY; }
                    
                //Mutators
                    public void setScrollX(double xEntry)
                        { scrollX = xEntry; }
                       
                    public void setScrollY(double yEntry)
                        { scrollY = yEntry; }
                    
                //Custom Methods     
                    public double getDepthAdjustedScrollX(String depthEntry)
                        {
                             switch(depthEntry)
                                   {
                                       case "fore": depthAdjustedScrollX = getScrollX(); break;
                                       case "mid": depthAdjustedScrollX = getScrollX() / globalVariables.getMidgroundDamper(); break; 
                                       case "back": depthAdjustedScrollX = getScrollX() / globalVariables.getBackgroundDamper(); break;
                                       case "back2": depthAdjustedScrollX = getScrollX() / globalVariables.getBackground2Damper(); break;        
                                       case "matte": depthAdjustedScrollX = 0; break;
                                       default: break;
                                   }
                             return depthAdjustedScrollX;
                        }

                    public double getDepthAdjustedScrollY(String depthEntry)
                        {
                             switch(depthEntry)
                                   {
                                       case "fore":  depthAdjustedScrollY = getScrollY(); break;  
                                       case "mid": depthAdjustedScrollY = getScrollY() / globalVariables.getMidgroundDamper(); break;         
                                       case "back": depthAdjustedScrollY = getScrollY() / globalVariables.getBackgroundDamper(); break;          
                                       case "back2": depthAdjustedScrollY = getScrollY() / globalVariables.getBackground2Damper(); break;                   
                                       case "matte": depthAdjustedScrollY = 0; break;           
                                       default: break;
                                   }
                             return depthAdjustedScrollY;
                        }

                    public void updateX(double updatedEntry)
                        {
                            scrollX = scrollX + updatedEntry;
                        }

                    public void updateY(double updatedEntry)
                        {
                           scrollY = scrollY + updatedEntry;
                        }

                    public void shake(int scaleEntry)
                        {
                            globalVariables.oscillateOscillator();
                            scrollX = scrollX + scaleEntry * Math.cos(Math.toRadians(globalVariables.getOscillator()))/1.1;
                            scrollY = scrollY + scaleEntry * Math.cos(Math.toRadians(globalVariables.getOscillator()))/1.1;
                        } 
        }//End of class
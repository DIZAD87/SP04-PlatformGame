/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Class
    public class Limb
        {
            //Properties
                private double xPos;
                private double yPos;
                private double angle;
                private double width;
                private double length;

            //Constructor
                Limb(double angle)
                    { this.angle = angle; }

            //Methods
                //Mutators
                    public void setXPos(double xPosEntry)
                        { xPos = xPosEntry; }
                    public void setYPos(double yPosEntry)
                        { yPos = yPosEntry; } 
                    public void setAngle(double angleEntry)
                        { angle = angleEntry; }
                    public void setWidth(double widthEntry)
                        { width = widthEntry; }
                    public void setLength(double lengthEntry)
                        { length = lengthEntry; }

                //Accessors
                    public double getXPos()
                        { return xPos; }
                    public double getYPos()
                        { return yPos; }
                    public double getAngle()
                        { return angle; }
                    public double getWidth()
                        { return width; } 
                    public double getLength()
                        { return length; } 
        }//End of class
/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Class
    public class Node
        {
        //Properties
            private int key;
            private double posX;
            private double posY;
            private double angle;

        //Constructor 
            Node(int key)
                {
                    this.key = key;
                    this.posX = 0;
                    this.posY = 0;
                    this.angle = 90; //90 is down
                }

        //Methods
            //Mutators
                public void setKey(int keyEntry)
                    { key = keyEntry; }
                public void setPosX(double xPosEntry)
                    { posX = xPosEntry; } 
                public void setPosY(double yPosEntry)
                    { posY = yPosEntry; }
                public void setAngle(double angleEntry)
                    { angle = angleEntry; }

            //Accessors
                public double getKey()
                    { return key; }
                public double getPosX()
                    { return posX; }
                public double getPosY()
                    { return posY; }
                public double getAngle()
                    { return angle; }
        }//End of class
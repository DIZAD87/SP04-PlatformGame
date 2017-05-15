/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Class
    public class Forces
        {
            //Properties
                private double gravity;
                private double forceX;
                private double forceY;

            //Constructor
                public Forces(double gravity)
                    {
                        this.gravity = gravity;
                        this.forceY = 0;
                        this.forceX = 0;
                    }

            //Methods
                //Mutators
                    public void setForceX(double forceXEntry)
                        { forceX = forceXEntry; }
                    public void setForceY(double forceYEntry)
                        { forceY = forceYEntry; } 
                    public void setGravity(double gravityEntry)
                        { gravity = gravityEntry; }

                //Accessors
                    public double getForceX()
                        { return forceX; }
                    public double getForceY()
                        { return forceY; }
                    public double getGravity()
                        { return gravity; } 
        }//End of class
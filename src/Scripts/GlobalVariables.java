/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Class    
    public class GlobalVariables
        {
        //Properties
            private double gravityConstant;
            private double runX;
            private double jumpY;
            private double decayFactor;
            private double midgroundDamper;
            private double backgroundDamper;
            private double background2Damper;
            private double matteDamper;
            private int powerupBonus;
            private int powerupHealthBonus;
            private double xPlayerForce;
            private double yPlayerForce;
            private int oscillator;
            private double xPlayerDefaultCoordinate;
            private double yPlayerDefaultCOordinate;
            private int contactBadguy;
            private double xRunAccelerator;
            private double xAcceleration;
            private double yAcceleration;
            private double PlatformFriction;
            private int magicCounter;
            private boolean playerCollisionBottom;

        //Constructor
            public GlobalVariables()
                {
                    this.gravityConstant = 10;
                    this.runX = 0.5;
                    this.jumpY = 20;
                    this.decayFactor = 1.1;
                    this.midgroundDamper = 2;
                    this.backgroundDamper = 5;
                    this.background2Damper = 10;
                    this.xPlayerForce = 20;
                    this.yPlayerForce = 20;
                    this.xAcceleration = 0;
                    this.yAcceleration = 0;
                    this.PlatformFriction = 1.5;
                    this.powerupHealthBonus = 10;
                    this.magicCounter = 1;

                    //Player
                    this.xPlayerDefaultCoordinate = 400;//245
                    this.yPlayerDefaultCOordinate = 200;//300
                    //Bonuses
                    this.powerupBonus = 10;
                    this.oscillator = 0;
                    //Deductions
                    this.contactBadguy = 10;
                    this.xRunAccelerator = 0;
                    this.playerCollisionBottom = false;
                }

        //Methods
            //Mutators
                public void setRunX(double forceXConstantEntry)
                    { runX = forceXConstantEntry; }
                public void setJumpY(double forceYConstantEntry)
                    { jumpY = forceYConstantEntry; } 
                public void setGravityConstant(double gravityEntry)
                    { gravityConstant = gravityEntry; }
                public void setDecayFactor(double decayFactorEntry)
                    { decayFactor = decayFactorEntry; }
                public void setOscillator(int oscillatorEntry)
                    { oscillator = oscillatorEntry; }
                public void setXRunAccelerator(double xAcceleratorEntry)
                    { xRunAccelerator = xAcceleratorEntry; }
                public void setXAcceleration(double xAccelerationEntry)
                    { xAcceleration = xAccelerationEntry; }
                public void setYAcceleration(double yAccelerationEntry)
                    { yAcceleration = yAccelerationEntry; }
                public void setPlayerCollisionBottom(boolean playerCollisionBottomEntry)
                    { playerCollisionBottom = playerCollisionBottomEntry; }
                public void setBackground2Damper(double background2DamperEntry)
                    { background2Damper = background2DamperEntry; }
                public void setMagicCounter(int magicCounterEntry)
                    { magicCounter = magicCounterEntry; }

            //Accessors
                public double getRunX()
                    { return runX; }
                public double getJumpY()
                    { return jumpY; }
                public double getGravity()
                    { return gravityConstant; } 
                public double getDecayFactor()
                    { return decayFactor; }
                public double getMidgroundDamper()
                    { return midgroundDamper; }
                public double getBackgroundDamper()
                    { return backgroundDamper; }
                public int getPowerupBonus()
                    { return powerupBonus; }
                public double getXPlayerForce()
                    { return xPlayerForce; }
                public double getYPlayerForce()
                    { return yPlayerForce; }
                public int getOscillator()
                    { return oscillator; }
                public double getXPlayerDefaultCoordinate()
                    { return xPlayerDefaultCoordinate; }
                public double getYPlayerDefaultCoordinate()
                    { return yPlayerDefaultCOordinate; }
                public int getContactBadguy()
                    { return contactBadguy; }
                public double getXRunAccelerator()
                    { return xRunAccelerator; }
                public double getXAcceleration()
                    { return xAcceleration;}
                public double getYAcceleration()
                    { return yAcceleration; }
                public boolean getPlayerCollisionBottom()
                    { return playerCollisionBottom; }
                public double getBackground2Damper()
                    { return background2Damper; }
                public int getPowerupHealthBonus()
                    { return powerupHealthBonus; }
                public int getMagicCounter()
                    { return magicCounter; }

            //Custom methods
                public void updateXAcceleration(double updatedEntry) 
                    { xAcceleration = xAcceleration + updatedEntry; }

                public void updateYAcceleration(double updatedEntry) 
                    { yAcceleration = yAcceleration + updatedEntry; }

                public void decayXAccelerationToZero()
                    {
                        if( Math.abs(xAcceleration) > 0.010 )
                            { xAcceleration = xAcceleration / PlatformFriction; }
                        else
                            { xAcceleration = 0; }     
                    }

                public void oscillateOscillator()
                    { oscillator++; }  
        }//End of class
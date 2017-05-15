/*Daniel Izadnegahdar S00840086 IT2650 Lab#3 03/04/17*/

//Package
    package Scripts;
    
//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class
    public class Player
        {
            //Properties
                private double xPos;
                private double yPos;  
                private double radius;
                private double neckOffset;
                private double limbWidth;
                private double limbLength;
                private double shoulderOffset;
                private Camera camera;
                private GraphicsContext gc;
                private boolean readyToJump;

            //Instances
                Limb body = new Limb(90); // Limb(double xPos, double yPos, double angle, double width, double length)
                Limb rightArm = new Limb(70);
                Limb leftArm = new Limb(110);
                Limb rightLeg = new Limb(90);
                Limb leftLeg = new Limb(90);
                GlobalVariables globalVariables = new GlobalVariables();

            //Constructor
                Player(double xPos, double yPos, double radius, Camera camera, GraphicsContext gc)
                    {
                        this.xPos = xPos;
                        this.yPos = yPos;
                        this.radius = radius;
                        this.neckOffset = 20;
                        this.limbWidth = 10;
                        this.limbLength = 30;
                        this.shoulderOffset = 15;
                        this.gc = gc;
                        this.readyToJump = true;
                        this.camera = camera;
                    }

        //Methods
            //Mutators
                public void setX(double xEntry)
                    { xPos = xEntry; }
                public void setY(double yEntry)
                    { yPos = yEntry; } 
                public void setRadius(double yEntry)
                    { yPos = yEntry; } 
                public void setReadyToJump(boolean readyToJumpEntry)
                    { readyToJump = readyToJumpEntry; } 

            //Accessors
                public double getX()
                    { return xPos; }
                public double getY()
                    { return yPos; } 
                public double getRadius()
                    { return radius; }
                public boolean getReadyToJump()
                    { return readyToJump; }

            //Custom methods
                public void run(int oscillatorEntry)
                    {
                        body.setAngle(90 + 10 * Math.cos(Math.toRadians(oscillatorEntry * 10))); //Magnitude, speed
                        rightArm.setAngle(90 + 80 * Math.cos(Math.toRadians(oscillatorEntry * 20 + 160)));
                        leftArm.setAngle(90 + 80 * Math.cos(Math.toRadians(oscillatorEntry * 20)));
                        rightLeg.setAngle(90 + 80 * Math.cos(Math.toRadians(oscillatorEntry * 20)));
                        leftLeg.setAngle(90 + 80 * Math.cos(Math.toRadians(oscillatorEntry * 20 + 160)));
                    }

                public void jump()
                    {
                        body.setAngle(85); //Magnitude, speed
                        rightArm.setAngle(-25);
                        leftArm.setAngle(135);
                        rightLeg.setAngle(-25);
                        leftLeg.setAngle(135);
                    }

                public void duck()
                    {
                        body.setAngle(180); //Magnitude, speed
                        rightArm.setAngle(0);
                        leftArm.setAngle(0);
                        rightLeg.setAngle(180);
                        leftLeg.setAngle(180);
                    }

                public void shoot()
                    {

                    }

                public void idle()
                    {
                        body.setAngle(90); 
                        rightArm.setAngle(70);
                        leftArm.setAngle(110);
                        rightLeg.setAngle(90);
                        leftLeg.setAngle(90);
                    }

                //Update positions
                    public void updatePositions()
                        {
                     //Build the limbs
                        //Body
                            body.setXPos(xPos);
                            body.setYPos(yPos + neckOffset + 5);
                            body.setAngle(body.getAngle());
                            body.setWidth(limbWidth * 2.5);
                            body.setLength(limbLength - 5);

                        //rightArm
                            rightArm.setXPos(xPos + shoulderOffset);
                            rightArm.setYPos(yPos  + neckOffset);
                            rightArm.setAngle(rightArm.getAngle());
                            rightArm.setWidth(limbWidth);
                            rightArm.setLength(limbLength);
                        //leftArm
                            leftArm.setXPos(xPos - shoulderOffset);
                            leftArm.setYPos(yPos + neckOffset);
                            leftArm.setAngle(leftArm.getAngle());
                            leftArm.setWidth(limbWidth);
                            leftArm.setLength(limbLength);
                        //rightLeg
                            rightLeg.setXPos(xPos + shoulderOffset/2);
                            rightLeg.setYPos(yPos + neckOffset + limbLength + 15);
                            rightLeg.setAngle(rightLeg.getAngle());
                            rightLeg.setWidth(limbWidth);
                            rightLeg.setLength(limbLength * 1.5);
                        //leftLeg
                            leftLeg.setXPos(xPos - shoulderOffset/2);
                            leftLeg.setYPos(yPos + neckOffset + limbLength + 15);
                            leftLeg.setAngle(leftLeg.getAngle());
                            leftLeg.setWidth(limbWidth);
                            leftLeg.setLength(limbLength * 1.5);
                        }

                //Player
                    public void updateY(double updatedEntry)
                        {yPos = yPos + updatedEntry;}
                       
                    public void drawLimb(GraphicsContext gcEntry, Limb limbEntry, String colorEntry)
                        {
                             gcEntry.setStroke(Color.web(colorEntry,1.0));
                                    gcEntry.setLineWidth(limbEntry.getWidth());
                                    gcEntry.strokeLine
                                        ( 
                                            limbEntry.getXPos(), //x1
                                            limbEntry.getYPos(), //y1
                                            limbEntry.getXPos() + (limbEntry.getLength() * Math.cos(Math.toRadians(limbEntry.getAngle()))), //x2
                                            limbEntry.getYPos() + (limbEntry.getLength() * Math.sin(Math.toRadians(limbEntry.getAngle()))) //y2
                                        );
                        }
                    
                //Draw player
                    public void draw()
                        {
                            updatePositions();
                             //Shadow
                                gc.setFill(Color.web("#332D23",0.3));  
                                gc.fillOval(xPos - 45, 515 + camera.getScrollY(), 80 , 20);
                            //Limbs
                                drawLimb(gc, rightArm, "#FFE100");
                                drawLimb(gc, rightLeg, "#36567d");
                                drawLimb(gc, leftLeg, "#36567d");
                                drawLimb(gc, body, "#ff6600");

                            //Head
                                //Head
                                    gc.setFill(Color.web("#DDFF00",1.0));  
                                    gc.fillOval(xPos - radius/2, yPos - radius/2 , radius , radius);
                                //EyeBall1
                                    gc.setFill(Color.web("#595959",1.0));
                                    gc.fillOval(xPos - 10 , yPos, radius/5 , radius/5); // x, y, r1, r2
                                //EyeBall2
                                    gc.setFill(Color.web("#595959",1.0));
                                    gc.fillOval(xPos + 10, yPos, radius/5 , radius/5);
                                //Left arm goes on top    
                                    drawLimb(gc, leftArm, "#FFE100");
                        } 
        }//End of class
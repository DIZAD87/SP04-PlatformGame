/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class    
    public class Rope
        {
            //Properties
                private double xHead;
                private double yHead;
                private double nodeLength;
                private Color color;
                private double anchorRadius;
                private double dampFactor;
                private int oscillatorIncrement;
                private double oscillator;
                private Camera camera;

            //Instances
                Node ropeNode0 = new Node(0); //Head
                Node ropeNode1 = new Node(1);
                Node ropeNode2 = new Node(2);
                Node ropeNode3 = new Node(3);
                Node ropeNode4 = new Node(4);
                Node ropeNode5 = new Node(5); //Tail
                GlobalVariables settings = new GlobalVariables();

            //Constructor
                Rope(double xHead, double yHead, Camera camera)
                    {
                    //General
                        this.color = Color.web("#756E57",1.0);
                        this.anchorRadius = 30;
                        this.nodeLength = 70;
                        this.dampFactor = 5;
                        this.oscillatorIncrement = 0;
                        this.oscillator = 0;
                        this.camera = camera;
                        this.xHead = xHead;
                        this.yHead = yHead;
                    }

            //Methods
                //Mutators
                    public void setNodeLength(double nodeLengthEntry)
                        { nodeLength = nodeLengthEntry; }
                //Accessors
                    public double getTailX()
                        {return ropeNode5.getPosX();}
                    public double getTailY()
                        {return ropeNode5.getPosY();}
                    public double getNodeLength()
                        {return nodeLength;}

                //Custom methods
                    public void addForce(double forceIncrementEntry)
                        {
                           oscillatorIncrement = 0;
                           oscillator = 0;
                           ropeNode0.setAngle(ropeNode0.getAngle() - (forceIncrementEntry)/dampFactor * 1); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                           ropeNode1.setAngle(ropeNode1.getAngle() - (forceIncrementEntry)/dampFactor * 2); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                           ropeNode2.setAngle(ropeNode2.getAngle() - (forceIncrementEntry)/dampFactor * 3); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                           ropeNode3.setAngle(ropeNode3.getAngle() - (forceIncrementEntry)/dampFactor * 4); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                           ropeNode4.setAngle(ropeNode4.getAngle() - (forceIncrementEntry)/dampFactor * 5); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                           ropeNode5.setAngle(ropeNode5.getAngle() - (forceIncrementEntry)/dampFactor * 6); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                        }

                    public void releaseForce(double decayFactorEntry)
                         {
                            oscillatorIncrement++;
                            oscillator = Math.sin(Math.toRadians(oscillatorIncrement));
                            ropeNode0.setAngle((ropeNode0.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                            ropeNode1.setAngle((ropeNode1.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                            ropeNode2.setAngle((ropeNode2.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                            ropeNode3.setAngle((ropeNode3.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                            ropeNode4.setAngle((ropeNode4.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                            ropeNode5.setAngle((ropeNode5.getAngle())/1.1 + 0); //ropeNode1.getAngle() - 100*settings.getForceXConstant()
                         }

                    public void updatePositions()
                         {//update position
                            ropeNode0.setPosX(xHead + camera.getScrollX());
                            ropeNode0.setPosY(yHead + camera.getScrollY()); 

                            ropeNode1.setPosX(ropeNode0.getPosX() + (nodeLength * Math.cos(Math.toRadians(ropeNode0.getAngle()))));
                            ropeNode1.setPosY(ropeNode0.getPosY() +(nodeLength * Math.sin(Math.toRadians(ropeNode0.getAngle()))));

                            ropeNode2.setPosX(ropeNode1.getPosX() + (nodeLength * Math.cos(Math.toRadians(ropeNode1.getAngle()))));
                            ropeNode2.setPosY(ropeNode1.getPosY() +(nodeLength * Math.sin(Math.toRadians(ropeNode1.getAngle()))));

                            ropeNode3.setPosX(ropeNode2.getPosX() + (nodeLength * Math.cos(Math.toRadians(ropeNode2.getAngle()))));
                            ropeNode3.setPosY(ropeNode2.getPosY() +(nodeLength * Math.sin(Math.toRadians(ropeNode2.getAngle()))));

                            ropeNode4.setPosX(ropeNode3.getPosX() + (nodeLength * Math.cos(Math.toRadians(ropeNode3.getAngle()))));
                            ropeNode4.setPosY(ropeNode3.getPosY() +(nodeLength * Math.sin(Math.toRadians(ropeNode3.getAngle()))));

                            ropeNode5.setPosX(ropeNode4.getPosX() + (nodeLength * Math.cos(Math.toRadians(ropeNode4.getAngle())))); //+ camera.getScrollX()
                            ropeNode5.setPosY(ropeNode4.getPosY() + (nodeLength * Math.sin(Math.toRadians(ropeNode4.getAngle())))); 
                         }

                    //Update graphic     
                        public void draw(GraphicsContext gcEntry)
                            {
                               updatePositions(); 
                            //Center circle
                                gcEntry.setStroke(color);
                                gcEntry.setLineWidth(5);
                                gcEntry.strokeOval((ropeNode0.getPosX() - anchorRadius/2), ropeNode0.getPosY() - anchorRadius/2, anchorRadius, anchorRadius); //Head
                            //Nodes
                                gcEntry.strokeLine(ropeNode0.getPosX(), ropeNode0.getPosY(), ropeNode1.getPosX(), ropeNode1.getPosY()); //Node1
                                gcEntry.strokeLine(ropeNode1.getPosX(), ropeNode1.getPosY(), ropeNode2.getPosX(), ropeNode2.getPosY()); //node2
                                gcEntry.strokeLine(ropeNode2.getPosX(), ropeNode2.getPosY(), ropeNode3.getPosX(), ropeNode3.getPosY()); //node3
                                gcEntry.strokeLine(ropeNode3.getPosX(), ropeNode3.getPosY(), ropeNode4.getPosX(), ropeNode4.getPosY()); //node4
                                gcEntry.strokeLine(ropeNode4.getPosX(), ropeNode4.getPosY(), ropeNode5.getPosX(), ropeNode5.getPosY()); //Tail
                            }
        }//End of class
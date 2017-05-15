/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

//Class
    public class CursorTarget
        {
            //Properties
                private double xPos;
                private double yPos;
                private double targetWidth;
                private double extension;

            //Constructor
                CursorTarget()
                    {
                        this.targetWidth = 40;
                        this.extension = 5;
                        this.xPos = 0;
                        this.yPos = 0;
                    }

            //Methods
                //Mutators
                    public void setXpos(double xPosEntry)
                        { xPos = xPosEntry - targetWidth/2; }
                
                    public void setYpos(double yPosEntry)
                        { yPos = yPosEntry - targetWidth/2; }
                //Custom methods
                    public void draw(GraphicsContext gcEntry)
                        {
                            gcEntry.setStroke(Color.web("#E76EFF", 1.0));
                            gcEntry.setLineWidth(5);
                            gcEntry.strokeOval(xPos, yPos, targetWidth, targetWidth);
                            gcEntry.strokeLine(xPos + targetWidth/2, yPos - extension, xPos + targetWidth/2, yPos + targetWidth + extension);
                            gcEntry.strokeLine(xPos - extension, yPos + targetWidth/2, xPos + targetWidth + extension, yPos + targetWidth/2);          
                        }
        }//End of class
/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.image.Image;
    import javafx.scene.paint.Color;
    import javafx.scene.text.Font;
    import javafx.scene.text.FontWeight;
    
//Class
    public class HUD
        {
            //Custom methods
                public void drawHUD(GraphicsContext gcEntry, int levelEntry, int livesEntry, int healthEntry, int pointsEntry, int magicEntry)
                    {
                        //Import image
                           Image GUI = new Image( "Images/HUD.png" ); //Import background image
                           gcEntry.drawImage( GUI, 0, 0 );

                        //Fonts
                           gcEntry.setFont(Font.font( "Helvetica", FontWeight.BOLD, 50 ));
                           gcEntry.setFill(Color.web("#FDDEFF", 1.0));
                                gcEntry.fillText(String.valueOf(magicEntry), 245, 45); //Magic
                           gcEntry.setFont(Font.font( "Helvetica", FontWeight.BOLD, 35 ));
                           gcEntry.setFill(Color.web("#D7FF73", 1.0));
                                gcEntry.fillText(String.valueOf(livesEntry), 392 , 570); //Lives
                                gcEntry.fillText(String.valueOf(healthEntry), 534, 570); //Health
                                gcEntry.fillText(String.valueOf(pointsEntry), 710, 570); //Points
                           gcEntry.setFont(Font.font( "Helvetica", FontWeight.BOLD, 75 ));
                                gcEntry.fillText(String.valueOf(levelEntry), 207 , 582); //Level

                    }  
        }//End of class

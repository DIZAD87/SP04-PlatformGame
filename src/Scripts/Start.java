/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.application.Application;
    import javafx.stage.Stage;

//Class
    public class Start extends Application
        {
            //Global swapStage
                Stage swapStage;

            //Global variables
                int swapCount = 0;
                
            //Start stage
                @Override
                public void start(Stage primaryStage)
                    {
                        swapStage = primaryStage; 
                        double windowWidth = 800;
                        double windowHeight = 600;
                        SceneMenu mainMenu = new SceneMenu();
                        mainMenu.play(swapStage , swapCount, windowWidth, windowHeight);
                    }
            //Launch    
                public static void main(String[] args)
                    {
                        launch(args);
                    }
        }//End of class
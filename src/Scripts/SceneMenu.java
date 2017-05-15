/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Imported libraries
    import javafx.stage.Stage;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.AnchorPane;
    import javax.swing.JOptionPane;
    
//Class    
    public class SceneMenu
        {
         void play(Stage stageEntry ,  int swapCountEntry, double windowWidthEntry, double windowHeightEntry)
            {
                //Create instances
                    SceneProfile sceneProfile = new SceneProfile();
                    SceneMenu sceneMenu = new SceneMenu();
                    PlaySound playSound = new PlaySound();
                    
                //PART#1: Instantiate the GUI objects
                    //Panes
                        AnchorPane root = new AnchorPane();
                    //Buttons
                        Button buttonNewGame = new Button();
                        Button buttonOptions = new Button();
                        Button buttonQuit = new Button();

                //PART#2: Attach the objects to their pane
                    //Buttons
                        root.getChildren().add(buttonNewGame);
                        root.getChildren().add(buttonOptions);
                        root.getChildren().add(buttonQuit);

                //PART#3: Define the location/style attributes
                    //Panes	
                        root.getStyleClass().add("titleBackgroundStyle");

                    //Buttons
                        //buttonNewGame
                            buttonNewGame.setText("Start"); 
                            buttonNewGame.getStyleClass().add("buttonDefault");
                            AnchorPane.setTopAnchor(buttonNewGame, 300.0);
                            AnchorPane.setLeftAnchor(buttonNewGame, 500.0);
                            AnchorPane.setRightAnchor(buttonNewGame, 90.0);
                        //buttonOptions
                            buttonOptions.setText("Options");
                            buttonOptions.getStyleClass().add("buttonDefault");
                            AnchorPane.setTopAnchor(buttonOptions, 380.0);
                            AnchorPane.setLeftAnchor(buttonOptions, 500.0);
                            AnchorPane.setRightAnchor(buttonOptions, 90.0);
                        //buttonQuit
                            buttonQuit.setText("Quit");
                            buttonQuit.getStyleClass().add("buttonDefault");
                            AnchorPane.setTopAnchor(buttonQuit, 460.0);
                            AnchorPane.setLeftAnchor(buttonQuit, 500.0);
                            AnchorPane.setRightAnchor(buttonQuit, 90.0);

                    //Button Events
                        //Press the buttonNewGame
                            buttonNewGame.setOnAction(new EventHandler<ActionEvent>()
                                {
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            playSound.buttonSound();
                                            sceneProfile.play(stageEntry, swapCountEntry, windowWidthEntry, windowHeightEntry);
                                        } 
                                });
                            
                        //Press the buttonQuit
                            buttonOptions.setOnAction(new EventHandler<ActionEvent>()
                                {                              
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            playSound.buttonSound();
                                             JOptionPane.showMessageDialog(null, "This button is still under construction.");
                                        }       
                                }); 
                         
                        //Press the buttonQuit
                            buttonQuit.setOnAction(new EventHandler<ActionEvent>()
                                {                              
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            playSound.buttonSound();
                                            System.exit(0); 
                                        }       
                                });

                    //Scene properties
                        //Start of patch
                            int windowSize;
                             if (swapCountEntry == 0)
                             { windowSize = 480; }
                             else 
                             { windowSize = 490; }
                        //End of patch
                        
                    //Standard scene settings
                        stageEntry.setResizable(false);
                        Scene scene = new Scene(root, windowWidthEntry, windowHeightEntry); //-10 is a patch fix
                        stageEntry.setScene(scene);
                        stageEntry.setTitle("SwingMan DIZAD 04/12/17");
                        stageEntry.show();
                        
                    //Attach stylesheet    
                        String css = Start.class.getResource("mainCSS.css").toExternalForm();
                        scene.getStylesheets().add(css); 
            }
        }//End of class
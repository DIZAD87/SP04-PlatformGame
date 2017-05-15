/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Imported libraries
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import javafx.stage.Stage;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.ListView;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;
    import javax.swing.JOptionPane;
    import java.util.logging.Logger;
    import java.util.logging.Level;

//Class
    public class SceneProfile       
        {
            //Create list of profiles
                ArrayList<PlayerStatus> arrayList = new ArrayList();

            //Play
                public void play(Stage stageEntry , int swapCountEntry, double windowWidthEntry, double windowHeightEntry)
                   {
                       SceneLevel1 level1 = new SceneLevel1();
                       SceneMenu sceneMenu = new SceneMenu();
                       PlaySound playSound = new PlaySound();

            //Start of the csv read file script
                //Read the Locations.csv file, parse it, and insert it inside an internal ArrayList
                       BufferedReader locationExternalFile; //Define the variable name for storing the .csv
                       try
                           {
                           //Define variables for the parsing process
                               String singleLine; //This will store one line of the .csv file
                               String[] singleLineSplit; //This array will store the split items of singleLine
                               locationExternalFile = new BufferedReader(new FileReader("src/Profiles/Profiles.csv")); //Define the .csv 
                           //Parse the file line by line and store it inside the ArrayList
                           //Assign line to singleLine, and read until there are no more lines to read
                               while ((singleLine = locationExternalFile.readLine()) != null) 
                                   {
                                   //Variable declarations for storing the split items
                                       //name, checkpoint, lives, health, points, magic  
                                        String name;
                                        int checkpoint;
                                        int lives;
                                        int health;
                                        int points;
                                        int magic;
                                   //Split the singleLine per each comma
                                       singleLineSplit = singleLine.split(",");
                                   //Assign the location variables
                                       name = singleLineSplit[0]; //Assign the name
                                       checkpoint = Integer.parseInt(singleLineSplit[1]); //checkpoint
                                       lives = Integer.parseInt(singleLineSplit[2]); //lives
                                       health = Integer.parseInt(singleLineSplit[3]); //health
                                       points = Integer.parseInt(singleLineSplit[4]); //points
                                       magic = Integer.parseInt(singleLineSplit[5]); //magic
                                   //Add the location object with these new variables to the ArrayList
                                       arrayList.add(new PlayerStatus(name, checkpoint, lives, health, points, magic));
                                   }
                           //After elements have been extracted, close the external file
                               locationExternalFile.close();
                           }
                       catch(IOException ex)
                           {
                                Logger.getLogger(SceneProfile.class.getName()).log(Level.SEVERE, null, ex);
                           }
            //End of the csv read file script

            //PART#1: Instantiate the GUI objects
                //Panes
                    AnchorPane root = new AnchorPane();
                //Buttons
                    Button buttonAddProfile = new Button();
                    Button buttonDeleteProfile = new Button();
                    Button buttonLoadProfile = new Button();
                    Button buttonGoBack = new Button();
                //Textfield
                    TextField textfieldProfileName = new TextField();
                //Listview
                    ListView<String> listView = new ListView<String>();

            //PART#2: Attach the objects to their pane
                //Buttons
                    root.getChildren().add(buttonAddProfile);
                    root.getChildren().add(buttonDeleteProfile);
                    root.getChildren().add(buttonLoadProfile);
                    root.getChildren().add(buttonGoBack);
                    root.getChildren().add(textfieldProfileName);
                    root.getChildren().add(listView);

            //PART#3: Define the location/style attributes
                //Panes	
                    root.getStyleClass().add("profileBackgroundStyle");

                //Textfields
                    textfieldProfileName.getStyleClass().add("textfieldDefault");
                    AnchorPane.setTopAnchor(textfieldProfileName, 120.0);
                    AnchorPane.setLeftAnchor(textfieldProfileName, 90.0);
                    AnchorPane.setRightAnchor(textfieldProfileName, 90.0);

                //Listview
                    listView.getStyleClass().add("listViewDefault");
                        AnchorPane.setTopAnchor(listView, 210.0);
                        AnchorPane.setLeftAnchor(listView, 90.0);
                        AnchorPane.setRightAnchor(listView, 325.0);
                        AnchorPane.setBottomAnchor(listView, 85.0);
                        updateListView(listView);

                //Buttons
                    //buttonNewGame
                        buttonAddProfile.setText("Add"); 
                        buttonAddProfile.getStyleClass().add("buttonDefault");
                        AnchorPane.setTopAnchor(buttonAddProfile, 210.0);
                        AnchorPane.setLeftAnchor(buttonAddProfile, 500.0);
                        AnchorPane.setRightAnchor(buttonAddProfile, 90.0);
                    //buttonQuit
                        buttonDeleteProfile.setText("Delete");
                        buttonDeleteProfile.getStyleClass().add("buttonDefault");
                        AnchorPane.setTopAnchor(buttonDeleteProfile, 290.0);
                        AnchorPane.setLeftAnchor(buttonDeleteProfile, 500.0);
                        AnchorPane.setRightAnchor(buttonDeleteProfile, 90.0);
                    //buttonQuit
                        buttonLoadProfile.setText("Load");
                        buttonLoadProfile.getStyleClass().add("buttonDefault");
                        AnchorPane.setTopAnchor(buttonLoadProfile, 370.0);
                        AnchorPane.setLeftAnchor(buttonLoadProfile, 500.0);
                        AnchorPane.setRightAnchor(buttonLoadProfile, 90.0);
                    //buttonGoBack
                        buttonGoBack.setText("Back");
                        buttonGoBack.getStyleClass().add("buttonDefault");
                        AnchorPane.setTopAnchor(buttonGoBack, 450.0);
                        AnchorPane.setLeftAnchor(buttonGoBack, 500.0);
                        AnchorPane.setRightAnchor(buttonGoBack, 90.0);

                    //Button Events
                        //Press the buttonAddProfile
                            buttonAddProfile.setOnAction(new EventHandler<ActionEvent>()
                                {
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                             playSound.buttonSound();
                                            //Create the profile
                                            if ((textfieldProfileName.getText()).equals(""))
                                                { JOptionPane.showMessageDialog(null, "Please enter a name in the textbox above.");}
                                            else
                                                {
                                                    PlayerStatus profile = new PlayerStatus(textfieldProfileName.getText(), 0, 3, 100, 0, 99);
                                                    //Add the profile to the arraylist
                                                    arrayList.add(profile.deepCopy());
                                                }
                                                 udpateExcelFile();
                                                 updateListView(listView);
                                        } 
                                });

                        //Press the buttonDeleteProfile
                            buttonDeleteProfile.setOnAction(new EventHandler<ActionEvent>()
                                {                              
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            playSound.buttonSound();
                                            int locationIndex = 0;
                                            //Find the selection
                                            for (int i = 0; i < arrayList.size(); i++)
                                                { 
                                                    if ((listView.getSelectionModel().getSelectedItem()).equals(arrayList.get(i).getName()))
                                                        { locationIndex = i; }
                                                } 
                                             arrayList.remove(locationIndex);
                                             udpateExcelFile();
                                             updateListView(listView);
                                        }       
                                });  

                        //Press the buttonLoadProfile
                            buttonLoadProfile.setOnAction(new EventHandler<ActionEvent>()
                                {                              
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            playSound.buttonSound();
                                            level1.play(stageEntry , swapCountEntry, arrayList.get(0), windowWidthEntry, windowHeightEntry);

                                        }       
                                }); 
                            
                        //Press the buttonGoBack
                            buttonGoBack.setOnAction(new EventHandler<ActionEvent>()
                                {                              
                                    @Override
                                    public void handle(ActionEvent event)
                                        {
                                            sceneMenu.play(stageEntry , swapCountEntry, windowWidthEntry, windowHeightEntry);
                                            playSound.buttonSound();
                                        }       
                                });  

                //Scene properties
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


          public void updateListView(ListView listViewEntry)
            {
                listViewEntry.getItems().clear();
                //Fill in the listview
                    for(int i = 0; i < arrayList.size(); i++)
                     { listViewEntry.getItems().addAll(arrayList.get(i).getName()); } 
            } 

          public void udpateExcelFile()
            {
                //Extract the array list and export it to a text file
                   try
                       {
                           FileWriter locationExternalFile = new FileWriter("src/Profiles/Profiles.csv" , false); //Define the .csv , false included for a complete update
                           for (int i = 0; i < arrayList.size(); i++)
                               {
                                   locationExternalFile.write(arrayList.get(i).getName() + "," +
                                   arrayList.get(i).getCheckpoint() + "," +
                                   arrayList.get(i).getLives() + "," +
                                   arrayList.get(i).getHealth() + "," + 
                                   arrayList.get(i).getPoints() + "," + 
                                   arrayList.get(i).getMagic() + "\n");
                               }
                           locationExternalFile.close(); //Close the file
                       }
                   catch (IOException ex)
                       { Logger.getLogger(SceneProfile.class.getName()).log(Level.SEVERE, null, ex); } 
            }
        }//End of class
/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Imported libraries
    import java.util.ArrayList;
    import javafx.animation.AnimationTimer;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.scene.Group;
    import javafx.scene.Scene;
    import javafx.scene.canvas.Canvas;
    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.control.Button;
    import javafx.scene.input.KeyEvent;
    import javafx.scene.paint.Color;
    import javafx.stage.Stage;
    import javafx.scene.input.MouseEvent;
    import javax.swing.JOptionPane;

//Class    
    public class SceneLevel1
        {
            public void play(Stage stageEntry , int swapCountEntry, PlayerStatus playerStatusEntry, double windowWidthEntry, double windowHeightEntry)
                {
                    //Instances of game settings
                        //General settings
                            SceneMenu mainMenu = new SceneMenu();
                            PlaySound playSound = new PlaySound();
                            Group root = new Group();    
                            Scene scene = new Scene(root);
                            Canvas canvas = new Canvas( windowWidthEntry, windowHeightEntry );
                            GraphicsContext gc = canvas.getGraphicsContext2D();
                            Button buttonGoBack = new Button();
                            Button buttonInformation = new Button();
                            Camera camera = new Camera();
                            GlobalVariables globalVariables = new GlobalVariables();
                            Player player = new Player(globalVariables.getXPlayerDefaultCoordinate(), globalVariables.getYPlayerDefaultCoordinate(), 30, camera, gc); //x, y, r
                            Forces forces = new Forces(0.01);
                            PlayerStatus playerStatus = new PlayerStatus("testName", 0, 3, 100, 0, 99); //name, checkpoint, Start lives, health, points, magic
                            HUD HUD = new HUD();
                            
                        //Canvass settings    
                            //Add elements to the root
                                root.getChildren().add(canvas);
                                root.getChildren().add(buttonInformation);
                                root.getChildren().add(buttonGoBack);

                            //Button styles
                                buttonGoBack.setText("Back"); 
                                buttonGoBack.getStyleClass().add("buttonIngameStyle");
                                buttonGoBack.setTranslateX(5);
                                buttonGoBack.setTranslateY(5);
                                buttonInformation.setText("!"); 
                                buttonInformation.getStyleClass().add("buttonIngameStyle");
                                buttonInformation.setTranslateX(120);
                                buttonInformation.setTranslateY(5);
                        
                    //Instances of level objects
                        //Magic
                            Magic1 magic1 = new Magic1(200, 200, camera, player);
                            Magic1 magic2 = new Magic1(200, 200, camera, player);
                            Magic1 magic3 = new Magic1(200, 200, camera, player);

                        //Cursor target
                            CursorTarget cursorTarget = new CursorTarget();

                        //Badguys
                            Badguy badguy1 = new Badguy(1500, 100, 0, camera);
                            Badguy badguy2 = new Badguy(1500, 300, Math.PI/1,  camera);
                            Badguy badguy3 = new Badguy(500, 300, Math.PI/2, camera);

                        //Powerups
                            //Star powerups
                                PowerupStar powerupStar1 = new PowerupStar(2000, 200, (2 * Math.PI)/1, camera);
                                PowerupStar powerupStar2 = new PowerupStar(1500, 300, (2 * Math.PI)/2, camera);
                                PowerupStar powerupStar3 = new PowerupStar(1000, 250, (2 * Math.PI)/3, camera);
                                PowerupStar powerupStar4 = new PowerupStar(500, 300, (2 * Math.PI)/4, camera);

                            //Health powerups
                                PowerupHealth powerupHealth1 = new PowerupHealth(130, 400, (2 * Math.PI)/1, camera);
                                PowerupHealth powerupHealth2 = new PowerupHealth(1000, 400, (2 * Math.PI)/2, camera);

                        //Trees
                            // Tree(xPos, yPos, angle, trunkWidth, trunkLength, crownDiameter, trunkColor, crownColor, Camera camera)
                                Tree tree1 = new Tree(80, 350, -45, 20, 135, 90, "#856C45", "#36C23B", camera);
                                Tree tree1Branch1 = new Tree(100, 330, -70, 10, 100, 80, "#8A775B", "#40D645", camera);

                                Tree tree2 = new Tree(700, 510, -105, 20, 300, 100, "#856C45", "#3DBF5C", camera); //Main trunk
                                Tree tree2Branch1 = new Tree(660, 365, -135, 10, 75, 75, "#695B47", "#26BD49", camera); //Left branch
                                Tree tree2Branch2 = new Tree(654, 323, -45, 10, 75, 65, "#8A775B", "#26BD49", camera); //Right branch
                        //Polygons
                            //ForePolies
                                //StartPoly
                                Polygon startPoly = new Polygon(4, "#877140", "#a77c53", "fore", camera); //polyCount, xOffset, yOffset, camera
                                    startPoly.defineCoordinate(0, -300, 600); //Index, x, y
                                    startPoly.defineCoordinate(1, 0, 500); //Index, x, y
                                    startPoly.defineCoordinate(2, 1000, 500); //Index, x, y
                                    startPoly.defineCoordinate(3, 1000, 600); //Index, x, y 
                                Polygon forePoly1 = new Polygon(4, "#877140" , "#a77c53" , "fore", camera); //polyCount, xOffset, yOffset, camera
                                    forePoly1.defineCoordinate(0, -300, -200); //Index, x, y
                                    forePoly1.defineCoordinate(1, -300, 150); //Index, x, y
                                    forePoly1.defineCoordinate(2, 466, 50); //Index, x, y
                                    forePoly1.defineCoordinate(3, 700, -200); //Index, x, y 
                                //First lower poly
                                Polygon forePoly2 = new Polygon(4, "#877140" , "#a77c53" , "fore", camera); //polyCount, xOffset, yOffset, camera
                                    forePoly2.defineCoordinate(0, 1700, 600); //Index, x, y
                                    forePoly2.defineCoordinate(1, 1700, 420); //Index, x, y
                                    forePoly2.defineCoordinate(2, 2500, 400); //Index, x, y
                                    forePoly2.defineCoordinate(3, 2500, 700); //Index, x, y 
                                Polygon forePoly3 = new Polygon(4, "#73623E" , "#5C4F32" , "fore", camera); //polyCount, xOffset, yOffset, camera
                                    forePoly3.defineCoordinate(0, -300, 600); //Index, x, y
                                    forePoly3.defineCoordinate(1, -300, -200); //Index, x, y
                                    forePoly3.defineCoordinate(2, 0, -200); //Index, x, y
                                    forePoly3.defineCoordinate(3, 100, 515); //Index, x, y         
                                Polygon forePoly4 = new Polygon(4, "#73623E" , "#5C4F32" , "fore", camera); //polyCount, xOffset, yOffset, camera
                                    forePoly4.defineCoordinate(0, 3500, 600); //Index, x, y
                                    forePoly4.defineCoordinate(1, 3500, 420); //Index, x, y
                                    forePoly4.defineCoordinate(2, 5500, 430); //Index, x, y
                                    forePoly4.defineCoordinate(3, 5500, 600); //Index, x, y   
                                Polygon forePoly5 = new Polygon(4, "#73623E" , "#5C4F32" , "fore", camera); //polyCount, xOffset, yOffset, camera
                                    forePoly5.defineCoordinate(0, 2615, 290); //Index, x, y
                                    forePoly5.defineCoordinate(1, 2600, 200); //Index, x, y
                                    forePoly5.defineCoordinate(2, 3015, 215); //Index, x, y
                                    forePoly5.defineCoordinate(3, 3000, 300); //Index, x, y   

                            //MidPolies
                                //Mountain
                                Polygon midPoly1 = new Polygon(5, "#0bbb65" , "#098b4b" , "mid", camera); //polyCount, xOffset, yOffset, camera //That fore mountain
                                    midPoly1.defineCoordinate(0, 0, 800); //Index, x, y
                                    midPoly1.defineCoordinate(1, 390, 425); //Index, x, y
                                    midPoly1.defineCoordinate(2, 500, 400); //Index, x, y
                                    midPoly1.defineCoordinate(3, 650, 280); //Index, x, y
                                    midPoly1.defineCoordinate(4, 1300, 800); //Index, x, y

                            //BackPolis
                                Polygon backPoly1 = new Polygon(3, "#5bd9a7" , "#4fbf93" , "back", camera); //polyCount, xOffset, yOffset, camera //Ground
                                     backPoly1.defineCoordinate(0, 0, 600); //Index, x, y
                                    backPoly1.defineCoordinate(1, 1500, 400); //Index, x, y
                                    backPoly1.defineCoordinate(2, 2600, 600); //Index, x, y
                                Polygon backPoly2 = new Polygon(3, "#62c3ab" , "#54a893" , "back", camera); //polyCount, xOffset, yOffset, camera 
                                    backPoly2.defineCoordinate(0, 0, 600); //Index, x, y
                                    backPoly2.defineCoordinate(1, 530, 300); //Index, x, y
                                    backPoly2.defineCoordinate(2, 1000, 600); //Index, x, y
                                Polygon backPoly3 = new Polygon(5, "#6ed4ce" , "#4d9490" , "back", camera); //polyCount, xOffset, yOffset, camera //Back mountains
                                    backPoly3.defineCoordinate(0, 0, 250); //Index, x, y
                                    backPoly3.defineCoordinate(1, 331, 350); //Index, x, y
                                    backPoly3.defineCoordinate(2, 613, 300); //Index, x, y
                                    backPoly3.defineCoordinate(3, 2200, 600); //Index, x, y 
                                    backPoly3.defineCoordinate(4, 0, 600); //Index, x, y 

                            //Clouds
                                //From left to right
                                Cloud cloud1 = new Cloud(0, 50, 3, "mid", camera);
                                    cloud1.defineCircle(0, 150, 75);
                                    cloud1.defineCircle(1, 200, 75);
                                    cloud1.defineCircle(2, 100, 50);

                                Cloud cloud2 = new Cloud(0, 200, 2, "back", camera);
                                    cloud2.defineCircle(0, 188, 40);
                                    cloud2.defineCircle(1, 250, 50);

                                Cloud cloud3 = new Cloud(400, 100, 2, "back", camera);
                                    cloud3.defineCircle(0, 300, 30);
                                    cloud3.defineCircle(1, 400, 50);

                                Cloud cloud4 = new Cloud(650, 640, 2, "back2", camera);
                                    cloud4.defineCircle(0, 350, 75);
                                    cloud4.defineCircle(1, 200, 100);

                                Cloud cloud5 = new Cloud(750, 30, 2, "mid", camera);
                                    cloud5.defineCircle(0, 400, 50);
                                    cloud5.defineCircle(1, 300, 75); 

                            //Background
                                Polygon mattePoly1 = new Polygon(4, "#42d5ff" , "#a7fffa" , "matte", camera); //polyCount, xOffset, yOffset, camera
                                    mattePoly1.defineCoordinate(0, 0, 0); //Index, x, y
                                    mattePoly1.defineCoordinate(1, 800, 0); //Index, x, y
                                    mattePoly1.defineCoordinate(2, 800, 600); //Index, x, y
                                    mattePoly1.defineCoordinate(3, 0, 600); //Index, x, y 
                            //Music
                                playSound.musicSound();
                                
                    //Press the HUD buttons                
                        //Press the buttonNewGame
                           buttonGoBack.setOnAction(new EventHandler<ActionEvent>()
                               {
                                   @Override
                                   public void handle(ActionEvent event)
                                       {
                                           playSound.buttonSound();
                                           mainMenu.play(stageEntry , swapCountEntry, windowWidthEntry, windowHeightEntry);
                                       } 
                               });   

                        //Press the buttonInformation
                            buttonInformation.setOnAction(new EventHandler<ActionEvent>()
                               {
                                   @Override
                                   public void handle(ActionEvent event)
                                       {
                                          playSound.buttonSound();
                                          JOptionPane.showMessageDialog(null, 
                                                  "CONTROLS:"
                                                          + "\n [A] = Go left."
                                                          + "\n [D] = Go right."
                                                          + "\n [S] = Duck."
                                                          + "\n [SPACE] = Jump."
                                                          + "\n [LeftMouseClick] = Shoot magic#1.");
                                       } 
                               });   

                    //Collect inputs
                        ArrayList<String> input = new ArrayList<String>();
                        
                    //Scripts for keyboard pressing
                        scene.setOnKeyPressed(
                               new EventHandler<KeyEvent>()
                               {
                                   public void handle(KeyEvent event)
                                   {
                                       if(!input.contains(event.getCode().toString()))
                                       {
                                           input.add(event.getCode().toString());
                                       }
                                   }
                               }
                           );

                        scene.setOnKeyReleased(
                            new EventHandler<KeyEvent>()
                            {
                                public void handle(KeyEvent event)
                                {
                                    input.remove(event.getCode().toString());
                                }
                            });        

//***************************Animation loop*************************************   
final long startNanoTime = System.nanoTime();
new AnimationTimer()
    {//Start of animation loop
        public void handle(long currentNanoTime)
        {//Start of animation handle
            double time = (currentNanoTime - startNanoTime) / 1000000000.0; 
        //Clear the field
            gc.clearRect(0, 0, windowWidthEntry,windowHeightEntry);
        //Draws 
            //Sky
                mattePoly1.draw(gc);
            //Sun   
                gc.setFill(Color.web("#FFFFBA",1.0));
                gc.fillOval(470 + camera.getScrollX()/globalVariables.getBackground2Damper(), 175 + camera.getScrollY()/globalVariables.getBackground2Damper(), 100, 100); //x, y, rx, ry     
            //Clouds
                cloud1.draw(gc);
                cloud2.draw(gc);
                cloud3.draw(gc);
                cloud4.draw(gc);
                cloud5.draw(gc);    
            //Polies    
                backPoly3.draw(gc);
                backPoly2.draw(gc);
                backPoly1.draw(gc);
                midPoly1.draw(gc);
            //Tree1
                tree1Branch1.draw(gc);
                tree1.draw(gc);
            //Tree2
                tree2Branch2.draw(gc);
                tree2.draw(gc);
                tree2Branch1.draw(gc);
            //Forepolies    
                forePoly1.draw(gc);
                forePoly2.draw(gc);
                startPoly.draw(gc);
                forePoly3.draw(gc);
                forePoly4.draw(gc);
                forePoly5.draw(gc);
            //Draw powerups
                //Star powerups
                    powerupStar1.draw(gc , time);
                    powerupStar2.draw(gc , time);
                    powerupStar3.draw(gc , time);
                    powerupStar4.draw(gc , time);
                //Health powerups
                    powerupHealth1.draw(gc , time);
            //Badugys
                badguy1.draw(gc, time);
                badguy2.draw(gc, time);
                badguy3.draw(gc, time);
            //Other
                playerStatus.checkPointsForExtraLife();
            //Player           
                player.draw();  //update player
            //Magic
                magic1.draw(gc, (time)); 
                magic2.draw(gc, (time)); 
                magic3.draw(gc, (time)); 
                scene.setOnMouseMoved(
                    new EventHandler<MouseEvent>()
                        {
                            public void handle(MouseEvent e)
                                {
                                    cursorTarget.setXpos(e.getSceneX());
                                    cursorTarget.setYpos(e.getSceneY());
                                }
                        });  
                cursorTarget.draw(gc); 

            //HUD
                HUD.drawHUD(gc , 1 , playerStatus.getLives(), playerStatus.getHealth(), playerStatus.getPoints(), playerStatus.getMagic()); //1 for level1 

            //Collisions
                //Collide with powerup              
                    powerupStar1.checkCollision(player, playerStatus, globalVariables.getPowerupBonus());
                    powerupStar2.checkCollision(player, playerStatus, globalVariables.getPowerupBonus());
                    powerupStar3.checkCollision(player, playerStatus, globalVariables.getPowerupBonus());
                    powerupStar4.checkCollision(player, playerStatus, globalVariables.getPowerupBonus());
                //Health powerups
                    powerupHealth1.checkCollision(player, playerStatus, globalVariables.getPowerupHealthBonus());

                //Collide with polygon platforms
                    if (
                        startPoly.checkCollision(player) == false &&
                        forePoly2.checkCollision(player) == false &&
                        forePoly4.checkCollision(player) == false && 
                        forePoly5.checkCollision(player) == false    
                       )
                        {
                            globalVariables.setPlayerCollisionBottom(false); //gravity value
                        }
                    else
                        {
                            globalVariables.setPlayerCollisionBottom(true); //gravity value
                        }

                    if (globalVariables.getPlayerCollisionBottom() == false)
                        {
                            player.jump();  
                            globalVariables.updateYAcceleration(1); //gravity value
                        }
                    else
                        {
                            player.idle();
                            globalVariables.setYAcceleration(0);
                        }

                //bad guys
                    badguy1.checkCollision(player, playerStatus, globalVariables.getContactBadguy());
                    badguy2.checkCollision(player, playerStatus, globalVariables.getContactBadguy());
                    badguy3.checkCollision(player, playerStatus, globalVariables.getContactBadguy());

                //Magic collides with outside boundaries
                    magic1.deactivateOutsideWindow(windowWidthEntry, windowHeightEntry);
                    magic2.deactivateOutsideWindow(windowWidthEntry, windowHeightEntry);
                    magic3.deactivateOutsideWindow(windowWidthEntry, windowHeightEntry);             
                                            
                //Mouse events
                    scene.setOnMouseClicked(
                    new EventHandler<MouseEvent>()
                        {
                            public void handle(MouseEvent e)
                                {
                                    if (playerStatus.getMagic() > 0)
                                        {
                                             //Shoot stuff
                                                     final double startTime = time;
                                                     playSound.fireSound();
                                                 //Swap between 3 fireballs
                                                     if (globalVariables.getMagicCounter() == 1)
                                                          {  
                                                              magic1.setStartTime(startTime);
                                                              magic1.setActive(true);
                                                              //Update the destination
                                                                  magic1.setXPos(player.getX() - camera.getScrollX());
                                                                  magic1.setYPos(player.getY() - camera.getScrollY());
                                                                  magic1.setXDestination(e.getSceneX()); //Set destination to mouse x
                                                                  magic1.setYDestination(e.getSceneY()); //Set destination to mouse y 
                                                          }
                                                     else if (globalVariables.getMagicCounter() == 2)
                                                          {  
                                                              magic2.setStartTime(startTime);
                                                              magic2.setActive(true);
                                                              //Update the destination
                                                                  magic2.setXPos(player.getX() - camera.getScrollX());
                                                                  magic2.setYPos(player.getY() - camera.getScrollY());
                                                                  magic2.setXDestination(e.getSceneX()); //Set destination to mouse x
                                                                  magic2.setYDestination(e.getSceneY()); //Set destination to mouse y 
                                                          }
                                                     else if (globalVariables.getMagicCounter() == 3)
                                                          {  
                                                              magic3.setStartTime(startTime);
                                                              magic3.setActive(true);
                                                              //Update the destination
                                                                  magic3.setXPos(player.getX() - camera.getScrollX());
                                                                  magic3.setYPos(player.getY() - camera.getScrollY());
                                                                  magic3.setXDestination(e.getSceneX()); //Set destination to mouse x
                                                                  magic3.setYDestination(e.getSceneY()); //Set destination to mouse y 
                                                          }
                                             globalVariables.setMagicCounter(globalVariables.getMagicCounter() + 1); //increment
                                             if (globalVariables.getMagicCounter() > 3)
                                                 { globalVariables.setMagicCounter(1);}
                                             //Update the HUD
                                                 playerStatus.setMagic(playerStatus.getMagic() - 1);
                                        }
                                }
                        }); //End of mouseEvent   
                        
                    //Keyboard events
                        if (input.contains("S"))//this does associate with the left key
                            {  
                                //Sound
                                    playSound.duckSound();
                                //Visual
                                    player.duck();
                            } 
                        if (input.contains("A"))//this does associate with the left key
                            {  
                                //Accelerate
                                    globalVariables.updateXAcceleration(globalVariables.getRunX());
                                //Visual
                                    globalVariables.oscillateOscillator(); //Increment a value
                                    player.run(globalVariables.getOscillator()); //Show run animation 
                            } 
                        else if (input.contains("D"))
                            {
                                //Accelerate 
                                   globalVariables.updateXAcceleration(-globalVariables.getRunX());
                                //Visual
                                   globalVariables.oscillateOscillator(); //Increment a value
                                   player.run(globalVariables.getOscillator()); //Show run animation 
                            } 
                         else
                            {
                                if (globalVariables.getPlayerCollisionBottom() == true)
                                {globalVariables.decayXAccelerationToZero();}
                            }
                        if (input.contains("W") && globalVariables.getPlayerCollisionBottom() == true)
                            {
                                playSound.jumpSound();
                                globalVariables.setYAcceleration(-globalVariables.getJumpY()); //goes up
                            } 

                    //Update camera
                        camera.updateX(globalVariables.getXAcceleration()); //X scroll
                        player.updateY(globalVariables.getYAcceleration());
                        camera.updateY(globalVariables.getYAcceleration()/-4); //Damped y scroll
                            
        }//End of animation handle
    }.start(); //End of animation loop
                //Show the scene
                   stageEntry.show();
                   
                //Scene settings        
                   stageEntry.setResizable(false); 
                   stageEntry.setTitle("SwingMan DIZAD 04/12/17");
                   stageEntry.setScene(scene);
                   stageEntry.show();

                //Attach stylesheet    
                    String css = Start.class.getResource("mainCSS.css").toExternalForm();
                    scene.getStylesheets().add(css); 
                    
                }//End of play method
        }//End of class
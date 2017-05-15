/*Daniel Izadnegahdar S00840086 IT2650 Lab#5 04/10/17*/

//Package
    package Scripts;
    
//Class
    public class PlayerStatus
        {
            //Properties
                private String name; //Key field
                private int checkpoint;
                private int lives;
                private int health;  
                private int points;
                private int magic;

            //Constructor
                PlayerStatus(String name, int checkpoint, int lives, int health, int points, int magic)
                    {
                        this.name = name;
                        this.checkpoint = checkpoint;
                        this.lives = lives;
                        this.health = health;
                        this.points = points;
                        this.magic = magic;
                    }
                
            //Methods
                //Mutators
                    public void setName(String nameEntry)
                        { name = nameEntry; }
                    public void setLives(int livesEntry)
                        { lives = livesEntry; }
                    public void setHealth(int healthEntry)
                        { health = healthEntry; } 
                    public void setPoints(int pointsEntry)
                        { points = pointsEntry; } 
                    public void setMagic(int magicEntry)
                        { magic = magicEntry; } 
                    public void setCheckpoint(int checkpointEntry)
                        { checkpoint = checkpointEntry; } 

                //Accessors
                    public int getLives()
                        { return lives; }
                    public int getHealth()
                        { return health; } 
                    public int getPoints()
                        { return points; }
                    public int getMagic()
                        { return magic; }
                    public int getCheckpoint()
                        { return checkpoint; }
                    public String getName()
                        { return name; }

                //Custom methods
                    public void checkPointsForExtraLife()
                        {
                            if (points > 99)
                                { 
                                    lives++;
                                    points = 0;
                                }      
                        }
 
                    public PlayerStatus deepCopy()
                        {
                             PlayerStatus clone = new PlayerStatus(name, checkpoint, lives, health, points, magic);
                             return clone;
                        }
        }
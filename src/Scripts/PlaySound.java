/*Daniel Izadnegahdar S00840086 IT2650 Lab#3 03/04/17*/

//Package
    package Scripts;

//Imported libraries
    import javafx.scene.media.AudioClip;

//Class
    public class PlaySound
        {
            //Instances of the audio clips
                AudioClip playButtonSound = new AudioClip(this.getClass().getResource("/Sounds/pressButton.wav").toExternalForm());
                AudioClip playFireSound = new AudioClip(this.getClass().getResource("/Sounds/fire.wav").toExternalForm());
                AudioClip playDuckSound = new AudioClip(this.getClass().getResource("/Sounds/duck.wav").toExternalForm());
                AudioClip playMusic = new AudioClip(this.getClass().getResource("/Sounds/music.mp3").toExternalForm());
                AudioClip playImpactBadGuySound = new AudioClip(this.getClass().getResource("/Sounds/impactBadGuy.wav").toExternalForm());
                AudioClip playJumpSound = new AudioClip(this.getClass().getResource("/Sounds/jump.wav").toExternalForm());
                AudioClip playPickupStar = new AudioClip(this.getClass().getResource("/Sounds/pickupStar.wav").toExternalForm());
                AudioClip playPickupHealth = new AudioClip(this.getClass().getResource("/Sounds/pickupHealth.wav").toExternalForm());
                AudioClip playReloadSound = new AudioClip(this.getClass().getResource("/Sounds/reload.wav").toExternalForm());
                AudioClip hoverButton = new AudioClip(this.getClass().getResource("/Sounds/hoverButton.wav").toExternalForm());
                
            //Methods
                public void buttonSound()
                    {playButtonSound.play();}
                public void fireSound()
                    {playFireSound.play();} 
                public void duckSound()
                    {playDuckSound.play();}  
                public void musicSound()
                    {playMusic.play();}
                public void impactBadGuySound()
                    {playImpactBadGuySound.play();}  
                public void jumpSound()
                    {playJumpSound.play();}  
                public void pickupStarSound()
                    {playPickupStar.play();} 
                public void healthSound()
                    {playPickupHealth.play();} 
                public void reloadSound()
                    {playReloadSound.play();}
                public void hoverButton()
                    {hoverButton.play();}          
        }//End of class
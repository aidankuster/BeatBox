package application;
	
import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			stage.setTitle("BeatBox ((d[-_-]b))");
			stage.getIcons().add(new Image("BeatBoxIcon/BeatBoxIcon.png"));
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setWidth(1280);
			stage.setHeight(720);
			stage.show();
			Controller c = loader.getController();
			
			// finger drumming section
			// this section links keyboard keys (z,c,v,d,f,g,h,j,q,e,t) to the drum machine audio samples
			scene.setOnKeyPressed(b -> {
				if(b.getCode() == KeyCode.Z){ // bass drum
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/BT0A0A7.WAV";
					else
						soundFile = "808samples/808bassdrum.wav";
					
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.C){ // snare
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/ST7T0S3.WAV";
					else
						soundFile = "808samples/808snare.wav";
					
			        playSound(soundFile);
				}
				if(b.getCode() == KeyCode.D){ // closed hi-hat
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/HHCD0(lowerVolume).wav";
					else
						soundFile = "808samples/808closedhat.wav";
					
			        playSound(soundFile);
				}
				if(b.getCode() == KeyCode.E){ // open hi-hat
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/HHOD0(lowerVolume).wav";
					else
						soundFile = "808samples/808openhat.wav";
			        playSound(soundFile);
				}
				if(b.getCode() == KeyCode.V){ // clap
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/HANDCLP1.WAV";
					else
						soundFile = "808samples/808clap.wav";
			        playSound(soundFile);
				}
				if(b.getCode() == KeyCode.F){ // rim
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/RIM63.WAV";
					else
						soundFile = "808samples/808rim.wav";
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.Q){ // crash
					c.keyPressed(b);
					String soundFile; 
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/CSHD0(lowerVolume).wav";
					else
						soundFile = "808samples/808crash.wav";
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.T){ // ride or clave
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/RIDED0(lowerVolume).wav";
					else
						soundFile = "808samples/808clave.wav";
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.J){ // hi tom or cowbell
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/HT0D0.WAV";
					else
						soundFile = "808samples/808cowbell.wav";
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.H){ // mid tom
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/MT0D0.WAV";
					else
						soundFile = "808samples/808midtom.wav";
			        playSound(soundFile);
				}	
				if(b.getCode() == KeyCode.G){ // low tom
					c.keyPressed(b);
					String soundFile;
					if(c.getDrumMachine() == 1)
						soundFile = "909samples/LT0D0.WAV";
					else
						soundFile = "808samples/808lowtom.wav";
			        playSound(soundFile);
				}	
				
			});
			
			scene.setOnKeyReleased(b -> {
			    if (b.getCode() == KeyCode.Z){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.C){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.D){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.E){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.V){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.F){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.G){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.H){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.J){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.Q){
			        c.keyReleased(b);
			    }
			    if (b.getCode() == KeyCode.T){
			        c.keyReleased(b);
			    }
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playSound(String soundFile) {
	    try {
	        // Get the resource as a stream
	        InputStream inputStream = getClass().getResourceAsStream("/" + soundFile);
	        
	        if (inputStream == null) {
	            System.out.println("Audio resource not found: " + soundFile);
	            return;
	        }

	        // Wrap the InputStream with BufferedInputStream to support mark/reset
	        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

	        // Open the audio input stream using AudioSystem
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch (Exception e) {
	        System.out.println("ERROR: Audio file could not be found");
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
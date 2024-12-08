package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller extends ToggleButtons{
	
	@FXML
	private Label bpmLabel;
	@FXML
	private Label listening;
	@FXML
	private ComboBox<String> comboBox = new ComboBox<String>();
	@FXML
	private Button clearAll;
	@FXML
	private ToggleButton record;
	public static int drumMachine = 0;
	@FXML
	private ToggleButton bassKey, snareKey, openHiHatKey, closedHiHatKey, clapKey, rimKey, lowTomKey, midTomKey,
						highTomKey, crashKey, rideKey;
	
	private Map<KeyCode, ToggleButton> keyToButtonMap = new HashMap<>();
	
	@FXML
	private Text pattern;
	
	@FXML
	private Text console;
	
	@FXML
	Text ride = new Text();
	@FXML
	Text highTom = new Text();
	@FXML
	Button rideButton = new Button();
	@FXML
	Button highTomButton = new Button();
	@FXML
	ImageView view = new ImageView();
	
	int BPM = 120;
	long sleepTime = (long)((60.0 / (BPM * 4)) * 1000);

	public void setBPM(int bpm){
		bpmLabel.setStyle("-fx-font-family: 'Audiowide Regular';");
		bpmLabel.setText("BPM: " + bpm);
		bpmLabel.setTextFill(Color.WHITE);
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
	
	public Controller getController(){
		Controller c = new Controller();
		return c;
	}
	
	@FXML
	public ComboBox<String> getComboBox(){
		return comboBox;
	}
	
	@FXML
	private boolean[] playing = {false};
	private int currentStep = 0;
	
	ToggleButton[] kickArray;
	ToggleButton[] clapArray;
	ToggleButton[] openHatArray;
	ToggleButton[] closedHatArray;
	ToggleButton[] snareArray;
	ToggleButton[] crashArray;
	ToggleButton[] lowTomArray;
	ToggleButton[] midTomArray;
	ToggleButton[] highTomArray;
	ToggleButton[] rimArray;
	ToggleButton[] rideArray;
	
	ToggleButton[] allArrays;
	
	RadioButton[] radioArray;
	
	ToggleGroup group = new ToggleGroup();
	
	
	
	@FXML
	public void initialize(){
		setBPM(BPM);
		listening.setStyle("-fx-font-weight: bold");
		listening.setStyle("-fx-font-family: 'Audiowide Regular';");
		comboBox.getItems().addAll("TR-808", "TR-909");
		startupSound();
		
		keyToButtonMap.put(KeyCode.Z, bassKey);
	    keyToButtonMap.put(KeyCode.C, snareKey);
	    keyToButtonMap.put(KeyCode.D, closedHiHatKey);
	    keyToButtonMap.put(KeyCode.E, openHiHatKey);
	    keyToButtonMap.put(KeyCode.V, clapKey);
	    keyToButtonMap.put(KeyCode.F, rimKey);
	    keyToButtonMap.put(KeyCode.G, lowTomKey);
	    keyToButtonMap.put(KeyCode.H, midTomKey);
	    keyToButtonMap.put(KeyCode.J, highTomKey);
	    keyToButtonMap.put(KeyCode.Q, crashKey);
	    keyToButtonMap.put(KeyCode.T, rideKey);
	    
		kickArray = new ToggleButton[] {kick1, kick2, kick3, kick4, kick5, kick6, kick7, kick8, kick9, kick10, kick11, kick12, kick13, kick14, kick15, kick16};
		clapArray = new ToggleButton[] {clap1, clap2, clap3, clap4, clap5, clap6, clap7, clap8, clap9, clap10, clap11, clap12, clap13, clap14, clap15, clap16};
		openHatArray = new ToggleButton[] {openHat1, openHat2, openHat3, openHat4, openHat5, openHat6, openHat7, openHat8, openHat9, openHat10, openHat11, openHat12, openHat13, openHat14, openHat15, openHat16};
		closedHatArray = new ToggleButton[] {closedHat1, closedHat2, closedHat3, closedHat4, closedHat5, closedHat6, closedHat7, closedHat8, closedHat9, closedHat10, closedHat11, closedHat12, closedHat13, closedHat14, closedHat15, closedHat16};
		snareArray = new ToggleButton[] {snare1, snare2, snare3, snare4, snare5, snare6, snare7, snare8, snare9, snare10, snare11, snare12, snare13, snare14, snare15, snare16};
		crashArray = new ToggleButton[] {crash1, crash2, crash3, crash4, crash5, crash6, crash7, crash8, crash9, crash10, crash11, crash12, crash13, crash14, crash15, crash16};
		lowTomArray = new ToggleButton[] {lowTom1, lowTom2, lowTom3, lowTom4, lowTom5, lowTom6, lowTom7, lowTom8, lowTom9, lowTom10, lowTom11, lowTom12, lowTom13, lowTom14, lowTom15, lowTom16};
		midTomArray = new ToggleButton[] {midTom1, midTom2, midTom3, midTom4, midTom5, midTom6, midTom7, midTom8, midTom9, midTom10, midTom11, midTom12, midTom13, midTom14, midTom15, midTom16};
		highTomArray = new ToggleButton[] {highTom1, highTom2, highTom3, highTom4, highTom5, highTom6, highTom7, highTom8, highTom9, highTom10, highTom11, highTom12, highTom13, highTom14, highTom15, highTom16};
		rimArray = new ToggleButton[] {rim1, rim2, rim3, rim4, rim5, rim6, rim7, rim8, rim9, rim10, rim11, rim12, rim13, rim14, rim15, rim16};
		rideArray = new ToggleButton[] {ride1, ride2, ride3, ride4, ride5, ride6, ride7, ride8, ride9, ride10, ride11, ride12, ride13, ride14, ride15, ride16};
		
		allArrays = new ToggleButton[] {crash1, crash2, crash3, crash4, crash5, crash6, crash7, crash8, crash9, crash10, crash11, crash12, crash13, crash14, crash15, crash16,
										ride1, ride2, ride3, ride4, ride5, ride6, ride7, ride8, ride9, ride10, ride11, ride12, ride13, ride14, ride15, ride16, 
										openHat1, openHat2, openHat3, openHat4, openHat5, openHat6, openHat7, openHat8, openHat9, openHat10, openHat11, openHat12, openHat13, openHat14, openHat15, openHat16,
										closedHat1, closedHat2, closedHat3, closedHat4, closedHat5, closedHat6, closedHat7, closedHat8, closedHat9, closedHat10, closedHat11, closedHat12, closedHat13, closedHat14, closedHat15, closedHat16,
										clap1, clap2, clap3, clap4, clap5, clap6, clap7, clap8, clap9, clap10, clap11, clap12, clap13, clap14, clap15, clap16,
										rim1, rim2, rim3, rim4, rim5, rim6, rim7, rim8, rim9, rim10, rim11, rim12, rim13, rim14, rim15, rim16, 
										highTom1, highTom2, highTom3, highTom4, highTom5, highTom6, highTom7, highTom8, highTom9, highTom10, highTom11, highTom12, highTom13, highTom14, highTom15, highTom16,
										midTom1, midTom2, midTom3, midTom4, midTom5, midTom6, midTom7, midTom8, midTom9, midTom10, midTom11, midTom12, midTom13, midTom14, midTom15, midTom16, 
										lowTom1, lowTom2, lowTom3, lowTom4, lowTom5, lowTom6, lowTom7, lowTom8, lowTom9, lowTom10, lowTom11, lowTom12, lowTom13, lowTom14, lowTom15, lowTom16,
										snare1, snare2, snare3, snare4, snare5, snare6, snare7, snare8, snare9, snare10, snare11, snare12, snare13, snare14, snare15, snare16,
										kick1, kick2, kick3, kick4, kick5, kick6, kick7, kick8, kick9, kick10, kick11, kick12, kick13, kick14, kick15, kick16};
		
		
		radioArray = new RadioButton[] {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16};
		for(RadioButton r : radioArray){
			r.setToggleGroup(group);
		}	
		printToConsole("Welcome to BeatBox!");
	}
	
	public void pressed(ToggleButton b){
		b.setSelected(true);
	}
	
	public void released(ToggleButton b){
		b.setSelected(false);
	}
	
	String[] mascot = {"d[-_-]b", "(d[-_-]b)", "( d[-_-]b )"};
	int count = 0;
	private ScheduledExecutorService scheduler;
	
	@FXML
	public void clearAll(){		
		for(ToggleButton b : allArrays){
			if(b.isSelected()){
				b.setSelected(false);
			}
		}
		printToConsole("Pattern cleared");
	}
	
	public void recordPattern(){
		try{
			File outputFile = new File("BeatBoxPattern.txt");
			if(outputFile.createNewFile()){
				System.out.println("File created: " + outputFile.getName());
			}
			else{
				System.out.println("File already exists");
			}
			FileWriter writer = new FileWriter("BeatBoxPattern.txt");
			Date date = new Date();
			writer.write("BeatBox pattern created on " + date + " at " + BPM + " BPM \n\n");
			String[] instrumentNames808 = {"Crash", "Clave", "Open Hi-Hat", "Closed Hi-Hat", "Clap", "Rim", "Cowbell",
					"Mid Tom", "Low Tom", "Snare", "Bass Drum"}; 
			String[] instrumentNames909 = {"Crash", "Ride", "Open Hi-Hat", "Closed Hi-Hat", "Clap", "Rim", "High Tom",
					"Mid Tom", "Low Tom", "Snare", "Bass Drum"};
			
			String[] instrumentNames = new String[11];
			if(drumMachine == 0)
				for(int i = 0; i < 11; i++)
					instrumentNames[i] = instrumentNames808[i];
			else
				for(int i = 0; i < 11; i++)
					instrumentNames[i] = instrumentNames909[i];
			
			int count = 0;
			for(int i = 0; i < allArrays.length; i++){
				if(i==0 || i%16==0){
					if(instrumentNames[count].length() > 7)
						writer.write(instrumentNames[count] +  "\t");
					else
						writer.write(instrumentNames[count] +  "\t\t");
					
					count++;
				}
				if(allArrays[i].isSelected()){
					writer.write("x ");
				}
				else{
					writer.write("- ");
				}

				if(i!=0 && (i+1)%16==0){
					writer.write("\n");
				}
			}
			writer.write("\t\t1   |   2   |   3   |   4   |");
			writer.write("\n\n((d[-_-]b))");
			writer.close();
			System.out.println("Successfully wrote text to file BeatBoxPattern.txt");
			printToConsole("Successfully wrote text to file BeatBoxPattern.txt");
		}
		catch(IOException e){
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
	
	@FXML
	public void printToConsole(String message)
	{
		console.setText(message);
	}
	
	@FXML
	public void helpWindow(ActionEvent event) throws IOException {
		
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
			Scene scene = new Scene(root,400,400);
			stage.setTitle("BeatBox Help Section");
			stage.getIcons().add(new Image("BeatBoxIcon/BeatBoxIcon.png"));
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setWidth(560);
			stage.setHeight(640);
			stage.show();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void keyboardWindow(ActionEvent event) throws IOException {
		
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Keyboard.fxml"));
			Scene scene = new Scene(root,400,400);
			stage.setTitle("BeatBox Live Drumming");
			stage.getIcons().add(new Image("BeatBoxIcon/BeatBoxIcon.png"));
			stage.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setWidth(560);
			stage.setHeight(480);
			stage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeNames(){
		
		if(comboBox.getValue() == "TR-808"){
			rideButton.setText("CLAVE");
			highTomButton.setText("COWBELL");
			ride.setText("CLAVE");
			ride.setLayoutX(44);
			highTom.setText("COWBELL");
			drumMachine = 0;
			System.out.println(drumMachine);
			printToConsole("Drum machine changed to TR-808");
		}
		else if(comboBox.getValue() == "TR-909"){
			rideButton.setText("RIDE");
			highTomButton.setText("HIGH TOM");
			ride.setText("RIDE");
			ride.setLayoutX(50);
			highTom.setText("HIGH TOM");
			drumMachine = 1;
			System.out.println(drumMachine);
			printToConsole("Drum machine changed to TR-909");
		}
	}
	
	public int getDrumMachine(){
		return drumMachine;
	}

	@FXML
	public void onOff(ActionEvent e){
		playing[0] = !playing[0];
		patternOn();
		printToConsole("");
		
		if(playing[0]){
			currentStep = 0;
			
			scheduler = Executors.newScheduledThreadPool(1);
			scheduler.scheduleAtFixedRate(() -> {			
				radioArray[currentStep].setSelected(true);
 
				// check every instrument in the loop simultaneously, if button is selected, sound will play
				if(kickArray[currentStep].isSelected()){
					kick();
				}
				if(clapArray[currentStep].isSelected()){
					clap();
				}
				if(openHatArray[currentStep].isSelected()){
					openHat();
				}
				if(closedHatArray[currentStep].isSelected()){
					closedHat();
				}
				if(snareArray[currentStep].isSelected()){
					snare();
				}
				if(crashArray[currentStep].isSelected()){
					crash();
				}
				if(lowTomArray[currentStep].isSelected()){
					lowTom();
				}
				if(midTomArray[currentStep].isSelected()){
					midTom();
				}
				if(highTomArray[currentStep].isSelected()){
					highTom();
				}
				if(rimArray[currentStep].isSelected()){
					rim();
				}
				if(rideArray[currentStep].isSelected()){
					ride();
				}
				
				if(currentStep%2 != 0){
					Platform.runLater(()-> {
						listening.setText(mascot[count]);
						listening.setAlignment(Pos.CENTER);
						listening.setMaxWidth(Double.MAX_VALUE);
						count = (count + 1) % 3;
					});
				}
				
				currentStep = (currentStep + 1) % 16;
				System.out.println(currentStep);
				
			
		}, 0, sleepTime, TimeUnit.MILLISECONDS);
		}
		else{
			patternOff();
			if(scheduler != null && !scheduler.isShutdown()){
				scheduler.shutdown();
			}
		}
	}
	
	public void patternOn(){
		pattern.setText("PLAYING PATTERN: TRUE");
	}
	
	public void patternOff(){
		pattern.setText("PLAYING PATTERN: FALSE");
	}
	
	public void startupSound(){
		String soundFile = "startupSound.wav";
        playSound(soundFile);
	}
	
	public void increaseBPM(){
		if(BPM < 199){
			BPM++;
			setBPM(BPM);
			sleepTime = (long)((60.0 / (BPM * 4)) * 1000);
		}
	}
	
	public void decreaseBPM(){
		if(BPM > 40){
			BPM--;
			setBPM(BPM);
			sleepTime = (long)((60.0 / (BPM * 4)) * 1000);
		}
	}
	
	@FXML
	void keyPressed(KeyEvent event){
		ToggleButton button = keyToButtonMap.get(event.getCode());
		if(button != null)
			button.setSelected(true);
	}
	
	@FXML
	void keyReleased(KeyEvent event){
		ToggleButton button = keyToButtonMap.get(event.getCode());
		if(button != null)
			button.setSelected(false);
	}

	@FXML
	public void kick(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/BT0A0A7.wav";
		else
			soundFile = "808samples/808bassdrum.wav";

        playSound(soundFile);
	}

	@FXML
	public void clap(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/HANDCLP1.WAV";
		else
			soundFile = "808samples/808clap.wav";
			
        playSound(soundFile);
	}

	@FXML
	public void openHat(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/HHOD0(lowerVolume).wav";
		else
			soundFile = "808samples/808openhat.wav";

        playSound(soundFile);
	}
	
	@FXML
	public void closedHat(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/HHCD0(lowerVolume).wav";
		else
			soundFile = "808samples/808closedhat.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void lowTom(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/LT0D0.WAV";
		else
			soundFile = "808samples/808lowtom.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void midTom(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/MT0D0.WAV";
		else
			soundFile = "808samples/808midtom.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void highTom(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/HT0D0.WAV";
		else
			soundFile = "808samples/808cowbell.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void rim(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/RIM63.WAV";
		else
			soundFile = "808samples/808rim.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void snare(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/ST7T0S3.WAV";
		else
			soundFile = "808samples/808snare.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void crash(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/CSHD0(lowerVolume).wav";
		else
			soundFile = "808samples/808crash.wav";
		
        playSound(soundFile);
	}
	
	@FXML
	public void ride(){
		String soundFile;
		if(comboBox.getValue() == "TR-909")
			soundFile = "909samples/RIDED0(lowerVolume).wav";
		else
			soundFile = "808samples/808clave.wav";
		
        playSound(soundFile);
	}
	
}

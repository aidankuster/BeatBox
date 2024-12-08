package application;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class ToggleButtons
{
	// all toggle buttons used for each of the 11 instruments (176 in total)
	
	@FXML
	ToggleButton kick1 = new ToggleButton();
	@FXML
	ToggleButton kick2 = new ToggleButton();
	@FXML
	ToggleButton kick3 = new ToggleButton();
	@FXML
	ToggleButton kick4 = new ToggleButton();
	@FXML
	ToggleButton kick5 = new ToggleButton();
	@FXML
	ToggleButton kick6 = new ToggleButton();
	@FXML
	ToggleButton kick7 = new ToggleButton();
	@FXML
	ToggleButton kick8 = new ToggleButton();
	@FXML
	ToggleButton kick9 = new ToggleButton();
	@FXML
	ToggleButton kick10 = new ToggleButton();
	@FXML
	ToggleButton kick11 = new ToggleButton();
	@FXML
	ToggleButton kick12 = new ToggleButton();
	@FXML
	ToggleButton kick13 = new ToggleButton();
	@FXML
	ToggleButton kick14 = new ToggleButton();
	@FXML
	ToggleButton kick15 = new ToggleButton();
	@FXML
	ToggleButton kick16 = new ToggleButton();
	
	@FXML
	ToggleButton clap1 = new ToggleButton();
	@FXML
	ToggleButton clap2 = new ToggleButton();
	@FXML
	ToggleButton clap3 = new ToggleButton();
	@FXML
	ToggleButton clap4 = new ToggleButton();
	@FXML
	ToggleButton clap5 = new ToggleButton();
	@FXML
	ToggleButton clap6 = new ToggleButton();
	@FXML
	ToggleButton clap7 = new ToggleButton();
	@FXML
	ToggleButton clap8 = new ToggleButton();
	@FXML
	ToggleButton clap9 = new ToggleButton();
	@FXML
	ToggleButton clap10 = new ToggleButton();
	@FXML
	ToggleButton clap11 = new ToggleButton();
	@FXML
	ToggleButton clap12 = new ToggleButton();
	@FXML
	ToggleButton clap13 = new ToggleButton();
	@FXML
	ToggleButton clap14 = new ToggleButton();
	@FXML
	ToggleButton clap15 = new ToggleButton();
	@FXML
	ToggleButton clap16 = new ToggleButton();
	
	@FXML
	ToggleButton openHat1 = new ToggleButton();
	@FXML
	ToggleButton openHat2 = new ToggleButton();
	@FXML
	ToggleButton openHat3 = new ToggleButton();
	@FXML
	ToggleButton openHat4 = new ToggleButton();
	@FXML
	ToggleButton openHat5 = new ToggleButton();
	@FXML
	ToggleButton openHat6 = new ToggleButton();
	@FXML
	ToggleButton openHat7 = new ToggleButton();
	@FXML
	ToggleButton openHat8 = new ToggleButton();
	@FXML
	ToggleButton openHat9 = new ToggleButton();
	@FXML
	ToggleButton openHat10 = new ToggleButton();
	@FXML
	ToggleButton openHat11 = new ToggleButton();
	@FXML
	ToggleButton openHat12 = new ToggleButton();
	@FXML
	ToggleButton openHat13 = new ToggleButton();
	@FXML
	ToggleButton openHat14 = new ToggleButton();
	@FXML
	ToggleButton openHat15 = new ToggleButton();
	@FXML
	ToggleButton openHat16 = new ToggleButton();
	
	@FXML
	ToggleButton closedHat1 = new ToggleButton();
	@FXML
	ToggleButton closedHat2 = new ToggleButton();
	@FXML
	ToggleButton closedHat3 = new ToggleButton();
	@FXML
	ToggleButton closedHat4 = new ToggleButton();
	@FXML
	ToggleButton closedHat5 = new ToggleButton();
	@FXML
	ToggleButton closedHat6 = new ToggleButton();
	@FXML
	ToggleButton closedHat7 = new ToggleButton();
	@FXML
	ToggleButton closedHat8 = new ToggleButton();
	@FXML
	ToggleButton closedHat9 = new ToggleButton();
	@FXML
	ToggleButton closedHat10 = new ToggleButton();
	@FXML
	ToggleButton closedHat11 = new ToggleButton();
	@FXML
	ToggleButton closedHat12 = new ToggleButton();
	@FXML
	ToggleButton closedHat13 = new ToggleButton();
	@FXML
	ToggleButton closedHat14 = new ToggleButton();
	@FXML
	ToggleButton closedHat15 = new ToggleButton();
	@FXML
	ToggleButton closedHat16 = new ToggleButton();
	
	@FXML
	ToggleButton snare1 = new ToggleButton();
	@FXML
	ToggleButton snare2 = new ToggleButton();
	@FXML
	ToggleButton snare3 = new ToggleButton();
	@FXML
	ToggleButton snare4 = new ToggleButton();
	@FXML
	ToggleButton snare5 = new ToggleButton();
	@FXML
	ToggleButton snare6 = new ToggleButton();
	@FXML
	ToggleButton snare7 = new ToggleButton();
	@FXML
	ToggleButton snare8 = new ToggleButton();
	@FXML
	ToggleButton snare9 = new ToggleButton();
	@FXML
	ToggleButton snare10 = new ToggleButton();
	@FXML
	ToggleButton snare11 = new ToggleButton();
	@FXML
	ToggleButton snare12 = new ToggleButton();
	@FXML
	ToggleButton snare13 = new ToggleButton();
	@FXML
	ToggleButton snare14 = new ToggleButton();
	@FXML
	ToggleButton snare15 = new ToggleButton();
	@FXML
	ToggleButton snare16 = new ToggleButton();
	
	@FXML
	ToggleButton crash1 = new ToggleButton();
	@FXML
	ToggleButton crash2 = new ToggleButton();
	@FXML
	ToggleButton crash3 = new ToggleButton();
	@FXML
	ToggleButton crash4 = new ToggleButton();
	@FXML
	ToggleButton crash5 = new ToggleButton();
	@FXML
	ToggleButton crash6 = new ToggleButton();
	@FXML
	ToggleButton crash7 = new ToggleButton();
	@FXML
	ToggleButton crash8 = new ToggleButton();
	@FXML
	ToggleButton crash9 = new ToggleButton();
	@FXML
	ToggleButton crash10 = new ToggleButton();
	@FXML
	ToggleButton crash11 = new ToggleButton();
	@FXML
	ToggleButton crash12 = new ToggleButton();
	@FXML
	ToggleButton crash13 = new ToggleButton();
	@FXML
	ToggleButton crash14 = new ToggleButton();
	@FXML
	ToggleButton crash15 = new ToggleButton();
	@FXML
	ToggleButton crash16 = new ToggleButton();
	
	@FXML
	ToggleButton lowTom1 = new ToggleButton();
	@FXML
	ToggleButton lowTom2 = new ToggleButton();
	@FXML
	ToggleButton lowTom3 = new ToggleButton();
	@FXML
	ToggleButton lowTom4 = new ToggleButton();
	@FXML
	ToggleButton lowTom5 = new ToggleButton();
	@FXML
	ToggleButton lowTom6 = new ToggleButton();
	@FXML
	ToggleButton lowTom7 = new ToggleButton();
	@FXML
	ToggleButton lowTom8 = new ToggleButton();
	@FXML
	ToggleButton lowTom9 = new ToggleButton();
	@FXML
	ToggleButton lowTom10 = new ToggleButton();
	@FXML
	ToggleButton lowTom11 = new ToggleButton();
	@FXML
	ToggleButton lowTom12 = new ToggleButton();
	@FXML
	ToggleButton lowTom13 = new ToggleButton();
	@FXML
	ToggleButton lowTom14 = new ToggleButton();
	@FXML
	ToggleButton lowTom15 = new ToggleButton();
	@FXML
	ToggleButton lowTom16 = new ToggleButton();
	
	@FXML
	ToggleButton midTom1 = new ToggleButton();
	@FXML
	ToggleButton midTom2 = new ToggleButton();
	@FXML
	ToggleButton midTom3 = new ToggleButton();
	@FXML
	ToggleButton midTom4 = new ToggleButton();
	@FXML
	ToggleButton midTom5 = new ToggleButton();
	@FXML
	ToggleButton midTom6 = new ToggleButton();
	@FXML
	ToggleButton midTom7 = new ToggleButton();
	@FXML
	ToggleButton midTom8 = new ToggleButton();
	@FXML
	ToggleButton midTom9 = new ToggleButton();
	@FXML
	ToggleButton midTom10 = new ToggleButton();
	@FXML
	ToggleButton midTom11 = new ToggleButton();
	@FXML
	ToggleButton midTom12 = new ToggleButton();
	@FXML
	ToggleButton midTom13 = new ToggleButton();
	@FXML
	ToggleButton midTom14 = new ToggleButton();
	@FXML
	ToggleButton midTom15 = new ToggleButton();
	@FXML
	ToggleButton midTom16 = new ToggleButton();
	
	@FXML
	ToggleButton highTom1 = new ToggleButton();
	@FXML
	ToggleButton highTom2 = new ToggleButton();
	@FXML
	ToggleButton highTom3 = new ToggleButton();
	@FXML
	ToggleButton highTom4 = new ToggleButton();
	@FXML
	ToggleButton highTom5 = new ToggleButton();
	@FXML
	ToggleButton highTom6 = new ToggleButton();
	@FXML
	ToggleButton highTom7 = new ToggleButton();
	@FXML
	ToggleButton highTom8 = new ToggleButton();
	@FXML
	ToggleButton highTom9 = new ToggleButton();
	@FXML
	ToggleButton highTom10 = new ToggleButton();
	@FXML
	ToggleButton highTom11 = new ToggleButton();
	@FXML
	ToggleButton highTom12 = new ToggleButton();
	@FXML
	ToggleButton highTom13 = new ToggleButton();
	@FXML
	ToggleButton highTom14 = new ToggleButton();
	@FXML
	ToggleButton highTom15 = new ToggleButton();
	@FXML
	ToggleButton highTom16 = new ToggleButton();
	
	@FXML
	ToggleButton rim1 = new ToggleButton();
	@FXML
	ToggleButton rim2 = new ToggleButton();
	@FXML
	ToggleButton rim3 = new ToggleButton();
	@FXML
	ToggleButton rim4 = new ToggleButton();
	@FXML
	ToggleButton rim5 = new ToggleButton();
	@FXML
	ToggleButton rim6 = new ToggleButton();
	@FXML
	ToggleButton rim7 = new ToggleButton();
	@FXML
	ToggleButton rim8 = new ToggleButton();
	@FXML
	ToggleButton rim9 = new ToggleButton();
	@FXML
	ToggleButton rim10 = new ToggleButton();
	@FXML
	ToggleButton rim11 = new ToggleButton();
	@FXML
	ToggleButton rim12 = new ToggleButton();
	@FXML
	ToggleButton rim13 = new ToggleButton();
	@FXML
	ToggleButton rim14 = new ToggleButton();
	@FXML
	ToggleButton rim15 = new ToggleButton();
	@FXML
	ToggleButton rim16 = new ToggleButton();
	
	@FXML
	ToggleButton ride1 = new ToggleButton();
	@FXML
	ToggleButton ride2 = new ToggleButton();
	@FXML
	ToggleButton ride3 = new ToggleButton();
	@FXML
	ToggleButton ride4 = new ToggleButton();
	@FXML
	ToggleButton ride5 = new ToggleButton();
	@FXML
	ToggleButton ride6 = new ToggleButton();
	@FXML
	ToggleButton ride7 = new ToggleButton();
	@FXML
	ToggleButton ride8 = new ToggleButton();
	@FXML
	ToggleButton ride9 = new ToggleButton();
	@FXML
	ToggleButton ride10 = new ToggleButton();
	@FXML
	ToggleButton ride11 = new ToggleButton();
	@FXML
	ToggleButton ride12 = new ToggleButton();
	@FXML
	ToggleButton ride13 = new ToggleButton();
	@FXML
	ToggleButton ride14 = new ToggleButton();
	@FXML
	ToggleButton ride15 = new ToggleButton();
	@FXML
	ToggleButton ride16 = new ToggleButton();
	
	// 16 radio buttons to provide visualization of the step sequencer
	@FXML
	RadioButton r1 = new RadioButton();
	@FXML
	RadioButton r2 = new RadioButton();
	@FXML
	RadioButton r3 = new RadioButton();
	@FXML
	RadioButton r4 = new RadioButton();
	@FXML
	RadioButton r5 = new RadioButton();
	@FXML
	RadioButton r6 = new RadioButton();
	@FXML
	RadioButton r7 = new RadioButton();
	@FXML
	RadioButton r8 = new RadioButton();
	@FXML
	RadioButton r9 = new RadioButton();
	@FXML
	RadioButton r10 = new RadioButton();
	@FXML
	RadioButton r11 = new RadioButton();
	@FXML
	RadioButton r12 = new RadioButton();
	@FXML
	RadioButton r13 = new RadioButton();
	@FXML
	RadioButton r14 = new RadioButton();
	@FXML
	RadioButton r15 = new RadioButton();
	@FXML
	RadioButton r16 = new RadioButton();
}
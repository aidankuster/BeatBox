# BeatBox - A Virtual Drum Machine Application

![image alt](https://github.com/aidankuster/BeatBox/blob/main/BeatBoxLogo-removebg-preview.png?raw=true)

Developed by Aidan Kuster with additional help from Mikul Brimley and Daniel Vivar.

- BeatBox is a drum machine application that allows users to create drum beats and rhythmic patterns.
- Users can program beats into the “sequencer” or can play drums live using their computer keyboard.
- Provides two different drum machine sound presets (TR-808 & TR-909) and the ability to change the speed of the drum pattern (BPM value).
- Users can save their patterns as a .txt file for later reuse or to share with others.

# The BeatBox Home Screen
![image alt](https://github.com/aidankuster/BeatBox/blob/main/Screenshot%20(137).png?raw=true)

# Run Instructions
  1. Download and install the Java JDK (preferrably version 20.0.2)
     
     https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html
  2. Download and install JavaFX (preferrably version 22.0.2)

     https://gluonhq.com/products/javafx/
  3. Download and install the Google Font Audiowide

     https://fonts.google.com/specimen/Audiowide
  4. On this GitHub page, click the drop-down on the green 'Code' button and download BeatBox as a ZIP file.
  5. Extract this ZIP and find the BeatBox.jar file contained inside. Move this jar file to your Desktop.
  6. Open the Command Prompt and navigate to your desktop directory. This can typically be done by simply typing "cd Desktop" into the command prompt window.
  7. Input the following message into the Command Prompt with your own filepath for the JavaFX 'lib' file (which can be found inside of the JavaFX folder, refer back to Step 2)
     
     java --module-path "C:\Users\YourName\path\to\openjfx-22.0.2_windows-x64_bin-sdk\javafx-sdk-22.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar BeatBox.jar
  

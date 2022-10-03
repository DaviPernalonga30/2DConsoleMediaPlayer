/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2daudioplayer;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import pkg2daudioplayer.src.AudioPlayback;

/**
 *
 * @author davip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filepath = "BlocoClimatizarBoscoDefar.wav";
        AudioPlayback aud = new AudioPlayback(filepath);
        
        // TODO code application logic here
    }
    
}

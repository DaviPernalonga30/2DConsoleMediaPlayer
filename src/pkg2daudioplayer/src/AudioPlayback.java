/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author davip
 */
public class AudioPlayback {
    private String filepath;
    private AudioInputStream audInput;
    private Clip clip;
        
    public void ChangeSong(String filepath) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        this.filepath = filepath;
        StartPlayback();
        
    }
    
    public void StartPlayback() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        System.out.println("Tocando agora: "+new File(filepath).getName());
        this.audInput = AudioSystem.getAudioInputStream(new File(this.filepath).getAbsoluteFile());
        this.clip = AudioSystem.getClip();
        this.clip.open(this.audInput);
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
        this.clip.start();
    }
    
    public void PausePlayback(){
        long s = this.clip.getMicrosecondPosition() / 100000;
        System.out.println("Playback Pausado. Tempo: "+s);
        this.clip.stop();
    }
    
    public void ResumePlayback(){
        long s = this.clip.getMicrosecondPosition() / 100000;
        System.out.println("Playback Resumido. Tempo: "+s);
        this.clip.start();
        
    }
    
    public void StopPlayback(){
        System.out.println("Playback Parado. Música fora da lista de reprodução.");
        this.filepath = "";
        this.clip.stop();
        this.clip.close();
        
    }
    
    public void JumpToTime(long timeMiliSeconds){
        
    }
    
    public void Choice(int i) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        switch(i){
            case 1:
                StartPlayback();
                return;
            case 2:
                PausePlayback();
                return;
            case 3:
                ResumePlayback();
                return;
            case 4:
                StopPlayback();
                return;
            case 5:
                System.out.println("Coloque o endereço da música. (arquivo .wav)");
                Scanner input = new Scanner(System.in);
                String aux = input.nextLine();
                StopPlayback();
                ChangeSong(aux);
                return;
            case 6:
                System.out.println("Aqui vai a parte de configurações.");
                return;
           
        }
    }
    
    
    
}

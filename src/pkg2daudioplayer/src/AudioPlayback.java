/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.File;
import java.io.IOException;
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
    
    public AudioPlayback() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        this.audInput = AudioSystem.getAudioInputStream(new File(this.filepath).getAbsoluteFile());
        this.clip = AudioSystem.getClip();
        this.clip.open(audInput);
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
        
    }
    
    public void ChangeSong(String filepath){
        
    }
    
    public void StartPlayback(){
        System.out.println("Tocando agora: "+new File(filepath).getName());
        this.clip.start();
    }
    
    public void PausePlayback(){
        
    }
    
    public void ResumePlayback(){
        
    }
    
    public void StopPlayback(){
        
    }
    
    public void JumpToTime(){
        
    }
    
    
    
}

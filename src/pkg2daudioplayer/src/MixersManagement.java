/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

/**
 *
 * @author davip
 */
public class MixersManagement {
    public MixersManagement(){
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        for(Mixer.Info info : mixerInfos){
            Mixer m = AudioSystem.getMixer(info);
            System.out.println(m.getMixerInfo().getName() + "   " + m.getMixerInfo().getDescription());
        }
        
    }
    
}

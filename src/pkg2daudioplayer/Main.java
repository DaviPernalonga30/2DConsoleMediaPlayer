/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2daudioplayer;

import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import pkg2daudioplayer.src.AudioPlayback;
import pkg2daudioplayer.src.MixersManagement;

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
        AudioPlayback aud = new AudioPlayback();
        MixersManagement mixMan = new MixersManagement();
        //aud.ChangeSong(filepath);
        int i;
        
        /*
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("============================================");
            System.out.println("1. Iniciar Playback");
            System.out.println("2. Pausar Playback");
            System.out.println("3. Resumir Playback");
            System.out.println("4. Parar Playback");
            System.out.println("5. Pular Para");
            System.out.println("6. Mudar Musica");
            System.out.println("7. Carregar Playlist");
            System.out.println("8. Carregar Diretório");
            System.out.println("9. Mais Opcões");
            System.out.println("0. Sair");
            System.out.println("============================================");
            i = input.nextInt();
            if(i == 0){
                aud.StopPlayback();
                break;
            }
            aud.Choice(i);
         
            
            
            
        }
          */
        // TODO code application logic here
    }
    
}

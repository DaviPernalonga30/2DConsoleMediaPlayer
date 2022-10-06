/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author davip
 */
public class AudioPlayback {
    private String filepath;
    private AudioInputStream audInput;
    private Clip clip;
    private Line line;
    private Mixer mixer;
    private SourceDataLine sourcedateline;
    private ArrayList queueList;
    private ArrayList playList;
    private ArquivesManagement arqMan = new ArquivesManagement();
        
    public void ChangeSong(String filepath) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        this.filepath = filepath;
        StartPlayback();
        //Fazer Try e Catch aqui para o programa nao travar.
        
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
        long s = this.clip.getMicrosecondPosition() / 1000000;
        int min = 00;
        int hr = 00;
        if(s>60){
            min = (int) (s/60);
            s = s - min * 60;
        }
        if(min > 60){
            hr = (int) (min/60);
            min = min - hr * 60;
        }
        System.out.println("Playback Pausado. Tempo: "+hr+":"+min+":"+s);
        this.clip.stop();
    }
    
    public void ResumePlayback(){
        long s = this.clip.getMicrosecondPosition() / 1000000;
        int min = 0;
        int hr = 0;
        if(s>60){
            min = (int) (s/60);
            s = s - min * 60;
        }
        if(min > 60){
            hr = (int) (min/60);
            min = min - hr * 60;
        }
        System.out.println("Playback Resumido. Tempo: "+hr+":"+min+":"+s);
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
    
    
    private void PlaylistManagement() {
        Scanner inputPath = new Scanner(System.in);
        String musicPath;
        int i = 1;
        while(i!=0){
            System.out.println("============================================");
            System.out.println("1. Criar playlist do zero");
            System.out.println("2. Editar playlist existente");
            System.out.println("3. Deletar playlist existente");
            System.out.println("============================================");
            i = inputPath.nextInt();
            switch(i){
                case 1:
                    System.out.println("Coloque o nome da playlist.");
                    String name = inputPath.nextLine();
                    System.out.println("Coloque a primeira musica da playlist.");
                    musicPath = inputPath.nextLine();
                    CreatePlaylist(name, musicPath);
                case 2:
                    
                    EditPlayList();
                case 3:
                    
                    DeletePlaylist();
            }
           
            
        //Mudar o nome da função e fazer as devidas alterações.
        }
        
        
       
    }
    
     private void CreatePlaylist(String name, String path) {
         PlayListClass playlist = new PlayListClass();
         playlist.setPl_creationDate();
         playlist.setPl_name(name);
         playlist.setPl_mscAdress(path);
         arqMan.SavePlayList(playlist);
       
    }

    private void EditPlayList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void DeletePlaylist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    private void AddMusicDirectory() {
        String directoryPath;
        System.out.println("Coloque aqui o endereço da musica.");
        Scanner inputPath = new Scanner(System.in);
        MusicDirectoryClass msdir = new MusicDirectoryClass();
        directoryPath = inputPath.nextLine();
        arqMan.SaveMusicDirectory(msdir);
        
    }

    private void RemoveMusicDirectory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void AddMusicToQueue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void RemoveMusicFromQueue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Configs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void Choice(int i) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        Scanner input;
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
                input = new Scanner(System.in);
                long s = input.nextInt();
                JumpToTime(s);
                return;
            case 6:
                System.out.println("Coloque o endereço da música. (arquivo .wav)");
                input = new Scanner(System.in);
                String aux = input.nextLine();
                StopPlayback();
                ChangeSong(aux);
                return;
            case 7:
                //Load Playlist
                
                return;
            case 8:
                //Load music Directory
            
                return;
            case 9:
                //Aqui temos um menu extra, devido o fato de colocarmos um valor < 10 para entrada
                //E necessitamos de configurações adicionais, tipo o management de playlist, filas
                //e configurações como volume.
                System.out.println("============================================");
                System.out.println("1. Criar Playlist");
                System.out.println("2. Adicionar Diretório de Música");
                System.out.println("3. Remover Diretório de Música");
                System.out.println("4. Adicionar música na fila");
                System.out.println("5. Remover música da fila");
                System.out.println("6. Configurações");
                System.out.println("0. Voltar");
                System.out.println("============================================");
                input = new Scanner(System.in);
                int auxint = input.nextInt();
                if(auxint!=0){
                    MoreChoices(auxint);
                
                }
        }
    }
    
    public void MoreChoices(int i){
        switch(i){
            case 1:
                PlaylistManagement();
                return;
            case 2:
                AddMusicDirectory();
                return;
            case 3:
                RemoveMusicDirectory();
                return;
            case 4:
                AddMusicToQueue();
                return;
            case 5:
                RemoveMusicFromQueue();
                return;
            case 6:
            
                
                Configs();
                return;
                
        }
        
    }

   
    
    
}

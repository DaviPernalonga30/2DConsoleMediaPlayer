/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davip
 */
public class ArquivesManagement {
    public void SaveMusicDirectory(MusicDirectoryClass msdir){
        try{
            FileOutputStream fileout = new FileOutputStream("msdir/"+msdir.getDir_name()+".ms2d");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(msdir);
            out.close();
            System.out.println("Diretório de música salvo");
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivesManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivesManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //Refazer essa classe depois.
    //Preciso de uma lista completa dos diretórios.
    public MusicDirectoryClass LoadMusicDirectory(String path){
        MusicDirectoryClass msdir = null;
        try{
            FileInputStream filein = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(filein);
            msdir = (MusicDirectoryClass) in.readObject();
            in.close();
            filein.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivesManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivesManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ArquivesManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return msdir;
    }

    
        
    public void SavePlayList(PlayListClass playlist){
        
        
        
    }
    
   
    
    
    
}

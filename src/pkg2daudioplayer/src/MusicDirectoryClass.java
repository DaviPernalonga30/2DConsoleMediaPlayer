/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author davip
 */
public class MusicDirectoryClass implements Serializable{
    
    private String dir_name;
    private String dir_dirAdress;
    private String dir_creationDate;
    private PlayListClass pl;
    
    public void setDir_name(String aux){
        this.dir_name = aux;
    }
    
    public void setDir_dirAdress(String path){
        this.dir_dirAdress = path;
        this.setPl();
    }
    
    public void setDir_creationDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String aux = formatter.format(Calendar.getInstance().getTime());
        this.dir_creationDate = aux;
    }
    
    public void setPl(){
        this.pl = new PlayListClass();
        File file = new File(this.dir_dirAdress);
        FilenameFilter filter = new FilenameFilter(){
            @Override
            public boolean accept(File file, String string) {
                String ends = string;
                if(ends.endsWith(".wav")){
                    return true;
                }
                else{
                return false;
                }
            }
           
        };
        
        
        File filesList[] = file.listFiles(filter);
        for(File aux : filesList){
            this.pl.setPl_mscAdress(aux.getAbsolutePath());
        }
        this.pl.setPl_name(this.dir_name);
        this.pl.setPl_creationDate();
        //fazer um for que consiga pegar o caminho de todos 
        //os arquivos dentro de um diretório e adicionar eles
        //na playlist associada ao diretório para assim
        //puder ser tocada.
        
    }
    
    public String getDir_name(){
        return this.dir_name;
    }
    
    public String getDir_dirAdress(){
        return this.dir_dirAdress;
    }
    
    public String getDir_creationDate(){
        return this.dir_creationDate;
    }
    
    public PlayListClass getPl(){
        return this.pl;
    }
    
}

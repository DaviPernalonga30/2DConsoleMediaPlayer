/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2daudioplayer.src;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author davip
 */
public class PlayListClass implements Serializable{
    private String pl_name;
    private ArrayList pl_mscAdress;
    private String pl_creationDate;
    
    public void setPl_name(String name){
        this.pl_name = name;
    }
    
    public void setPl_mscAdress(String path){
        this.pl_mscAdress.add(path);
    }
    
    public void setPl_creationDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String aux = formatter.format(Calendar.getInstance());
        this.pl_creationDate = aux;
    }
    
    public String getPl_name(){
        return this.pl_name;
    }
    
    public String getPl_creationDate(){
        return this.pl_creationDate;
    }
    
    public ArrayList getPl_mscAdress(){
        return this.pl_mscAdress;
    }
    
    
    
    
    
}

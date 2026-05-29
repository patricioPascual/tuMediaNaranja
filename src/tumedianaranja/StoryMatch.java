/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tumedianaranja;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class StoryMatch {
    
    private Usuario usuario1;
    private Usuario usuario2;
    private LocalDate fechaInicio;
    private LocalDate fechafin;
    private int puntos;
    private ArrayList<Meeting> story;
    
    
    
    
    public void listarMeetings(){
        for(Meeting aux: story){
            System.out.println(aux.toString());
        }
    }
}

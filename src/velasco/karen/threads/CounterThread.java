/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author karen
 */
public class CounterThread extends Thread{
    int i=0;
    Integer descanso;
    Integer posicion;
    JProgressBar progressBar;
    Semaphore semaphore; 
    
    public CounterThread(Semaphore semaphore, JProgressBar progressBar, Integer posicion, Integer descanso){
        System.out.println("----->  Constructor del hilo "+posicion);
        
        int i=0;
        this.progressBar = progressBar;
        this.descanso = descanso;
        this.posicion = posicion;
        this.semaphore = semaphore;
    }
   
    public void run(){
        System.out.println("\n\n\t\t FUNCION RUN DEL HILO "+this.posicion+" \n\n");
        Integer i=0;
        
        while(i<=100){    
            
            if(this.semaphore.permisoAvanzar(posicion, i)==true){
                
                i+=1;//velocidad;
                
                System.out.println("* * * * *   * * * * * HILO "+posicion+" -----> puntos acumulados"+i);
                
                progressBar.setValue(i);    
            
                progressBar.revalidate();
                progressBar.repaint();
                    
                
                try {

                    System.out.println("Sleeping...");
                    Thread.sleep(descanso*1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(CounterThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }else{
                System.out.println("------ ----- ESPERAR ----- ----- Hilo = "+this.posicion+"Suma acumulada = "+i);
                Thread.yield();
            }
            
        }
        
    }
}

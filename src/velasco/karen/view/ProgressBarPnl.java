/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import velasco.karen.threads.CounterThread;
import velasco.karen.threads.Semaphore;

/**
 *
 * @author karen
 */
public class ProgressBarPnl extends JPanel{
    private JProgressBar progressBar;
    private CounterThread contador;
    private Semaphore oSemaphore;
    private Integer velocidad;
    private Integer posicion;
    private int i=0,num=0;     
    
    public ProgressBarPnl(Semaphore semaphore, Integer totalHilos, Integer posicion, Integer descanso){ 
        //el progressBar requiere un valor minimo y uno maximo 
        super.setLayout(new FlowLayout());
        this.posicion = posicion;
        Font fuente = new Font("Dialog", Font.BOLD, 15);
        
        oSemaphore = semaphore;
        
        progressBar = new JProgressBar(0,100);    
        progressBar.setPreferredSize(new Dimension(600,40));
//        progressBar.setBounds(40,40,500,40);         
        progressBar.setValue(0);    
        progressBar.setStringPainted(true);    
        

        //crear el contador
        String contenido = String.valueOf(descanso);
        contenido = contenido.concat(" s");
        JLabel lblVelocidad = new JLabel(contenido);
        lblVelocidad.setFont(fuente);
        
        super.add(progressBar);
        super.add(lblVelocidad);
        
        contador = new CounterThread(semaphore, progressBar, posicion, descanso);
        contador.start();
    
    }    
    
    public void reset(){
        try {
            this.contador.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import velasco.karen.threads.Semaphore;

/**
 *
 * @author karen
 */
public class MainFrame extends JFrame{
    InstruccionesPnl pnlInstrucciones;
    ProgressBarPnl[] pnlProgressBar;
    Semaphore semaphore;
    
    public MainFrame(){
        super.setSize(new Dimension(850,800));
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        int n = 4;

        //Instrucciones
        pnlInstrucciones = new InstruccionesPnl();
        
        
        super.add(pnlInstrucciones);
        //Controlador 
        semaphore = new Semaphore(n);
        
        pnlProgressBar = new ProgressBarPnl[n];//de cuando en cuanto
        
        for(int i=0; i<n;i++){
            pnlProgressBar[i] = new ProgressBarPnl(semaphore, n, i, (i+1)); //del 1 al 4
            System.out.println("Tiempo de espera del hilo "+(i)+" = "+((i+1)*1000));
            super.add(pnlProgressBar[i]);
        }
        
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainFrame();
    }
}

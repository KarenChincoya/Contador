/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import velasco.karen.threads.Semaphore;
import velasco.karen.view.listeners.ListenerInstruccionesPnl;

/**
 *
 * @author karen
 */
public class MainFrame extends JFrame{
    InstruccionesPnl pnlInstrucciones;
    ProgressBarPnl[] pnlProgressBar;
    Semaphore semaphore;
    Integer descanso;
    JButton btnReiniciar;
    
    public MainFrame(){
        super.setSize(new Dimension(850,800));
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Instrucciones
        pnlInstrucciones = new InstruccionesPnl();
        pnlInstrucciones.setListener(new ListenerInstruccionesPnl() {
            @Override
            public void onBtnClick() {
                try {
                    Integer n = Integer.valueOf(pnlInstrucciones.getTxtHilos().getText());
                    //Controlador 
                    semaphore = new Semaphore(n);
                    pnlProgressBar = new ProgressBarPnl[n];//de cuando en cuanto
                    
                    Integer lim = Integer.valueOf(pnlInstrucciones.getTxtLimSup().getText());
                    
                    Random random = new Random();
                            
                    for(int i=0; i<n;i++){
                        descanso = random.nextInt(lim)+1;
                        pnlProgressBar[i] = new ProgressBarPnl(semaphore, n, i, descanso); //del 1 al 4
                        System.out.println("Tiempo de espera del hilo "+(i)+" = "+descanso);
                        MainFrame.this.add(pnlProgressBar[i]);
                    }
                    
                    btnReiniciar = new JButton("Reset");
                    btnReiniciar.setPreferredSize(new Dimension(500,40));
                    btnReiniciar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            pnlInstrucciones.reset();
                            for(int i=0; i<n; i++){
                                pnlProgressBar[i].reset();
                                pnlProgressBar[i].setVisible(false);
                            }
                            btnReiniciar.setVisible(false);
                        }
                    });
                    
                    MainFrame.this.add(btnReiniciar);
                    MainFrame.this.setVisible(true);
                    
                    
                    
                } catch (Exception e) {
                }
            }
        });
        
        super.add(pnlInstrucciones);
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainFrame();
        
    }
}

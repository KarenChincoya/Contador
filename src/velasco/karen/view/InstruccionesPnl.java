/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import velasco.karen.view.listeners.ListenerInstruccionesPnl;

/**
 *
 * @author karen
 */
public class InstruccionesPnl extends JPanel{
    private JLabel instrucciones;
    private JLabel lblHilos;
    private JTextField txtHilos;
    private JButton btnEnviar;
    private ListenerInstruccionesPnl listener;
    private JLabel lblEspecificaciones;
    private JLabel lblLimInf;
    private JTextField txtLimInf;
    private JLabel lblLimSup;
    private JTextField txtLimSup;
    private JLabel lblFin;
    
    public InstruccionesPnl(){
        System.out.println("Instrucciones panl");
        this.setLayout(new BoxLayout(InstruccionesPnl.this, BoxLayout.Y_AXIS));
        Font fuente = new Font("Dialog", Font.BOLD, 20);
        
        instrucciones = new JLabel("Contador multihilos");
        instrucciones.setFont(fuente);
         
        JPanel pnlDatos = new JPanel();
        pnlDatos.setLayout(new FlowLayout());
        lblHilos = new JLabel("Ingrese la cantidad de hilos: ");
        txtHilos = new JTextField();
        txtHilos.setPreferredSize(new Dimension(50,30));
        
        
        JPanel pnlEspecificaciones = new JPanel();
        pnlEspecificaciones.setLayout(new FlowLayout());
        lblEspecificaciones = new JLabel("La velocidad de cada contador "
                + "es un valor aleatorio entre los segundos que indique: ");
        lblEspecificaciones.setPreferredSize(new Dimension(600,50));
        lblLimInf = new JLabel("De ");
        txtLimInf = new JTextField();
        txtLimInf.setPreferredSize(new Dimension(40,40));
        lblLimSup = new JLabel(" a ");
        txtLimSup = new JTextField();
        txtLimSup.setPreferredSize(new Dimension(40,40));
        lblFin = new JLabel(" segundos.");
        
        pnlEspecificaciones.add(lblEspecificaciones);
        pnlEspecificaciones.add(lblLimInf);
        pnlEspecificaciones.add(txtLimInf);
        pnlEspecificaciones.add(lblLimSup);
        pnlEspecificaciones.add(txtLimSup);
        pnlEspecificaciones.add(lblFin);
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.onBtnClick();
            }
        });
        
        pnlDatos.add(lblHilos);
        pnlDatos.add(txtHilos);
        
        super.add(instrucciones);
        super.add(pnlDatos);
        super.add(pnlEspecificaciones);
        super.add(btnEnviar);
    }
    
    public void setListener(ListenerInstruccionesPnl listener){
        this.listener = listener;
    }

    public JLabel getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(JLabel instrucciones) {
        this.instrucciones = instrucciones;
    }

    public JLabel getLblHilos() {
        return lblHilos;
    }

    public void setLblHilos(JLabel lblHilos) {
        this.lblHilos = lblHilos;
    }

    public JTextField getTxtHilos() {
        return txtHilos;
    }

    public void setTxtHilos(JTextField txtHilos) {
        this.txtHilos = txtHilos;
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public void setBtnEnviar(JButton btnEnviar) {
        this.btnEnviar = btnEnviar;
    }
    
    
}

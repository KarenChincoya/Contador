/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.threads;

/**
 *
 * @author karen
 */
public class Semaphore { // extends Thread
    
    Integer hilos;
    Integer[] puntosAcumulados;//
    Integer limInf;
    Integer limSup;
    
    public Semaphore(Integer hilos){
        System.out.println("Controlador");
        System.out.println("Se han creado "+hilos+" espacios");
        this.hilos = hilos;
        this.puntosAcumulados = new Integer[hilos];
        this.limInf = 0;
        this.limSup = 10;
        for(int i=0; i<hilos;i++){
            puntosAcumulados[i] = 0;
        }
    }
    
    public synchronized boolean permisoAvanzar(Integer i, Integer currentCount){
        System.out.println("Solicitud de permiso por parte del hilo: "+i);
        this.ajustarLimites();
        
        if((currentCount+1)<=this.limSup){
            this.puntosAcumulados[i] = currentCount+1;
            return true;
        }else{
            return false;
        }
        
    }
    
    public void ajustarLimites(){
        //todos son mayores o iguales a la referencia
        int cont = 0;
        
        for(int j=0; j<hilos; j++){
            if(puntosAcumulados[j] == this.limSup) cont++;
        }
        
        if(cont==hilos){
            this.limInf = this.limSup;
            this.limSup = this.limInf+10;
        }
    }
    
}


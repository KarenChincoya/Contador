/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.bolsas;

/**
 *
 * @author karen
 */
public class Principal {

    public static void main(String[] args) {

        Bolsa bolsa = new Bolsa();
        HiloEnvio hilo = new HiloEnvio(bolsa);
        hilo.start();

        for (int i = 0; i <= 10; i++) {

            Producto p = new Producto();
            try {

                synchronized (bolsa) {

                    Thread.sleep(1000);
                    if (bolsa.estaLlena()) {
                        bolsa.notify();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            bolsa.addProducto(p);
            System.out.println(bolsa.getSize());

        }

    }
}

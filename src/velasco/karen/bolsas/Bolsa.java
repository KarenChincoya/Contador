/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.bolsas;

import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class Bolsa {

    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public void addProducto(Producto producto) {

        if (!estaLlena()) {
            listaProductos.add(producto);
        }
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;

    }

    public int getSize() {
        return listaProductos.size();
    }

    public boolean estaLlena() {

        return listaProductos.size() >= 5;
    }
}

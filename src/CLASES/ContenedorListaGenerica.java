package CLASES;

import INTERFACES.IOperacionesBasicas;

import java.awt.*;
import java.util.ArrayList;

public class ContenedorListaGenerica <E> implements IOperacionesBasicas<E>{

    private ArrayList<E> lista;


    public ContenedorListaGenerica() {
        lista = new ArrayList<>();
    }


    @Override
    public void agregar(E elemento) {
        lista.add(elemento);
    }

    @Override
    public void eliminar(E elemento) {
        lista.remove(elemento);
    }

    @Override
    public void mostrar(E elemento) {

    }

    @Override
    public int size() {
        return lista.size();
    }
}

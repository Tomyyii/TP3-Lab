package CLASES;

import INTERFACES.IOperacionesBasicas;

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
    public void elimiar(E elemento) {
        lista.remove(elemento);
    }

    @Override
    public StringBuilder mostrar() {

        return null;
    }

    @Override
    public int size() {
        return lista.size();
    }
}

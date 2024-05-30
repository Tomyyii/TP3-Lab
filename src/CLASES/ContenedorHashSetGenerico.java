package CLASES;

import INTERFACES.IOperacionesBasicas;

import java.util.HashSet;

public class ContenedorHashSetGenerico <E> implements IOperacionesBasicas <E>{
    private HashSet<E> set;

    public ContenedorHashSetGenerico() {
        this.set = new HashSet<>();
    }

    public HashSet<E> getSet() {
        return set;
    }

    @Override
    public void agregar(E elemento) {
        set.add(elemento);
    }

    @Override
    public void elimiar(E elemento) {
        set.remove(elemento);
    }

    @Override
    public void mostrar(E elemento) {
        
    }

    @Override
    public int size() {
        return set.size();
    }

}

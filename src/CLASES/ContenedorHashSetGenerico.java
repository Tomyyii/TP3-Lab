package CLASES;

import INTERFACES.IOperacionesBasicas;

import java.util.HashSet;
import java.util.Iterator;

public class ContenedorHashSetGenerico <E> implements IOperacionesBasicas <E>{
    private HashSet<E> set;

    public ContenedorHashSetGenerico() {
        this.set = new HashSet<>();
    }

    public HashSet<E> getSet() {
        return set;
    }

    public Iterator<E> getIterator()
    {
        return set.iterator();
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
    public StringBuilder mostrar() {
        StringBuilder sb=new StringBuilder();
        Iterator iterator=set.iterator();
        int i=0;
        while (iterator.hasNext())
        {
            E aux= (E) iterator.next();
            sb.append("PRODUCTO\n").append(i).append("\n").append(aux.toString());
        }
        return sb;
    }

    @Override
    public int size() {
        return set.size();
    }

}

package CLASES;

import INTERFACES.IOperacionesBasicas;

import java.util.HashSet;
import java.util.Iterator;

public class ContenedorHashSetGenerico <E> implements IOperacionesBasicas<E> {
    private HashSet<E> set;

    public ContenedorHashSetGenerico() {
        this.set = new HashSet<>();
    }//constructor

    public HashSet<E> getSet() {
        return set;
    }//getter del set

    public Iterator<E> getIterator()
    {
        return set.iterator();
    }//retorna un iterador del set

    @Override
    public void agregar(E elemento) {
        set.add(elemento);
    }//metodo de agregado al set

    @Override
    public void eliminar(E elemento) {
        set.remove(elemento);
    }//metodo de eliminado del set

    @Override
    public StringBuilder mostrar() {//metodo para mostrar el set completo
        StringBuilder sb=new StringBuilder();
        Iterator iterator=set.iterator();
        int i=0;
        while (iterator.hasNext())
        {
            E aux= (E) iterator.next();
            sb.append("\nPRODUCTO\n").append(i).append("\n").append(aux);
            i++;
        }
        return sb;
    }

    @Override
    public int size() {
        return set.size();
    }//metodo que retorna el tamanio del set



}

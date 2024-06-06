package CLASES;

import INTERFACES.IOperacionesBasicasHashset;

import java.util.ArrayList;

public class ContenedorListaGenerica <E> implements IOperacionesBasicasHashset<E> {
    private ArrayList<E> lista;
    public ContenedorListaGenerica() {
        lista = new ArrayList<>();
    }//constructor
    public ArrayList<E> getLista() {//getter de la lista
        return lista;
    }
    @Override
    public void agregar(E elemento) {
        lista.add(elemento);
    }//metodo de agregado a la lista generica
    @Override
    public void eliminar(E elemento) {
        lista.remove(elemento);
    }//metodo de eliminado a la lista generica
    public E get(int i){
        return lista.get(i);
    }
    @Override
    public StringBuilder mostrar() {//muestra de la lista generica
        StringBuilder sb=new StringBuilder();
        for(E elemento: lista)
        {
            sb.append(elemento);
        }
        return sb;
    }
    @Override
    public int size() {
        return lista.size();
    }//retorna el tamanio de la lista generica
}

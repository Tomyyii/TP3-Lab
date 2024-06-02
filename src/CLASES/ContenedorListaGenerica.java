package CLASES;

import INTERFACES.IOperacionesBasicasHashset;

import java.util.ArrayList;

public class ContenedorListaGenerica <E> implements IOperacionesBasicasHashset<E> {

    private ArrayList<E> lista;




    public ContenedorListaGenerica() {
        lista = new ArrayList<>();
    }

    public ArrayList<E> getLista() {
        return lista;
    }

    @Override
    public void agregar(E elemento) {
        lista.add(elemento);
    }

    @Override
    public void eliminar(E elemento) {
        lista.remove(elemento);
    }

    public E get(int i){
        return lista.get(i);
    }

    @Override
    public StringBuilder mostrar() {
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
    }
}

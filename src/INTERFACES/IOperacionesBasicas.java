package INTERFACES;

import java.util.HashSet;

public interface IOperacionesBasicas <E>{
    void agregar(E elemento);
    void eliminar(E elemento);
    void mostrar(E elemento);
    int size();


}

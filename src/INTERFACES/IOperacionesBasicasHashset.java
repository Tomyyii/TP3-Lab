package INTERFACES;

import java.util.HashSet;

public interface IOperacionesBasicasHashset <E>{
    void agregar(E elemento);
    void eliminar(E elemento);
    StringBuilder mostrar();
    int size();


}

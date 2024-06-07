package INTERFACES;

public interface IOperacionesBasicas<E>{
    void agregar(E elemento);
    void eliminar(E elemento);
    StringBuilder mostrar();
    int size();


}

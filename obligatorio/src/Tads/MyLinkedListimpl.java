package Tads;

public class MyLinkedListimpl<T> implements MyList<T>{

    private Nodo<T> primero;

    private Nodo<T> ultimo;

    private int size;

    public MyLinkedListimpl() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }


    public void add(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (primero == null) {
            primero = nuevoNodo;
            ultimo=primero;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo=nuevoNodo;

        }
        size++;
    }

    private void addToBeginning(T value) {
        Nodo<T> nuevoPrimerNodo = new Nodo<>(value);
        nuevoPrimerNodo.setSiguiente(primero);
        primero = nuevoPrimerNodo;
        size++;
    }


    public T get(int position) {
        Nodo<T> nodoActual = primero;

        for (int i = 0; i < position; i++) {
            nodoActual= nodoActual.getSiguiente();
        }
        return nodoActual.getValue();
    }

    public boolean contains(T value) {
        boolean existencia = true;
        Nodo nodoActual = primero;
        while (!value.equals(nodoActual.getValue()) && nodoActual.getSiguiente() != null) {
            nodoActual = nodoActual.getSiguiente();
        }
        if (!value.equals(nodoActual.getValue())) {
            existencia = false;
        }
        return existencia;
    }

    public void remove(T value) {
        if (this.primero.getValue().equals(value)){
            if(this.ultimo==this.primero){this.ultimo=null;}
            this.primero = this.primero.getSiguiente();
            size--;
        }

        Nodo<T> searchValue = this.primero;

        while (searchValue != null && !searchValue.getSiguiente().getValue().equals(value)) {
             searchValue = searchValue.getSiguiente();

        }

        if (searchValue != null) {
            searchValue.setSiguiente(null);
            if (searchValue == this.ultimo) {this.ultimo = searchValue;}
            size--;

        }

    }



    public int size() {
        return size;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }
}

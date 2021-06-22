package Tads;

import java.util.Iterator;

public class MyLinkedListimpl<T> implements MyList<T>{

    private Nodo<T> primero;

    private Nodo<T> ultimo;

    private int size;

    public MyLinkedListimpl() {
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public MyLinkedListimpl(T value) {
        this.primero = new Nodo<>(value);
        this.ultimo = this.primero;
        this.size = 1;
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

        if (searchValue.getSiguiente() != null) {
            searchValue.setSiguiente(null);
            if (searchValue.getSiguiente() == this.ultimo) {this.ultimo = searchValue;}
            size--;

        }

    }



    public int size() {
        return size;
    }

    private class IteradorLL implements Iterator<T> {

        private Nodo<T> nodoSiguiente = primero;

        @Override
        public boolean hasNext() {
            return nodoSiguiente != null;
        }

        @Override
        public T next() {
            T ret = nodoSiguiente.getValue();
            nodoSiguiente = nodoSiguiente.getSiguiente();
            return ret;
        }

    }
    @Override
    public Iterator<T> iterator() {
        return new IteradorLL();
    }

}

package Tads;

public class MyLinkedListimpl<T> implements MyList<T>{

    private Nodo<T> primero;

    private Nodo<T> ultimo;

    public MyLinkedListimpl() {
        this.primero = null;
        this.ultimo = null;
    }


    public void add(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
    }

    private void addToBeginning(T value) {
        Nodo<T> nuevoPrimerNodo = new Nodo<>(value);
        nuevoPrimerNodo.setSiguiente(primero);
        primero = nuevoPrimerNodo;
    }


    public T get(int position) {
        Nodo<T> nodoActual = primero;
        T value = null;
        int contador = 0;

        while (contador < position) {
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        if (contador == position) {
            value = nodoActual.getValue();
        }
        return value;
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
        Nodo<T> beforeSearchValue = null;
        Nodo<T> searchValue = this.primero;

        while (searchValue != null && !searchValue.getValue().equals(value)) {

            beforeSearchValue = searchValue;
            searchValue = searchValue.getSiguiente();

        }

        if (searchValue != null) {

            if (searchValue == this.primero && searchValue != this.ultimo) {

                Nodo<T> temp = this.primero;
                this.primero = this.primero.getSiguiente();

                temp.setSiguiente(null);

            } else if (searchValue == this.ultimo && searchValue != this.primero) {

                beforeSearchValue.setSiguiente(null);
                this.ultimo = beforeSearchValue;

            } else if (searchValue == this.ultimo && searchValue == this.primero) {

                this.primero = null;
                this.ultimo = null;

            } else {

                beforeSearchValue.setSiguiente(searchValue.getSiguiente());
                searchValue.setSiguiente(null);

            }

        }

    }



    public int size() {
        int size = 0;

        Nodo<T> temp = this.primero;

        while (temp != null) {

            temp = temp.getSiguiente();
            size++;

        }

        return size;
    }

}

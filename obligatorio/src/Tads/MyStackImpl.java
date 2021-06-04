package Tads;

public class MyStackImpl<T> implements MyStack<T> {

    private Nodo<T> top;
    private int size = 0;

    @Override
    public Nodo pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            Nodo nodoActual = top.getPrevio();
            top = nodoActual;
            size--;
            return nodoActual;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public T top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    @Override
    public void push(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (isEmpty()) {
            top = nuevoNodo;
            top.setSiguiente(top);
            top.setPrevio(null);
            size++;
        } else {
            top.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(top);
            top = nuevoNodo;
            size++;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }



}

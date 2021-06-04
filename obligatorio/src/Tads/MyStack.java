package Tads;


public interface MyStack<T> {

    void push(T value);

    Nodo pop() throws EmptyStackException;

    int size();
}

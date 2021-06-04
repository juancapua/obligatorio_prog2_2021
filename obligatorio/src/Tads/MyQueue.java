package Tads;

public interface MyQueue<T> {

    void enqueue(T value);

    T dequeue() throws EmptyQueueException;

    int size();
}

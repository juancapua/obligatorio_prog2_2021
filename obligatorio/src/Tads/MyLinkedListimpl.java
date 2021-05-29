package Tads;

public class MyLinkedListimpl<T> implements MyList<T>, MyStack<T>{

    private Nodo<T> first;

    private Nodo<T> last;

    public MyLinkedListimpl() {
        this.first = null;
        this.last = null;
    }

    // pusimos las implementaciones de stack, queue y linked list en la misma clase ya que enj la queue y stack usamos funciones que estan ya en liked list

    public void add(T value) {
        addToTheEnd(value);
    }

    private void addToBeginning(T value) {
        if (value != null) {

            Nodo<T> elementToAdd = new Nodo<>(value);

            if (this.first == null) {

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else {

                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }

        }
    }

    private void addToTheEnd(T value) {
        if (value != null) {

            Nodo<T> elementToAdd = new Nodo<>(value);

            if (this.first == null) {

                this.first = elementToAdd;
                this.last = elementToAdd;

            } else {

                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }

        }
    }

    public T get(int position) {
        T valueToReturn = null;
        int tempPosition = 0;
        Nodo<T> temp = this.first;

        while (temp != null && tempPosition != position) {

            temp = temp.getNext();
            tempPosition++;

        }

        if (tempPosition == position) {


            valueToReturn = temp.getValue();

        }

        return valueToReturn;
    }

    public boolean contains(T value) {
        boolean contains = false;
        Nodo<T> temp = this.first;

        while (temp != null && !temp.getValue().equals(value)) {

            temp = temp.getNext();

        }

        if (temp != null) {

            contains = true;

        }

        return contains;
    }

    public void remove(T value) {
        Nodo<T> beforeSearchValue = null;
        Nodo<T> searchValue = this.first;

        while (searchValue != null && !searchValue.getValue().equals(value)) {

            beforeSearchValue = searchValue;
            searchValue = searchValue.getNext();

        }

        if (searchValue != null) {

            if (searchValue == this.first && searchValue != this.last) {

                Nodo<T> temp = this.first;
                this.first = this.first.getNext();

                temp.setNext(null);

            } else if (searchValue == this.last && searchValue != this.first) {

                beforeSearchValue.setNext(null);
                this.last = beforeSearchValue;

            } else if (searchValue == this.last && searchValue == this.first) {

                this.first = null;
                this.last = null;

            } else {

                beforeSearchValue.setNext(searchValue.getNext());
                searchValue.setNext(null);

            }

        }

    }

    private T eliminarUltimo() {
        T valueToRemove = null;

        if (this.last != null) {
            valueToRemove = this.last.getValue();

            remove(valueToRemove);
        }

        return valueToRemove;
    }

    public int size() {
        int size = 0;

        Nodo<T> temp = this.first;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }

    public void push(T value) {
        addToTheEnd(value);
    }

    public T pop() throws EmptyStackException {
        if (this.last == null) {

            throw new EmptyStackException();
        }

        return eliminarUltimo();
    }

    public T peek() {
        T valueToReturn = null;

        if (this.last != null) {
            valueToReturn = this.last.getValue();
        }

        return valueToReturn;
    }

    public void enqueue(T value) {
        addToBeginning(value);
    }

    public T dequeue() throws EmptyQueueException {
        if (this.last == null) { // si la queue esta vacia

            throw new EmptyQueueException();
        }

        return eliminarUltimo();
    }

}

package Tads;

public class MyQueueImpl<T> implements MyQueue<T> {

    private Nodo<T> first;

    private Nodo<T> last;

    public MyQueueImpl() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(T value) {
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

    public T dequeue() throws EmptyQueueException {
        if (this.last == null) {

            throw new EmptyQueueException();
        }

        return eliminarUltimo();
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

    public int size() {
        int size = 0;

        Nodo<T> temp = this.first;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }


}

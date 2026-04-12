package Module_4;

import java.util.LinkedList;

/*
Generic queue named GenericQueue.
 */
public class GenericQueue<E> {
    private LinkedList<E> list;

    public GenericQueue() {
        this.list = new LinkedList<E>();
    }

    public void enqueue(E item) {
        list.addFirst(item);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

}

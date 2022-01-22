package datastructures.sequential;

/**
 * The class representing nodes with a single link to another node of the same type. Typically to
 * be used in classes implementing the singly linked list data type or any class extending it, such
 * as stacks, queues or deques.
 *
 * @author Ritwik Banerjee
 */
public class SNode<T> {

    private T data;
    private SNode<T> next;

    /**
     * A constructor that creates a stand-alone node with the given data, and no other node to point to.
     *
     * @param data the given data
     */
    public SNode(T data) {
        this(data, null);
    }

    /**
     * A constructor to create a node with the given data, and a given next node to point to.
     *
     * @param data the given data
     * @param next the node to point to
     */
    public SNode(T data, SNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T t) { data = t; }

    public void setNext(SNode<T> next) { this.next = next; }

    public void setNext(T t) { setNext(new SNode<>(t)); }

    public T getData() { return data; }

    public SNode<T> getNext() { return next; }

}

package datastructures.sequential;

/**
 *The stack class is implementing the LIFOQueue interface
 * The implementation uses a singly linked list based on the SNode class
 *
 * @author Nikhil Meruva
 */

public class Stack<E> implements LIFOQueue<E> {
    private SNode<E> top;
    private int size;

    /**
     * This constructor creates an empty stack with size 0 and top node set to null
     */
    public Stack(){
        E top = null;
        size = 0;
    }

    /**
     * This method checks whether the stack is empty
     *
     * @return true or false value(boolean)
     */
    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method returns the number of items of tye E in the stack
     *
     * @return int(size)
     */
    public int size(){
        if(size == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return size;
    }

    /**
     * This method removes and returns the most recent item to the stack
     *
     * @return element of type E that was popped
     */
    public E pop() {
        E data = null;
        if (isEmpty()){
            throw new NullPointerException("Stack Empty!");
        }
        else{
            data = top.getData();
            SNode temp = top;
            top = top.getNext();
            temp.setNext(null);
            size--;
        }
        return data;
    }

    /**
     * THis method adds item to the stack
     *
     * @param element the element to be pushed onto the top of this stack.
     */
    public void push(E element){
        SNode newNode = new SNode(element, top);
        top = newNode;
        size++;
    }

    /**
     * This method return the most recent item added to the stack
     *
     * @return element of type E
     */
    public E peek(){
        E data = null;
        if (isEmpty()){
            throw new NullPointerException("Stack Empty!");
        }
        else{
            data = top.getData();
        }
        return data;
    }
}

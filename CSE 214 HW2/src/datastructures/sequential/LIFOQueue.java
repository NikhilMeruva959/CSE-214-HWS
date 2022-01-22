package datastructures.sequential;

import java.util.EmptyStackException;

/**
 * @author Ritwik Banerjee
 */
public interface LIFOQueue<E> {

    /**
     * Retrieves and removes the element at the top of this stack.
     *
     * @return the element at the top of this stack.
     * @throws EmptyStackException if the stack is empty.
     */
    E pop();

    /**
     * Pushes the specified element onto the top of this stack.
     *
     * @param element the element to be pushed onto the top of this stack.
     */
    void push(E element);

    /**
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * @return the element at the top of this stack.
     * @throws EmptyStackException if the stack is empty.
     */
    E peek();

    /**
     * Returns the number of elements in this sequence. If this sequence has more than <code>Integer.MAX_VALUE</code>
     * elements, returns <code>Integer.MAX_VALUE</code>.
     *
     * @return the number of elements in this sequence
     */
    int size();

    /**
     * @return <code>true</code> if and only if the sequence contains no elements, <code>false</code> otherwise.
     */
    boolean isEmpty();
}
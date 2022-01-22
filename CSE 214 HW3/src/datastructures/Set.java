package datastructures;
import java.util.Iterator;

/**
 * !!DO NOT MODIFY THIS CODE!!
 *
 * @author Ritwik Banerjee
 */
public interface Set<E> {

    /**
     * @return the number of elements in this set (its cardinality)
     */
    int size();

    /**
     * @return <code>true</code> if this set contains no elements, and <code>false</code> otherwise.
     */
    boolean isEmpty();

    /**
     * Returns <code>true</code> if this set contains the specified element, and <code>false</code> otherwise.
     *
     * @param element the element whose presence in this set is to be tested
     * @return <code>true</code> if this set contains the specified element
     * @throws NullPointerException if the specified element is null
     */
    boolean contains(E element);

    /**
     * Adds the specified element to this set if it is not already present. If this set already contains the element,
     * the call leaves the set unchanged and returns <code>false</code>. This ensures that a set never contains
     * duplicate elements.
     *
     * @param e the element to be added to this set
     * @return <code>true</code> if this set did not already contain {@literal e}, and <code>false</code>
     * otherwise
     * @throws NullPointerException if {@literal e} is null
     */
    boolean add(E e);

    /**
     * Removes the specified element from this set if it is present, and returns {@code true} if this set contained the
     * element (or equivalently, if this set changed as a result of the call).
     *
     * @param e the element to be removed from this set, if present
     * @return <code>true</code> if this set contained the specified element, and <code>false</code> otherwise
     * @throws NullPointerException if the specified element is null
     */
    boolean remove(E e);
}

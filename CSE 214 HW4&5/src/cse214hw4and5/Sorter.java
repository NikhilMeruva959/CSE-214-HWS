package cse214hw4and5;

import java.util.List;

public interface Sorter<E extends Comparable<E>> {

    /**
     * The enumerable type specifying whether the sorting must be in increasing or decreasing order.
     */
    enum Order {INCREASING, DECREASING}

    /**
     * Any implementation of the sorter interface must be backed by a list data type, which holds the elements to be
     * sorted. This method simply returns the backing list.
     *
     * @return the backing list of elements
     */
    List<E> getList();

    /**
     * Sorts the backing list of elements. The exact algorithm to be used to sorting depends on the implementation of
     * this interface. For in-place sorting, the backing list is expected to be changed in-place. For an implementation
     * that does not use an in-place sorting algorithm, the backing list must be replaced with its sorted version.
     */
    void sort();

    /**
     * Displays the steps of the sorting, and returns the entire display as a single string. This is not a good approach
     * for showing the steps when a very long list is sorted, but for short (say, around 20 elements or less), this
     * method provides a way to demonstrate the internal workings of the algorithm.
     *
     * @return a string representing the steps of the algorithm used to sort the backing list of elements
     */
    String show();
}
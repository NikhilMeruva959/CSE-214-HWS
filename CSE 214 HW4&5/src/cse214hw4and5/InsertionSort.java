package cse214hw4and5;

import java.util.*;

public class InsertionSort<E extends Comparable<E>> implements Sorter<E> {

    private List<E> elements;
    private Order   order;
    private StringBuilder display;

    public InsertionSort(List<E> elements, Order order) {
        this.elements = elements;
        this.order    = order;
        this.display = new StringBuilder();
    }

    @Override
    public List<E> getList() {
        return elements;
    }

    @Override
    public void sort() {
        int len = elements.size();
        for(int x = 1; x < len; x++){
            E e = elements.get(x);
            int num = x-1;
            display.append(e + " :: " + elements.toString() + "\n");

            while(num >= 0 && (order == Order.INCREASING ? elements.get(num).compareTo(e) > 0: elements.get(num).compareTo(e) < 0)){
                elements.set(num+1, elements.get(num));
                num--;
            }
            elements.set(num+1, e);
        }
        display.append(elements.toString() + "\n");

    }

    /**
     * The method displays the original input (unsorted) list, and then, each step is shown in a new line. For example,
     * if the original list to be sorted in increasing order is [6, 5, 3, 1, 8, 7, 2, 4], calling this method should
     * return the following string (exactly in this format):
     * <p>
     * 5 :: [6, 5, 3, 1, 8, 7, 2, 4]
     * 3 :: [5, 6, 3, 1, 8, 7, 2, 4]
     * 1 :: [3, 5, 6, 1, 8, 7, 2, 4]
     * 8 :: [1, 3, 5, 6, 8, 7, 2, 4]
     * 7 :: [1, 3, 5, 6, 8, 7, 2, 4]
     * 2 :: [1, 3, 5, 6, 7, 8, 2, 4]
     * 4 :: [1, 2, 3, 5, 6, 7, 8, 4]
     * [1, 2, 3, 4, 5, 6, 7, 8]
     * <p>
     * At each step, the element being inspected for insertion is at the start, and the list in its current state is
     * then placed after ::, two colon symbols. Notice the repeated list when the element being inspected for insertion
     * is 8, and the list does not change at all. Such repetitions must be included in the returned string.
     *
     * @return the string representation of the step-wise transformation of the input list, as done with insertion sort
     */
    @Override
    public String show() {
        return display.toString();
    }

    /**
     * Just an example showing how your code will be used. The same list of elements used to explain the show() method
     * is being used in this example. Notice that this main method actually doesn't care about the type of algorithm
     * used by the sorter. For example, you could have a BubbleSort, MergeSort, or QuickSort implemenation instead, and
     * someone using your code would not need to change anything!
     *
     * This is a type of "abstraction" in code. We are ending this semester on this note, because you will learn a lot
     * more about abstraction in CSE 216.
     */
    public static void main(String... args) {
        Sorter<Integer> intsorter = new InsertionSort<>(Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4), Order.INCREASING);
        intsorter.sort();
        System.out.println(intsorter.show());
        // NOTE: the list shown at the end of the string printed after calling show() MUST be identical to the result
        // calling getList() after calling sort(). That is, the backing list must actually be changed as is shown by the
        // result of the show() method.
    }
}

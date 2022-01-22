package cse214hw4and5;

import java.util.*;

public class QuickSort<E extends Comparable<E>> implements Sorter<E> {

    private List<E> elements;
    private Order   order;
    private StringBuilder display;

    public QuickSort(List<E> elements, Order order) {
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
        sort(elements, 0, elements.size());
    }

    public void sort(List<E> list, int first, int n) {
        int pivotIndex;
        if (first < n-1) {
            pivotIndex = partition(list, first, n);
            sort(list, first, pivotIndex);
            sort(list, pivotIndex + 1, n);
        }

    }

    private int partition(List<E> list, int first, int n){
        E pivot = list.get(first);
        int i = first+1;

        for(int j = first+1; j<n; j++){
            if(order == Order.INCREASING ? list.get(j).compareTo(pivot) <=  0: list.get(j).compareTo(pivot) > 0){
                E temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                display.append(pivot + " :: " + elements.toString() + "\n");
                i++;
            }
        }
        E temp = list.get(i-1);
        list.set(i-1, pivot);
        list.set(first, temp);
        display.append("  :: " + elements.toString() + "\n");
        return i-1;
    }
    /**
     * The method displays the original input (unsorted) list, and then, each step is shown in a new line. For example,
     * if the original list to be sorted in increasing order is [6, 4, 9, 5, 1, 8, 2, 7, 3], calling this method should
     * string as follows, exactly in the format shown:
     * <p>
     * 6 :: [6, 4, 9, 5, 1, 8, 2, 7, 3]
     * 6 :: [6, 4, 3, 5, 1, 8, 2, 7, 9]
     * 6 :: [6, 4, 3, 5, 1, 2, 8, 7, 9]
     *   :: [2, 4, 3, 5, 1, 6, 8, 7, 9]
     * <p>
     * Only the steps with the first pivot are shown above, and NOT the entire output. The last step with a specific
     * pivot does not show the pivot separately in front of the :: separator, to indicate that a different pivot will
     * be used in the next step. At each stage, you must use the first element as the pivot.
     *
     * @return the string representation of the step-wise transformation of the input list, as done with quick sort
     */
    @Override
    public String show() {
        return display.toString();
    }

    public static void main(String... args) {
        Sorter<Integer> intsorter = new QuickSort<>(Arrays.asList(6, 4, 9, 5, 1, 8, 2, 7,3), Order.INCREASING);
        intsorter.sort();
        //System.out.println(intsorter.getList().toString());
        System.out.println(intsorter.show());

        Sorter<String> stringSorter = new QuickSort<>(Arrays.asList("abc", "xyz", "xjk", "abcd", "a"), Order.INCREASING);
        stringSorter.sort();
        //System.out.println(stringSorter.getList().toString());
        System.out.println(stringSorter.show());

        // NOTE: the list shown at the end of the string printed after calling show() MUST be identical to the result
        // calling getList() after calling sort(). That is, the backing list must actually be changed as is shown by the
        // result of the show() method.
    }

}

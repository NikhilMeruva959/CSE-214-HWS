package cse214hw1;

import java.util.List;

public class Main {
//    if (n <= 1) return;
//     insertionSort( list, n-1 );
//
//    int last = list[n-1];
//    int j = n-2;
//
//        /* Move elements of arr[0..i-1], that are
//          greater than key, to one position ahead
//          of their current position */
//    while (j >= 0 && arr[j] > last)
//    {
//        arr[j+1] = arr[j];
//        j--;
//    }
//    arr[j+1] = last;
//}
public static boolean singlyListCircular(Node<E> p){
    if (p == null) return true;

    Node node = p.next;

    while (node != null && node != p) node = node.next;

    return (node == p);
}
    bool hasCircle(List l)
    {
        Iterator i = l.begin(), j = l.begin();
        while (true) {
            // increment the iterators, if either is at the end, you're done, no circle
            if (i.hasNext())  i = i.next(); else return false;

            // second iterator is travelling twice as fast as first
            if (j.hasNext())  j = j.next(); else return false;
            if (j.hasNext())  j = j.next(); else return false;

            // this should be whatever test shows that the two
            // iterators are pointing at the same place
            if (i.getObject() == j.getObject()) {
                return true;
            }
        }
    }
    // An empty linked list is circular
    // Next of head
// This loop would stop in both cases (1) If
    // Circular (2) Not circular
    // If loop stopped because of circular
    // condition


    // Driver Method
    public static void main(String[] args)
    {
        long x = 048231312622L;
        int arr[] = {12, 11, 13, 5, 6};

        insertionSortRecursive(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
    public boolean isValidBinarySearchTree(Node node) {
        Double minVal = Double.NEGATIVE_INFINITY;
        Double maxVal = Double.NEGATIVE_INFINITY;

        return isValidBinarySearchTree(node, minVal, maxVal);
    }
    public boolean isValidBinarySearchTree(Node node, double minVal, double maxVal){
        if(node==null) return true;
        if(node.value <= minVal || node.value >= maxVal) return false;
        return isValidBinarySearchTree(node.left, minVal, node.value) && isValidBinarySearchTree(node.right, node.value, maxVal);
    }
    boolean isValidBinarySearchTree(Node node){
        if (node != null){
            if (!isValidBinarySearchTree(node.left))return false;

            if (prev != null && node.data <= prev.data ) return false;
                prev = node;
            return isValidBinarySearchTree(node.right);
        }
        return true;
    }
}

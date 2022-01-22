package datastructures;

import java.util.ArrayList;

/**
 * This class implements the {@link Set} interface. It offers constant time performance (on average) for the basic
 * operations <code>add</code>, <code>remove</code>, <code>containt</code>, and <code>size</code>, under the simple
 * uniform hashing assumption (i.e., the hash function distributes elements uniformly across the slots in the backing
 * table).
 * There are two constructors given to you. You can modify them, or add new constructors. However, the signature of
 * these two constructors must not be changed. That is, the user must be able to create an instance of this class by
 * invoking <code>new ChainedHashSet()</code> and <code>new ChainedHashSet(int k)</code>.
 *
 * @param <E> the type of elements stored in this set
 * @author Nikhil Meruva
 */
public class ChainedHashSet<E> implements Set<E> {

    private static class Node<K, E> {
        K key;
        E value;
        Node<K, E> next; // Reference to next node
        public Node(K k, E v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    private ArrayList<Node<Integer, E>> bucket;
    private int size;

    /**
     * Once an instance is created, this table size cannot change
     */
    private final int tablesize;

    // DO NOT MODIFY THIS METHOD
    public final int tablesize() { return this.tablesize; }

    // DO NOT MODIFY THIS METHOD
    public final double loadfactor() { return size() / (double) tablesize; }

    /**
     * This is an empty constructor for ChainedHashSet
     * this has no parameters and just intializes the basics
     *
     */
    public ChainedHashSet() {
        bucket = new ArrayList<>();
        tablesize = 10;
        size = 0;
        // Create empty chains
        for (int i = 0; i < tablesize; i++)
            bucket.add(null);
    }

    /**
     * This is a constructor with bucketsize as the param
     * This takes in bucketsize and assigns it to tablesize
     * @param bucketsize
     */
    public ChainedHashSet(int bucketsize) {
        bucket = new ArrayList<>();
        tablesize = bucketsize;
        size = 0;
        // Create empty chains
        for (int i = 0; i < tablesize; i++)
            bucket.add(null);
    }

    /**
     * Returns int size
     * @return int val
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * Checks whether size is 0
     * @return boolean val
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Checks whether element is in the hashset
     * Takes in the element of type e
     * @return boolean value
     */
    @Override
    public boolean contains(E e) {
        int key = e.hashCode();
        key = (key < 0 ? -key : key) % tablesize;
        if (bucket.get(key) == null) {
            return false;
        } else {
            Node<Integer, E> node = bucket.get(key);
            while (node != null) {
                if (node.key == key && node.value == e) return true;
                node = node.next;
            }
            return false;
        }
    }

    /**
     * This adds an element in the chained hashset
     * @param e the element to be added to this set
     * @return boolean
     */
    @Override
    public boolean add(E e) {
        int key = e.hashCode();
        key = (key < 0 ? -key : key) % tablesize;
        if (bucket.get(key) == null) {
            bucket.set(key, new Node<Integer, E>(key, e));
            size++;
            return true;
        } else {
            Node<Integer, E> node = bucket.get(key);
            while (node.next != null && node.key == key) node = node.next;
            node.next = new Node<Integer, E>(key, e);
            return false;
        }
    }

    /**
     * This removes the value within the chainedhashset
     * @param e the element to be removed from this set, if present
     * @return boolean
     */
    @Override
    public boolean remove(E e) {
        int key = e.hashCode();
        key = (key < 0 ? -key : key) % tablesize;
        if (bucket.get(key) == null) {
            return false;
        } else {
            Node<Integer, E> node = bucket.get(key);
            if (node.value == e) {
                bucket.set(key, null);
                size--;
                return true;
            }
            Node<Integer, E> new_list_head, new_list;
            new_list_head = new_list = new Node<Integer, E>(node.key, node.value);
            node = node.next;
            boolean deleted = false;
            while (node != null) {
                if (node.next.key == key && node.next.value == e) {
                    deleted = true;
                } else {
                    new_list.next = new Node<Integer, E>(node.key, node.value);
                    new_list = new_list.next;
                }
                node = node.next;
            }
            if (deleted) bucket.get(key).next = new_list_head;
            return deleted;
        }
    }

    /**
     * This method returns a string showing the entire hash table structure of this set. The format must be as follows:
     * Suppose a table has four slots, with three elements 'a', 'b', 'c', hashed to the first slot and 'z' hashed to the
     * third slot. Printing out the returned string should show the following:
     *
     * 1 || a -> b -> c
     * 2 ||
     * 3 || z
     *
     * Note that the elements 'a', 'b', 'c', and 'z' must also be human-readable.
     *
     * @return a string representation of the entire set, showing the underlying hash table structure
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < tablesize; i++) {
            output += String.format("%02d", i+1) + " ||";
            Node<Integer, E> node = bucket.get(i);
            if (node != null) {
                output += " " + node.value.toString();
                node = node.next;
            }
            while (node != null) {
                output += " -> " + node.value;
            }
            output += "\n";
        }
        return output; // todo
    }
}

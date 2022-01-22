package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * @author Nikhil Meruva
 * @author Ritwik Banerjee
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    private BinaryTreeNode<T> root;
    private int               size;

    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Consrtucts a binary search tree consisting of items from the given collection. Duplicates in the collection are
     * ignored, i.e., every item will be considered only once for the tree being constructed.
     *
     * @param collection the given collection
     */
    public BinarySearchTree(Collection<T> collection) {
        this();
        for (T t : collection)
            add(t);
    }

    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Constructs an empty binary search tree.
     */
    private BinarySearchTree() {
        root = null;
        size = 0;
    }

    /*
    *This method adds a BinaryTreeNode within a BST tree, but uses a helper function add() down below
    * This method takes in a type T parameter
    * @return void
     */
    @Override
    public void add(T t) {
        root = add(t, root);
    }

    /**
     * This method mathematically adds a BinaryTreeNode within a BST tree
     * This method takes in the type T parameter and a BinaryTreeNode(will always be the root)
     * @return BinaryTreeNode type T
     */
    public BinaryTreeNode<T> add(T val, BinaryTreeNode<T> node){
        if(node != null) {
            T t = node.element();
            if (val.compareTo(t) < 0) {
                BinaryTreeNode<T> newNode = add(val, node.left());
                node.setLeft(newNode);
                newNode.setParent(node);
            }
            else if (val.compareTo(t) > 0) {
                BinaryTreeNode<T> newNode = add(val, node.right());
                node.setRight(newNode);
                newNode.setParent(node);
            }
            return node;
        }
        else{
            size++;
            return new BinaryTreeNode<T>(val);
        }
    }

    /**
     * This method will properly remove a given value within a BST
     * This method takes in the type T parameter
     * return void
     */
    @Override
    public void remove(T t) {
        BinaryTreeNode<T> toBeDeleted = findNode(t, root);
        if (toBeDeleted == null)
            return;

        if(toBeDeleted.left() == null && toBeDeleted.right() == null) {
            if (toBeDeleted.parent().left().equals(toBeDeleted)) toBeDeleted.parent().setLeft(null);
            else toBeDeleted.parent().setRight(null);
        }
        else if(toBeDeleted.left() == null){
            toBeDeleted.setElement(toBeDeleted.right().element());
            toBeDeleted.setRight(null);
        }
        else if(toBeDeleted.right() == null){
            toBeDeleted.setElement(toBeDeleted.left().element());
            toBeDeleted.setLeft(null);
        }
        else {
            BinaryTreeNode<T> successor = minSuccessor(toBeDeleted.right());
            toBeDeleted.setElement(successor.element());

            if (successor.parent().left().equals(successor)) successor.parent().setLeft(null);
            else successor.parent().setRight(null);
        }
        size--;
        return;
    }

    /**
     * This helper method used within the remove() will find the min successor within a BST
     * takes in a BinaryTreeNode of type T
     * @return a BinaryTreeNode of type T
     */
    private BinaryTreeNode<T> minSuccessor(BinaryTreeNode<T> node){
        if(node.left() == null) return node;
        return minSuccessor(node.left());
    }

    /**
     * This helper method used within the remove() will find the node within a BST
     * THis method takes in a param of type t and a BinaryTreeNode
     * @return  a BinaryTreeNode of type T
     */
    private BinaryTreeNode<T> findNode(T t, BinaryTreeNode<T> node){
        if(node == null) return null;
        if(node.element().compareTo(t) == 0) return node;
        return node.element().compareTo(t) < 0 ? findNode(t, node.right()) : findNode(t, node.left());
    }


    /**
     * Returns the search path that starts at the root node of the tree, and ends at the node containing the specified
     * item. If such a node exists in the tree, it is the last object in the returned list. Otherwise, this method will
     * still return the path corresponding to the search for this item, but append a <code>null</code> element at the
     * end of the list.
     *
     * @param t the specified item
     * @return the search path, with a node containing the specified item as the last object in the list if the item is
     * found in the tree, and the <code>null</code> node if item is not found in the tree.
     */
    @Override
    public List<BinaryTreeNode<T>> find(T t){
        List<BinaryTreeNode<T>> list = new ArrayList<BinaryTreeNode<T>>();

        BinaryTreeNode<T> x = new BinaryTreeNode<T>(t);
        BinaryTreeNode<T> tempRoot = new BinaryTreeNode<T>(this.root().element());

        boolean bool = false;
        tempRoot = root;
        while (!bool) {
            if (tempRoot.element().compareTo(x.element()) == 0) {
                bool = true;
                list.add(tempRoot);
            } else if (tempRoot.element().compareTo(x.element()) < 0) {
                list.add(tempRoot);
                tempRoot = tempRoot.right();
            }
            if (tempRoot.element().compareTo(x.element()) > 0) {
                list.add(tempRoot);
                tempRoot = tempRoot.left();
            }
        }
        return list;
    }

    /**
     * !!DO NOT MODIFY THIS CODE!!
     */
    @Override
    public void print() {
        root.print();
    }

    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the root node of this tree
     */
    @Override
    public BinaryTreeNode<T> root() {
        return root;
    }

    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the size, i.e., the number of nodes in this tree
     */
    @Override
    public int size() {
        return size;
    }
}
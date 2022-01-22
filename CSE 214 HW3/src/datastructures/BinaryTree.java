package datastructures;

import java.util.List;

/**
 * !!DO NOT MODIFY THIS CODE!!
 *
 * @author Ritwik Banerjee
 */
public interface BinaryTree<T> {
    
    void add(T t);
    
    void remove(T t);
    
    void print();
    
    List<BinaryTreeNode<T>> find(T t);
    
    BinaryTreeNode<T> root();
    
    int size();
}

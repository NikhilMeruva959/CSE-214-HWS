package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikhil Meruva
 * @author Ritwik Banerjee
 */
public class PreOrderTraversal<E> extends Traversal<E> {

    private List<E> list = new ArrayList<E>();

    /**
     * This method returns a list in preorder
     * This method takes in a binarytree
     * @return a List type E
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        preOrder(tree.root());
        return list;
    }
    /**
     * This method produces the preorder traversal of the given input
     * This takes in a BinaryTreeNode
     * return void
     */
    private void preOrder(BinaryTreeNode<E> val) {
        if (val != null) {
            list.add(val.element());
            preOrder(val.left());
            preOrder(val.right());
        }
        return;
    }
}

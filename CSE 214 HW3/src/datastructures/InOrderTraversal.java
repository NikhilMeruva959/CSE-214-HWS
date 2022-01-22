package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikhil Meruva
 * @author Ritwik Banerjee
 */
public class InOrderTraversal<E> extends Traversal<E> {
    private List<E> list = new ArrayList<E>();

    /**
     * This method returns a list in inorder
     * This method takes in a binarytree
     * @return a List type E
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        inOrder(tree.root());
        return list;
    }

    /**
     * This method produces the inorder traversal of the given input
     * This takes in a BinaryTreeNode
     * return void
     */
    private void inOrder(BinaryTreeNode<E> val) {
        if (val != null) {
            inOrder(val.left());
            list.add(val.element());
            inOrder(val.right());
        }
        return;
    }

}

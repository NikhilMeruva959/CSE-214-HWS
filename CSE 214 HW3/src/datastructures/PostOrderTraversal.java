package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikhil Meruva
 * @author Ritwik Banerjee
 */
public class PostOrderTraversal<E> extends Traversal<E> {

    private List<E> list = new ArrayList<E>();

    /**
     * This method returns a list in postorder
     * This method takes in a binarytree
     * @return a List type E
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        postOrder(tree.root());
        return list;
    }
    /**
     * This method produces the postorder traversal of the given input
     * This takes in a BinaryTreeNode
     * return void
     */
    private void postOrder(BinaryTreeNode<E> val) {
        if (val != null) {
            postOrder(val.left());
            postOrder(val.right());
            list.add(val.element());
        }
        return;
    }

}



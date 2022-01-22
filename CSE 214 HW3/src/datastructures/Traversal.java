package datastructures;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * !!DO NOT MODIFY THIS CODE!!
 *
 * @author Ritwik Banerjee
 */
public abstract class Traversal<E> {
    
    public abstract List<E> of(BinaryTree<E> tree);
    
    public static <T> Traversal<T> ofType(String s) {
        if ("inorder".equalsIgnoreCase(s))
            return new InOrderTraversal<>();
        if ("preorder".equalsIgnoreCase(s))
            return new PreOrderTraversal<>();
        if ("postorder".equalsIgnoreCase(s))
            return new PostOrderTraversal<>();
        throw new InvalidParameterException(String.format("%s is not a valid tree traversal.", s));
    }
    
}

package hw3.app;

import hw3.datastructures.BinarySearchTree;
import hw3.datastructures.ChainedHashSet;
import hw3.datastructures.Set;
import hw3.datastructures.Traversal;
import hw3.products.Laptop;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * !!DO NOT MODIFY THIS CODE!!
 *
 * @author Ritwik Banerjee
 */
public class Main {

    public static void main(String... args) {
        System.out.println("Enter product instances (format: <brand>,<processor-speed>,<memory>,<price>,<screen-size>):");
        Scanner      scanner = new Scanner(System.in);
        List<Laptop> laptops = new ArrayList<>();
        for (String line = ""; !line.equalsIgnoreCase("done"); line = scanner.nextLine()) {
            Laptop laptop = Laptop.fromString(line.trim());
            if (laptop != null)
                laptops.add(laptop);
        }

        // A sample test for part 1 of the homework
        BinarySearchTree<Laptop> laptopTree = new BinarySearchTree<>(laptops);
        laptopTree.print();

        System.out.println("Enter traversal type: ");
        Traversal<Laptop> traversal = Traversal.ofType(validated(scanner.nextLine().trim()));
        for (Laptop laptop : traversal.of(laptopTree))
            System.out.println(laptop);

        // A sample test for part 2 of the homework
        Set<Laptop> laptopSet = new ChainedHashSet<>();
        for (Laptop a : laptops)
            laptopSet.add(a);
        System.out.println(laptopSet.contains(laptops.get(0))); // should be true
        Laptop l1 = Laptop.fromString("apple,2.9,8,1200,14"); // this is just an example
        System.out.println(laptopSet.contains(l1)); // should be false unless a laptop with all the exact same fields is already in the set
    }

    private static String validated(String s) {
        if (s.equalsIgnoreCase("inorder") || s.equalsIgnoreCase("preorder") || s.equalsIgnoreCase("postorder"))
            return s;
        throw new InvalidParameterException(String.format("%s is not a valid tree traversal.", s));
    }
}

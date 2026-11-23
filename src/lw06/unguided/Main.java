package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        BinarySearchTree bst = new BinarySearchTree();
        String firstLine = read.nextLine();
        String[] numbers = firstLine.split(" ");

        for (int i=0; i<numbers.length; i++){
            int value = Integer.parseInt(numbers[i]);
            bst.insert(value);
        }
        int target = read.nextInt();
        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder :");
        bst.postOrder();
        System.out.println("Search " + target + " : " + bst.search(target));
        read.close();
        System.out.println("Minimum : "+bst.findMin());
        System.out.println("Maximum : "+bst.findMax());
    }
}

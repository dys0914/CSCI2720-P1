package Project1;

import java.io.File;
import java.util.Scanner;
public class LinkedListDriver {
    public static void main(String args[]) {
        SortedLinkedList sll = new SortedLinkedList();
        if(args.length > 0) {
            try {
                String filename = args[0];
                File file = new File(filename);
                Scanner reader = new Scanner(file);
                int a;
                while(reader.hasNext()) {
                    a = reader.nextInt();
                    sll.insertItem(new ItemType(a));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        SortedLinkedList copy, temp;
        int x;
        while(!end) {
            System.out.print("Enter a command : ");
            String next = sc.next();
            switch (next) {
            case "i":
                System.out.print("Enter a number to insert : ");
                x = sc.nextInt();
                System.out.println("Original list : " + sll);
                sll.insertItem(new ItemType(x));
                System.out.println("New List : " + sll);
                break;
            case "d":
                System.out.print("Enter a number to delete : ");
                x = sc.nextInt();
                if(sll.getLength() != 0) {
                    System.out.println("Original list : " + sll);
                    sll.deleteItem(new ItemType(x));
                    System.out.println("New List : " + sll);
                }
                else {
                    System.out.println("You cannot delete from an empty list");
                }
                break;
            case "s":
                System.out.print("Enter a number to search: ");
                x = sc.nextInt();
                System.out.println("Original list: " + sll);
                int search = sll.searchItem(new ItemType(x));
                if(sll.getLength() == 0) {
                    System.out.println("The list is empty");
                }
                else if(search < 0) {
                    System.out.println("Item is not present in the list");
                }
                else {
                    System.out.println("The item is present at index " + search);
                }
                break;
            case "n":
                System.out.println(sll.getNextItem().getValue());                                                                                                                                                                                      
                break;
            case "r":
                sll.resetList();
                System.out.println("Iterator is reset");
                break;
            case "a":
                System.out.println("Original list: " + sll);
                copy = sll;
                sll.DeleteAlternate();
                System.out.println("Modified list: " + sll);
                sll = copy;
                break;
            case "m":
                System.out.print("Enter the length of the new list: ");
                temp = new SortedLinkedList();
                copy = sll;
                x = sc.nextInt();
                System.out.print("Enter the numbers: ");
                for(int i = 0; i < x; i++) {
                    int l = sc.nextInt();
                    temp.insertItem(new ItemType(l));
                }
                System.out.println("The list 1: " + sll);
                System.out.println("The list 2: " + temp);
                sll.mergeList(temp);
                System.out.println("Merged List: " + sll);// check implementation                                                                                                                                                             
                sll = copy;
                break;
            case "t":
                System.out.print("Enter the length of the new list: ");
                temp = new SortedLinkedList();
                copy = sll;
                x = sc.nextInt();
                System.out.print("Enter the numbers: ");
                for(int i = 0; i < x; i++) {
                    int l = sc.nextInt();
                    temp.insertItem(new ItemType(l));
                }
                System.out.println("The list 1: " + sll);
                System.out.println("The list 2: " + temp);
                System.out.print("Intersection of lists: ");
                sll.intersection(temp);
                sll = copy;
                break;
            case "p":
                System.out.println("The list is: " + sll);
                break;
            case "l":
                System.out.println("The length of the list is: " + sll.getLength());
                break;
            case "q":
                end = true;
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid Command, try again!");
                break;
            }
        }

        sc.close();
    }
}

import java.util.Scanner;
public class LinkedListDriver() {
    public static void main(String args[]) {
        if(args.length > 0) {
            String filename = args[0];
        }
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        SortedLinkedList sll = new SortedLinkedList();
        while(!end) {
            System.out.println("Enter a command : ");
            String next = sc.next();
            switch (next) {
            case "i":
                System.out.println("Enter a number to insert : ");
                System.out.println("Original list : " + sll);
                int x = sc.nextInt();
                sll.insertItem(new ItemType(x));
                System.out.println("New List : " + sll);
                break;
            case "d":
                System.out.println("Enter a number to delete : ");
                System.out.println("Original list : " + sll);
                int x = sc.nextInt();
                sll.deleteItem(new ItemType(x));
                System.out.println("New List : " + sll);
                break;
            case "s":
                System.out.println("Enter a number to search: ");
                System.out.println("Original list: " + sll);
                int x = sc.nextInt();
                int search = sll.searchItem(new ItemType(x));
                if(search < 0) {
                    System.out.println("Item is not present in the list");
                }
                else if(sll.getLength == 0) {
                    System.out.println("The list is empty");
                }
                else {
                    System.out.println("The item is present at index " + search);
                }
                break;
            case "n":
                ItemType t = sll.getNextItem(); //check implementation                                                                                                                                 
                if(t == null) {
                    sll.resetList();
                }

                System.out.println(t.getValue());
                break;
            case "r":
                sll.resetList();
                System.out.println("Iterator is reset");
                break;
            case "a":
                System.out.println("Original list: " + sll);
                SortedLinkedList copy = sll;
                sll.deleteAlternateNodes();
                System.out.println("Modified list: " + sll);
                sll = copy;
                break;
            case "m":
                System.out.println("Enter the length of the new list: ");
                SortedLinkedList merge = new SortedLinkedList();
                SortedLinkedList copy = sll;
                System.out.println("Enter the numbers: ");
                for(int i = 0; i < l; i++) {
                    int l = sc.nextInt();
                    merge.insertItem(new ItemType(l));
                }
                System.out.println("The list 1: " + sll);
                System.out.println("The list 2: " + merge);
                System.out.println("Merged List: " + sll);// check implementation                                                                                                                      
                sll = copy;
                break;
            case "t":
                System.out.println("Enter the length of the new list: ");
                SortedLinkedList merge = new SortedLinkedList();
                SortedLinkedList copy = sll;
                System.out.println("Enter the numbers: ");
                for(int i = 0; i < l; i++) {
                    int l = sc.nextInt();
                    merge.insertItem(new ItemType(l));
                }
                System.out.println("Intersection of lists: " + sll);
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

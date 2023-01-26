import java.util.Scanner;
public class LinkedListDriver() {
    public static void main(String args[]) {
        if(args.length > 0) {
            String filename = args[0];
        }
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        boolean end = false;
        while(!end) {
            switch (next) {
            case "i":
                break;
            case "d":
                break;
            case "s":
                break;
            case "n":
                break;
            case "r":
                break;
            case "a":
                break;
            case "m":
                break;
            case "t":
                break;
            case "p":
                break;
            case "l":
                break;
            case "q":
                end = true;
                break;
            default:
                break;
            }
        }

        sc.close();
    }
}

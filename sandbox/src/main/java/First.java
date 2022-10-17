
import java.util.Scanner;
public class First {

    public static void main(String[] args) {
        StringChanges n = new StringChanges();
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String typeToDisplay = a;
        System.out.println("Do you want to reverse? Please type 'yes' to reverse.");
        String answer = in.next();
        if (answer.equals("yes")) {
            n.prep(typeToDisplay);
            System.out.println(n);
            n.reverse(typeToDisplay);
            System.out.println(n);
        } else {
            System.out.println("Program is finished");
        }
    }


}

import java.util.Scanner;
public class First {

    public static void main(String[] args) {
        StringChanges n = new StringChanges();
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String typeToDisplay = a;
        System.out.println("Do you want to reverse? Please type 'yes' to reverse.");
        String answer = in.nextLine();
        if (answer.equals("yes")) {
            n.prep(typeToDisplay);
            n.reverse();
            System.out.println(n);
        } else {
            System.out.println("Program is finished");
        }
    }


}
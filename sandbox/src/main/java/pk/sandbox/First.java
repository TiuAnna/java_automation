package pk.sandbox;

import java.util.Scanner;
public class First {
    public static void main(String[] args) {
//        StringChanges n = new StringChanges();
//        Scanner in = new Scanner(System.in);
//        String typeToDisplay = in.nextLine();
//        System.out.println("Do you want to reverse? Please type 'yes' to reverse.");
//        String answer = in.nextLine();
//        if (answer.equals("yes")) {
//            n.prep(typeToDisplay);
//            n.reverse();
//            System.out.println(n);
//        } else {
//            System.out.println("Program is finished");
//        }
        Calculation var = new Calculation(6,7);
        System.out.println(var.answer());
    }


}
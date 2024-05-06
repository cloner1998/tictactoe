import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TTT ttt = new TTT();
        ttt.initializer();
        Scanner my_box = new Scanner(System.in);
        Scanner my_character = new Scanner(System.in);
        System.out.println("choose your number :");
        int box = my_box.nextInt();
        System.out.println("choose your character :");
        String character = my_character.nextLine();
        ttt.put_in_table(box, character.charAt(0));
        ttt.put_in_table(2,'x');
        ttt.put_in_table(3,'x');
        ttt.winner_check();
        ttt.printer();

    }
}
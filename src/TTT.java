import java.util.Scanner;

public class TTT {

    Character[][] table = new Character[3][3];

    public Character[][] initializer() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = '-';
            }
        }
        return table;
    }

    public boolean winner_check() {

        boolean check = false;

        StringBuilder line_r = new StringBuilder();
        StringBuilder line_c = new StringBuilder();
        StringBuilder line_X1 = new StringBuilder();
        StringBuilder line_X2 = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                line_r.append(table[i][j]);
                line_c.append(table[j][i]);
            }
            if (line_r.toString().equals("xxx")) {
                System.out.println("x winner");
                check = true;
            }
            if (line_r.toString().equals("ooo")) {
                System.out.println("o winner");
                check = true;
            }
            if (line_c.toString().equals("xxx")) {
                System.out.println("x winner");
                check = true;
            }
            if (line_c.toString().equals("ooo")) {
                System.out.println("o winner");
                check = true;
            }
        }
        line_X1.append(table[0][0]).append(table[1][1]).append(table[2][2]);
        line_X2.append(table[0][2]).append(table[1][1]).append(table[2][0]);
        if (line_X1.toString().equals("xxx") || line_X2.toString().equals("xxx")) {
            System.out.println("x winner");
            check = true;
        }
        if (line_X1.toString().equals("ooo") || line_X2.toString().equals("ooo")) {
            System.out.println("o winner");
            check = true;
        }
        return check;
    }

    public void put_in_table(int number, char sign){
        switch (number){
            case 1:
                table[0][0] = sign;
                break;
            case 2:
                table[0][1] = sign;
                break;
            case 3:
                table[0][2] = sign;
                break;
            case 4:
                table[1][0] = sign;
                break;
            case 5:
                table[1][1] = sign;
                break;
            case 6:
                table[1][2] = sign;
                break;
            case 7:
                table[2][0] = sign;
                break;
            case 8:
                table[2][1] = sign;
                break;
            case 9:
                table[2][2] = sign;
                break;
            default:
                break;
        }
    }

    public void printer() {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    System.out.printf(String.valueOf(table[i][j]));
                }
                System.out.println();
            }
            System.out.println("______________");
        }

    public static void starter(){
        TTT ttt = new TTT();
        Scanner my_box = new Scanner(System.in);
        Scanner my_character = new Scanner(System.in);
        ttt.initializer();
        ttt.printer();
        while (!ttt.winner_check()){
            //TODO
        }
    }
}



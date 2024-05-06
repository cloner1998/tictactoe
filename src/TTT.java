import java.util.ArrayList;
import java.util.List;

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

    public Character[][] initializer2() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[j][i] = 'x';
            }
        }
        return table;
    }

    public void winner_check() {

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
            }
            if (line_r.toString().equals("ooo")) {
                System.out.println("o winner");
            }
            if (line_c.toString().equals("xxx")) {
                System.out.println("x winner");
            }
            if (line_c.toString().equals("ooo")) {
                System.out.println("o winner");
            }
        }
        line_X1.append(table[0][0]).append(table[1][1]).append(table[2][2]);
        line_X2.append(table[0][2]).append(table[1][1]).append(table[2][0]);
        if (line_X1.toString().equals("xxx") || line_X2.toString().equals("xxx")) {
            System.out.println("x winner");
        }
        if (line_X1.toString().equals("ooo") || line_X2.toString().equals("ooo")) {
            System.out.println("o winner");

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
}


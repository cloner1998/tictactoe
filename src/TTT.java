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

    public boolean winner_check2(){
        boolean checker = false;
        String line = new String();
        String line_c = new String();
        StringBuilder line_X1 = new StringBuilder();
        StringBuilder line_X2 = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                line += table[i][j];
                line_c += table[j][i];
            }
        }
        if (line.contains("xxx") || line_c.contains("xxx")){
            System.out.println("x winner");
            checker = true;
        }
        if (line.contains("ooo") || line_c.contains("ooo")){
            System.out.println("o winner");
            checker = true;
        }
        line_X1.append(table[0][0]).append(table[1][1]).append(table[2][2]);
        line_X2.append(table[0][2]).append(table[1][1]).append(table[2][0]);
        if (line_X1.toString().equals("xxx") || line_X2.toString().equals("xxx")) {
            System.out.println("x winner");
            checker = true;
        }
        if (line_X1.toString().equals("ooo") || line_X2.toString().equals("ooo")) {
            System.out.println("o winner");
            checker = true;
        }
        return checker;
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
        for (Character[] characters : table) {
            for (int j = 0; j < table.length; j++) {
                System.out.printf(String.valueOf(characters[j]));
            }
            System.out.println();
        }
            System.out.println("______________");
        }

    public static void starter(){
        TTT ttt = new TTT();
        String name = "player 1";
        Scanner my_box = new Scanner(System.in);
        Scanner my_character = new Scanner(System.in);
        ttt.initializer();
        ttt.printer();
        while (!ttt.winner_check2()){
            System.out.println(STR."\{name} enter your number:");
            int box = my_box.nextInt();
            System.out.println(STR."\{name} enter your character:");
            String character = my_character.nextLine();
            ttt.put_in_table(box, character.charAt(0));
            ttt.printer();
            if(name.equals("player 1")){
                name = "player 2";
            }else {
                name = "player 1";
            }
            ttt.winner_check2();

        }
    }
}



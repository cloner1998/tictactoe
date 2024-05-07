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
        if ((line.contains("xxx") || line_c.contains("xxx")) && !(line_c.contains("x-x") || line.contains("x-x"))
        && !(line_c.contains("xox") || line.contains("xox"))){
            //System.out.println("x winner");
            checker = true;
        }
        if ((line.contains("ooo") || line_c.contains("ooo")) && !(line_c.contains("o-o") || line.contains("o-o"))
        && !(line_c.contains("oxo") || line.contains("oxo"))){
            //System.out.println("o winner");
            checker = true;
        }
        line_X1.append(table[0][0]).append(table[1][1]).append(table[2][2]);
        line_X2.append(table[0][2]).append(table[1][1]).append(table[2][0]);
        if (line_X1.toString().equals("xxx") || line_X2.toString().equals("xxx")) {
            //System.out.println("x winner");
            checker = true;
        }
        if (line_X1.toString().equals("ooo") || line_X2.toString().equals("ooo")) {
            //System.out.println("o winner");
            checker = true;
        }

        return checker;
    }

    public boolean draw_checker(){
        boolean check = false;
        String line = null;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                line += table[i][j];
            }
        }
        if(!line.contains("-")){
            TTT ttt = new TTT();
            if(!ttt.winner_check2()){
                check = true;
            }
        }
        return check;
    }

    public void add_table(int box, char sign){
        int row;
        if(box % 3 == 0){
            row = box / 3;
            table[row-1][2] = sign;
        }
        if(box % 3 == 2){
            row = box / 3;
            table[row][1] = sign;
        }
        if(box % 3 == 1){
            row = box / 3;
            table[row][0] = sign;
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
        boolean checker = false;
        String name = "player 1";
        Scanner my_box = new Scanner(System.in);
        Scanner my_character = new Scanner(System.in);
        ttt.initializer();
        ttt.printer();
        while (!checker){
            System.out.println(STR."\{name} enter your number:");
            int box = my_box.nextInt();
            System.out.println(STR."\{name} enter your character:");
            String character = my_character.nextLine();
            ttt.add_table(box, character.charAt(0));
            ttt.printer();
            if(name.equals("player 1")){
                name = "player 2";
            }else {
                name = "player 1";
            }
            checker = ttt.winner_check2();
            if(ttt.draw_checker()){
                System.out.println("draw");
                return;
            }
        }
        if(name.equals("player 1")){
            name = "player 2";
        }else {
            name = "player 1";
        }
        System.out.println(STR."\{name} is winner");
    }
}



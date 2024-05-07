public class add_in_table extends TTT{
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
}

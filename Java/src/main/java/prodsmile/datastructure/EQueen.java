package prodsmile.datastructure;

public class EQueen {

    int[] queens = new int[8];

    public boolean solve(int col) {

        if(col == 8) {
            return true;
        }

        // i : row
        for(int i = 0; i < 8; i++) {
            queens[col] = i;

            boolean flag = true;

            for(int j = 0; j < col; j++) {
                var rowDiff = Math.abs(queens[j] - i);
                var colDiff = col - j;

                if(queens[j] == i || rowDiff == colDiff) {
                    flag = false;
                    break;
                }
            }

            if(flag && solve(col + 1)) {
                return true;
            }

        }
        return false;
    }

    void print(){

        for(int i = 0; i < 8; i++) {

            for(int j = 0; j < 8; j++) {
                if(queens[i] == j) {
                    System.out.print("Q");
                } else {

                    System.out.print(".");
                }

            }
            System.out.print("\n");
        }
    }

    public static void main(String[] argv) {
        var equeen = new EQueen();
        equeen.solve(0);
        equeen.print();

    }

}

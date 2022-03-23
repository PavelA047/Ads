package Exe;

public class Exe2 {
    final static int ROW = 5;
    final static int COLUMN = 6;

    public static void main(String[] args) {
        int[][] arr = new int[ROW][COLUMN];
        showArr(arr);
    }

    private static void showArr(int[][] arr) {
        int k = 1;
        int c = 1;
        int d = 1;
        for (int i = 0; i < COLUMN; i++) {
            arr[0][i] = k;
            k++;
        }
        for (int i = 1; i < ROW; i++) {
            arr[i][COLUMN - 1] = k;
            k++;
        }
        for (int i = COLUMN - 2; i >= 0; i--) {
            arr[ROW - 1][i] = k;
            k++;
        }
        for (int i = ROW - 2; i > 0; i--) {
            arr[i][0] = k;
            k++;
        }

        while (k < ROW * COLUMN) {
            while (arr[c][d + 1] == 0) {
                arr[c][d] = k;
                k++;
                d++;
            }

            while (arr[c + 1][d] == 0) {
                arr[c][d] = k;
                k++;
                c++;
            }

            while (arr[c][d - 1] == 0) {
                arr[c][d] = k;
                k++;
                d--;
            }

            while (arr[c - 1][d] == 0) {
                arr[c][d] = k;
                k++;
                c--;
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = k;
                }
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (arr[i][j] < 10) {
                    System.out.print(arr[i][j] + ",  ");
                } else {
                    System.out.print(arr[i][j] + ", ");
                }
            }
            System.out.println("");
        }
    }
}

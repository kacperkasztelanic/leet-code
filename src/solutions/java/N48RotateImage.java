package solutions.java;

import java.util.Arrays;

public class N48RotateImage {

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void reverseRows(int[][] matrix) {
        for (int[] row : matrix) {
            reverseRow(row);
        }
    }

    private static void reverseRow(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int temp = row[row.length - 1 - i];
            row[row.length - 1 - i] = row[i];
            row[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(matrix));
        N48RotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

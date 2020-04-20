package solutions.java;

public class N867TransposeMatrix {

    public int[][] transpose(int[][] a) {
        int rowNum = a.length;
        int colNum = a[0].length;
        int[][] res = new int[colNum][rowNum];
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                res[c][r] = a[r][c];
            }
        }
        return res;
    }
}

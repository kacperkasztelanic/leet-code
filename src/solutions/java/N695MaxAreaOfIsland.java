package solutions.java;

public class N695MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, area(i, j, grid, seen));
            }
        }
        return ans;
    }

    private static int area(int i, int j, int[][] grid, boolean[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || seen[i][j] || grid[i][j] == 0) {
            return 0;
        }
        seen[i][j] = true;
        return area(i + 1, j, grid, seen) //
                + area(i - 1, j, grid, seen) //
                + area(i, j + 1, grid, seen) //
                + area(i, j - 1, grid, seen)//
                + 1;
    }

    public static void main(String[] args) {
        assert maxAreaOfIsland(//
                new int[][] { //
                        new int[] { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },//
                        new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },//
                        new int[] { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },//
                        new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },//
                        new int[] { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },//
                        new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },//
                        new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },//
                        new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }//
                }//
        ) == 6;
        assert maxAreaOfIsland(//
                new int[][] { //
                        new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }//
                }//
        ) == 0;
    }
}

package solutions.java;

public class N200NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (discover(i, j, grid, seen)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean discover(int i, int j, char[][] grid, boolean[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || seen[i][j] || grid[i][j] == '0') {
            return false;
        }
        seen[i][j] = true;
        discover(i + 1, j, grid, seen);
        discover(i - 1, j, grid, seen);
        discover(i, j + 1, grid, seen);
        discover(i, j - 1, grid, seen);
        return true;
    }

    public static void main(String[] args) {
        assert numIslands(//
                new char[][] { //
                        new char[] { '1', '1', '1', '1', '0' },//
                        new char[] { '1', '1', '0', '1', '0' },//
                        new char[] { '1', '1', '0', '0', '0' },//
                        new char[] { '0', '0', '0', '0', '0' }//
                }//
        ) == 1;
        assert numIslands(//
                new char[][] { //
                        new char[] { '1', '1', '0', '0', '0' },//
                        new char[] { '1', '1', '0', '0', '0' },//
                        new char[] { '0', '0', '1', '0', '0' },//
                        new char[] { '0', '0', '0', '1', '1' }//
                }//
        ) == 3;
        assert numIslands(//
                new char[][] {}//
        ) == 0;
    }
}

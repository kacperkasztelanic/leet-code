package solutions.java;

public class N463IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int edges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    edges += countEdges(grid, i, j);
                }
            }
        }
        return edges;
    }

    @SuppressWarnings("all")
    private static int countEdges(int[][] grid, int i, int j) {
        int edges = 0;
        if (i + 1 == grid.length || grid[i + 1][j] == 0) {
            edges++;
        }
        if (i == 0 || grid[i - 1][j] == 0) {
            edges++;
        }
        if (j + 1 == grid[i].length || grid[i][j + 1] == 0) {
            edges++;
        }
        if (j == 0 || grid[i][j - 1] == 0) {
            edges++;
        }
        return edges;
    }

    public static void main(String[] args) {
        assert islandPerimeter(//
                new int[][] { //
                        new int[] { 0, 1, 0, 0 },//
                        new int[] { 1, 1, 1, 0 },//
                        new int[] { 0, 1, 0, 0 },//
                        new int[] { 1, 1, 0, 0 }//
                }//
        ) == 16;
    }
}

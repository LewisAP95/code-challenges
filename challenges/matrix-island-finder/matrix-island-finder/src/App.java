//Given a matrix of 1s and 0s, return the number of "islands" in the matrix.
// A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

public class App {
    public static void main(String[] args) throws Exception {
        int[][] islandMatrix = {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}};
        IslandScanner scanner = new IslandScanner();
        int islands = scanner.getIslands(islandMatrix);
        System.out.println(String.format("Within the given matrix %d islands were found.", islands));

    }
}

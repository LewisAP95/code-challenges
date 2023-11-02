import java.util.ArrayList;

public class IslandScanner {
    public int getIslands(int[][] islandMatrix){
        //Store a list of arrays with the coordinates of each found piece of land
        ArrayList<int[]> foundList = new ArrayList<int[]>();
        int islandCount = 0;

        //Scan the whole matrix
        //If 1 for 'land' is found and its coords are not already in the found list then begin a scan from this cell
        for(int row = 0; row < islandMatrix.length; row++){
            for(int col = 0; col < islandMatrix[row].length; col++){
                if(islandMatrix[row][col] == 1){
                    if(!listCheck(row, col, foundList)){
                        spreadScan(row, col, foundList, islandMatrix);
                        islandCount++;
                    }
                }
            }
        }

        return islandCount;
    }

    private void spreadScan(int cellRow, int cellCol, ArrayList<int[]> foundList, int[][] islandMatrix){
        //Add this cell to the found list
        int[] cell = {cellRow, cellCol};
        foundList.add(cell);

        //Set up coords to manipulate based on desired direction to check in
        int newRow = cellRow;
        int newCol = cellCol;

        for(int i = 0; i < 4; i++){
            //Based on loop count, changes coords to check in each direction
            //In order: Up, down, left, right
            switch(i){
                case 0:
                newRow = cellRow - 1;
                newCol = cellCol;
                break;

                case 1:
                newRow = cellRow + 1;
                newCol = cellCol;
                break;

                case 2:
                newRow = cellRow;
                newCol = cellCol - 1;
                break;

                case 3:
                newRow = cellRow;
                newCol = cellCol + 1;
                break;
            }

            //Passes the new direction into this same method if land was found as the cell is not already in the found list
            //Try is used as a check to catch directions which took the scan out of bounds of the matrix
            try{
                if(islandMatrix[newRow][newCol] == 1 && !listCheck(newRow, newCol, foundList)){
                    spreadScan(newRow, newCol, foundList, islandMatrix);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
    }

    private boolean listCheck(int cellRow, int cellCol, ArrayList<int[]> foundList){
        //This method looks through the found list with given coordinates and returns true if they are located within it
        boolean isFound = false;
        for(int[] innerList : foundList){
            if(innerList[0] == cellRow && innerList[1] == cellCol){
                isFound = true;
            }
        }
        return isFound;
    }
}

import java.util.ArrayList;

public class IslandScanner {
    public int getIslands(int[][] islandMatrix){
        ArrayList<int[]> foundList = new ArrayList<int[]>();
        int islandCount = 0;

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
        int[] cell = {cellRow, cellCol};
        foundList.add(cell);

        int newRow = cellRow;
        int newCol = cellCol;
        for(int i = 0; i < 4; i++){
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
        boolean isFound = false;
        for(int[] innerList : foundList){
            if(innerList[0] == cellRow && innerList[1] == cellCol){
                isFound = true;
            }
        }
        return isFound;
    }
}

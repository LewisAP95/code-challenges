import java.util.ArrayList;

public class IslandScanner {
    public int getIslands(int[][] islandMatrix){
        ArrayList<int[]> foundList = new ArrayList<int[]>();
        int islandCount = 0;

        for(int row = 0; row < islandMatrix.length; row++){
            for(int col = 0; col < islandMatrix[row].length; col++){
                if(islandMatrix[row][col] == 1){
                    boolean isFound = false;
                    for(int[] found : foundList){
                        if(found[0] == row && found[1] == col){
                            isFound = true;
                        }
                    }
                    if(!isFound){
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

        //Up
        int upDir = cellRow - 1;
        if(upDir >= 0){
            if(islandMatrix[upDir][cellCol] == 1){
                boolean isFound = false;
                for(int[] found : foundList){
                    if(found[0] == upDir && found[1] == cellCol){
                        isFound = true;
                    }
                }
                if(!isFound){
                    spreadScan(upDir, cellCol, foundList, islandMatrix);
                }
            }
        }

        //Down
        int downDir = cellRow + 1;
        if(downDir < islandMatrix.length){
            if(islandMatrix[downDir][cellCol] == 1){
                boolean isFound = false;
                for(int[] found : foundList){
                    if(found[0] == downDir && found[1] == cellCol){
                        isFound = true;
                    }
                }
                if(!isFound){
                    spreadScan(downDir, cellCol, foundList, islandMatrix);
                }
            }
        }

        //Left
        int leftDir = cellCol - 1;
        if(leftDir >= 0){
            if(islandMatrix[cellRow][leftDir] == 1){
                boolean isFound = false;
                for(int[] found : foundList){
                    if(found[0] == cellRow && found[1] == leftDir){
                        isFound = true;
                    }
                }
                if(!isFound){
                    spreadScan(cellRow, leftDir, foundList, islandMatrix);
                }
            }
        }

        //Right
        int rightDir = cellCol + 1;
        if(rightDir < islandMatrix[0].length){
            if(islandMatrix[cellRow][rightDir] == 1){
                boolean isFound = false;
                for(int[] found : foundList){
                    if(found[0] == cellRow && found[1] == rightDir){
                        isFound = true;
                    }
                }
                if(!isFound){
                    spreadScan(cellRow, rightDir, foundList, islandMatrix);
                }
            }
        }
    }
}

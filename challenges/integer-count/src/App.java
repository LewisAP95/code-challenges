//Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.
//For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

//There are two methods included here, "countInstances" being my initial attempt and "countInstancesRipple" being an attempt at a more efficient method
public class App {
    public static void main(String[] args) throws Exception {
        int[] sourceArray = {2, 4, 6, 8, 10, 2, 6, 10};

        long execStart = System.nanoTime();
        countInstances(sourceArray);
        long execEnd = System.nanoTime();
        System.out.println(String.format("Time taken for standard method: %s", execEnd - execStart));

        execStart = System.nanoTime();
        countInstancesRipple(sourceArray);
        execEnd = System.nanoTime();
        System.out.println(String.format("Time taken for 'ripple' method: %s", execEnd - execStart));
    }

    public static void countInstances(int[] sourceArray){
        //Loop through the array, make a flag to track if any duplicates have been found
        for(int i = 0; i < sourceArray.length; i++){
            boolean dupe = false;
            //Loop through it again, if a matching value is found at any point that is not the original index, raise the dupe flag
            for(int j = 0; j < sourceArray.length; j++){
                if(sourceArray[j] == sourceArray[i] && j != i){
                    dupe =  true;
                    break;
                }
            }
            //Report the value at the current index as the only instance if no dupes were found
            if(!dupe){
                System.out.println(String.format("Element '%s' appears only once in the given array.", sourceArray[i]));
            }
        }
    }

    public static void countInstancesRipple(int[] sourceArray){
        //Loop through the array, again keep a flag to track if there have been duplicates of the current number
        for(int i = 0; i < sourceArray.length; i++){
            boolean dupe = false;

            //Checks the indexes moving backwards and forwards through the array from the current index as the origin point
            //Stops checking a direction if it has reached the bounds of the array in that direction
            //Breaks the whole inner loop if a dupe is found
            //Using the current index as a starting point and moving in both directions at once should mean we find any dupes faster than the previous method
            int j = i, k = i;
            while(j > 0 || k < sourceArray.length - 1){
                if(j > 0){
                    j--;
                    if(sourceArray[j] == sourceArray[i]){
                        dupe = true;
                        break;
                    }
                }
                if(k < sourceArray.length - 1){
                    k++;
                    if(sourceArray[k] == sourceArray[i]){
                        dupe = true;
                        break;
                    }
                }
            }

            if(!dupe){
                System.out.println(String.format("Element '%s' appears only once in the given array.", sourceArray[i]));
            }
        }
    }
}

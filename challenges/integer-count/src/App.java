//Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.
//For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

public class App {
    public static void main(String[] args) throws Exception {
        int[] sourceArray = {2, 4, 6, 8, 10, 2, 6, 10};
        countInstances(sourceArray);
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
}

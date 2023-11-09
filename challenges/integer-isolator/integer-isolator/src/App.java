/* 
 * Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
 */

public class App {
    public static void main(String[] args) throws Exception {
        int[] inputArray1 = {6, 1, 3, 3, 3, 6, 6};
        int[] inputArray2 = {13, 19, 13, 13}; 
        int[] inputArray3 = {1, 1, 2, 2, 3, 3};

        System.out.println(intFinder(inputArray1));
        System.out.println(intFinder(inputArray2));
        System.out.println(intFinder(inputArray3));
    }

    public static int intFinder(int[] sourceArr){

        //Loop through the array, for each element check what's on the left and right of it (looping around if at either end of the array)
        //Because the format of the given examples implies all input will have the identical elements grouped together-
        //-we can assume if any element is found which does not have a matching integer on either side of it, it must be the isolated single integer
        for(int i = 0; i < sourceArr.length; i++){
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            if(leftIndex == -1){
                leftIndex = sourceArr.length - 1;
            }
            if(rightIndex == sourceArr.length){
                rightIndex = 0;
            }
            if((sourceArr[leftIndex] != sourceArr[i]) && (sourceArr[rightIndex] != sourceArr[i])){
                return sourceArr[i];
            }
        };
        return -1;
    }
}

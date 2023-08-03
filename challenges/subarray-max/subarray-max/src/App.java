public class App {
    /**
     * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
        For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

        10 = max(10, 5, 2)
        7 = max(5, 2, 7)
        8 = max(2, 7, 8)
        8 = max(7, 8, 7)
     */
    public static void main(String[] args) throws Exception {
        int[] exampleVals = {10, 5, 2, 7, 8, 7};
        int subArrayLength = 3;

        if(subArrayLength > 1 && subArrayLength <= exampleVals.length){
            for(int i = 0; i <= (exampleVals.length - subArrayLength); i++){
                int currentMax = exampleVals[i];
                for(int j = 1; j < subArrayLength; j++){
                    if(exampleVals[i+j] > currentMax){
                        currentMax = exampleVals[i+j];
                    }
                }
                System.out.println(currentMax);
            }
        }else{
            System.out.println("Value of k (desired sub array length to check) is outside allowed values.");
        }
    }
}

import java.util.Arrays;

public class App {
//Given two strings A and B, return whether or not A can be shifted some number of times to get B.
//For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

    public static void main(String[] args) throws Exception {
        String stringA = "abcde";
        String stringB = "cdeab";
        System.out.println("Should be true: " + scrollTest(stringA, stringB));

        stringA = "abc";
        stringB = "acb";
        System.out.println("Should be false: " + scrollTest(stringA, stringB));
    }

    public static boolean scrollTest(String stringA, String stringB){
        //Split the strings to be tested into arrays for looping through
        String[] firstString = stringA.split("");
        String[] secondString = stringB.split("");
        boolean canShift = false;

        for(int i = 0; i < firstString.length; i++){
            shiftStringArray(firstString);
            System.out.println(Arrays.toString(firstString));
            if(Arrays.equals(firstString, secondString)){
                canShift = true;
                break;
            }
        }

        return canShift;
    }

    public static void shiftStringArray(String[] arr){
        String zero = "";
        for(int i = 0; i <= arr.length - 1; i++){
            if(i == 0){
                zero = arr[0];
            }else{
                arr[i - 1] = arr[i];
            }
        }
        arr[arr.length - 1] = zero;
    }
}

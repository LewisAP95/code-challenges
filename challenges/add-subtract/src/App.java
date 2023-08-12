//Write a function which alternately adds and subtracts items in an array passed to it

public class App {
    public static void main(String[] args) throws Exception {
        int[] sourceOne = {9};
        int[] sourceTwo = {1, 2, 3};
        int[] sourceThree = {-5, 10, 3, 9};
        System.out.println(addSubtract(sourceOne));
        System.out.println(addSubtract(sourceTwo));
        System.out.println(addSubtract(sourceThree));
    }

    public static int addSubtract(int[] source){
        int result = source[0];

        boolean flip = true;
        for(int i = 1; i < source.length; i++){
            if(flip){
                result += source[i];
                flip = false;
            }else{
                result -= source[i];
                flip = true;
            }
        }

        return result;
    }
}

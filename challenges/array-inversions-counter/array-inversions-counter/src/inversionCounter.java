public class inversionCounter {
    public int[] count(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int[] arrOne = new int[arr.length/2]; 
        int[] arrTwo = new int[arr.length - arr.length/2];

        for(int i = 0; i < arr.length; i++){
            if(i < arr.length/2){
                arrOne[i] = arr[i];
            }
            else{
                arrTwo[i - arr.length/2] = arr[i];
            }
        }

        arrOne = count(arrOne);
        arrTwo = count(arrTwo);

        return merge(arrOne, arrTwo);
    }

    private int[] merge(int[] arrOne, int[] arrTwo){
        int[] mergedArr = new int[arrOne.length + arrTwo.length];

        int i = 0, o = 0, t = 0;

        while(o < arrOne.length && t < arrTwo.length){
            if(arrOne[o] < arrTwo[t]){
                mergedArr[i] = arrOne[o];
                i++;
                o++;
            }else{
                mergedArr[i] = arrTwo[t];
                i++;
                t++;
            }
        }
        while(o < arrOne.length){
            mergedArr[i] = arrOne[o];
            i++;
            o++;
        }
        while(t < arrTwo.length){
            mergedArr[i] = arrTwo[t];
            i++;
            t++;
        }
        return mergedArr;
    }
}

public class inversionCounter {
    private int inversions;

    public int count(int[] arr){
        //Reset the inversion count and then begin the process
        //Inversions are counted via performing a merge sort and counting the inverions found as it merges
        this.inversions = 0;

        split(arr);

        return this.inversions;
    }

    private int[] split(int[] arr){
        //Continually splits an input array into subarrays

        if(arr.length == 1){
            //Return the input array if it has been split as far as possible
            return arr;
        }

        //Split the input array into two parts of required size
        int midIndex = arr.length/2;
        int[] arrOne = new int[midIndex]; 
        int[] arrTwo = new int[arr.length - midIndex];

        //Populate the two new subarrays
        for(int i = 0; i < arr.length; i++){
            if(i < midIndex){
                arrOne[i] = arr[i];
            }
            else{
                arrTwo[i - midIndex] = arr[i];
            }
        }

        //Recursively split the arrays until each reaches only one element
        arrOne = split(arrOne);
        arrTwo = split(arrTwo);

        return merge(arrOne, arrTwo);
    }

    private int[] merge(int[] arrOne, int[] arrTwo){
        //Merges two input arrays and counts any inversions found as it goes

        int[] mergedArr = new int[arrOne.length + arrTwo.length];

        //Sets up three counters to track the current positions within both subarrays and the resulting merged array
        int mergedPos = 0, onePos = 0, twoPos = 0;

        //Loops as long as there are still elements in both arrays to move across
        while(onePos < arrOne.length && twoPos < arrTwo.length){
            if(arrOne[onePos] < arrTwo[twoPos]){
                mergedArr[mergedPos] = arrOne[onePos];
                mergedPos++;
                onePos++;
            }else{
                mergedArr[mergedPos] = arrTwo[twoPos];
                //Because each subarray in a step of the merge has already been sorted, whenever something in the second array
                //is less than something in the first, it's also then going to be less than anything to the right of whatever
                //element in the first array it's being compared to, so we use the number of said elements to count the inversions
                this.inversions += arrOne.length - onePos;
                mergedPos++;
                twoPos++;
            }
        }
        //Since one subarray will always be longer than the other, secondary loops are needed to merge in whatever elements remain
        while(onePos < arrOne.length){
            mergedArr[mergedPos] = arrOne[onePos];
            mergedPos++;
            onePos++;
        }
        while(twoPos < arrTwo.length){
            mergedArr[mergedPos] = arrTwo[twoPos];
            mergedPos++;
            twoPos++;
        }
        
        return mergedArr;
    }
}

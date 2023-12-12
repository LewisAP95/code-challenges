public class BitArray{
    private int[] array;

    public BitArray(int size){
        //Only initiliases the array with the new size if the value is valid
        if(size > 0 && size <= Integer.MAX_VALUE){
            array = new int[size];
        }
    }

    public void set(int index, int value){
        //Sets the value at the given index only if the index is valid and the value is 0 or 1
        if((value == 0 || value == 1) && (index >= 0 && index < array.length)){
            array[index] = value;
        }
    }

    public int get(int index){
        //Checks for a valid index value first, then returns the value at that index
        //Returns -1 as an error code if the provided index would have been out of the bounds of the array
        if(index >= 0 && index < array.length){
            return array[index];
        }
        else{
            return -1;
        }
    }
}
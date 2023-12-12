/*
 * Implement a bit array. A bit array is a space efficient array that holds a value of 1 or 0 at each index.
    init(size): initialize the array with size
    set(i, val): updates index at i with val where val is either 1 or 0.
    get(i): gets the value at index i.
 */

public class App {
    public static void main(String[] args) throws Exception {
        int size = 10;
        BitArray bitArr = new BitArray(10);
        bitArr.set(0, 1);
        bitArr.set(9, 1);
        bitArr.set(1, 1);
        bitArr.set(1, 0);
        for(int i = 0; i < size; i++){
            System.out.println(bitArr.get(i));
        }
    }
}

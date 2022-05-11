import java.util.Arrays;

public class ShiftingNumbers {

//    The problem we would like you to solve deals with an array of integers.
//    We want to rotate these integers to a specified number of positions to the left.
//    If for example you have an array of integers [1,2,3,4,5,6,7]
//    and we would like to rotate 2 positions to the left, the solution expected would be [3,4,5,6,7,1,2].
//    Note: the solution should be able to handle
//    a position value greater than the number of integers in the array.
//    If, for example, we would like to rotate [1,2,3,4,5,6,7] 8 positions to left,
//    it would produce the result [2,3,4,5,6,7,1].
//    Negative values for the positions to rotate will throw an error which the code example should handle gracefully.

    private static int[] shiftingNumbers(int[] array, int n) {

        if (n == 0 || n < 0 || array.length == 0) {
            return null;
        } else {
            if (n > array.length) {
                n = n % array.length;
            }
        }

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i < n) {
                result[result.length + i - n] = array[i];
            } else {
                result[i - n] = array[i];
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(result));
        return array;
    }

    public static void main(String[] args) {
        shiftingNumbers(new int[] {1,2,3,4,5,6,7}, 2);
        shiftingNumbers(new int[] {1,2,3,4,5,6,7}, 8);
        shiftingNumbers(new int[] {1,2,3,4,5,6,7}, -258);
    }
}

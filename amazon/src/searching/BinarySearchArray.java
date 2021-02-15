package searching;

import java.util.Arrays;

public class BinarySearchArray {

    public static boolean arrayContains(int[] array, int target){

        if(array == null || array.length == 0)
            return false;

        int middlePoint = array.length > 1 ? array.length / 2 : 0;
        int middleValue = array[middlePoint];

        if(middleValue == target)
            return true;

        else if (middleValue < target){
            int[] newArray = Arrays.copyOfRange(array, middlePoint + 1, array.length);
            return arrayContains(newArray, target);
        } else {
            int[] newArray = Arrays.copyOfRange(array, 0, middlePoint);
            return arrayContains(newArray, target);
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4 , 5, 420, 1337, 1520};
        System.out.println(arrayContains(array, 3));
        System.out.println(arrayContains(array, 5));
        System.out.println(arrayContains(array, 97));
        System.out.println(arrayContains(array, 1338));
        System.out.println(arrayContains(array, 1337));
    }
}

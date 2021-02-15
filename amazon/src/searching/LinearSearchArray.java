package searching;

public class LinearSearchArray {

    public static boolean arrayContains(int[] array, int target){
        if(array == null || array.length == 0)
            return false;

        for(int i = 0; i < array.length; i++){
            if(array[i] == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4 , 5};
        System.out.println(arrayContains(array, 3));
        System.out.println(arrayContains(array, 97));
    }
}

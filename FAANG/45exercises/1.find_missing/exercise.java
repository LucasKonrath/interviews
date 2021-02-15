class Solution {
    public int missingNumber(final int[] integerArray) {

        final int expectedSum = new Double((
            (integerArray.length + 1) / 2.0)
            * integerArray.length).intValue();

        int totalSum = 0;

        for (int i = 0; i < integerArray.length; i++) {
            totalSum += integerArray[i];
        }

        return expectedSum - totalSum;
    }
}
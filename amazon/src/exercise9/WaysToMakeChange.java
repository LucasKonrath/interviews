package exercise9;

public class WaysToMakeChange {

    /**
     * 9. How many ways can you make change with coins and a total amount
     * Suppose we have coin denominations of [1, 2, 5] and the total amount is 7. We can make changes in the following 6 ways:
     * @param denominations
     * @param amount
     * @return
     */
    int solveCoinChange(int[] denominations, int amount){
        int[] solutions = new int[amount + 1];
        solutions[0] = 1;

        for(int denomination : denominations){
            for(int i = denomination; i < solutions.length; i++){
                solutions[i] += solutions[i - denomination];
            }
        }

        return solutions[amount];
    }

    public static void main(String[] args) {
        WaysToMakeChange ways = new WaysToMakeChange();
        System.out.println(ways.solveCoinChange(new int[]{1, 2, 5}, 123));
    }
}

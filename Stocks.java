/*
    Time Complexity: O(N^2)
    Space Complexity: O(1)

    Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution {
    public static int maximumProfit(ArrayList<Integer> prices) {

        // Variable to store the maximum profit.
        int maxProfit = 0;
        int n = prices.size();

        for (int i = 0; i < n - 1; i++) {

            int buy = prices.get(i), curMaxProfit = 0;

			for (int j = i + 1; j < n; j++) {
                curMaxProfit = Math.max(curMaxProfit, (prices.get(j) - buy));
            }

            maxProfit = Math.max(maxProfit, curMaxProfit);
        }

        return maxProfit;
    }
}
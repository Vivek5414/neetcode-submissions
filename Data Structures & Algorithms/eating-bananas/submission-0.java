class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find the maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            long hours = 0;

            // Calculate hours needed at speed k
            for (int pile : piles) {
                hours += (pile + k - 1) / k;

                // No need to continue if already exceeding h
                if (hours > h) {
                    break;
                }
            }

            if (hours <= h) {
                // k works, try a smaller speed
                answer = k;
                right = k - 1;
            } else {
                // k is too slow, increase speed
                left = k + 1;
            }
        }

        return answer;
    }
}
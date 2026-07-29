class Solution {
    public int longestConsecutive(int[] nums) {

        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        // Add all numbers to the set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Check if it is the start of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
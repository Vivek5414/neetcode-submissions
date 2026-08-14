class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frequency of characters required from t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int required = need.size();

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int resultLeft = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add current character to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If frequency requirement is satisfied
            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // Window is valid
            while (have == required) {

                // Update minimum answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resultLeft = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                // If removing it makes window invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resultLeft, resultLeft + minLen);
    }
}
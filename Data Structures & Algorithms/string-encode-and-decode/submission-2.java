
class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            // Find the delimiter '#'
            while (j < s.length() && s.charAt(j) != '#') {
                j++;
            }

            if (j >= s.length()) break;

            int len = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            String str = s.substring(i, i + len);

            result.add(str);
            i += len;
        }

        return result;
    }
}
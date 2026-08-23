
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store {position, speed}
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position: closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {

            double time = (double) (target - car[0]) / car[1];

            // New fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

            // Otherwise this car joins the fleet ahead
        }

        return stack.size();
    }
}
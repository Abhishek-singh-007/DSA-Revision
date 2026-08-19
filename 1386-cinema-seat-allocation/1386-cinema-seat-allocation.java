class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> rows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                rows.put(row, rows.getOrDefault(row, 0) | (1 << col));
            }
        }

        int answer = 2 * (n - rows.size());

        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : rows.values()) {
            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                answer += 2;
            }
            else if (canLeft || canMiddle || canRight) {
                answer += 1;
            }
        }

        return answer;
    }
}
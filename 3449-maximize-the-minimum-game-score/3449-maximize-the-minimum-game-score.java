class Solution {

    private boolean possible(long target, int[] points, int M) {

        long moves = 0;
        long extra = 0;
        long bonus = 0;

        for (int p : points) {

            long required = (target + p - 1L) / p;

            if (extra >= required) {

                extra = 0;
                bonus++;

            } else {

                long need = required - extra;

                moves += 2 * need - 1 + bonus;

                extra = need - 1;
                bonus = 0;
            }

            if (moves > M) {
                return false;
            }
        }

        return true;
    }

    public long maxScore(int[] points, int M) {

        if (M < points.length) {
            return 0;
        }

        long low = 1;
        long high = (long) 1e18;
        long ans = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (possible(mid, points, M)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return ans;
    }
}
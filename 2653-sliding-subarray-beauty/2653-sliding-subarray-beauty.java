class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            // add current element (only if negative)
            if (nums[i] < 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            // remove element outside window
            if (i >= k) {
                int out = nums[i - k];
                if (out < 0) {
                    map.put(out, map.get(out) - 1);
                    if (map.get(out) == 0) {
                        map.remove(out);
                    }
                }
            }

            // compute answer
            if (i >= k - 1) {
                int count = 0;
                int beauty = 0;

                for (int key : map.keySet()) {
                    count += map.get(key);

                    if (count >= x) {
                        beauty = key;
                        break;
                    }
                }

                res[i - k + 1] = beauty;
            }
        }

        return res;
    }
}
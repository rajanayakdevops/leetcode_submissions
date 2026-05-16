class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for (int val : nums) {
            set.add(val);
        }

        List<Integer> list = new ArrayList<>(set);

        if (list.size() < 3) {
            return list.get(list.size() - 1); // largest element
        }

        return list.get(list.size() - 3);
    }
}
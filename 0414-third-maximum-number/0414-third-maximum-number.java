// class Solution {
//     public int thirdMax(int[] nums) {
//         Set<Integer> set = new TreeSet<>();

//         for (int val : nums) {
//             set.add(val);
//         }

//         List<Integer> list = new ArrayList<>(set);

//         if (list.size() < 3) {
//             return list.get(list.size() - 1); // largest element
//         }

//         return list.get(list.size() - 3);
//     }
// }

class Solution {
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;

        for (int n : nums) {
            long val = n;

            // skip duplicates
            if ((first != null && val == first) ||
                (second != null && val == second) ||
                (third != null && val == third)) {
                continue;
            }

            if (first == null || val > first) {
                third = second;
                second = first;
                first = val;
            } 
            else if (second == null || val > second) {
                third = second;
                second = val;
            } 
            else if (third == null || val > third) {
                third = val;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
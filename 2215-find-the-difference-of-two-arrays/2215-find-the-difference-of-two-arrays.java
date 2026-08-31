class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (int x : set1) {
            if (!set2.contains(x)) {
                ans1.add(x);
            }
        }
        for (int x : set2) {
            if (!set1.contains(x)) {
                ans2.add(x);
            }
        }
        return Arrays.asList(ans1, ans2);
    }
}
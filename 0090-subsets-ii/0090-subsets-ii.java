class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, ans, new ArrayList<>());

        return ans;
    }

    void backtrack(int idx, int[] nums,
                   List<List<Integer>> ans,
                   List<Integer> ds) {

        ans.add(new ArrayList<>(ds));

        for (int i = idx; i < nums.length; i++) {

            // Skip duplicate choices at the same level
            if (i > idx && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);

            backtrack(i + 1, nums, ans, ds);

            ds.remove(ds.size() - 1);
        }
    }
}
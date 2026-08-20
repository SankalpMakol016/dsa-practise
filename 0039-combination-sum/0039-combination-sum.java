class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subans =new ArrayList<>();
        int n = candidates.length;
        int idx=0;
        int sum=0;
        func(idx, sum, candidates, target, ans, subans, n);
        return ans;
    }

    void func(int idx, int sum ,int[] candidates, int target,List<List<Integer>> ans,List<Integer> subans,int n){
        if(idx>=n){
            if(sum==target){
                ans.add(new ArrayList<>(subans));
                return;
            }
            return;
        }
        if(sum>target){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(subans));
            return;
        }

        subans.add(candidates[idx]);
        sum+=candidates[idx];
        func(idx, sum, candidates, target, ans, subans, n);

        sum-=subans.get(subans.size()-1);
        subans.remove(subans.size()-1);
        func(idx+1, sum, candidates, target, ans, subans, n);

    }
}
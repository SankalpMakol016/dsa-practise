class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            max = Math.max(max, candies[i]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            int candy = candies[i]+extraCandies;
            result.add(candy>=max);
        }
        return result;
    }
}
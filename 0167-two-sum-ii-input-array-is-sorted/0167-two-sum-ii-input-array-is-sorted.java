class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int one=0 ;
        int two = numbers.length -1;
        while(one<two && one<numbers.length && two<numbers.length){
            if(numbers[one]+numbers[two]==target){
                return new int[] {one + 1, two + 1};
            }else if(numbers[one]+numbers[two]< target){
                one++;
            }else{
                two--;
            }
        }
        return new int[] {0,0};
    }
}
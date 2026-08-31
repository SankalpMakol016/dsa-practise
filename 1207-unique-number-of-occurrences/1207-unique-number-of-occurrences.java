class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            if(map.containsKey(x)){
                int count = map.get(x);
                map.put(x, count+1);
            }else{
                map.put(x,1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int x : map.keySet()){
            if(!set.contains(map.get(x))){
                set.add(map.get(x));
            }else{
                return false;
            }
        }
        return true;
    }
}
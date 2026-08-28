class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            int idx = c - 'a';
            freq[idx]++;
        }
        for(char c : t.toCharArray()){
            int idx = c - 'a';
            freq[idx]--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        

        return true;
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        int k=s.length();
        int n=t.length();
        while(i<n && j<k){
            if(t.charAt(i)==s.charAt(j)){
                
                j++;
            }
            i++;
        }
        return j>=k;
    }
}
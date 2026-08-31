class Solution {
    public int compress(char[] chars) {
        int i=0;
        int k=0;
        while(i<chars.length){
            int j =i;
            while(j<chars.length && chars[j]== chars[i]){
                j++;
            }
            int count = j-i;
            chars[k++]=chars[i];
            if(count>1){
                String s = String.valueOf(count);
                for(char c : s.toCharArray()){
                    chars[k++] = c;
                }
            }
            i=j;
        }
        return k;
    }
}
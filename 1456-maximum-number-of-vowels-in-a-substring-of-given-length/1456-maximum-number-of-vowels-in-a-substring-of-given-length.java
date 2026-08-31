class Solution {
    public int maxVowels(String s, int k) {
        int vowel = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<k;i++){
            if(isVowel(arr[i])) vowel++;
        }

        int maxi = vowel;
        for(int i=k ; i<arr.length ; i++){
            if(isVowel(arr[i-k])) vowel--;
            if(isVowel(arr[i])) vowel++;

            maxi = Math.max(maxi, vowel);
        }
        return maxi;
        
    }

    boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}
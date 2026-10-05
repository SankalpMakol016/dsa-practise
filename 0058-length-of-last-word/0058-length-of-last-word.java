class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        int length = words.length;
        return words[length-1].length();
    }
}
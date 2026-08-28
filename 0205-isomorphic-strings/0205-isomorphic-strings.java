class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapST.containsKey(a) && mapST.get(a) != b) {
                return false;
            }
            if (mapTS.containsKey(b) && mapTS.get(b) != a) {
                return false;
            }
            mapST.put(a, b);
            mapTS.put(b, a);
            i++;
        }
        return true;
    }
}
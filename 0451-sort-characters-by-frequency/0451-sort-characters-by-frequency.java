class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int n = map.get(c);
                map.put(c, n + 1);
            } else {
                map.put(c, 1);
            }
            i++;
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a));
        for (char c : chars) {
            int freq = map.get(c);
            while (freq > 0) {
                sb.append(c);
                freq--;
            }
        }
        return sb.toString();
    }
}
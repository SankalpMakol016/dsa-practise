class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        int num = 0;
        String curr = "";
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[') {
                nums.push(num);
                strs.push(curr);
                num = 0;
                curr = "";
            }
            else if (ch == ']') {
                int repeat = nums.pop();
                String prev = strs.pop();
                curr = prev + curr.repeat(repeat);
            }
            else {
                curr += ch;
            }
        }
        return curr;
    }
}
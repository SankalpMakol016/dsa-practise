class Solution {
    public boolean isValid(String s) {
    char[] str = s.toCharArray();
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < str.length; i++) {

        if (str[i] == '[' || str[i] == '(' || str[i] == '{') {
            st.push(str[i]);
        } else {

            if (st.isEmpty()) {
                return false;
            }

            char ch = st.pop();

            if (str[i] == ')' && ch == '(') {
                continue;
            } else if (str[i] == '}' && ch == '{') {
                continue;
            } else if (str[i] == ']' && ch == '[') {
                continue;
            } else {
                return false;
            }
        }
    }

    return st.isEmpty();
}
}
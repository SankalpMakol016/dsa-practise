class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }

        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }
        String ans = sb.substring(i);

        return ans.isEmpty() ? "0" : ans; 

    }
}
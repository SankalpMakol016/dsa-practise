class Solution {
    public int myAtoi(String s) {
        int result = 0;
        int i = 0;
        int signal = 1;
        // 1. Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // 2. Check sign
        if (i < s.length() && s.charAt(i) == '-') {
            signal = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        // 3. Process digits
        while (i < s.length() &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            // 4. Overflow check
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10)) {
                return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * signal;
    }
}
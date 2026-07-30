class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        if (st.isEmpty()) {
            min = value;
            st.push((long) value);
        } else {
            if (value >= min) {
                st.push((long) value);
            } else {
                st.push(2L * value - min);
                min = value;
            }
        }
    }

    public void pop() {
        long val = st.pop();

        if (val < min) {
            min = 2 * min - val;
        }
    }

    public int top() {
        long val = st.peek();

        if (val < min)
            return (int) min;

        return (int) val;
    }

    public int getMin() {
        return (int) min;
    }
}
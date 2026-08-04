class StockSpanner {

    static class Pair {
        int price;
        int idx;

        Pair(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }

    Stack<Pair> st;
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }

    public int next(int price) {

        while (!st.isEmpty() && st.peek().price <= price) {
            st.pop();
        }

        int span;
        if (st.isEmpty()) {
            span = index + 1;
        } else {
            span = index - st.peek().idx;
        }

        st.push(new Pair(price, index));
        index++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
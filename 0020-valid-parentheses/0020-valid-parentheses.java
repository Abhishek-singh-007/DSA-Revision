class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (sc == '(' || sc == '[' || sc == '{') {
                st.push(sc);
            } else if (sc == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (sc == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (sc == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if (st.size() > 0) return false;
        else return true;
    }
}
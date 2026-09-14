class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if("+".equals(s)){
                st.push(st.pop()+st.pop());
            }
            else if("-".equals(s)){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1-v2);
            }
            else if("*".equals(s)){
                st.push(st.pop()*st.pop());
            }
            else if("/".equals(s)){
                int v2=st.pop();
                int v1=st.pop();
                st.push(v1/v2);
            }
            else{
                st.push(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}
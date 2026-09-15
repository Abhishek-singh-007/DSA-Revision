class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack();
        int ans=0,num=0,sign=1;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
                num=num*10+(int)(c-'0');
            else if(c=='+'){
                ans+=sign*num;
                num=0;
                sign=1;
            }
            else if(c=='-'){
                ans+=sign*num;
                num=0;
                sign=-1;              
            }
            else if(c=='('){
                st.push(ans);
                st.push(sign);
                sign=1;
                ans=0;
            }
            else if(c==')'){
                ans+=sign*num;
                num=0;
                ans*=st.pop();
                ans+=st.pop();
            }
        }
        if(num!=0)
            ans+=sign*num;
        return ans;
    }
}
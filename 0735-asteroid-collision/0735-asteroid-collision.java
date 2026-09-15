class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack<>();
        for(int a : asteroids){
            // if positive came then we have to push only
            if(a > 0){
                st.push(a);
            }
            // condition for if negative element came 
            else{
                // condition if negative element is bigger than peek element
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a)){
                    
                    st.pop();
                }
                // codition for peek element is also negative
                if(st.isEmpty() || st.peek() < 0){
                    st.push(a);
                }
                // condition for same element came with different sign
                else if (st.peek() + a == 0){
                    st.pop();
                }
            }
        }
        // we have to return a array of our proceed answer
        int[] res=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            res[i--] = st.peek();
            st.pop();
        }
        return res;
    }
}
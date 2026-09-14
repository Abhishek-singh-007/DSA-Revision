class MinStack {
    Stack <Long> st = new Stack<>();
    long min=-1;
    public MinStack() {
        // constructor
    }
    public void push(int val) {
        long x = (long)val;
        if(st.size() == 0){
            st.push(x);
            min=x;
        }
       else if(x>=min){
           st.push(x);
       }
       else if(x<min){
           st.push(2*x-min);
           min=x;
       }
    }
    public void pop() {
          if(st.size() == 0) return;
          else if(st.peek()>=min) st.pop();
          else if(st.peek()<min){  // fake value
          // restore the old min
          long old=2*min - st.peek();
          min=old;
          st.pop();
          }
    }
    public int top() {
          if(st.size() == 0) return -1;
          long q= st.peek();
          if(q>=min) return (int)(q);
          if(q< min) return (int) min;
          return 0;
    }
    public int getMin() {
         if(st.size() == 0) return -1;
         return (int)min;
    }
}
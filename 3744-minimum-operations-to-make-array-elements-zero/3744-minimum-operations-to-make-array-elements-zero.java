class Solution {
    static long expSum4[]=new long[18];
    static long expSum(int x){
        if (x==0) return 0;
        int log4=(31-Integer.numberOfLeadingZeros(x))>>1;
        int r=x-(1<<(log4<<1));
        return expSum4[log4]+r*(log4+1L);
    }
    static public long minOperations(int[][] queries) {
        expSum4[0]=1;
        for(int i=1; i<18; i++)
            expSum4[i]=expSum4[i-1]+3L*i*(1L<<(2*(i-1)))+1;
        long op=0;
        for(int[] q : queries){
            int l=q[0]-1, r=q[1];
            op+=(expSum(r)-expSum(l)+1)>>1;// ceiling of (expSum(r)-expSum(l))/2
        }
        return op;
    }
}
class Solution {
    public boolean checkDivisibility(int n) {
        int original=n;
        int sum=0;
        int pro=1;
        while(n>0){
            int digit=n%10;
            sum+=digit;
            pro*=digit;
            n=n/10;
        }
        int a=sum+pro;
        if(original%a==0)return true;
        return false;
    }
}
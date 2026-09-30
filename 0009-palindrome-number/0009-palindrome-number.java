class Solution {
    public int rev(int x){
        int rev=0;
        while(x!=0){
            int dig=x%10;
            rev=rev*10+dig;
            x=x/10;
        }
        return rev;
    }
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(rev(x)==x)return true;
        else return false;
    }
}
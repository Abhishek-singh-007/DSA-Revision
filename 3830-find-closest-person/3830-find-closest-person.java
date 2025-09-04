class Solution {
    public int findClosest(int x, int y, int z) {
        if(z!=0 && x==y)return 0;
        int a = Math.abs(z-x);
        int b=Math.abs(z-y);
        if(a <b) return 1;
        else if(a==b)return 0;
        
        else return 2;
    }
}
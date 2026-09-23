class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        String[] split = str.split(" ");
        String last=split[split.length-1]; // world
        int cnt=0;
        return last.length();
    }
}
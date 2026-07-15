class Solution {
    public boolean isPalindrome(String str) {
        String a = str.toLowerCase();
        int start=0;
        int end=str.length()-1;
        while(start<=end){
            char s=a.charAt(start);
            char e=a.charAt(end);
            if(!Character.isLetterOrDigit(s)){
                start++;
            }else if(!Character.isLetterOrDigit(e)){
                end--;
            }else{
                if(s!=e)return false;
                start++;
                end--;
            } 
        }
        return true;
    }
}
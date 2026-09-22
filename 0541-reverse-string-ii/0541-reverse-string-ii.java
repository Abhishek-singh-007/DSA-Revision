class Solution {
    public String reverseStr(String s, int k) {

        int step = k * 2;
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i += step){

            int start = i;
            int end = Math.min(i + k - 1, arr.length - 1);

            while(start < end){

                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        return new String(arr);
    }
}
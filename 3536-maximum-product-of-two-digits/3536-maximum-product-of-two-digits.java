class Solution {
    public int maxProduct(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int[] arr = new int[ch.length];

        for (int i = 0; i < ch.length; i++) {
            arr[i] = ch[i] - '0';
        }
        Arrays.sort(arr);
        int left = 0;
int right = arr.length - 1;

while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
}
return arr[0]*arr[1];
    }
}
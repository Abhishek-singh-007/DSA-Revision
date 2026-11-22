class Solution {
    public boolean checkString(String s) {
        return IntStream.range(1, s.length()).allMatch(i -> s.charAt(i - 1) <= s.charAt(i));
    }
}
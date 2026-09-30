class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        int currentGroup = 1;

        for (int index = 0; index < seq.length(); index++) {
            char bracket = seq.charAt(index);

            if (bracket == '(') {
                answer[index] = 1 - currentGroup;
            } else {
                answer[index] = currentGroup;
            }

            currentGroup ^= 1;
        }

        return answer;
    }
}
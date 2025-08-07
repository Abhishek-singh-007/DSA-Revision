class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] candidates, int start, int target, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;

            temp.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], temp);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }
}
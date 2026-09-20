class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> s1=new HashSet<>();
        HashSet<Integer> s2=new HashSet<>();
        for(int num : nums1){
            s1.add(num);   // s1 = [1 2 3]
        }
        for(int num:nums2){
            s2.add(num);   // s2 = [2 4 6]
        }
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        for(int num : s1){
            if(!s2.contains(num)){
                ans1.add(num);
            }
        }
        for(int num : s2){
            if(!s1.contains(num)){
                ans2.add(num);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(ans1);
        res.add(ans2);
        return res;
    }
}
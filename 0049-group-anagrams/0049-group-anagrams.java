class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!mp.containsKey(sortedWord)){
                mp.put(sortedWord, new ArrayList<>());
            }
            mp.get(sortedWord).add(word);
        }
        return new ArrayList<>(mp.values());
    }
}
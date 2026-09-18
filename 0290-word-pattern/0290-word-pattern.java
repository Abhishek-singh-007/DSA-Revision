class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> mp = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (mp.containsKey(ch)) {

                if (!mp.get(ch).equals(word)) {
                    return false;
                }

            } else if (mp.containsValue(word)) {

                return false;

            } else {

                mp.put(ch, word);
            }
        }

        return true;
    }
}
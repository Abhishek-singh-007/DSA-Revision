class Solution {
    public String isPossible(int n, int[] freqIn, String cur, char mid, String target){
        int[] freq = freqIn.clone(); // copy

        // build the largest possible arrangement of remaining chars (descending order)
        for(int i=25; i>=0; i--){
            while(freq[i] > 0){
                cur += (char)('a'+i);
                freq[i]--;
            }
        }

        if(mid!='#'){
            // odd-length palindrome: left half + mid + reverse(left half)
            String temp = cur;
            cur += mid;
            temp = new StringBuilder(temp).reverse().toString();
            cur += temp;
        }
        else {
            // even-length palindrome: left half + reverse(left half)
            String temp = cur;
            temp = new StringBuilder(temp).reverse().toString();
            cur += temp;
        }

        // feasibility check: only valid if this (largest possible) candidate beats target
        return cur.compareTo(target) > 0 ? cur : "";
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        if(n==1){
            if(s.compareTo(target) > 0) return s;
            else return "";
        }

        for(char c : s.toCharArray())
            freq[c-'a']++;

        char mid = '#';
        int oddCount = 0;

        for(int i=0; i<26; i++){
            if(freq[i]%2 != 0){
                // odd count -> this becomes the middle character
                mid = (char)('a'+i);
                freq[i]--;
                oddCount++;
            }

            freq[i] /= 2; // each char used freq[i]/2 times in the left half

            if(oddCount>=2) return ""; // more than one odd-frequency char -> can't form a palindrome
        }

        n /= 2; // we only need to construct the left half now

        String res = "", prefix = "";

        // greedily build the left half, position by position
        for(int i=0; i<n; i++){

            String cur = prefix;
            boolean isThereAny = false;

            // try smallest character first ('a' -> 'z')
            for(int j=0; j<26; j++){

                if(freq[j] > 0){

                    freq[j]--;
                    cur += (char)('a'+j);

                    // check if this prefix can still lead to a palindrome > target
                    String isPos = isPossible(n, freq, cur, mid, target);

                    if(!isPos.equals("")){
                        prefix = cur;      // keep this character, lock in the prefix
                        isThereAny = true;

                        if(res.equals(""))
                            res = isPos;
                        else
                            res = res.compareTo(isPos) < 0 ? res : isPos; // track smallest valid candidate

                        break;
                    }

                    // this character doesn't work, undo and try the next one
                    freq[j]++;
                    cur = cur.substring(0, cur.length()-1);
                }
            }

            if(!isThereAny)
                return ""; // no character works at this position -> impossible
        }

        return res; 
    }
}
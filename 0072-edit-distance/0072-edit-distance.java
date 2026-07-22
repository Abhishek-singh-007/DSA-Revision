class Solution {
    int solve(String word1, String word2,int i, int j){
        // base case
        if(i == word1.length()) return word2.length() - j;
        if(j == word2.length()) return word1.length() - i;

        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            return solve(word1,word2,i+1,j+1);
        }else{
            // insert
            int insertans = 1 + solve(word1,word2,i,j+1);
            // delete
            int deleteans = 1 +  solve(word1,word2,i+1,j);
            // replace
            int replaceans = 1 + solve(word1,word2,i+1,j+1);
            ans = Math.min(insertans, Math.min(deleteans,replaceans));
        }
        return ans;
    }
    int solvememo(String word1, String word2,int i, int j,int[][] dp){
        // base case
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            return ans = solvememo(word1,word2,i+1,j+1,dp);
        }else{
            int insert = 1+solvememo(word1,word2,i,j+1,dp);
            int delete = 1+solvememo(word1,word2,i+1,j,dp);
            int replace = 1+solvememo(word1,word2,i+1,j+1,dp);
            ans = Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
       // return solve(word1, word2, 0, 0);
       int [][] dp = new int[word1.length() + 1][word2.length() + 1];
       for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solvememo(word1,word2,0,0,dp);
    }
}
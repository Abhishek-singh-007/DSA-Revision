/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s=0, e=n;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(guess(mid)==1){
               s=mid+1;
            }else if(guess(mid)==0){
                return mid;
            }else{
                e=mid-1;
            }
        }
        return 0;
    }
}
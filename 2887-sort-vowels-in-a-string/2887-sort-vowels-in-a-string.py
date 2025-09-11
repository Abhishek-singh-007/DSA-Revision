class Solution:
    def sortVowels(self, s: str) -> str:
        freq=Counter(s)
        vowel='AEIOUaeiou'
        count, v, j=0, freq['A'], 0
        s=list(s)
        for i, c in enumerate(s):
            if ((0x208222>>(ord(c)&31))&1)==0: continue
            while count>=v:
                j+=1
                v+=freq[vowel[j]]
            s[i]=vowel[j]
            count+=1
        return "".join(s)
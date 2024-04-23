class Solution {
    public int characterReplacement(String s, int k) {
        int[] alpha = new int[26]; //we use this to track every occurance of every letter
        int len = s.length();
        int left = 0;
        int max = 0; //we use this to track the most repeated letter
        int right = 0;
        k--; //we lower k by one just because
        for(; right <len; right++){
            alpha[s.charAt(right) - 'A']++;
            max = Math.max(max, alpha[s.charAt(right) - 'A']);

            if((right - left- max) > k){ //if the distance between the right pointer and the left pointer minus max is greater than k, then we have too many differing characters and we have to up the left pointer
                alpha[s.charAt(left++) - 'A']--; 
            }
        }
        return(len - left);       
    }
}

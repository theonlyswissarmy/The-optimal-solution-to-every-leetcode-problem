class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        StringBuilder teststring = new StringBuilder();
        char[] chararr = s.toCharArray();
        int leng = chararr.length;
        for(int i = 0; i < leng; i++){
            if(teststring.indexOf(String.valueOf(chararr[i])) != -1){
                teststring.delete(0, teststring.indexOf(String.valueOf(chararr[i]))+1);
                teststring.append(chararr[i]);
            }else{
                teststring.append(chararr[i]);
            }
            if(teststring.length()>len){
                len = teststring.length();
            }
        }
        if(leng > 0 && len == 0){
            return leng;
        }
        return len; 
    }
}

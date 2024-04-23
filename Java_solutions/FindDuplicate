//this one really sucked, the tortice and the hare isn't the easiest to understand at first glance

class Solution {
    public int findDuplicate(int[] nums) {

        int lp = nums[0];
        int lpp = lp;

        for (int i = 0; i < 100000; i++){ //i is our left pointer
            lp = nums[lp];
            lpp = nums[lpp];
            lpp = nums[lpp];
            if(lp == lpp){
                break;
            }
        }
        lp = nums[0];
        while (lp != lpp){
            lp = nums[lp];
            lpp = nums[lpp];
        }
        return lp;
    }
}

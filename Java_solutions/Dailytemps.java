class Solution {
    public int[] dailyTemperatures(int[] temperatures){
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                results[index] = i-index;
            }
            stack.push(i);
        }
        return results;
    }
}

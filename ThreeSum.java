class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int curr = nums[i] + nums[left] + nums[right];
                if(curr<sum){
                    left++;
                }else if(curr>sum){
                    right--;
                }else{
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                  
                    res.add(temp);
                    while(left<nums.length-1 && nums[left]==nums[left+1])
                        left++;
                    while(right>0 && nums[right]==nums[right-1])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
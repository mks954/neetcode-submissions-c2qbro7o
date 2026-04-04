class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if(nums.length > 0){
            ans = 1;
        }else{
            return 0;
        }
        // ans = 1
        Set<Integer> numset = new HashSet<>();
        for(int ele: nums){
            numset.add(ele);
        }
        // 2 , 20 , 4 , 10 , 3 , 4 , 5
        Iterator<Integer> it = numset.iterator();
        int maxelement = Collections.max(numset);
        // 20
        while(it.hasNext()){
            // at 2
            int temp = 1;
            int curr = it.next();
            // i -> 1 to 18 at 1st loop
            for(int i = 1; i <= maxelement - curr; i++ ){
                // 3 present -> temp = 2 , 4 present -> temp = 3
                // 5 present -> temp = 4
                // 6 absent -> temp = 4
                // mistake: if not contains then break; at 6
                if(numset.contains(curr+i)){
                    temp++;
                } else{
                    break;
                }
            }
            if(temp>ans){
                ans = temp;
            }
        }
        return ans;
    }
}

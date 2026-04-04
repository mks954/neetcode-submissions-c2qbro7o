class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        // so atleast 2 elements
        int ans = 1;
        Set<Integer> numset = new TreeSet<>();
        // [0,3,2,5,4,6,1,1]
        for(int ele: nums){
            numset.add(ele);
        }
        // [0, 1, 2, 3, 4, 5, 6]
        Iterator<Integer> it1 = numset.iterator();
        int temp = 1;
        // temp = 1 , before 0 ->  it1
        // at 0 ->it2
        Iterator<Integer> it2 = numset.iterator();
        it2.next();
        while(it1.hasNext() && it2.hasNext()){
            int first = it1.next(); // 0,1
            int second = it2.next(); // 1,, 5 , 10, 20
            if(second-first ==1){
                temp++; //2, 3,  4
            }else{
                if(temp>ans){  // 4>1
                    ans = temp; // 4 = ans
                }
                temp = 1;
            }
        }
        if(temp>ans) ans = temp;
        return ans;
    }
}

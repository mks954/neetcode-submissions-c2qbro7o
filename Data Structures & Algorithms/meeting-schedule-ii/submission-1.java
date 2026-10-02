/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->{
            if(a.start == b.start){
                return a.end - b.end;
            }
            return a.start-b.start;
        }
        );
        for(Interval meeting_sch: intervals){
            pq.add(new Interval(meeting_sch.start, 1));
            pq.add(new Interval(meeting_sch.end, -1));
        }
        int ans = 0;
        int count = 0;
        while(!pq.isEmpty()){
            Interval curr = pq.poll();
            if(curr.end == 1){
                count++;
            }else{
                count--;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}

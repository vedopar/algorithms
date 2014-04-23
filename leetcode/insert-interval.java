/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    /*
    * This way is in-place.
    */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval==null) return intervals;
        if(intervals==null) return new ArrayList<Interval>(Arrays.asList(newInterval));
        int i=-1;
        for(;i+1<intervals.size();){
            if(intervals.get(i+1).start<=newInterval.end) i++;
            else break;
        }
        if(i==-1){
            intervals.add(0,newInterval);
            return intervals;
        }
        int j=i+1;
        for(;j-1>=0;){
            if(intervals.get(j-1).end>=newInterval.start) j--;
            else break;
        }
        if(j==intervals.size()){
            intervals.add(newInterval);
            return intervals;
        }
        newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
        newInterval.start=Math.min(newInterval.start,intervals.get(j).start);
        for(int k=j;k<=i;k++) intervals.remove(j);
        intervals.add(j,newInterval);
        return intervals;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1) {
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> ret = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (Interval curr : intervals) {
            if (curr.start <= prev.end) {
                prev.end = Math.max(curr.end, prev.end);
            } else {
                ret.add(prev);
                prev = curr;
            }
        }
        ret.add(prev);
        return ret;
    }
}

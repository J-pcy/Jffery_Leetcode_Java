/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

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
/*
    public int minMeetingRooms(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int res = 0, room = 0;
        for (int key : map.keySet()) {
            room += map.get(key);
            res = Math.max(res, room);
        }
        return res;
    }*/
/*
    public int minMeetingRooms(Interval[] intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (Interval i : intervals) {
            starts.add(i.start);
            ends.add(i.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int res = 0, endpos = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (starts.get(i) < ends.get(endpos)) ++res;
            else ++endpos;
        }
        return res;
    }*/
/*
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; ++i) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0, endpos = 0;
        for (int i = 0; i < len; ++i) {
            if (starts[i] < ends[endpos]) ++res;
            else ++endpos;
        }
        return res;
    }*/
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (!pq.isEmpty() && i.start >= pq.peek()) pq.poll();
            pq.add(i.end);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
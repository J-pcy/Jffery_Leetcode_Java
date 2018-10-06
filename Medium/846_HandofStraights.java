/*
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.
 

Note:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
*/

class Solution {
/*
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0) return false;
        if (hand.length % W != 0) return false;
        if (W == 1) return true;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int h : hand) minHeap.add(h);
        while (!minHeap.isEmpty()) {
            int head = minHeap.poll();
            for (int i = 1; i < W; ++i) {
                if (!minHeap.remove(head + i)) return false;
            }
        }
        return true;
    }*/
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) map.put(h, map.getOrDefault(h, 0) + 1);
        for (int i : map.keySet()) {
            int icnt = map.get(i);
            if (icnt == 0) continue;
            for (int j = i + 1; j < i + W; ++j) {
                Integer jcnt = map.get(j);
                if (jcnt == null || jcnt < icnt) return false;
                map.put(j, jcnt - icnt);
            }
        }
        return true;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};
        ListNode prev = head;
        head = head.next;
        if (head.next == null) {
            return result;
        }
        int i = 0;
        int prevIndex = -1;
        int firstIndex = -1;
        int lastIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        while (head.next != null) {
            i++;
            int current = head.val;
            ListNode nextNode = head.next;
            if (current > nextNode.val && current > prev.val) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    minDistance = Math.min(minDistance, i - prevIndex);
                }
                prevIndex = i;
            } else if (current < nextNode.val && current < prev.val) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    minDistance = Math.min(minDistance, i - prevIndex);
                }
                prevIndex = i;
            }
            head = head.next;
            prev = prev.next;
        }
        int maxDistance = prevIndex - firstIndex;
        if (maxDistance == 0) {
            return result;
        }
        result[0] = minDistance;
        result[1] = maxDistance;
        return result;
    }
}

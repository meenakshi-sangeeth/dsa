/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
*/

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        int interval=1;
        while (interval<lists.length) {
            for (int i=0; i+interval < lists.length;i=i+interval*2) {
                lists[i] = merge(lists[i], lists[i+interval]);
            }
            interval=interval*2;
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while (l1!=null && l2!=null) {
            if (l1.val<=l2.val) {
                curr.next=l1;
                l1=l1.next;
            } 
            else{
                curr.next=l2;
                l2=l2.next;
            }

            curr = curr.next;
        }
        if(l1==null) curr.next=l2;
        else curr.next=l1;

        return dummy.next;
    }
    
}


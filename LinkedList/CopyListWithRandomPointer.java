// LeetCode 138: Copy List with Random Pointer
// Time Complexity: O(n)
// Space Complexity: O(1)
Three step to solve:-
Step 1:- Insert copy nodes betwwen original nodes
Step 2:- Assign random pointers
Step 3:- Seperate orginal and copied List

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        //Insert copy nodes between original nodes
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        //Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Separate original and copied lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }
}

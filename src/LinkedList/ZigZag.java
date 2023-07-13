package LinkedList;

//You are given the head of a singly linked-list. The list can be represented as:
//
//        L0 → L1 → … → Ln - 1 → Ln
//        Reorder the list to be on the following form:
//
//        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

public class ZigZag {
    public static void zigZag1(SLLNode<Integer> head) {
        if(head == null || head.next == null){
            return;
        }

        var curr = head;

        while(curr != null && curr.next != null){
            var temp = curr;
            var currNext = curr.next;

            // reach to 2nd last node
            while(temp.next.next != null){
                temp = temp.next;
            }
            var last = temp.next;
            curr.next = last;
            temp.next = null;

            last.next = currNext;

            curr = currNext;
        }

    }

    public static void zigZag2(SLLNode<Integer> head) {
        var mid = LinkedListUse.getMidNode(head);
//        System.out.println(mid.data);

        // seperate two halfs -left,right
        var head1 = mid.next;
        mid.next = null;

        //reverse right half
        head1 = LinkedListUse.reverseI(head1);

        // Alternate Merging
        var leftCurr = head;
        var rightCurr = head1;

        while (rightCurr != null){
            var leftCurrNext = leftCurr.next;
            var rightCurrNext = rightCurr.next;

            leftCurr.next = rightCurr;
            rightCurr.next = leftCurrNext;

            leftCurr = leftCurrNext;
            rightCurr = rightCurrNext;
        }

    }

    public static void main(String[] args) {
        var head = LinkedListUse.takeInput();
        zigZag2(head);
        LinkedListUse.print(head);
    }


}

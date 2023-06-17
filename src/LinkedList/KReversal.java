package LinkedList;

import org.w3c.dom.Node;

public class KReversal {

    // recursive
    public static SLLNode<Integer> kReversal(SLLNode<Integer> head, int k){
        if(head == null){
            return head;
        }
        var tail = head;
        for(int i=0; i<k-1 && tail != null; i++){
            tail = tail.next;
        }
        SLLNode<Integer> newHead = null;
        if(tail != null){
            //seperate k size list
            newHead = tail.next;
            tail.next = null;
        }
        PairOfHeadTail headTail = LinkedListUse.reverseUsingDoubleNode(head);
        headTail.tail.next = kReversal(newHead, k);
        return headTail.head;
    }

    public static SLLNode<Integer> kReversal1(SLLNode<Integer> head, int k){
        if(head == null){
            return head;
        }
        var curr = head;

        // dummy for the new list
        var dummy = new SLLNode<Integer>(0);
        var newHead = dummy;
        var newTail = dummy;

        while(curr != null){
            var tail = curr;
            for(int i=0; i<k-1 && tail != null; i++){
                tail = tail.next;
            }
            SLLNode<Integer> temp = null;
            if(tail != null){
                temp = tail.next; // storing next for next iteration
                tail.next = null;
            }
            newTail.next = LinkedListUse.reverseR1(curr); // no need for tail of reversed list because tail is current
            newTail = curr;
            curr = temp;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        SLLNode<Integer> head = LinkedListUse.takeInput();
        LinkedListUse.print(head);


//        Sample Input : 1 2 3 4 5 6 7 8 -1
        head = kReversal1(head, 0);
        LinkedListUse.print(head);
    }
}

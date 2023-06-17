package LinkedList;

public class InsertionSortLL {
    public static void main(String[] args) {
        var head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        head = insertionSort(head);
//        head = insertNodeInSortedList(head, new SLLNode<Integer>(3));
        LinkedListUse.print(head);
    }

    public static SLLNode<Integer> insertionSort(SLLNode<Integer> head) {
        SLLNode<Integer> sortedListHead = null;

        var curr = head;
        while (curr != null){
            var temp = curr.next;
            curr.next = null;
            sortedListHead = insertNodeInSortedList(sortedListHead, curr);
            curr = temp;
        }
        return sortedListHead;
    }

    private static SLLNode<Integer> insertNodeInSortedList(SLLNode<Integer> head, SLLNode<Integer> node){
//        node.next = null; // ensuring ndoe is single
        if(head == null){
            return node;
        }


        var dummy = new SLLNode<Integer>(0);
        dummy.next = head;

        var curr = head;
        var prev = dummy;

        while(curr != null){
            if(node.data < curr.data){
                prev.next = node;
                node.next = curr;
                return dummy.next;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = node;
        return dummy.next;
    }
}

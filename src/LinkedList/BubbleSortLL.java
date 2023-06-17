package LinkedList;

public class BubbleSortLL {
    public static void bubbleSort(SLLNode<Integer> head){
        int length = LinkedListUse.lengthOfLL(head);

        // only swapping data not nodes
        for(int i=1; i<length; i++){
            var curr = head;
            for(int j=0; j<length-i; j++){
                if(curr.data > curr.next.data){
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
                curr = curr.next;
            }
        }
    }

    public static SLLNode<Integer> bubbleSort1(SLLNode<Integer> head){
        int length = LinkedListUse.lengthOfLL(head);

        var dummy = new SLLNode<Integer>(0);
        dummy.next = head;

        for(int i=0; i<length-1; i++) {
            var prev = dummy;
            var c1 = dummy.next;
            for (int j = 0; j < length-i-1; j++) {
                var c2 = c1.next;
                var fwd = c2.next;
                if(c1.data > c2.data){
                    prev.next = c2;
                    c2.next = c1;
                    c1.next = fwd;

                    prev = c2;
                }
                else{
                    // no swap
                    prev = c1;
                    c1 = c1.next;
                }
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        var head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        head = bubbleSort1(head);
        LinkedListUse.print(head);
    }
}

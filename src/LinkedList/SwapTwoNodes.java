package LinkedList;

public class SwapTwoNodes {

    // i is index of 1st Node and j is index of 2nd Node
    public static SLLNode<Integer> swapTwoNodes(SLLNode<Integer> head, int i , int j){
//        case 1: either i or j is 0
//                can be eliminated by dummy node;
//        case 2: | i- j | = 1  // implit handled by our logic
//        case 3: case1 and case2
//                eliminated by dummy node and case 2 handling

//        handle the case when i and j are out of bound

        if (i == j) {
            return head; // No need to swap if i and j are the same
        }

        var dummy = new SLLNode<Integer>(0);
        dummy.next = head;

        // Find the nodes at positions i-1 and j-1
        var p1 = getNodeAtIndex(dummy, i);
        var p2 = getNodeAtIndex(dummy, j);

        // Check if either i or j is out of bounds
        if (p1 == null || p2 == null || p1.next == null || p2.next == null) {
            return head;
        }

        var t1 = p1.next;
        var t2 = p2.next;

        // swapping the nodes
        p1.next = t2;
        p2.next = t1;

        var temp = t1.next;  // this will implicit handle the case 2
        t1.next = t2.next;
        t2.next = temp;

        return dummy.next;
    }

    // Helper method to get the node at a specific index
    private static SLLNode<Integer> getNodeAtIndex(SLLNode<Integer> head, int index) {
        var node = head;
        for (int count = 0; count < index && node != null; count++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        var head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        head = swapTwoNodes(head, 0, 1);
        LinkedListUse.print(head);
    }
}

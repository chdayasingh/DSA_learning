package LinkedList;

public class RemoveCycle {
    public static boolean isCycle(SLLNode<Integer> head) {
        var slow = head;
        var fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(SLLNode<Integer> head){
        // Detect cycle
        var slow = head;
        var fast = head;

        boolean isCycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            return;
        }
        // finding meeting point
        slow = head;
        SLLNode<Integer> prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {
//        1->2->3->2
        SLLNode<Integer> head = new SLLNode<>(1);
        var temp = new SLLNode<>(2);
        head.next = temp;
        head.next.next = new SLLNode<>(3);
        head.next.next.next = temp;

//        LinkedListUse.print(head);
        System.out.println(isCycle(head));
        removeCycle(head);
        System.out.println(isCycle(head));

    }


}

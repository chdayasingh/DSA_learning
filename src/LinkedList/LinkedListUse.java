package LinkedList;

import java.util.Scanner;

public class LinkedListUse {
    public static SLLNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element separated by space, enter '-1' at the end of last element");
        int data = sc.nextInt();
        SLLNode<Integer> head = null;
        // tail is required to add new node (new node is always attach to the last)
        SLLNode<Integer> tail = null;

        while (data != -1){
            SLLNode<Integer> current = new SLLNode<>(data);
            if(head == null){
                head = current;
            } else {
                tail.next = current;
            }
            tail = current;
            data = sc.nextInt();
        }

        return head;
    }

    public static void print(SLLNode<Integer> head){
        SLLNode<Integer> temp = head;
        for(; temp != null; temp = temp.next){
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    private static void printR(SLLNode<Integer> head) {
        if(head == null){
            System.out.println();
            return;
        }
        System.out.print(head.data + " ");
        printR(head.next);
    }

    public static void incrementEachElement(SLLNode<Integer> head){
        SLLNode<Integer> temp = head;
        while(temp != null){
            temp.data++;
            temp = temp.next;
        }
    }

    public static int lengthOfLL(SLLNode<Integer> head) {
        int count = 0;
        SLLNode<Integer> temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static int printNode(SLLNode<Integer> head, int index){
        SLLNode<Integer> temp = head;
        int count = 0;
        while((count < index) && (temp != null)){
            count++;
            temp = temp.next;
        }
        if(temp == null) return -1;
        return temp.data;
    }

    public static SLLNode<Integer> insertNode(SLLNode<Integer> head, int data, int pos){
        // creating a new node with given data
        SLLNode<Integer> newNode = new SLLNode<>(data);

        if(pos == 0){
            newNode.next = head;
            return newNode;
        }
        SLLNode<Integer> temp = head;
        int count = 0;
        while(temp != null && count < pos-1){
            count++;
            temp = temp.next;
        }

        if(temp == null){
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static SLLNode<Integer> insertNodeR(SLLNode<Integer> head, int data, int pos){
        if(pos == 0 || head == null){
            SLLNode<Integer> newNode = new SLLNode<>(data);
            newNode.next = head;
            return newNode;
        }

        head.next = insertNodeR(head.next, data, pos-1);
        return head;
    }

    public static SLLNode<Integer> deleteNode(SLLNode<Integer> head, int pos){
        if(head == null){
            return head;
        }
        if(pos == 0){  // edge case
            return head.next;
        }
        SLLNode<Integer> temp = head;
        int count = 0;
        while(temp != null && count < pos-1){
            count++;
            temp = temp.next;
        }
        if( temp == null || temp.next == null){  // edge case
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static SLLNode<Integer> deleteNodeR(SLLNode<Integer> head, int pos){
        if(head == null){
            return null;
        }
        if(pos == 0){
            return head.next;
        }

        head.next = deleteNodeR(head.next, pos-1);
        return head;
    }

    public static SLLNode<Integer> reverseLinkedList(SLLNode<Integer> head) {
        SLLNode<Integer> curr = head;
        SLLNode<Integer> prev = null;
        SLLNode<Integer> fwd = null;

        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;

        }
        return prev;
    }

    public static SLLNode<Integer> reverseR(SLLNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        SLLNode<Integer> smallHead = reverseR(head.next);

        head.next.next = head;
        head.next = null;

        return smallHead;
    }

    // reverse the linked list using reverseUsingDoubleNode() (DoubleNode is a class which holds two data members that is head and tail
    public static SLLNode<Integer> reverseR1(SLLNode<Integer> head) {
        PairOfHeadTail ans = reverseUsingDoubleNode(head);
        return ans.head;
    }

    // this method will be used by only reverseR1() method internally
    public static PairOfHeadTail reverseUsingDoubleNode(SLLNode<Integer> head) {
        if(head == null || head.next == null){
            return new PairOfHeadTail(head,head);
        }
        PairOfHeadTail smallAns = reverseUsingDoubleNode(head.next);
        head.next = null;
        smallAns.tail.next = head; // joining current head to the tail of reversed list
        smallAns.tail = head; // updating tail
        return smallAns;
    }

    public static SLLNode<Integer> createCopyOfLL(SLLNode<Integer> head) {
        SLLNode<Integer> head1 = null;
        SLLNode<Integer> tail1 = null;
        SLLNode<Integer> temp = head;
        while(temp != null){
            SLLNode<Integer> newNode = new SLLNode<>(temp.data);
            if(head1 == null){
                head1 = newNode;
            }
            else{
                tail1.next = newNode;
            }
            tail1 = newNode;
            temp = temp.next;
        }
        return head1;
    }

    // This method will compare each element of two linked list , it will gives true if both linked list is same
    private static boolean compareTwoLinkedList(SLLNode<Integer> head, SLLNode<Integer> head2) {
        SLLNode<Integer> current1 = head;
        SLLNode<Integer> current2 = head2;
        while(current1 != null){
            if(current1.data != current2.data){
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public static SLLNode<Integer> getMidNodeUsingLength(SLLNode<Integer> head) {
        if(head == null){
            return null;
        }
        int length = lengthOfLL(head);
        int midPos = (length-1)/2;

        SLLNode<Integer> temp = head;
        int count = 0;
        while(count < midPos){
            count++;
            temp = temp.next;
        }
        return temp;
    }

    public static SLLNode<Integer> getMidNode(SLLNode<Integer> head){
        SLLNode<Integer> slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static SLLNode<Integer> mergeTwoSortedLL(SLLNode<Integer> head1, SLLNode<Integer> head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        SLLNode<Integer> t1 = head1, t2 = head2;
        SLLNode<Integer> finalHead = null, tail = null;

        if (t1.data <= t2.data){
            finalHead = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            finalHead = t2;
            tail = t2;
            t2 = t2.next;
        }
        while(t1 != null && t2 != null){
            if (t1.data <= t2.data){
                tail.next = t1;  // linking current node to merged list
                tail = t1; // updating the tail
                t1 = t1.next; // updating the current
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        if(t1 == null){
            tail.next = t2;
        }
        else{
            tail.next = t1;
        }
        return finalHead;
    }

    public static SLLNode<Integer> mergeSortInLL(SLLNode<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        SLLNode<Integer> midNode = getMidNode(head);
        SLLNode<Integer> head1 = head;
        SLLNode<Integer> head2 = midNode.next;
        midNode.next = null;  // breaking the connection
        SLLNode<Integer> sortedHead1 = mergeSortInLL(head1);
        SLLNode<Integer> sortedHead2 = mergeSortInLL(head2);
        SLLNode<Integer> sortedHead = mergeTwoSortedLL(sortedHead1, sortedHead2);

        return sortedHead;
    }

    public static void main(String[] args) {
//        Node<Integer> head = takeInput();
//        System.out.println("LL after sorting using MergeSort : ");
//        head = mergeSortInLL(head);
//        printR(head);

//        printLinkedList(head);
//        incrementEachElement(head);
//        printLinkedList(head);
//        int length = lengthOfLL(head);
//        System.out.println(length);
//        System.out.println(printNode(head, 6));

//        head = insertNode(head, 20, 3);
//        printLinkedList(head);

//        head = deleteNode(head,5);
//        head = reverseLinkedList(head);
//        printLinkedList(head);


//        Node<Integer> head2 = createCopyOfLL(head);
////        printLinkedList(head2);
//
//        head2 = reverseLinkedList(head2);
//        printLinkedList(head2);
//
//        System.out.println(compareTwoLinkedList(head, head2));

//        printR(head);
//        head = insertNodeR(head, 8,8);
//        head = deleteNodeR(head, 8);
//        head = reverseR(head);
//        printR(head);

//        head = reverseR1(head);
//        printR(head);

//        System.out.println(getMidNodeUsingLength(head).data);
//        System.out.println(getMidNode(head).data);

//        Node<Integer> head1 = takeInput();
//        printR(head1);
//        Node<Integer> head2 = takeInput();
//        printR(head2);
//        head1 = mergeTwoSortedLL(head1,head2);
//        printR(head1);



    }



}

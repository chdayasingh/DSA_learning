package LinkedList;

import java.util.Scanner;

public class MyLinkedList {
    private static SLLNode<Integer> head;
//    private SLLNode<Integer> tail;
    private static int size;

    MyLinkedList(){

    }
    MyLinkedList(Scanner sc){
        System.out.println("Enter element separated by space, enter '-1' at the end of last element");
        int data = sc.nextInt();
        SLLNode<Integer> head = null;
        // tail is required to add new node (new node is always attach to the last)
        SLLNode<Integer> tail = null;

        while (data != -1){
            SLLNode<Integer> current = new SLLNode<>(data);
            size++;
            if(head == null){
                head = current;
            } else {
                tail.next = current;
            }
            tail = current;
            data = sc.nextInt();
        }
        // updating head of the linkedlist obj
        MyLinkedList.head = head;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }


    public void print(){
        SLLNode<Integer> temp = head;
        for(; temp != null; temp = temp.next){
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public void printR(){
        printR(head);
    }
    private static void printR(SLLNode<Integer> head) {
        if(head == null){
            System.out.println();
            return;
        }
        System.out.print(head.data + " ");
        printR(head.next);
    }


    public void addFirst(int data){
        head = insertNode(head, data, 0);
        size++;
    }
    public void addLast(int data){
        head = insertNode(head, data, size);
        size++;
    }
    public void add(int data, int index){
        if(index < 0 || index>= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        head = insertNode(head, data, index);
        size++;
    }
    private static SLLNode<Integer> insertNode(SLLNode<Integer> head, int data, int pos){
        // creating a new node with given data
        SLLNode<Integer> newNode = new SLLNode<>(data);

        // edge case
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

    public int get(int index) throws Exception {
        SLLNode<Integer> temp = head;
        int count = 0;
        while(temp != null && count<index){
            count++;
            temp = temp.next;
        }
        if(temp == null){
            throw new Exception("Empty Linked List");
        }
        return temp.data;
    }

    public int getFirst() throws Exception{
        return get(0);
    }
    public int getLast() throws Exception{
        return get(size-1);
    }

    public int removeFirst(){
        return remove(0);
    }
    public int removeLast(){
        return remove(this.size()-1);
    }
    public int remove(int index){
        // index checking will eliminating head== null edge cases
        if(index < 0 || index>= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        var dummy = new SLLNode<Integer>(0);
        dummy.next = head;

        SLLNode<Integer> prev = dummy;

        for(int i=0; i<index; i++){
            prev = prev.next;
        }
        int data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        head = dummy.next;
        return data;
    }

    public boolean contains(int data){
        return indexOf(data) != -1;
    }

    public int indexOf(int data){
        SLLNode<Integer> temp = head;
        int count = 0;
        while(temp != null){
            if(temp.data == data){
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    public void rotateRight(int k){
        if(head == null || k == 0){
            return;
        }
        SLLNode<Integer> current = head;
        SLLNode<Integer> fast = head; // target to reach at last node
        SLLNode<Integer> slow = head; // target to reach at one before new head

        // to handle the case when k is greater than length
        k = k % size;

        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next; // making new head;
        slow.next = null;
    }

    // demove duplicates from list and give unique element list
    public void removeConsecutiveDuplicates(){
        if(head == null){
            return;
        }
        SLLNode<Integer> prev = head;
        SLLNode<Integer> curr = head.next;

        while(curr != null){
            if(curr.data == prev.data){
                // Duplicate node
                curr = curr.next;
            }
            else{
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        prev.next = curr;
    }

    public void removeConsecutiveDuplicates1(){
        // checking the nextnode with current if there data are equal then skip nextnode
        SLLNode<Integer> current = head;

        while(current != null){
            SLLNode<Integer> nextNode = current.next;

            if(nextNode != null && current.data == nextNode.data){
                // deleting next node
                current.next = nextNode.next;
            }
            else{
                current = nextNode;
            }
        }
    }


    // TODO: decrease the size as weil
    public void removeConsecutiveR(){
        removeConsecutiveR(head);
    }

    private static SLLNode<Integer> removeConsecutiveR(SLLNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        SLLNode<Integer> curr = head.next;
        while(curr != null && curr.data == head.data){
            curr = curr.next;
        }
        head.next = removeConsecutiveR(curr);
        return head;
    }

    public void printReverse(){
        printReverese(head);
        System.out.println();
    }
    private static void printReverese(SLLNode<Integer> head){
        if(head == null){
            return;
        }
        printReverese(head.next);
        System.out.print(head.data + " ");
    }


    public boolean isPalindrome(){
        if(head  == null){
            return true;
        }
        var mid = getMidNode();
        // creating two half
        // 1->2->3->4    =  1->2   3->4
        var head2 = mid.next;
        mid.next = null;

        head2 = reverseR(head2);

        var c1 = head;
        var c2 = head2;
        while(c1 != null && c2!=null){
            if(c1.data != c2.data){
                // backing to previous state
                mid.next = reverseR(head2);
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        mid.next = reverseR(head2);
        return true;
    }

    private SLLNode<Integer> getMidNode(){
        if(head == null){
            return null;
        }
        // for even length give 1st middle
        var slow = head;
        var fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reverse(){
        if(head == null){
            return;
        }
        SLLNode<Integer> prev = null;
        SLLNode<Integer> curr = head;

        while(curr != null){
            SLLNode<Integer> fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        head = prev;
    }

    public void reverseR(){
        head = reverseR(head);
    }
    private static SLLNode<Integer> reverseR(SLLNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        SLLNode<Integer> smallHead = reverseR(head.next);
        head.next.next = head;
        head.next = null;
        return smallHead;
    }

    public MyLinkedList createCopy() {
        MyLinkedList listCopy = new MyLinkedList();
        SLLNode<Integer> curr = head;
        while(curr != null){
            listCopy.addLast(curr.data);
            curr = curr.next;
        }
        return listCopy;
    }

    public int getKthNodeFromEnd(int k){
        if(k < 1 || k > size){
            return Integer.MAX_VALUE;
        }
//        int count = this.size - k;    // if we don't know the size , 1 scan takes to find size and another to find element
//        var curr = this.head;
//        for(int i=0; i<count; i++){
//            curr = curr.next;
//        }
//        return curr.data;


        // in one scan;
        var slow = head;
        var fast = head;

        // slow and fast have seperated with distance (k-1)
        for(int i=0; i<k-1; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }


    public void mergeSort(){
        head = mergeSort(head);
    }

    private static SLLNode<Integer> getMidNode(SLLNode<Integer> head){
        if(head == null ){
            return null;
        }
        var slow = head;
        var fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static SLLNode<Integer> mergeTwoSortedLL(SLLNode<Integer> head1, SLLNode<Integer> head2){
        SLLNode<Integer> newHead = null;

        SLLNode<Integer> c1 = head1; // pointer for list 1
        SLLNode<Integer> c2 = head2; // pointer for list 2

        if(c1.data <= c2.data){
            newHead = c1;
            c1 = c1.next;
        }
        else{
            newHead = c2;
            c2 = c2.next;
        }
        var newTail = newHead;

        while(c1 != null && c2 != null){
            if(c1.data <= c2.data){
                newTail.next = c1;
                newTail = c1;
                c1 = c1.next;
            }
            else{
                newTail.next = c2;
                newTail = c2;
                c2 = c2.next;
            }
        }
        if(c1 == null){
            newTail.next = c2;
        }
        if(c2 == null){
            newTail.next = c1;
        }
        return newHead;
    }

    private static SLLNode<Integer> mergeSort(SLLNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        var midNode = getMidNode(head);

        var head1 = head;
        var head2 = midNode.next;
        // break the link
        midNode.next = null;

        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return mergeTwoSortedLL(head1, head2);
    }
}

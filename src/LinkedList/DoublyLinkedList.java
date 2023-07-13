package LinkedList;

public class DoublyLinkedList {
    public static DLLNode head;
    public static DLLNode tail;
    public static int size;

    public void addFirst(int data) {
        DLLNode newNode = new DLLNode(data);
    }

    public void addLast(int i) {

    }

    public void removeFirst() {
    }

    public void removeLast() {

    }

    public void reverse(){

    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(5);
        list.removeFirst();
        list.addLast(10);
        list.removeLast();
    }



}

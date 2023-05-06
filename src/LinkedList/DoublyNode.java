package LinkedList;

public class DoublyNode<T> {
    T data;
    DoublyNode prev;
    DoublyNode next;
    DoublyNode(){}
    DoublyNode(T data){
        this.data = data;
    }
}

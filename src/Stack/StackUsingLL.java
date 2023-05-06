package Stack;

import LinkedList.SLLNode;

public class StackUsingLL<T> {
    private SLLNode<T> head;
    public int size;

    public void push(T elem){
        SLLNode<T> newNode = new SLLNode<T>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T top(){
        return head.data;
    }

    public T pop() throws StackEmptyException {
        if(head == null){
            throw new StackEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }


}

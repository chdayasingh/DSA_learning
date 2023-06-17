package Stack;

public class StackUsingArray {
    private int[] data;
    private int topIndex;

    public StackUsingArray(){
        data = new int[10];
        topIndex = -1;
    }
    public StackUsingArray(int size){
        data = new int[size];
        topIndex = -1;
    }

    public int size(){
        return topIndex+1;
    }
    public void push(int elem) throws StackFullException {
        if(topIndex == data.length-1){
            increaseSizeOfData();
//            throw new StackFullException();
        }

        data[++topIndex] = elem;
    }

    private void increaseSizeOfData() {
        int[] temp = new int[data.length*2];
        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public int top() throws StackEmptyException {
        if(topIndex == -1){
            // throw exception
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if(topIndex == -1){
            // throw exception
            throw new StackEmptyException();
        }
        return data[topIndex--];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }
}

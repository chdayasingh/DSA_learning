package OOPs;

public class DynamicArray {
    private int data[];
    private int nextElementIndex = 0;

    public DynamicArray(){
        data = new int[5];
    }
    public int size(){
        return nextElementIndex;
    }

    public int get(int i) {
        if(i >= nextElementIndex){
            // Throw Error
            return -1;
        }
        return data[i];
    }

    public void add(int element) {
        if(nextElementIndex == data.length){
            doubleCapacity();
        }
        data[nextElementIndex] = element;
        nextElementIndex++;
    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2* data.length];
        for(int i=0; i<temp.length; i++){
            data[i] = temp[i];
        }
    }

    public void printHorizontally(){
        for(int i=0; i<nextElementIndex; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void set(int index, int value) {
        if(index >= nextElementIndex){
            // Throw Error
            return;
        }
        System.out.println("Updating element at index "+index+" from "+data[index]+" to "+value);
        data[index] = value;
    }

    public boolean isEmpty() {
        return nextElementIndex == 0;
    }

    public void removeLast() {
        System.out.println("Last element "+data[nextElementIndex-1]+" deleted successfully");
        nextElementIndex--;
    }

    public void addAtIndex(int index, int value) {
        if(index >= nextElementIndex){
            // Throw Error
            System.out.println("Array is smaller than your given index");
        }
        if(nextElementIndex == data.length){
            doubleCapacity();
        }
        for(int i=index; i<nextElementIndex; i++){
            data[i+1] = data[i];
        }
        nextElementIndex++;
        data[index] = value;
    }
}

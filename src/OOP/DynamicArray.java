package OOP;

import java.sql.Array;

public class DynamicArray {
    private int nextIndex;
    private int[] data;
    public DynamicArray(){
        data = new int[5];
        this.nextIndex = 0;
    }

    public int get(int index){
        if(index < 0 || index >= nextIndex){
            System.out.println("Invalid Index");
            return 0;
        }
        return data[index];
    }

    public int size(){
        return nextIndex;
    }


    public void set(int index, int value){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        if(index >= this.size()){
            while(index>=data.length){
                this.data = doubleArray(this.data);
            }
            data[index] = value;
            nextIndex = index+1;
        }
        else{
            data[index] = value;
        }

    }

    public void print(){
        System.out.print("[");
        for(int i=0; i<nextIndex; i++){

            System.out.print(data[i]+ ",");
        }
        System.out.println("]");
    }

    public void add(int elem){
        if(nextIndex == data.length){
            this.data = doubleArray(this.data);
        }
        data[nextIndex] = elem;
        nextIndex++;
    }

    public void add(int index, int elem){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        if(nextIndex == data.length){
            this.data = doubleArray(this.data);
        }
        // if user wants to add at index which is greater than the dynamic array length
        if(index >= this.size()){
            while(index>=data.length){
                this.data = doubleArray(this.data);
            }
            data[index] = elem;
            nextIndex = index+1;
        }
        // if user wants to add between existing array
        else {
            for (int i = nextIndex - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }

            data[index] = elem;
            nextIndex++;
        }
    }

    private static int[] doubleArray(int[] data) {
        int[] a = new int[data.length * 2];
        for(int i=0; i<data.length; i++){
            a[i] = data[i];
        }
        return a;
    }

    public boolean isEmpty(){
        return nextIndex == 0;
    }

    public int removeLast(){
        if(nextIndex <= 0){
            System.out.println("Array is already Empty");
            return 0;
        }
        nextIndex--;
        return data[nextIndex-1];
    }
}

package PriorityQueue;

// Every element has value and priority
public class ElementOfPQ<T> {
    T value;
    int priority;

    ElementOfPQ(T value, int priority){
        this.value = value;
        this.priority = priority;
    }
}

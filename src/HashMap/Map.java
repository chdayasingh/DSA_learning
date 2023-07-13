package HashMap;

import java.util.ArrayList;

public class Map<K, V> {
    private static class MapNode<K, V> {
        private K key;
        private V value;
        private MapNode<K, V> next;

        public MapNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private ArrayList<MapNode<K, V>> buckets;
    private int size;
    private int numBuckets;

    private double loadFactor; // lF = no_of_keys/numBuckets

    public Map(){
        buckets = new ArrayList<>();
        numBuckets = 5;
        for(int i = 0; i< numBuckets; i++){
            buckets.add(null);
        }
    }

    public void print_buckets(){
        int index = 0;
        for(MapNode<K, V> pointer: buckets){
            System.out.print(index + ": ");

            if(pointer == null){
                System.out.print(pointer);
            }
            else{
                while(pointer != null){
                    System.out.print("(Key:" + pointer.key + ", Value:" + pointer.value + ") " );
                    pointer = pointer.next;
                }
            }
            index++;
            System.out.println();
        }

    }

    public int size(){
        return this.size;
    }

    public double getLoadFactor(){ return this.loadFactor; }

    // Hash function
    private int getBucketIndex(K key){
        // getting hashcode
        int hc = key.hashCode();
        // compression
        return hc%numBuckets;
    }

    private void reHash(){
        // storing reference of old buckets
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        this.numBuckets *= 2;
        this.size = 0;
        // Initailizing bucket arraylist with numBuckets
        for(int i=0; i<this.numBuckets; i++){
            buckets.add(null);
        }
        // inserting all nodes from old bucket to new bucket
        for(int i=0; i<temp.size(); i++){
            MapNode<K, V> head = temp.get(i);
            while(head != null){
                K key = head.key;
                V val = head.value;
                put(key, val);
                head = head.next;
            }
        }

    }
    public void put(K key, V value){
        // grabing the int index for key
        int bucketIndex = getBucketIndex(key);
        // store previous value at that index to head;
        MapNode<K, V> head = buckets.get(bucketIndex);
        // checking , if the key is already present or not , if yes update the value of the key
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // reinitailizing the head
        head = buckets.get(bucketIndex);
        // if we are here, that's means we don't find key , so we create the new key
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        this.size++;
        this.loadFactor = (double)size/numBuckets;
        if(this.loadFactor > 0.7){
            reHash();
            System.out.println("Rehashing is called");
        }
    }

    public V get(K key){
        int bucketIndex = getBucketIndex(key);
//        grabing the head of the linkedList
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V getValueOrDefault(K key, V defaultVal){
        V val = get(key);
        if(val == null){
            val = defaultVal;
        }
        return val;
    }

    public V remove(K key){
        int bucketIndex = getBucketIndex(key);
//        grabing the head of the linkedList
        MapNode<K, V> head = buckets.get(bucketIndex);
        // maintaining prev to set head.next if we found the key to remove that node
        MapNode<K, V> prev = null;

        while(head != null){
            if(head.key.equals(key)){
                // if the head is the matching key
                if(prev == null){
                    buckets.set(bucketIndex, head.next);
                }
                else{
                    prev.next = head.next;
                }
                size--;
                // returning the deleted node value
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

}

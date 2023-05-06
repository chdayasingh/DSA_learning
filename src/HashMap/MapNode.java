package HashMap;

public class MapNode<K, V> {
    public K key;
    public V value;
    public MapNode<K, V> next;

    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}

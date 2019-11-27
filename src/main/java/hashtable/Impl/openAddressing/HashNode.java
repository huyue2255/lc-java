package hashtable.Impl.openAddressing;

/**
 * Created by yuehu on 7/1/19.
 */
public class HashNode<K,V> {
    public K key;

    public V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

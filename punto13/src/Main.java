import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V>
{
    private final int capacidad;
    public LRUCache(int capacidad)
    {
        super(capacidad, 0.75f, true);
        this.capacidad = capacidad;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return size() > capacidad;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println("Cache inicial: " + cache);
        cache.get(1);
        System.out.println("Tras acceder a 1: " + cache);
        cache.put(4, "D");
        System.out.println("Tras insertar 4: " + cache);
        cache.get(3);
        System.out.println("Tras acceder a 3: " + cache);
        cache.put(5, "E");
        System.out.println("Tras insertar 5: " + cache);
    }
}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

public class HMTest {
    MyHashMap<Integer> map;

    @BeforeEach
    public void setup(){
        map = new MyHashMap("Bozo", 3);
    }

    @Test
    public void putTest(){
        map.put("Banana", 100);
        assertEquals(2, map.size());

        map.put("Melvin", 20);
        map.put("Bruba", 98);
        assertEquals(4, map.size());
    }

    @Test
    public void getTest(){
        map.put("Benzo", 10);
        assertEquals(10, map.get("Benzo"));
    }

    @Test
    public void getContainsTest(){
        map.put("Benzo", 10);
        assertEquals(true, map.contains("Benzo"));
    }

    @Test
    public void isEmptyTest(){
        map.put("Benzo", 10);
        map.put("Manny", 6);
        assertEquals(false, map.isEmpty());
    }

    @Test
    public void replaceTest(){
        map.put("Benzo", 10);
        assertEquals(10, map.get("Benzo"));

        map.replace("Benzo", 15);
        assertEquals(15, map.get("Benzo"));

    }

    @Test
    public void HMIteratorHasNextTest(){
        Iterator<Integer> itr = map.iterator();
        map.put("Benzo", 10);
        assertEquals(true, itr.hasNext());
    }

    @Test
    public void HMIteratorNextTest(){
        Iterator<Integer> itr = map.iterator();
        map.put("Benzo", 10);
        assertEquals(3, itr.next());

    }

}

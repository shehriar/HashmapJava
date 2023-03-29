import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

public class GQTest {
    GenericQueue<Integer> gq;
    int iterator;

    @BeforeEach
    void setup(){
        gq = new GenericQueue(5);
        iterator = 0;
    }

    @Test
    void gqConstructorTest(){
        GenericQueue<Integer> queue = new GenericQueue("Hi");
        assertEquals(1, queue.getLength());
    }

    @Test
    void addLengthTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        assertEquals(6, gq.getLength());
    }

    @Test
    void addValueTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        assertEquals(4, gq.get(5));
    }

    @Test
    void deleteLengthTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        gq.delete();
        gq.delete();
        assertEquals(4, gq.getLength());
    }

    @Test
    void deleteValueTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        assertEquals(4, gq.delete());
    }

    @Test
    void enqueueTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        assertEquals(6, gq.getLength());
    }

    @Test
    void dequeue(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        gq.delete();
        gq.delete();
        assertEquals(4, gq.getLength());
    }

    @Test
    void setTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        gq.set(1, 10);
        assertEquals(10, gq.get(1));
    }

    @Test
    void dumpArrayTest(){
        ArrayList<Integer> array;
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        array = gq.dumpList();
        assertEquals(6, array.size());

    }

    @Test
    void hasNextTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        Iterator<Integer> itr = gq.iterator();
        assertEquals(true, itr.hasNext());
    }

    @Test
    void hasNextTestFalse(){
        Iterator<Integer> itr = gq.iterator();
        assertEquals(false, itr.hasNext());
    }

    @Test
    void nextTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        Iterator<Integer> itr = gq.iterator();
        assertEquals(5, itr.next());

        assertEquals(0, itr.next());
    }

    @Test
    void reverseHasNextTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        Iterator<Integer> itr = gq.descendingIterator();
        assertEquals(true, itr.hasNext());
    }

    @Test
    void reverseNextTest(){
        for(int i = 0; i<5; i++){
            gq.add(i);
        }
        Iterator<Integer> itr = gq.descendingIterator();
        assertEquals(4, itr.next());
    }

    @Test
    void forEachTest() {
        gq.forEach(arg ->{
            assertEquals(gq.get(iterator), arg);
            iterator++;
        });
    }
}

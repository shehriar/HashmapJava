import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.ArrayList;
import java.util.Iterator;
public class MyHashMap<T> implements Iterable<T>{
    ArrayList<GenericQueue<T>> map = new ArrayList<>();

    MyHashMap(String key, T value){
        ArrayList<GenericQueue<T>> map = new ArrayList(10);
        for(int i = 0; i<10; i++){
            GenericQueue<T> gq = new GenericQueue(null, -1);
            this.map.add(gq);
        }
        this.put(key, value);
    }

    public void put(String key, T value){

        int code = key.hashCode();
        int index = code&9;

        if(map == null){
            GenericQueue<T> gq = new GenericQueue(value, code);
            map.add(index, gq);
            return;
        }
        // If the index is empty, add value
        if(map.get(index) == null){
            GenericQueue<T> gq = new GenericQueue(value, code);
            map.add(index, gq);
            return;
        }

        // If index is not empty, then add value to end of queue
        GenericQueue<T> gq = map.get(index);
        gq.add(value, code);
        map.set(index, gq);
    }

    public boolean contains(String key){

        int code = key.hashCode();
        int index = code&9;

        // If hashCode index does not exist then return false.
        if(map.get(index) == null){
            return false;
        }

        // Else
        // Initialize node as the head of queue.
        GenericQueue<T> queueAtIndex = map.get(index);
        GenericQueue<T>.Node<T> node = queueAtIndex.getHead();
        // Loop through each node in the index to find the key.
        while(true){
            if(node.code == code){
                return true;
            }

            // Return false when we have reached the end of the queue.
            if(node.next == null){
                return false;
            }
            node = node.next;
        }
    }

    public T get(String key){
        int code = key.hashCode();
        int index = code&9;

        // If hashCode index does not exist then return null.
        if(map.get(index) == null){
            return null;
        }

        // Else
        // Initialize node as the head of queue.
        GenericQueue<T> queueAtIndex = map.get(index);
        GenericQueue<T>.Node<T> node = queueAtIndex.getHead();
        // Loop through each node in the index to find the key and return it's value.
        while(true){
            if(node.code == code){
                return node.data;
            }

            // Return null when we have reached the end of the queue.
            if(node.next == null){
                return null;
            }
            node = node.next;
        }
    }

    public GenericQueue.Node getNode(int index){
        // If hashCode index does not exist then return null.
        if(map.get(index) == null){
            return null;
        }

        // Else
        // Initialize node as the head of queue.
        GenericQueue<T> queueAtIndex = map.get(index);
        GenericQueue<T>.Node<T> node = queueAtIndex.getHead();
        return node;
    }

    public int size(){
        int size = 0;
        for(int i = 0; i<10; i++){
            // Initialize node as the head of queue.
            GenericQueue<T> queueAtIndex = map.get(i);
            GenericQueue<T>.Node<T> node = queueAtIndex.getHead();
            if(node == null){
                continue;
            }

            // Loop through queue and increase size throughout.
            while(true){

                size++;

                // Break loop when we have reached end of queue.
                if(node.next == null){
                    break;
                }
                node = node.next;
            }
        }
        return size-10;
    }

    // Returns false if the hashmap is empty, true otherwise.
    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        return false;
    }

    public T replace(String key, T value){
        int code = key.hashCode();
        int index = code&9;

        // If hashCode index does not exist then return null.
        if(map.get(index) == null){
            return null;
        }

        // Else
        // Initialize node as the head of queue.
        GenericQueue<T> queueAtIndex = map.get(index);
        GenericQueue<T>.Node<T> node = queueAtIndex.getHead();

        while(true){
            if(node.code == code){
                T result = node.data;
                node.data = value;
                return result;
            }
            if(node.next == null){
                return null;
            }
            node = node.next;
        }
    }

    public Iterator<T> iterator(){
        HMIterator<T> hashMapItr = new HMIterator(this);
        return hashMapItr;
    }

}

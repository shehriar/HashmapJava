import java.util.Iterator;

public class HMIterator<E> implements Iterator<E> {
    MyHashMap<E> hashMap;
    int index;
    GenericQueue.Node next;
    HMIterator(MyHashMap<E> map){
        this.hashMap = map;
        this.index = 0;
        this.next = nextVal();
    }

    public boolean hasNext(){
        if(this.nextVal() == null){
            return false;
        }
        return true;
    }

    public E next(){
        if(!hasNext()){
            return null;
        }

        GenericQueue.Node node = this.nextVal();
        return (E) node.data;
    }

    public GenericQueue.Node nextVal(){
        // if the map is empty then return null
        if(hashMap.isEmpty()){
            return null;
        }

        // Initializing node.
        GenericQueue.Node node = hashMap.getNode(index);

        // If next node exists, then return it.
        if(node.next != null){
            return node.next;
        }

        // Else, increase index by 1.
        index++;

        // While there is no value in index, keep increasing index by 1.
        while(hashMap.getNode(index) == null){
            index++;
        }

        return hashMap.getNode(index);
    }

}

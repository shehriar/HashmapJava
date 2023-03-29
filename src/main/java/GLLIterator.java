import java.util.Iterator;
public class GLLIterator<E> implements Iterator<E>{
    GenericList<E>.Node<E> head;
    GLLIterator(GenericList<E>.Node<E> node){
        head = node;
    }

    // Checking to see if next value exists.
    public boolean hasNext(){
        if(head.next == null){
            return false;
        }
        return true;
    }

    // Returning the current value and progressing linked list to next value.
    public E next(){
        // If there is no value in linked list, return null
        if(head == null){
            return null;
        }

        E currentData = head.data;
        // If there is no next value, head is null and current value is returned.
        if(!hasNext()){
            head = null;
            return currentData;
        }

        // Else head is progressed to next and current value is returned.
        head = head.next;
        return currentData;
    }
}

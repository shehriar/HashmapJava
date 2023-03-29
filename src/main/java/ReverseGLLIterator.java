import java.util.Iterator;
public class ReverseGLLIterator<E> implements Iterator<E>{
    GenericList<E>.Node<E> head;
    GenericList<E>.Node<E> tail;
    ReverseGLLIterator(GenericList<E>.Node<E> head){
        // Initializing value for head
        this.head = head;
        GenericList<E>.Node<E> temp = head;

        // Initializing value for tail
        while(temp.next != null){
            temp = temp.next;
        }
        this.tail = temp;
    }

    // Checking to see if next value exists.
    public boolean hasNext(){
        if(head.next == null){
            return false;
        }
        return true;
    }

    public E next(){

        // If there is no value in linked list, return null
        if(head == null){
            return null;
        }
        E returnData = tail.data;

        // If there is no next value, head is null and current value is returned.
        if(!hasNext()){
            head = null;
            tail = null;
            return returnData;
        }
        GenericList<E>.Node<E> temp = head;

        // Loop through list till next node is tail, then assign tail with current node and return previous tail value
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        return returnData;

    }
}

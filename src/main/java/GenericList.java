import java.util.Iterator;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T>{
    //Implementing a Node class to be used in a linked list.
    public class Node<T>{
        T data;
        int code;
        Node<T> next;

        // Default constructor
        public Node(){
            this.data = null;
            this.code = 0;
            this.next = null;
        }
        // Constructors for nodes
        public Node(T data){
            this.data = data;
            this.code = 0;
            this.next = null;
        }

        public Node(T data, int code){
            this.data = data;
            this.code = code;
            this.next = null;
        }

        // Getter for data
        public T getData(){
            return data;
        }
        // Setter for data
        public void setData(T data){
            this.data = data;
        }
    }

    private Node<T> head = new Node();
    private int length;

    public void print(){
        // If the linked list is null
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        // Creating temp variable for printing. Loop through and print until the value is null.
        Node temp = head;
        while(true){
            System.out.println(temp.getData());
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

    // Abstract methods for add and delete.
    public abstract void add(T data);

    public abstract T delete();

    public ArrayList<T> dumpList(){
        ArrayList<T> result = new ArrayList(length);

        // If list is empty, return null;
        if(this.head == null){
            return null;
        }


        // If there is only one element in List, add element to ArrayList and return.
        if(this.head.next == null){
            result.add((T) this.head.data);
            return result;
        }

        // If multiple elements in List, loop through the list and add as you go. Using temporary value to loop through.
        Node node = head;
        while(true){
            result.add((T) node.data);
            if(node.next == null){
                break;
            }
            node = node.next;
        }

        return result;
    }

    public T get(int index){

        int i = 0;
        Node node = this.head;

        // If index is greater than / equal to the length of list.
        if(index >= this.length){
            System.out.println("Index is out of bounds");
            return null;
        }
        // Else, loop through the list and when you reach at index, return the data.
        while(i<index){
            node = node.next;
            i++;
        }
        return (T) node.data;
    }

    public T set(int index, T element){
        // If index is greater than length
        if(index >= this.length){
            System.out.println("Index is out of bounds");
            return null;
        }

        // Loop through till index is reached, then replace its data.
        Node node = this.head;
        T previous = null;
        int i = 0;
        while(i<index){
            node = node.next;
            i++;
        }
        // Assign data of previous to variable, then replace data with element variable
        previous = (T) node.data;
        node.data = element;
        // Return data of previous
        return previous;
    }
    //Getter for length
    public int getLength(){ return this.length; }

    //Setter for length
    public void setLength(int value){ this.length = value; }

    // Getter for head
    public Node<T> getHead(){ return this.head; }

    // Setter for Head
    public void setHead(Node<T> node){ this.head = node; }

    public Iterator<T> descendingIterator(){
        ReverseGLLIterator<T> itr = new ReverseGLLIterator<T>(head);
        return itr;
    }
}

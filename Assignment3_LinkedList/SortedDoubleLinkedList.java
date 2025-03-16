package application;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparableObject) {
        super(); 
        this.comparator = comparableObject;
    }
    
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
    
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        else if (comparator.compare(data, head.data) <= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } 
        else if (comparator.compare(data, tail.data) >= 0) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } 
        else {
            Node current = head;
            while (current != null && comparator.compare(data, current.data) > 0) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode; 
            }
            current.prev = newNode;
        }
        size++;
    }
    
    @Override
    public ListIterator<T> iterator() {
        return super.iterator(); 
    }
    
    @Override
    public T remove(T data, Comparator<T> comparator) {
        return super.remove(data, comparator); 
    }
}

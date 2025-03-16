package application;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected class Node {
        protected T data;
        protected Node next;
        protected Node prev;

        public Node(T dataNode) {
            this.data = dataNode;
            this.next = null;
            this.prev = null;
        }
    }
	
	protected Node head;
    protected Node tail;
    protected int size;
    
    public BasicDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }
    
    public int getSize() {
        return size;
    }
    
    public void addToFront(T data) {
        Node newNode = new Node(data);
        
        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
    }
    
    public void addToEnd(T data) {
        Node newNode = new Node(data);
        
        if (tail == null) { 
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
    }
    
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    
    public T getLast() {
        if (tail == null) {
            return null; 
        }
        return tail.data;
    }
    
    public T retrieveFirstElement() {
        if (head == null) {
            return null; 
        }
        T data = head.data;
        head = head.next;

        if (head != null) {
            head.prev = null; 
        } else {
            tail = null; 
        }
        size--;
        return data;
    }
    
    public T retrieveLastElement() {
        if (tail == null) {
            return null; 
        }
        T data = tail.data;
        tail = tail.prev; 

        if (tail != null) {
            tail.next = null; 
        } else {
            head = null; 
        }
        size--;
        return data;
    }
    
    public T remove(T targetData, Comparator<T> comparator) {
        if (head == null) {
            return null; 
        }
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) { // Match found
                T data = current.data;
                if (current == head) {
                    return retrieveFirstElement(); 
                } else if (current == tail) {
                    return retrieveLastElement(); 
                } else {             
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return data;
            }
            current = current.next; 
        }
        return null; 
    }
    
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next; 
        }

        return list;
    }
    
    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current;

        public DoubleLinkedListIterator() {
            this.current = head; 
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = current.data;
            current = current.next; 
            return data;
        }
        
        @Override
        public boolean hasPrevious() {
            return current != null && current.prev != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            current = current.prev; 
            return current.data;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T data) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T data) {
            throw new UnsupportedOperationException();
        }

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
        
    }
    
}

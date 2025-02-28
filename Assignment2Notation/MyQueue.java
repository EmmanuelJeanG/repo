package application;
import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int front;
    private int back;
    private int size;
    private int capacity;
    
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        back = -1;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        back++;
        queue[back] = e;
        size++;
        return true;
    }
    
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        T removedElement = queue[front];
        queue[front] = null;
        front++;
        size--;
        return removedElement;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = front; i <= back; i++) {
            sb.append(queue[i]);
        }
        return sb.toString();
    }
    
    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = front; i <= back; i++) {
            sb.append(queue[i]);
            if (i < back) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
    
    @Override
    public void fill(ArrayList<T> list) {
        ArrayList<T> copy = new ArrayList<>(list);
        for (int i = 0; i < copy.size() && !isFull(); i++) {
            enqueue(copy.get(i));
        }
    }
}


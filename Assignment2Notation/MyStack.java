package application;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private T[] stack; 
    private int topIndex;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    
    @SuppressWarnings("unchecked")
	public MyStack() {
        this.capacity = DEFAULT_CAPACITY;
        stack = (T[]) new Object[capacity];
        topIndex = -1;
    }
    
    @SuppressWarnings("unchecked")
	public MyStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        topIndex = -1;
    }
    
    @Override
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
        	throw new StackOverflowException();
        }
        stack[++topIndex] = e;
        return true;
    }

    
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T topItem = stack[topIndex];
        topIndex--;
        return topItem;
    }
    
    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        if (topIndex == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (topIndex == capacity - 1) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= topIndex; i++) { 
        	if (i > 0) sb.append(" ");
        	sb.append(stack[i]);
        }
        return sb.toString();
    }

    @Override
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= topIndex; i++) { 
            sb.append(stack[i]);
            if (i < topIndex) { 
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    @Override
    public void fill(ArrayList<T> list) throws StackOverflowException {
        topIndex = -1;

        ArrayList<T> copy = new ArrayList<>(list);

        for (int i = 0; i < copy.size(); i++) {
            push(copy.get(i));
        }
    }
    
    @Override
    public int size() {
        return topIndex + 1; 
    }



}

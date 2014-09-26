import java.util.Arrays;


public class MyStack<E> implements IStack<E>{
	
	private E[] store;
	private int pointer; //pointer on last element
	
	public MyStack()
	{
		this(256);
	}
	public MyStack(int initSize)
	{
		store = (E[]) new Object[initSize];
	}
	
	public void push(E o)
	{
		if(pointer == store.length)
			this.expand();
		store[pointer++] = o;
	}
	public E pop()
	{
		
		return store[--pointer];
	}
	public E top()
	{
		return store[pointer];
	}
	private void expand()
	{
		store = Arrays.copyOf(store, store.length*2);
	}
	              

}



public class MyQueue<E> implements Queue<E>{

	private E[] store;
	private int in;//points to the next free positon
	private int out;//points to the next element to the dequeue
	private int size;

	
	
	MyQueue()
	{
		store = (E[]) new Object[3];
	}
	
	public void enqueue(E o) {
		// TODO Auto-generated method stub
		if(size == store.length) expand();
		if(in == store.length)in = 0;
		store[in++] = o;
		size++;
	}
	private void expand()
	{
		E[] old  = store;
		
		store = (E[])new Object[old.length*2];
		for(int i = in,count =0; count < old.length; i++,count++)
		{
			if(i == old.length)i =0;
			store[count] = old[i];
		}
		out = 0;
		in = old.length;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(size ==0)throw new RuntimeException("Empty Queue");
		size--;
		if(out == store.length)out=0;
		E tmp = store[out];
		
		out++;
		return tmp;
		
		
	}

	@Override
	public E head() {
		// TODO Auto-generated method stub
		return store[out];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}

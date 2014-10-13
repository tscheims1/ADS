import java.util.Arrays;


public class MyPriorityQueue <K extends Comparable<? super K>,E> implements PriorityQueue<K,E>
{
	class PQLocator<K1 extends Comparable<? super K1>,E1> implements Locator<K1, E1> {

		K1 key;
		E1 elem;
		Object creator = MyPriorityQueue.this;
		int pos; // position in the heap-array
		
		/* (non-Javadoc)
		 * @see examples.Position#element()
		 */
		@Override
		public E1 element() {
			return elem;
		}

		/* (non-Javoadoc)
		 * @see examples.Locator#key()
		 */
		@Override
		public K1 key() {
			return key;
		}
		
	}
	private PQLocator<K,E>[] locs = (PQLocator<K,E>[]) new PQLocator[256]; 
	private int size=1; // we start at 1 because the navigation is simpler
	
	
	@Override
	public Locator<K, E> showMin() {
		// TODO Auto-generated method stub
		return locs[1];
		
	}

	@Override
	public Locator<K, E> removeMin() {
		// TODO Auto-generated method stub
		swap(1,size-1);
		size--;
		upHeap(size);
		downHeap(0,size);
		
		return locs[size+1];
	}

	@Override
	public Locator<K, E> insert(K key, E element) {
		// TODO Auto-generated method stub
		PQLocator<K,E> locator = new PQLocator();
		locator.key = key;
		locator.elem = element;
		if(locs.length <= size)expand();
		locs[size] = locator;
		upHeap(size);//Tidy up the Heap
		size++;
		
		return locator;
	}

	@Override
	public void remove(Locator<K, E> loc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceKey(Locator<K, E> loc, K newKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	private void upHeap(int i)
	{
		/*
		 * Laufzeitkomplexität: Log2
		 */
		while(i >1 && locs[i].key.compareTo(locs[i/2].key) < 0)
		{
			swap(i,i/2);
			i/=2;
		}
	}
	private void downHeap(int i, int length)
	{
		int leftChild = i*2;
		int rightChild = i*2+1;
		while(i< length)
		{
			int cand = leftChild;
			if(rightChild < length && locs[rightChild].key.compareTo(locs[leftChild].key) < 0)
			{
				cand = rightChild;
			}
			if(locs[cand].key.compareTo(locs[i].key) <0)
			{
				swap(cand,i);
				i = cand;
				leftChild = i*2;
				rightChild = i*2+1;
			}
			else
				break;
		}
	}
	
	private void expand() {
		locs = Arrays.copyOf(locs,locs.length*2);
		}
	private void swap(int i, int k) {
		PQLocator<K,E> tmp = locs[i];
		locs[i]=locs[k];
		locs[k]=tmp;
		// do'nt forget the 'pos' values:
		locs[i].pos=i;
		locs[k].pos=k;		
	}
	public String ToString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < size;i++)
		{
			
			sb.append(locs[i].key+"\n");
		}
		return sb.toString();
	}

}

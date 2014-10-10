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
		return null;
	}

	@Override
	public Locator<K, E> removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locator<K, E> insert(K key, E element) {
		// TODO Auto-generated method stub
		return null;
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
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	private void upHeap(int i)
	{
		int parent = 0;
		while(i >0)
		{
			parent = (i-1)/2;
			if(locs[parent].key().compareTo(locs[i].key()) >0)
				swap(parent,i);
			i = parent;
			
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

}

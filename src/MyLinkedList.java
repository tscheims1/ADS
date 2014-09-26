import java.util.Iterator;


public class MyLinkedList <E> implements List<E>{
	class LNode implements Position<E>{
		E elem;
		LNode prev, next;
		Object creator = MyLinkedList.this; // pointer to outer instance
		@Override
		public E element() {
			// TODO Auto-generated method stub
			return elem;
		}
	}
	
	private LNode first, last;
	
	
	@Override
	public Position<E> first() {
		// TODO Auto-generated method stub
		return first;
	}

	@Override
	public Position<E> last() {
		// TODO Auto-generated method stub
		return last;
	}

	@Override
	public boolean isFirst(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLast(Position<E> p) {
		return false;
	}

	@Override
	public Position<E> next(Position<E> p) {
		// TODO Auto-generated method stub
		LNode n = (LNode)p;
		
		if(this != n.creator)throw new RuntimeException("invalid position");
		
		return n.next;
	}

	@Override
	public Position<E> previous(Position<E> p) {
		
		LNode n = (LNode)p;
		if(this != n.creator)throw new RuntimeException("invalid position");
		
		return 	n.prev;
	}

	@Override
	public E replaceElement(Position<E> p, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> insertFirst(E o) {
		
		LNode n = new LNode();
		n.elem = o;

		
		n.next = first;
		if(first != null)
			first.prev = n;
		else
		{
			last = n;
		}
			
		first = n;
		return n;
	}

	@Override
	public Position<E> insertLast(E o) {
		
		LNode n = new LNode();
		n.elem = o;
		
		if(last != null)
		{			
			last.next = n;
			n.prev = last;
		}
		else
		{
			first = n;
		}

		
		last = n;
		
		return last;
	}

	@Override
	public Position<E> insertBefore(Position<E> p, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> insertAfter(Position<E> p, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Position<E> p) {
		
		LNode n = (LNode)p;
		if(n.prev !=null)
		{
			if(n.next != null)
			{
				n.prev.next = n.next;
			}
			else
			{
				n.prev.next = null;
				last = n.prev;
				
				
			}
		}
		if(n.next != null)
		{
			if(n.prev != null)
			{
				n.next.prev = n.prev;
			}
			else
			{
				n.next.prev = null;
				first = n.next;
				
			}
		
		}
		if(n.next == null && n.prev == null)
		{
			first = null;
			last = null;
		}
		n = null;

	}

	@Override
	public Iterator<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}

import java.util.Iterator;


public class MyLinkedList <E> implements List<E>, Iterable<E>{
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
	class SeqIterator implements Iterator<E>
	{
		LNode current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E item = current.elem;
			
			current = current.next;
			
			return item;
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	private int size = 0;
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
		return p == first;
	}

	@Override
	public boolean isLast(Position<E> p) {
		return p == last;
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
		LNode node = (LNode)p;
		node.elem = o;
		
		return o;
	}

	@Override
	public Position<E> insertFirst(E o) {
		size++;
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
		size++;
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
		size++;
		
		LNode node = (LNode)p;
		
		
		LNode newNode = new LNode();
		newNode.elem = o;
		
		newNode.next = node;
		if(node.prev != null)
			newNode.prev = node.prev.prev;
		else
			first = newNode;
		
		node.prev = newNode;
		
		
		if(node.prev.prev != null)
		{
			node.prev.prev.next = newNode;
		}
		
		return newNode;
		
	}

	@Override
	public Position<E> insertAfter(Position<E> p, E o) {
		// TODO Auto-generated method stub
		size++;
		
		LNode node = (LNode)p;
		
		LNode newNode = new LNode();
		newNode.elem = o;
		
		newNode.prev = node;
		if(node.next != null)
			newNode.next = node.next.next;
		else
			last = newNode;
		
		node.next = newNode;
		
		
		if(node.next.next != null)
		{
			node.next.next.prev = newNode;
		}
		
		return newNode;
	}

	@Override
	public void remove(Position<E> p) {
		
		size--;
		
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
		return (Iterator<Position<E>>) new SeqIterator();
	}

	@Override
	public Iterator<E> elements() {
		
		
		return new SeqIterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	

}

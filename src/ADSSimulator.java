
public class ADSSimulator {
	static public void main(String[]args)
	{
		/*
		 * 
		 * Linked list
		 */
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		
		myLinkedList.insertLast("Hans1");
		
		myLinkedList.insertLast("Hans2");
		myLinkedList.insertLast("Hans3");
		
		myLinkedList.insertLast("Hans4");
		myLinkedList.insertLast("Hans5");
		Position<String>p1 = myLinkedList.last();
		//myLinkedList.remove(p1);
		myLinkedList.insertAfter(p1, "after hans5");
		Position<String>p = myLinkedList.last();
		
		
		
		
		
		while(p != null)
		{
			System.out.println(p.element());
			p = myLinkedList.previous(p);
		}
		p = myLinkedList.first();
		while(p != null)
		{
			System.out.println(p.element());
			p = myLinkedList.next(p);
		}
		
		/*
		 * queue
		 * 
		 */
		
		MyQueue<String> myQueue = new MyQueue();
		myQueue.enqueue("Pos1");
		myQueue.enqueue("Pos2");
		myQueue.enqueue("Pos3");
		myQueue.enqueue("pos4");
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
		
		myQueue.enqueue("Pos1");
		myQueue.enqueue("Pos2");
		
		System.out.println(myQueue.dequeue());
		System.out.println(myQueue.dequeue());
	}
}

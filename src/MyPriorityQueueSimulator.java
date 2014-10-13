
public class MyPriorityQueueSimulator {
	public static void main(String []args)
	{
		MyPriorityQueue<Integer,String> pq = new MyPriorityQueue();
		
		pq.insert(12, "12");
		pq.insert(13, "13");
		pq.insert(45, "45");
		pq.insert(15, "15");
		pq.insert(1, "1");
		pq.insert(3, "3");
		pq.insert(7, "7");
		System.out.println(pq.ToString());
		
	}
}

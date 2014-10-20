/**
 * 
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


/**
 * @author ps
 *
 */
public class MyAVLTree<K extends Comparable<? super K>, E> implements
		OrderedDictionary<K, E> {

	class AVLNode implements Locator<K, E>{
		
		AVLNode parent,left,right;
		Object creator = MyAVLTree.this;
		E elem;
		K key;
		int height;

		/* (non-Javadoc)
		 * @see examples.Position#element()
		 */
		@Override
		public E element() {
			return elem;
		}

		/* (non-Javadoc)
		 * @see examples.Locator#key()
		 */
		@Override
		public K key() {
			return key;
		}
		
		boolean isExternal(){
			return left==null; // is also true for right
		}
		
		boolean isLeftChild(){
			return parent != null && parent.left==this;
		}
		
		boolean isRightChild(){
			return parent != null && parent.right==this;
		}
		
		void expand(K key,E elem){
			this.elem = elem;
			this.key = key;
			left = new AVLNode();
			right = new AVLNode();
			left.parent = this;
			right.parent = this;
			if(this.parent == null)
				height = 1;
			else
				height = this.parent.height+1;
		}
	}

	
	
	// istance variables:
	private AVLNode root = new AVLNode();
	private int size;
	
	private AVLNode checkAndCast(Locator<K,E> p){
		try {
			AVLNode n = (AVLNode) p;			
			if (n.creator == null) throw new RuntimeException(" allready removed locator!");
			if (n.creator != this) throw new RuntimeException(" locator belongs to another AVLTree instance");
			return n;
		} catch (ClassCastException e) {
			throw new RuntimeException(" locator belongs to another container-type ");
		}
	}

	
	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#size()
	 */
	@Override
	public int size() {
		return size;
	}

	public Locator<K, E> find(K key) {
		// returns the leftmost occurence of
		// 'key' or null
		AVLNode node = new AVLNode();
		AVLNode n = root;
		
		while(!n.isExternal())
		{
			if(key.compareTo(n.key) ==0)
			{
				node.key = key;
				node.elem = n.elem;
			}
			if(key.compareTo(n.key) > 0)
			{
				n = n.right;
			}
			else
			{
				n = n.left;
			}
			
		}
		if( node.elem == null)return null;
		return node;
		
	}

	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#findAll(java.lang.Comparable)
	 */
	@Override
	public Locator<K, E>[] findAll(K key) {
		return null;
	}

	/**
	 * @param root2
	 * @param al
	 */
	private void findAll(K key,AVLNode n, ArrayList<Locator<K, E>> al) {
	}





	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#insert(java.lang.Comparable, java.lang.Object)
	 */
	@Override
	public Locator<K, E> insert(K key, E o) 
	{
		
		AVLNode n = root;
		AVLNode node = new AVLNode();
		size++;
		while(!n.isExternal())
		{
			if(key.compareTo(n.key)>0)
			{
				n = n.right;
			}
			else
			{
				n = n.left;
			}
		}
		
		node.parent = n;
		
		if(n.key== null)
		{
			n.expand(key, o);
		}
		else
		{
			if(key.compareTo(n.key) >0)
			{
				n.right = node;
			}
			else
			{
				n.left = node;
			}
			
		}node.expand(key, o);
		
	
		
		
		return node;
	}

	
	


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#remove(examples.Locator)
	 */
	@Override
	public void remove(Locator<K, E> loc) {
		// TODO Auto-generated method stub
		AVLNode node = checkAndCast(loc);
		
		while(!node.isExternal())
		{
			
			
		}
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#closestBefore(java.lang.Comparable)
	 */
	@Override
	public Locator<K, E> closestBefore(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#closestAfter(java.lang.Comparable)
	 */
	@Override
	public Locator<K, E> closestAfter(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#next(examples.Locator)
	 */
	@Override
	public Locator<K, E> next(Locator<K, E> loc) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#previous(examples.Locator)
	 */
	@Override
	public Locator<K, E> previous(Locator<K, E> loc) {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#min()
	 */
	@Override
	public Locator<K, E> min() {
		// TODO Auto-generated method stub
		AVLNode node = root;
		while(!node.isExternal())
		{
			node = node.left;
		}
		return node.parent;
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#max()
	 */
	@Override
	public Locator<K, E> max() {
		
		AVLNode node = root;
		while(!node.isExternal())
		{
			node = node.right;
			
		}
		return node.parent;
	}
	public void print()
	{
		print(root,"");
	}
	public void prettyPrint()
	{
		prettyPrint(root,0);
		
	}
	private void prettyPrint(AVLNode subtree,int deep)
	{
		if(subtree.isExternal())
		{
			
			return;
		}
		prettyPrint(subtree.right,deep+1);
		
		System.out.println(new String(new char[deep]).replace('\0', ' ')+ "+-("+subtree.height+")"+subtree.key);
		//System.out.println(new String(new char[deep]).replace('\0', ' ')+"|");
		prettyPrint(subtree.left,deep+1);
	}
	private void print(AVLNode n,String before)
	{
		
		if(n.isExternal())
		{
			return;
		}
		System.out.println(before+n.key);
		
		
		print(n.left,before+"+");
	
		print(n.right,before+"++");
		
	}


	/* (non-Javadoc)
	 * @see examples.OrderedDictionary#sortedLocators()
	 */
	@Override
	public Iterator<Locator<K, E>> sortedLocators() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String[] argv){
		MyAVLTree<Integer, String> t = new MyAVLTree<>();
		Random rand = new Random();
		int n  = 10;
		Locator<Integer,String>[] locs = new Locator[n];
		long time1 = System.currentTimeMillis();
		for (int i=0;i<n;i++) {
			locs[i]=t.insert(rand.nextInt(n),""+i);
		
		}
		t.prettyPrint();
		System.out.println("min"+t.min().key());
		System.out.println("max"+t.max().key());
		for (int i=0;i<n/2;i++) {
			t.find(locs[i].key());
		}
	}

}

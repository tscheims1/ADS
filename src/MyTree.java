import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author James
 *
 */
public class MyTree<E> implements Tree<E> {
	
	private TNode root;
	private int size;
	private class TNode implements Position<E>
	{
		TNode parent;
		MyLinkedList<TNode> children = new MyLinkedList<TNode>();
		Position<TNode> mySiblingPos;
		E ele;
		Object creator = MyTree.this;
		
		TNode(E ele){this.ele = ele;}
		TNode(){}
		
		@Override
		public E element() {
			// TODO Auto-generated method stub
			return ele;
		}
		
	}
	
	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Position<E> createRoot(E o) {
		// TODO Auto-generated method stub
		if(root != null)throw new RuntimeException("allready a root present");
		TNode node = new TNode(o);
		node.children = new MyLinkedList<TNode>();
		node.parent = null;
		size++;
		root = node;
		
		return node;
	}

	@Override
	public Position<E> parent(Position<E> child) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Position<E>> childrenPositions(Position<E> parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> childrenElements(Position<E> parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numberOfChildren(Position<E> parent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Position<E> insertParent(Position<E> p, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addChild(Position<E> parent, E o) {
		
		
		TNode child = new TNode(o);
		child.children = new MyLinkedList<TNode>();
		child.parent = (TNode)parent;
		child.mySiblingPos =  ((TNode)parent).children.insertLast(child);
		
		
		return child;
	}

	@Override
	public Position<E> addChildAt(int pos, Position<E> parent, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addSiblingAfter(Position<E> sibling, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addSiblingBefore(Position<E> sibling, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Position<E> p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExternal(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E replaceElement(Position<E> p, E o) {
		// TODO Auto-generated method stub
		return null;
	}
	public void print()
	{
		print(this.root,"+");
	}
	private void print(TNode subTree,String intend)
	{
		System.out.println(intend+subTree.ele.toString());
		Iterator<TNode> elements = subTree.children.elements();
		
		while(elements.hasNext())
		{
			
			print(elements.next(),intend+"+");
		}
	}
	public void getHeight()
	{
		System.out.println(getHeight(root));
	}
	public ArrayList<Position<E>> externalNodes()
	{
		ArrayList<Position<E>>nodes = new ArrayList<Position<E>>();
		externalNodes(nodes,this.root);
		
		return nodes;
	}
	private void externalNodes(ArrayList<Position<E>> list,TNode subTree)
	{
		Iterator<TNode> pos = subTree.children.elements();
		while(pos.hasNext())
		{
			externalNodes(list,pos.next());
		}
		if(subTree.children.size() == 0)
			list.add(subTree);
	}
	private int getHeight(TNode subTree)
	{
		int h = -1;
		Iterator<TNode> children = subTree.children.elements();
		
		while(children.hasNext())
		{
			h= Math.max(getHeight(children.next()),h);
		}
		
		return h+1;
	}

}

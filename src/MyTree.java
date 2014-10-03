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
	private int size = 0;
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
		
		final TNode node = (TNode)parent;
		return new Iterator<E>(){
			Iterator<TNode>it =  node.children.elements();
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return it.next().ele;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
			
		};
	}

	@Override
	public int numberOfChildren(Position<E> parent) {
		TNode node = (TNode)parent;
		return node.children.size();
		
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
		TNode sib = (TNode)sibling;
		TNode insert = new TNode(o);
		insert.parent = sib.parent;
		
		insert.mySiblingPos = sib.parent.children.insertAfter(sib.mySiblingPos, insert);
		size++;
		return insert;
	}

	@Override
	public Position<E> addSiblingBefore(Position<E> sibling, E o) {
		TNode sib = (TNode)sibling;
		TNode insert = new TNode(o);
		insert.parent = sib.parent;
		
		insert.mySiblingPos = sib.parent.children.insertBefore(sib.mySiblingPos, insert);
		size++;
		return insert;
	
	}

	@Override
	public void remove(Position<E> p) {
		
		TNode node = (TNode)p;
		if(node != root)
		{
			
		
		node.parent.children.remove(node.mySiblingPos);
		}
		else
		{
			root = null;
		}
		node.creator = null;
		size--;
	}

	@Override
	public boolean isExternal(Position<E> p) {
		// TODO Auto-generated method stub
		TNode node = (TNode)p;
		return node.children.size() == 0;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		// TODO Auto-generated method stub
		return !isExternal(p);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public E replaceElement(Position<E> p, E o) {
		
		TNode node = (TNode)p;
		node.ele = o;
		
		return node.ele;
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
	class WalkHelper
	{
		TNode n;
		int depth =-1;
	}
	public Position<E> getDeepestNode()
	{
		WalkHelper walker = new WalkHelper();
		walker.n = root;
		getDeepestNode(walker,root,1);
		return walker.n;
		
	}
	private void getDeepestNode(WalkHelper position,TNode subTree,int deepest)
	{
		
		Iterator<TNode> pos = subTree.children.elements();
		while(pos.hasNext())
		{
			getDeepestNode(position,pos.next(),deepest+1);
		}
		if(subTree.children.size() == 0)
		{
			if(deepest >= position.depth)
			{
				position.n = subTree;
				position.depth = deepest;
			}
		}
		
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

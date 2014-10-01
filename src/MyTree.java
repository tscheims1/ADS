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
		MyLinkedList<TNode> children;
		Position<E> mySiblingPos;
		E ele;
		
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
		return null;
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
		// TODO Auto-generated method stub
		return null;
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

}

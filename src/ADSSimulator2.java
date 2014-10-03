import java.util.ArrayList;


public class ADSSimulator2 {
	public static void main(String[] args)
	{
		MyTree<String> stringTree = new MyTree<String>();
		
		stringTree.createRoot("A");
		Position<String>bPos = stringTree.addChild(stringTree.root(), "B");
		stringTree.addChild(bPos, "E");
		stringTree.addChild(bPos, "F");
		Position<String>fPos = stringTree.addChild(stringTree.root(), "C");	
		Position<String>f1Pos =stringTree.addChild(fPos, "F1");
		Position<String>f2Pos =stringTree.addChild(f1Pos, "F3");
		stringTree.addChild(f2Pos, "F4");
		
		stringTree.addChild(stringTree.root(), "C");
		Position<String>dPos =  stringTree.addChild(stringTree.root(), "D");
		Position<String>g1Pos =  stringTree.addChild(dPos, "G");
		stringTree.addChild(g1Pos, "L");
		stringTree.print();
		stringTree.getHeight();
		ArrayList<Position<String>> externalNodes = stringTree.externalNodes();
		
		
		for(Position<String>item : externalNodes)
		{
			System.out.println(item.element());
		}
		Position<String> deepest = stringTree.getDeepestNode();
		System.out.println(deepest.element());
		
	}
}

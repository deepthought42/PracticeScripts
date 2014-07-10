package BinaryTree;


public class TestHarness {
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int idx = 0;
		BinaryTree<Integer> tree = new BinaryTree<Integer>(arr[idx]);
		
		System.out.println(tree.getRoot().getData());
		addNodes(tree.getRoot(), arr, 0, 1);
	}
	
	public static void addNodes(BinaryTree.Node<Integer> node, int[] arr, int idx, int lvl){
		int left_idx = idx + (lvl);
		int right_idx = idx +(lvl + 1);
		
		if(left_idx > arr.length-1){
			return;
		}
		else{				
			BinaryTree.Node<Integer> leftNode = new BinaryTree.Node<Integer>(arr[left_idx]);
			BinaryTree.Node<Integer> rightNode = new BinaryTree.Node<Integer>(arr[right_idx]);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
			System.out.print(leftNode.getData() + " " + rightNode.getData());
			addNodes(leftNode, arr, left_idx, lvl+1);
			addNodes(rightNode, arr, right_idx, lvl+1);
			System.out.println();
		}
	}
	
}

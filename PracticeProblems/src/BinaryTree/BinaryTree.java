package BinaryTree;

public class BinaryTree<T> {
	private Node<T> root;

    public BinaryTree(T rootData) {
        root = new Node<T>(rootData);
    }

    public Node<T> getRoot(){
    	return this.root;
    }
    
    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private Node<T> leftNode = null;
        private Node<T> rightNode = null;
    	
        public Node(T dataVal){
        	this.data = dataVal;
        }
        
        public T getData(){
        	return data;
        }
        
        public Node<T> getParent(){
        	return parent;
        }
        
        public void setParent(Node<T> node){
        	parent = node;
        }
        
    	public Node<T> getLeftNode(){
    		return leftNode;
    	}
    	
    	public void setLeftNode(Node<T> node){
    		this.leftNode = node;
    	}
    	
    	public Node<T> getRightNode(){
    		return rightNode;
    	}
    	
    	public void setRightNode(Node<T> node){
    		this.rightNode = node;
    	}
    }
}

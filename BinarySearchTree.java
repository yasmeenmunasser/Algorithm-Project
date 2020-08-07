package Algorithem;

public class BinarySearchTree 
{
	class Node {
		int key;
		Node left, right;
		
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	
	int count = 0;
	
	int getCount() {
		int c = count;
		count = 0;
		return c;
	}
	
	// Root of BST
	Node root;
	
	// Constructor
	BinarySearchTree() {
		root = null;
	}
	
	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}
	
	// A recursive function to insert a new key in BST
	Node insertRec(Node root, int key) {
		
		// If the tree is empty, return a new node
		if (root == null) {
			root = new Node(key);
			return root;
		}
		
		// Otherwise, recur down the tree
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);
		
		// return the (unchanged) node pointer
		return root;
	}
	
	// This method mainly calls InorderRec()
	void sort() {
		inorderRec(root);
	}
	
	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) { 
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}
	
	void search(int key) {
		if (find(root, key))
			System.out.println("Present");
		else 
			System.out.println("Not present");
	}
	
	// This method searches for a key in the BST
	Boolean find(Node root, int key) { 
		
	    // If the root is null then key not present
	    if (root==null) {
	    	count++;
	        return false; 
	    }
	    
	    //If the key equals the current root key then the key is present
	    if (root.key==key) {
	    	count++;
	    	return true;
	    }
	    
	    // value is greater than root's key 
	    if (root.key > key)  {
	    	count++;
	        return find(root.left, key); 
	    }
	    
	    // value is less than root's key 
	    return find(root.right, key); 
	} 
	
	// This method mainly calls deleteRec()
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}
	
	// A recursive function to insert a new key in BST 
	Node deleteRec(Node root, int key) {
		
		// Base Case: If the tree is empty
		if (root == null)  return root;
		
		// Otherwise, recur down the tree
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);
		
		// if key is same as root's key, then this is the node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			// node with two children: Get the inorder successor (smallest in the right subtree)
			root.key = minValue(root.right);
			
			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}
		
		return root;
	}
	
	int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

}

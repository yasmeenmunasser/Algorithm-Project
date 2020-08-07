package Algorithem;

public class AVLTree 
{
	class Node {  
	    int key, height;  
	    Node left, right;  
	  
	    Node(int d) {  
	        key = d;  
	        height = 1;  
	    }
	}
	
	int count = 0;
	
	int getCount() {
		int c = count;
		count = 0;
		return c;
	}
	
	// Root of AVL
    Node root;  
  
    // A utility function to get height of the tree  
    int height(Node N) {  
        if (N == null)  
            return 0;  
        return N.height;  
    }  
  
    // A utility function to get maximum of two integers  
    int max(int a, int b) {
    	return (a > b) ? a : b;  
    }  
  
    // A utility function to right rotate subtree rooted with y  
    Node rightRotate(Node y) {  
    	Node x = y.left;  
        Node T2 = x.right;  
  
        // Perform rotation  
        x.right = y;  
        y.left = T2;  
  
        // Update heights  
        y.height = max(height(y.left), height(y.right)) + 1;  
        x.height = max(height(x.left), height(x.right)) + 1;  
  
        // Return new root  
        return x;  
    }  
  
    // A utility function to left rotate subtree rooted with x   
    Node leftRotate(Node x) {
    	Node y = x.right;  
        Node T2 = y.left;  
  
        // Perform rotation  
        y.left = x;  
        x.right = T2;  
  
        // Update heights  
        x.height = max(height(x.left), height(x.right)) + 1;  
        y.height = max(height(y.left), height(y.right)) + 1;  
  
        // Return new root  
        return y;  
    }  
  
    // Get Balance factor of node N  
    int getBalance(Node N) {
    	if (N == null)
    		return 0;
    	return height(N.left) - height(N.right);  
    } 
    
    void insert(int key) {
    	root = insertRec(root, key);
	}
  
    Node insertRec(Node node, int key) {
    	/* 1. Perform the normal BST rotation */
        if (node == null)  
            return (new Node(key));  
  
        if (key < node.key)  
            node.left = insertRec(node.left, key);  
        else if (key > node.key)  
            node.right = insertRec(node.right, key);  
        else // Equal keys not allowed  
            return node;  
  
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left), height(node.right));  
  
        /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
        int balance = getBalance(node);  
  
        // If this node becomes unbalanced, then there are 4 cases Left Left Case  
        if (balance > 1 && key < node.left.key)  
            return rightRotate(node);  
  
        // Right Right Case  
        if (balance < -1 && key > node.right.key)  
            return leftRotate(node);  
  
        // Left Right Case  
        if (balance > 1 && key > node.left.key) {  
            node.left = leftRotate(node.left);  
            return rightRotate(node);  
        }  
  
        // Right Left Case  
        if (balance < -1 && key < node.right.key) {  
            node.right = rightRotate(node.right);  
            return leftRotate(node);  
        }  
  
        /* return the (unchanged) node pointer */
        return node;  
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
	    if (root.key > key) {
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
  
    Node deleteRec(Node root, int key) {
    	// STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than the root's key, then it lies in left subtree  
        if (key < root.key)  
            root.left = deleteRec(root.left, key);  
  
        // If the key to be deleted is greater than the root's key, then it lies in right subtree  
        else if (key > root.key)  
            root.right = deleteRec(root.right, key);  
  
        // if key is same as root's key, then this is the node to be deleted  
        else {
        	
        	// node with only one child or no child  
            if ((root.left == null) || (root.right == null)) {
            	Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null) {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
            	Node temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.key = temp.key;  
  
                // Delete the inorder successor  
                root.right = deleteRec(root.right, temp.key);  
            }  
        }  
  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height = max(height(root.left), height(root.right)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0) {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0) {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }
    
    // Return the node with minimum key value found in that tree
    Node minValueNode(Node node) {
    	Node current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }
}

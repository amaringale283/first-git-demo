package com.DSA_JAVA.BinarySearchTree;

public class BinarySearchTree {
	private TreeNode root;
	
	private class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert (TreeNode root,int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		}
		if (value < root.data) {
			root.left = insert(root.left, value);
		}
		else {
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public TreeNode search(int key) {
		return search(root, key);
	}
	
	public TreeNode search(TreeNode root, int key) {
		if (root == null || root.data == key)
			return root;
		if (key < root.data)
			return search(root.left, key);
		else
			return search(root.right, key);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public void isValid(int min, int max) {
		if (isValid(root,min,max))
			System.out.println("Valid binary search tree");
		else
			System.out.println("Invalid binary search tree");
	}
	
	public boolean isValid(TreeNode root,int min, int max) {
		if (root == null)
			return true;
		
		if (root.data <=min || root.data >= max) 
			return false;
		boolean left = isValid(root.left,min,root.data);
		if(left) {
			boolean right = isValid(root.right,root.data,max);
			return right;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.inorder();
		
		if (bst.search(10) != null)
			System.out.println("\n"+"Key found !!!");
		else
			System.out.println("\n"+"Key not found !!!");
		bst.isValid( Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}

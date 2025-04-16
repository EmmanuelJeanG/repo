package application;

public class TreeNode<T> {
	protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;
    
    public TreeNode(T dataNode) {
        this.data = dataNode;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(TreeNode<T> node) {
        this.data = node.data;
        this.left = node.left;
        this.right = node.right;
    }
    
    public T getData() {
        return data;
    }

}

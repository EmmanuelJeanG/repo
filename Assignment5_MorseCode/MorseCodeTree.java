package application;
import java.util.ArrayList;


public class MorseCodeTree implements ConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	public MorseCodeTree() {
        root = null;
        buildTree();
    }
	
	@Override
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }
	
	@Override
    public TreeNode<String> getRoot() {
        return root;
    }
	
	@Override
	public void buildTree() {
	    root = new TreeNode<>("");

	    addNode(".", "e");
	    addNode("-", "t");

	    addNode("..", "i");
	    addNode(".-", "a");
	    addNode("-.", "n");
	    addNode("--", "m");

	    addNode("...", "s");
	    addNode("..-", "u");
	    addNode(".-.", "r");
	    addNode(".--", "w");
	    addNode("-..", "d");
	    addNode("-.-", "k");
	    addNode("--.", "g");
	    addNode("---", "o");

	    addNode("....", "h");
	    addNode("...-", "v");
	    addNode("..-.", "f");
	    addNode(".-..", "l");
	    addNode(".--.", "p");
	    addNode(".---", "j");
	    addNode("-...", "b");
	    addNode("-..-", "x");
	    addNode("-.-.", "c");
	    addNode("-.--", "y");
	    addNode("--..", "z");
	    addNode("--.-", "q");
	}
	
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
	    if (code.length() == 1) {
	        if (code.equals(".")) {
	            root.left = new TreeNode<>(letter);
	        } else if (code.equals("-")) {
	            root.right = new TreeNode<>(letter);
	        }
	    } else {
	        if (code.charAt(0) == '.') {
	            if (root.left == null) {
	                root.left = new TreeNode<>("");
	            }
	            addNode(root.left, code.substring(1), letter);
	        } else if (code.charAt(0) == '-') {
	            if (root.right == null) {
	                root.right = new TreeNode<>("");
	            }
	            addNode(root.right, code.substring(1), letter);
	        }
	    }
	}
	
	public void addNode(String code, String letter) {
	    addNode(root, code, letter);
	}
	
	@Override
	public String fetchLetter(TreeNode<String> root, String code) {
	    if (code.length() == 0) {
	        return root.getData();
	    }

	    if (code.charAt(0) == '.') {
	        return fetchLetter(root.left, code.substring(1));
	    } else if (code.charAt(0) == '-') {
	        return fetchLetter(root.right, code.substring(1));
	    }

	    return null; //shouldn’t happen if input is valid
	}
	
	@Override
	public ArrayList<String> toArrayList() {
	    ArrayList<String> list = new ArrayList<>();
	    traverseInOrder(root, list);
	    return list;
	}
	
	@Override
	public void traverseInOrder(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
	        traverseInOrder(root.left, list);
	        if (!root.getData().isEmpty()) {
	            list.add(root.getData());
	        }
	        traverseInOrder(root.right, list);
	    }
	}
	
	@Override
	public String printTree() {
	    ArrayList<String> list = toArrayList();
	    return String.join(" ", list);
	}

}

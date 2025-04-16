package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest_STUDENT {
	private TreeNode<String> simpleNode;
    private TreeNode<String> leftChild;
    private TreeNode<String> rightChild;
    private TreeNode<String> copiedNode;

    @BeforeEach
    void setUp() throws Exception {
    	simpleNode = new TreeNode<>("A");
        leftChild = new TreeNode<>("L");
        rightChild = new TreeNode<>("R");

        simpleNode.left = leftChild;
        simpleNode.right = rightChild;

        copiedNode = new TreeNode<>(simpleNode);
    }

    @AfterEach
    void tearDown() throws Exception {
    	 simpleNode = null;
         leftChild = null;
         rightChild = null;
         copiedNode = null;
    }

    @Test
    void testTreeNodePassingData() {
    	assertEquals("A", simpleNode.getData());
        assertEquals("L", simpleNode.left.getData());
        assertEquals("R", simpleNode.right.getData());
    }

    @Test
    void testCopyTreeNode() {
    	assertEquals("A", copiedNode.getData());
        assertEquals("L", copiedNode.left.getData());
        assertEquals("R", copiedNode.right.getData());
    }

    @Test
    void testGetData() {
    	TreeNode<String> node = new TreeNode<>("Test");
        assertEquals("Test", node.getData());
    }

}

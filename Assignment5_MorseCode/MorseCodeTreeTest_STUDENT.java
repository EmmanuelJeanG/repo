package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {
	private MorseCodeTree tree;

    @BeforeEach
    void setUp() throws Exception {
    	 tree = new MorseCodeTree();
    }

    @AfterEach
    void tearDown() throws Exception {
    	tree = null;
    }

    @Test
    void testGetRoot() {
    	assertNotNull(tree.getRoot());
        assertEquals("", tree.getRoot().getData());
    }

    @Test
    void testSetRoot() {
    	TreeNode<String> newRoot = new TreeNode<>("ROOT");
        tree.setRoot(newRoot);
        assertEquals("ROOT", tree.getRoot().getData());
    }

    @Test
    void testAddNodePassingRoot() {
    	tree.addNode(tree.getRoot(), "--.-", "Q");
        String result = tree.fetchLetter(tree.getRoot(), "--.-");
        assertEquals("Q", result);
    }

    @Test
    void testBuildTree() {
    	assertEquals("e", tree.fetchLetter(tree.getRoot(), "."));
        assertEquals("m", tree.fetchLetter(tree.getRoot(), "--"));
        assertEquals("s", tree.fetchLetter(tree.getRoot(), "..."));
    }

    @Test
    void testFetchLetter() {
    	assertEquals("h", tree.fetchLetter(tree.getRoot(), "...."));
        assertEquals("o", tree.fetchLetter(tree.getRoot(), "---"));
    }

    @Test
    void testToArrayList() {
    	String result = String.join(" ", tree.toArrayList());
        assertEquals("h s v i f u e l r a p w j b d x n c k y t z g q m o", result);
    }

    @Test
    void testPrintTree() {
    	 assertEquals("h s v i f u e l r a p w j b d x n c k y t z g q m o", tree.printTree());
    }

}

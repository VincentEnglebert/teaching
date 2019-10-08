
package test_unitaire;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Vincent
 * 
 */
public class TestStack {
	private Stack<Integer> stack = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/**
		 * Annotating a public static void no-arg method with @BeforeClass
		 * causes it to be run once before any of the test methods in the class.
		 */
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		/**
		 * Annotating a public static void method with @AfterClass causes that
		 * method to be run after all the tests in the class have been run.
		 */
	}

	@Before
	public void setUp() throws Exception {
		/**
		 * Annotating a public void method with @Before causes that method to be
		 * run before the Test methods.
		 */
		stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
	}

	@After
	public void tearDown() throws Exception {
		/**
		 * Annotating a public void method with @After causes that method to be
		 * run after the Test method.
		 */
	}

	/**
	 * Test method for {@link java.util.Stack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		stack.push(5);
		assertTrue(stack.size() == 4);
		assertTrue(stack.pop() == 5);
	}

	/**
	 * Test method for {@link java.util.Stack#pop()}.
	 */
	@Test
	public void testPop() {
		assertTrue(stack.size() == 3);
		int three = stack.pop();
		assertTrue(stack.size() == 2);
		assertTrue(three == 3);
		int two = stack.pop();
		assertTrue(stack.size() == 1);
		assertTrue(two == 2);
		int one = stack.pop();
		assertTrue(stack.size() == 0);
		assertTrue(one == 1);
	}

	/**
	 * Test method for {@link java.util.Stack#peek()}.
	 */
	@Test
	public void testPeek() {
		assertTrue(stack.peek() == 3);
		assertTrue(stack.size() == 3);
	}

	/**
	 * Test method for {@link java.util.Stack#empty()}.
	 */
	@Test
	public void testEmpty() {
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link java.util.Stack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch() {
		assertTrue(stack.search(2) == 2);
		assertTrue(stack.search(4) == -1);
	}

}

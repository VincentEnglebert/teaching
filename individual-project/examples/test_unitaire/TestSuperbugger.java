package test_unitaire;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import test_unitaire.SuperBugger.BadPrecondition;

/**
 * @author Léon Prunelle Unit test for the SuperBugger class.
 */
public class TestSuperbugger {
	/// Test the argument 0
	@Test
	public void test0() {
		try {
			assertTrue(SuperBugger.factorial(0) == 1);
		} catch (BadPrecondition e) {
			fail("Exception shouldn't be thrown");
		}
	}

	/// test factorial(5)
	@Test
	public void testn() {
		try {
			assertTrue(SuperBugger.factorial(5) == 120);
		} catch (BadPrecondition e) {
			fail("Exception shouldn't be thrown");
		}
	}

	/// Test if BadPrecondition is thrown when arg is <0
	@Test
	public void testprecondition() {
		try {
			SuperBugger.factorial(-1);
			fail("BadPrecondition exception should have been thown before");
		} catch (BadPrecondition e) {
			// nothing to do.
		}

	}
}

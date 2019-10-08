package test_unitaire;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author Léon Prunelle Suite of test for the Spirou project.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestSuperbugger.class, TestStack.class })
public class AllTests {

}

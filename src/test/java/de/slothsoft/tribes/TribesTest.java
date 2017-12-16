package de.slothsoft.tribes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.slothsoft.tribes.contrib.WolvesTribe;
import de.slothsoft.tribes.contrib1.A;
import de.slothsoft.tribes.contrib1.B;
import de.slothsoft.tribes.contrib1.C;
import de.slothsoft.tribes.contrib2.Apple;
import de.slothsoft.tribes.contrib2.Banana;
import de.slothsoft.tribes.contrib2.Orange;
import de.slothsoft.tribes.contrib2.Pear;
import de.slothsoft.tribes.contrib3.One;
import de.slothsoft.tribes.contrib3.Three;
import de.slothsoft.tribes.contrib3.Two;

public class TribesTest {

	@Test
	public void testGetClasses() throws Exception {
		List<Class<?>> result = Tribes.getClasses("de.slothsoft.tribes.contrib1");
		Assert.assertEquals(Arrays.asList(A.class, B.class, C.class), result);
	}

	@Test
	public void testGetClassesUnknownPackage() throws Exception {
		List<Class<?>> result = Tribes.getClasses("de.slothsoft.unknown");
		Assert.assertEquals(new ArrayList<>(), result);
	}

	@Test
	public void testGetPositioners() throws Exception {
		List<Tribe> result = Tribes.fetchImplementations(Apple.class.getPackage());
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		Assert.assertTrue("Result has wrong type: " + result.get(0), result.get(0) instanceof Banana);
		Assert.assertTrue("Result has wrong type: " + result.get(1), result.get(1) instanceof Orange);
		Assert.assertTrue("Result has wrong type: " + result.get(2), result.get(2) instanceof Pear);
	}

	@Test
	public void testGetPositionersIgnoreAbstractClasses() throws Exception {
		List<Tribe> result = Tribes.fetchImplementations(One.class.getPackage());
		Assert.assertEquals(Arrays.asList(new Three(), new Two()), result);
	}

	@Test
	public void testGetDefaultPositioners() throws Exception {
		List<Tribe> result = Tribes.fetchAllImplementations();
		Assert.assertNotNull(result);
		Assert.assertTrue("Default tribe is missing: " + result,
				result.stream().filter(i -> i instanceof WolvesTribe).count() > 0);
	}

}

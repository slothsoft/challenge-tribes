package de.slothsoft.tribes;

import java.util.List;

import de.slothsoft.challenger.core.Contributions;
import de.slothsoft.tribes.contrib.WolvesTribe;

/**
 * Util class for getting and managing {@link Tribe}s (hence the name)
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public final class Tribes {

	/**
	 * Returns all instances of {@link Tribe}s in the <code>tribe</code> package.
	 *
	 * @return a list of implementations
	 */

	public static List<Tribe> fetchAllImplementations() {
		return Contributions.fetchImplementations(WolvesTribe.class.getPackage(), Tribe.class);
	}

	private Tribes() {
		// hide me
	}
}

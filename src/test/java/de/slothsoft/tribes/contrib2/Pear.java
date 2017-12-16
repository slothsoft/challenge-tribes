package de.slothsoft.tribes.contrib2;

import de.slothsoft.tribes.Action;
import de.slothsoft.tribes.Tribe;

public class Pear implements Tribe {

	@Override
	public Action execute(Context context) {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Pear;
	}

	@Override
	public int hashCode() {
		return 42;
	}

	@Override
	public String toString() {
		return "PearPositioner";
	}

}

package de.slothsoft.tribes.contrib;

import java.util.Objects;

import de.slothsoft.tribes.Tribe;

/**
 * A implementation for {@link Tribe} that only does {@link #hashCode()} and
 * {@link #equals(Object)} right.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public abstract class AbstractTribe implements Tribe {

	@Override
	public int hashCode() {
		return 37 * (getDisplayName() == null ? 3 : getDisplayName().hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final AbstractTribe that = (AbstractTribe) obj;
		if (!Objects.equals(getDisplayName(), that.getDisplayName())) return false;
		return true;
	}

	@Override
	public String toString() {
		return getDisplayName();
	}

}

package de.slothsoft.tribes;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.slothsoft.tribes.gui.TribesChallengeFrame;

/**
 * This class is the starting point for this application. It opens a "nice" GUI with
 * settings, a game field and the high scores.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public class TribesChallenge {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception ex) {
			System.err.println(ex.getMessage());
		}
		SwingUtilities.invokeLater(() -> createAndShowGui());
	}

	private static void createAndShowGui() {
		final TribesChallengeFrame mainFrame = new TribesChallengeFrame();
		mainFrame.start();
		mainFrame.pack();
	}

}

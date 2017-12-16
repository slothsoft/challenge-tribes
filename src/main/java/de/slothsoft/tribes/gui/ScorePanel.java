package de.slothsoft.tribes.gui;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import de.slothsoft.tribes.Tribe;
import de.slothsoft.tribes.Map;

public class ScorePanel extends JComponent {

	private static final long serialVersionUID = -6297202903243792595L;
	private Map map;

	private void createControls() {
		setLayout(new FlowLayout());

		for (Tribe tribe : this.map.getExistingTribes()) {
			add(new TribeControl(tribe));
		}
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
		removeAll();
		createControls();
	}

	class TribeControl extends JLabel {

		private static final long serialVersionUID = -1769442297405719987L;

		public TribeControl(Tribe tribe) {
			setText(tribe.getDisplayName());
			setToolTipText(tribe.getDisplayName());
			setIcon(createIcon(tribe));
		}

		private Icon createIcon(Tribe tribe) {
			final int size = 32;
			BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			g.scale(size / MapRenderer.WIDTH_IN_PIXELS, size / MapRenderer.HEIGHT_IN_PIXELS);
			new MapRenderer().paintTribe(g, tribe);
			g.dispose();
			return new ImageIcon(image);
		}

	}

}

package de.slothsoft.tribes.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import de.slothsoft.tribes.Tribe;
import de.slothsoft.tribes.Tribes;

public class TribeModel extends AbstractTableModel {

	private static final long serialVersionUID = 6708900198232721648L;

	private static final String[] COLUMNS = { "Use", "Name", "Author", "Class" };
	public static final int COLUMN_SELECTED = 0;
	public static final int COLUMN_NAME = 1;
	public static final int COLUMN_AUTHOR = 2;
	public static final int COLUMN_CLASS = 3;

	private List<Row> rows = new ArrayList<>();

	public TribeModel() {
		for (Tribe tribe : Tribes.fetchAllImplementations()) {
			this.rows.add(new Row(tribe.getDisplayName(), tribe.getAuthor(), tribe.getClass()));
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Row row = this.rows.get(rowIndex);
		switch (columnIndex) {
		case COLUMN_SELECTED:
			return Boolean.valueOf(row.selected);
		case COLUMN_NAME:
			return row.displayName;
		case COLUMN_AUTHOR:
			return row.author;
		case COLUMN_CLASS:
			return row.tribeClass.getSimpleName();
		default:
			return null;
		}
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMNS.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMNS[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COLUMN_SELECTED:
			return Boolean.class;
		case COLUMN_NAME:
		case COLUMN_AUTHOR:
		case COLUMN_CLASS:
			return String.class;
		default:
			return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case COLUMN_SELECTED:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Row row = this.rows.get(rowIndex);
		switch (columnIndex) {
		case COLUMN_SELECTED:
			row.selected = ((Boolean) aValue).booleanValue();
			break;
		default:
		}
	}

	public Tribe createTribe(int rowIndex) {
		Row row = this.rows.get(rowIndex);
		try {
			return row.selected ? row.tribeClass.newInstance() : null;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("Cannot create instance of " + row.tribeClass, e);
		}
	}

	/*
	 * 
	 */

	static class Row {

		final String displayName;
		final String author;
		final Class<? extends Tribe> tribeClass;
		boolean selected = true;

		public Row(String displayName, String author, Class<? extends Tribe> tribeClass) {
			this.displayName = displayName;
			this.author = author;
			this.tribeClass = tribeClass;
		}

	}

}

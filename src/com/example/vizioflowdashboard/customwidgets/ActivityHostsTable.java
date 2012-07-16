package com.example.vizioflowdashboard.customwidgets;

import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class ActivityHostsTable extends Table {

	public static final String[] ACTIVITYHOST_LINKS_ARRAY = { "View Detail", "Delete"};

	String[] tempCol_1 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String[] tempCol_2 = { "AH1", "AH2", "AH3", "AH4", "AH5", "AH6", "AH7", "AH8", "AH9", "AH10", "AH11", "AH12" };
	String[] tempCol_3 = { "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3" };
	String[] tempCol_4 = { "134", "134", "134", "134", "134", "134", "134", "134", "134", "134", "134", "134" };
	String[] tempCol_5 = { "23", "23", "23", "23", "23", "23", "23", "23", "23", "23", "23", "23" };

	public ActivityHostsTable() {
		
		super();
		initTable();
	}

	private void initTable() {
		
		setImmediate(false);
		setWidth("100%");
		
		// setHeight("100%");
		// setSizeUndefined();
		// setPageLength(7);

		addStyleName("striped");
		setSortDisabled(true);

		setSelectable(true);
		setMultiSelect(true);
		setImmediate(true); // react at once when something is selected

		addContainerProperty("ID", String.class, null);
		addContainerProperty("Name", String.class, null);
		addContainerProperty("Avg Run Time", String.class, null);
		addContainerProperty("Jobs", String.class, null);
		addContainerProperty("% of Workflow Run Time", String.class, null);
		// addContainerProperty("Action", ComboBox.class, null);
		addContainerProperty("Action", LinksHorizontalLayout.class, null);

		// this.setColumnWidth("ID", 100);
		// this.setColumnWidth("Name", 100);
		// this.setColumnWidth("Avg Run Time", 100);
		// this.setColumnWidth("Jobs", 100);
		// this.setColumnWidth("% of Workflow Run Time", 100);
		this.setColumnWidth("Action", 230);

		fillData();
	}

	private void fillData() {
		for (int i = 0; i < tempCol_1.length; i++) {
			this.addItem(new Object[] { tempCol_1[i], tempCol_2[i], tempCol_3[i], tempCol_4[i], tempCol_5[i], new LinksHorizontalLayout(ACTIVITYHOST_LINKS_ARRAY) }, new Integer(i + 1));
		}

	}

}

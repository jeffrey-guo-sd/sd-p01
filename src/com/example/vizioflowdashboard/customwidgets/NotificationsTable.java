package com.example.vizioflowdashboard.customwidgets;

import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class NotificationsTable extends Table {

	public static final String[] NOTIFICATIONS_LINKS_ARRAY = { "Delete", "View Details" };
	String[] tempColDate = { "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012", "1/1/2012" };
	String[] tempColAlert = { "Warn", "Failure", "Info", "Error", "Failure", "Error", "Failure", "Warn", "Warn", "Failure", "Failure", "Failure" };

	public NotificationsTable() {
		super();
		initTable();
	}

	private void initTable() {
		setImmediate(false);
		setWidth("100%");

		// setSizeUndefined();
		// setPageLength(7);
		addStyleName("striped");

		setSelectable(true);
		setMultiSelect(true);
		setImmediate(true); // react at once when something is selected

		addContainerProperty("Date", String.class, null);
		addContainerProperty("Alert", String.class, null);
		// addContainerProperty("Action", ComboBox.class, null);
		addContainerProperty("Action", LinksHorizontalLayout.class, null);
		this.setColumnWidth("Action", 170);

		fillData();
	}

	private void fillData() {
		for (int i = 0; i < tempColAlert.length; i++) {
			this.addItem(new Object[] { tempColDate[i], tempColAlert[i], new LinksHorizontalLayout(NOTIFICATIONS_LINKS_ARRAY) }, new Integer(i + 1));
		}

	}

}

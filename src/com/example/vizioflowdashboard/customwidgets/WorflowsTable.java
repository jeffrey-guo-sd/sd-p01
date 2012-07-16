package com.example.vizioflowdashboard.customwidgets;

import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class WorflowsTable extends Table {

	private static final String[] WORKFLOW_LINKS_ARRAY = { "Pause", "Logs",
			"Start" };
	String[] tempCol_1 = { "1/1/2012", "1/2/2012", "1/3/2012", "1/4/2012",
			"1/5/2012", "1/6/2012", "1/7/2012", "1/8/2012", "1/9/2012",
			"1/10/2012", "1/11/2012", "1/12/2012", "1/13/2012", "1/14/2012",
			"1/15/2012", "1/16/2012", "1/17/2012", "1/18/2012" };
	String[] tempCol_2 = { "WF1", "WF2", "WF3", "WF4", "WF5", "WF6", "WF7",
			"WF8", "WF9", "WF10", "WF11", "WF12", "WF13", "WF14", "WF15",
			"WF16", "WF17", "WF18" };
	String[] tempCol_3 = { "Owner", "Owner", "Owner", "Owner", "Owner",
			"Owner", "Owner", "Owner", "Owner", "Owner", "Owner", "Owner",
			"Owner", "Owner", "Owner", "Owner", "Owner", "Owner" };
	String[] tempCol_4 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18" };

	public WorflowsTable() {
		super();
		initTable();
	}

	private void initTable() {

		setImmediate(false);
		setWidth("100%");
		setPageLength(12);
		addStyleName("striped");

		setSelectable(true);
		setMultiSelect(true);
		setImmediate(true); // react at once when something is selected

		addContainerProperty("Date Started", String.class, null);
		addContainerProperty("Workflow Name", String.class, null);
		addContainerProperty("Owner", String.class, null);
		addContainerProperty("Running Time", String.class, null);
		addContainerProperty("Action", LinksHorizontalLayout.class, null);

		// this.setColumnWidth("Date Started", 200);
		// this.setColumnWidth("Workflow Name", 200);
		// this.setColumnWidth("Owner", 200);
		// this.setColumnWidth("Running Time", 200);
		this.setColumnWidth("Action", 160);
		fillData();
	}

	private void fillData() {

		for (int i = 0; i < tempCol_1.length; i++) {

			this.addItem(new Object[] { tempCol_1[i], tempCol_2[i],
					tempCol_3[i], tempCol_4[i],
					new LinksHorizontalLayout(WORKFLOW_LINKS_ARRAY) },
					new Integer(i + 1));
		}

	}

}

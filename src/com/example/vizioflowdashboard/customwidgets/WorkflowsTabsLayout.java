package com.example.vizioflowdashboard.customwidgets;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class WorkflowsTabsLayout extends VerticalLayout implements
		TabSheet.SelectedTabChangeListener {

	// Icons for the table
	// private static final ThemeResource icon1 = new
	// ThemeResource("../sampler/icons/action_save.gif");
	// private static final ThemeResource icon2 = new
	// ThemeResource("../sampler/icons/comment_yellow.gif");
	// private static final ThemeResource icon3 = new
	// ThemeResource("../sampler/icons/icon_info.gif");

	private TabSheet tabSheet;

	public WorkflowsTabsLayout() {

		// Tab 1 content
		VerticalLayout contentLayout_Completed = new VerticalLayout();
		contentLayout_Completed.addComponent(new WorflowsTable());

		// Tab 2 content
		VerticalLayout contentLayout_Stopped = new VerticalLayout();
		contentLayout_Stopped.addComponent(new WorflowsTable());

		// Tab 3 content
		VerticalLayout contentLayout_Terminated = new VerticalLayout();
		contentLayout_Terminated.addComponent(new WorflowsTable());

		// Tab 4 content
		VerticalLayout contentLayout_Waiting = new VerticalLayout();
		contentLayout_Waiting.addComponent(new WorflowsTable());

		// Tab 5 content
		VerticalLayout contentLayout_Errored = new VerticalLayout();
		contentLayout_Errored.addComponent(new WorflowsTable());

		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		tabSheet.setSizeFull();

		tabSheet.addTab(contentLayout_Completed, "Completed (20)");
		tabSheet.addTab(contentLayout_Stopped, "Stopped (0)");
		tabSheet.addTab(contentLayout_Terminated, "Terminated (11)");
		tabSheet.addTab(contentLayout_Waiting, "Waiting (2)");
		tabSheet.addTab(contentLayout_Errored, "Error (0)");

		// t.addTab(l1, "Saved actions", icon1);
		// t.addTab(l2, "Notes", icon2);
		// t.addTab(l3, "Issues", icon3);
		tabSheet.addListener(this);
		addComponent(tabSheet);
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		
		TabSheet tabsheet = event.getTabSheet();
		Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());
		if (tab != null) {
			
			// getWindow().showNotification("Selected tab: " +
			// tab.getCaption());
		}
	}
}
package com.example.vizioflowdashboard;

import org.vaadin.addon.borderlayout.BorderLayout;

import com.example.vizioflowdashboard.customwidgets.ActivityHostsTable;
import com.example.vizioflowdashboard.customwidgets.FiltersTree;
import com.example.vizioflowdashboard.customwidgets.NotificationsTable;
import com.example.vizioflowdashboard.customwidgets.TitleBar;
import com.example.vizioflowdashboard.customwidgets.WorkflowsTabsLayout;
import com.vaadin.Application;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings({ "serial", "deprecation" })
public class VizioflowdashboardApplication extends Application {

	@Override
	public void init() {

		this.setTheme("vizioflow-theme");

		Window win = new Window();
		win.setWidth("100%");
		win.setHeight("100%");
		win.center();

		VerticalLayout vlo = new VerticalLayout();
		vlo.setHeight("100%");
		vlo.setWidth("100%");
		vlo.setSpacing(true);
		win.setContent(vlo);

		BorderLayout borderLayout = new BorderLayout();

		CustomLayout header = new CustomLayout("header");
		header.setWidth("100%");
		header.setHeight("31px");

		borderLayout.addComponent(header, BorderLayout.Constraint.NORTH);

		CustomLayout main = new CustomLayout("main");
		main.setWidth("100%");
		borderLayout.addComponent(new ApplicationLayoutWindow(),
				BorderLayout.Constraint.CENTER);

		CustomLayout footer = new CustomLayout("footer");
		footer.setWidth("100%");
		footer.setHeight("17px");
		borderLayout.addComponent(footer, BorderLayout.Constraint.SOUTH);

		borderLayout.setSizeFull();
		vlo.addComponent(borderLayout);
		vlo.setExpandRatio(borderLayout, 1);

		((VerticalLayout) win.getContent()).setMargin(false);
		setMainWindow(win);
	}

	private HorizontalLayout getTopBarHorizontalLayout() {
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("100%");
		horizontalLayout.addComponent(new TitleBar("Workflows", "heading-two"));
		return horizontalLayout;
	}

	private GridLayout getUpperGridLayout() {

		GridLayout grid = new GridLayout(2, 1);
		grid.setWidth("100%");
		// grid.setHeight("50%");
		grid.addStyleName("example-gridlayout");

		FiltersTree treeSingleSelectExample = new FiltersTree();
		treeSingleSelectExample.setWidth("200px");

		WorkflowsTabsLayout tabs = new WorkflowsTabsLayout();
		tabs.setWidth("100%");

		grid.addComponent(treeSingleSelectExample, 0, 0);
		grid.addComponent(tabs, 1, 0);

		grid.setColumnExpandRatio(1, 5);

		return grid;
	}

	private HorizontalLayout getLowerHorizontalLayout() {

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("100%");
		VerticalLayout activityHostsVerticalLayout = getActivityHostsVerticalLayout();
		VerticalLayout notificationsVerticalLayout = getNotificationsVerticalLayout();

		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		hsplit.setSplitPosition(60, SplitPanel.UNITS_PERCENTAGE);

		// hsplit.setLocked(true);
		hsplit.setFirstComponent(activityHostsVerticalLayout);
		hsplit.setSecondComponent(notificationsVerticalLayout);
		hsplit.getSecondComponent().setDebugId("notofications-layout");

		horizontalLayout.addComponent(hsplit);

		return horizontalLayout;
	}

	private VerticalLayout getActivityHostsVerticalLayout() {

		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout titleBar = new TitleBar("Activity Hosts",
				"heading-two");
		VerticalLayout tableContainer = new VerticalLayout();
		tableContainer.addComponent(new ActivityHostsTable());
		tableContainer.setDebugId("host-tbl");
		verticalLayout.addComponent(titleBar);
		verticalLayout.addComponent(tableContainer);
		verticalLayout.setSizeFull();
		return verticalLayout;
	}

	private VerticalLayout getNotificationsVerticalLayout() {

		VerticalLayout verticalLayout = new VerticalLayout();
		TitleBar topBar = new TitleBar("Notifications", "heading-two");

		VerticalLayout tableContainer = new VerticalLayout();
		tableContainer.addComponent(new NotificationsTable());
		tableContainer.setDebugId("notify-tbl");
		verticalLayout.addComponent(topBar);
		verticalLayout.addComponent(tableContainer);

		verticalLayout.setSizeFull();
		return verticalLayout;
	}

	public class ApplicationLayoutWindow extends VerticalLayout {

		public ApplicationLayoutWindow() {

			setSizeFull();
			VerticalLayout vl = new VerticalLayout();
			vl.addComponent(getTopBarHorizontalLayout());
			vl.addComponent(getUpperGridLayout());

			HorizontalLayout lower = getLowerHorizontalLayout();

			addComponent(vl);
			addComponent(lower);
			setMargin(false);
			setDebugId("body-wrapper-v-layout");
		}
	}

}

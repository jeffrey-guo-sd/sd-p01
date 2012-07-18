package com.vizioflow.dashboard.customwidgets;

import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vizioflow.dashboard.util.ExampleUtil;

/**
 * TreeWidget to show filters on left side of workflows table.
 * 
 * @author Naeem
 * 
 */
@SuppressWarnings("serial")
public class FiltersTree extends HorizontalLayout {

	// Actions for the menu
	private static final Action ACTION_ADD = new Action("Add child item");
	private static final Action ACTION_DELETE = new Action("Delete");
	static final Action[] ACTIONS = new Action[] { ACTION_ADD, ACTION_DELETE };

	private Tree tree;

	public FiltersTree() {
		setSpacing(true);

		VerticalLayout innerLayout = new VerticalLayout();
		innerLayout.setDebugId("tree-container");

		Label richText = new Label("<h3>Filters</h3>");
		richText.setContentMode(Label.CONTENT_XHTML);

		innerLayout.addComponent(richText);

		tree = new Tree();
		innerLayout.addComponent(tree);

		addComponent(innerLayout);

		// Contents from a (prefilled example) hierarchical container:
		// tree.setContainerDataSource(ExampleUtil.getHardwareContainer());
		tree.setContainerDataSource(getTreeData());

		// Cause valueChange immediately when the user selects
		tree.setImmediate(true);

		// Set tree to show the 'name' property as caption for items
		tree.setItemCaptionPropertyId(ExampleUtil.hw_PROPERTY_NAME);
		tree.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);

		// Expand whole tree
		for (Object id : tree.rootItemIds()) {
			tree.expandItemsRecursively(id);
		}

	}

	public static final Object tree_PROPERTY_NAME = "name";

	private static final String[][] hardware = { //
			/*
			 * { "Mobile", "Samsung Galaxy S", "Samsung Galaxy S II",
			 * "HTC Desire", "Samsung Nexus S" },
			 */
			{ "FG1", "FG1-1", "FG1-2", "FG1-3" },
			{ "FG2", "FG2-1", "FG2-2", "FG2-3" },
			{ "FG3", "FG3-1", "FG3-2", "FG3-3" } };

	public static HierarchicalContainer getTreeData() {

		Item item = null;
		int itemId = 0; // Increasing numbering for itemId:s

		// Create new container
		HierarchicalContainer hierarchicalContainer = new HierarchicalContainer();
		// Create containerproperty for name
		hierarchicalContainer.addContainerProperty(tree_PROPERTY_NAME,
				String.class, null);

		for (int i = 0; i < hardware.length; i++) {
			// Add new item
			item = hierarchicalContainer.addItem(itemId);
			// Add name property for item
			item.getItemProperty(tree_PROPERTY_NAME).setValue(hardware[i][0]);
			// Allow children
			hierarchicalContainer.setChildrenAllowed(itemId, true);
			itemId++;
			for (int j = 1; j < hardware[i].length; j++) {
				// Add child items
				item = hierarchicalContainer.addItem(itemId);
				item.getItemProperty(tree_PROPERTY_NAME).setValue(
						hardware[i][j]);
				hierarchicalContainer.setParent(itemId, itemId - j);
				hierarchicalContainer.setChildrenAllowed(itemId, false);
				itemId++;
			}
		}
		return hierarchicalContainer;
	}
}
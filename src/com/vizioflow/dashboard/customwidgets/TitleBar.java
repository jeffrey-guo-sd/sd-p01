package com.vizioflow.dashboard.customwidgets;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class TitleBar extends HorizontalLayout implements ClickListener {

	private TextField textField;
	private Label richText;

	public TitleBar() {

		setSpacing(true);
		setWidth("100%");

		richText = new Label("<h3>Rich text example</h3>");
		richText.setContentMode(Label.CONTENT_XHTML);
		richText.addStyleName("color");

		addComponent(richText);

		HorizontalLayout innerLayout = new HorizontalLayout();

		textField = new TextField();
		// textField.addStyleName("search");
		textField.addStyleName("search big");
		textField.addStyleName("v-textfield-search");

		innerLayout.addComponent(textField);
		// button = new Button();
		// button.setCaption("Search");
		// button.addListener(this);
		// innerLayout.addComponent(button);

		addComponent(innerLayout);

		setComponentAlignment(innerLayout, Alignment.MIDDLE_RIGHT);
	}

	public TitleBar(String labelText, String headingStyle) {

		setStyleName("titlebar");
		setSpacing(true);
		setMargin(false, true, false, true);
		setWidth("100%");
		
		richText = new Label(labelText);
		richText.setContentMode(Label.CONTENT_XHTML);

		richText.addStyleName(headingStyle);

		addComponent(richText);

		HorizontalLayout innerLayout = new HorizontalLayout();
		innerLayout.addStyleName("search");
		textField = new TextField();
		textField.addStyleName("search");

		innerLayout.addComponent(textField);
		// button = new Button();
		// button.setCaption("Search");
		// button.addListener(this);
		// innerLayout.addComponent(button);

		addComponent(innerLayout);

		setComponentAlignment(innerLayout, Alignment.MIDDLE_RIGHT);
	}

	public void buttonClick(ClickEvent event) {
		// if (getComponentIterator().next() == richText) {
		// editor.setValue(richText.getValue());
		// replaceComponent(richText, editor);
		// b.setCaption("Apply");
		// } else {
		// richText.setValue(editor.getValue());
		// replaceComponent(editor, richText);
		// b.setCaption("Edit");
		// }
	}
}

package com.vizioflow.dashboard.customwidgets;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.BaseTheme;

@SuppressWarnings("serial")
public class LinksHorizontalLayout extends HorizontalLayout {

	public LinksHorizontalLayout(String[] links) {

		super();
		this.setMargin(false, true, false, false);
		for (int i = 0; i < links.length; i++) {

			Button button = new Button(links[i]);
			button.setStyleName(BaseTheme.BUTTON_LINK);
			this.addComponent(button);
		}
	}
}

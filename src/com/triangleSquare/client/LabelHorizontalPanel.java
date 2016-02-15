package com.triangleSquare.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by Антон on 10.02.2016.
 */
public class LabelHorizontalPanel extends HorizontalPanel {


    public LabelHorizontalPanel(Label label, TextBox textBox) {
        super();
        add(label);
        add(textBox);
    }
}

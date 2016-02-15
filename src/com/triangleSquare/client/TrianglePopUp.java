package com.triangleSquare.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Антон on 10.02.2016.
 */
public class TrianglePopUp extends PopupPanel {


    private final Button popup_button = new Button("Calculate");
    private final Button exit = new Button("Cancel");
    private HorizontalPanel buttons_panel = new HorizontalPanel();
    private VerticalPanel mainPanel = new VerticalPanel();
    private TextBox a_text = new TextBox();
    private TextBox b_text = new TextBox();
    private TextBox c_text = new TextBox();
    private Label text = new Label("Enter sides of triangle:");
    private Label a_label = new Label("A:");
    private Label b_label = new Label("B:");
    private Label c_label = new Label("C:");





    public TrianglePopUp(final TriangleTable triangleTable) {
        super(true,true);
        setGlassEnabled(true);


        a_label.setStyleName("label");
        b_label.setStyleName("label");
        c_label.setStyleName("label");


        a_text.setStyleName("textbox");
        b_text.setStyleName("textbox");
        c_text.setStyleName("textbox");


        popup_button.setStyleName("button",true);
        popup_button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {



                if (valid(a_text.getText().trim())){

                    if (valid(b_text.getText().trim())){


                        if (valid(c_text.getText().trim())){

                            triangleTable.addRow(Double.valueOf(a_text.getText().trim()),Double.valueOf(b_text.getText().trim()),Double.valueOf(c_text.getText().trim()));
                            hide();

                        } else {


                            c_text.setStyleName("textbox-error");

                        }


                    } else {
                        b_text.setStyleName("textbox-error");
                    }

                } else {

                    a_text.setStyleName("textbox-error");
                }

            }
        });


        exit.setStyleName("button",true);
        exit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                //hide this popup
                hide();

            }
        });







        buttons_panel.add(popup_button);
        buttons_panel.add(exit);



        mainPanel.add(text);
        mainPanel.add(new LabelHorizontalPanel(a_label,a_text));
        mainPanel.add(new LabelHorizontalPanel(b_label,b_text));
        mainPanel.add(new LabelHorizontalPanel(c_label,c_text));

        mainPanel.add(buttons_panel);


        setWidget(mainPanel);


    }



    public boolean valid(String text){


        try {

            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e){
            return false;
        }

    }
}

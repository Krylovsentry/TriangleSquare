package com.triangleSquare.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.*;


/**
 * Created by Антон on 10.02.2016.
 */
public class TriangleTable extends FlexTable {


    private Storage storage = null;

    public TriangleTable() {
        super();

        storage = Storage.getLocalStorageIfSupported();


        this.setText(0,0,"A");
        this.setText(0,1,"B");
        this.setText(0,2,"C");
        this.setText(0,3,"Result");
        this.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {


                final int row = getCellForEvent(event).getRowIndex();
                final PopupPanel confirm = new PopupPanel(true,true);
                HorizontalPanel button_panel = new HorizontalPanel();
                VerticalPanel main_panel = new VerticalPanel();
                Button yes_button = new Button("Yes");
                Button no_button = new Button("No");
                yes_button.setStyleName("button",true);
                no_button.setStyleName("button",true);
                Label confirm_text = new Label("Are you sure?");
                confirm_text.setStyleName("label");

                button_panel.add(yes_button);
                button_panel.add(no_button);


                main_panel.add(confirm_text);
                main_panel.add(button_panel);

                confirm.add(main_panel);
                confirm.setGlassEnabled(true);
                confirm.center();
                confirm.show();


                //add no button
                no_button.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {

                        //hide popup
                        confirm.hide();
                    }
                });

                //add yes button
                yes_button.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {

                        removeRow(row);
                        confirm.hide();
                    }
                });



            }
        });



    }

    public void addRow(double a,double b , double c){

        //S=sqrt{p(p-a)(p-b)(p-c)}
        double p = (a+b+c)/2;
        double result = Math.sqrt(p*(p-a)*(p-b)*(p-c));




        int row = getRowCount();
        this.setText(row,0,String.valueOf(a));
        this.setText(row,1,String.valueOf(b));
        this.setText(row,2,String.valueOf(c));
        this.setText(row,3,String.valueOf(result));


        this.getRowFormatter().addStyleName(row,"rows");
        for (int i = 0; i <= 3 ; i ++)
        this.getCellFormatter().addStyleName(row,i,"cells");


    }



}

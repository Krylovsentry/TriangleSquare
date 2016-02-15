package com.triangleSquare.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class TriangleSquare implements EntryPoint {


    private TriangleTable triangle_table = new TriangleTable();
    private final Button calc_button = new Button("Calculate");
    private Storage storage = null;




    @Override
    public void onModuleLoad() {


        storage = Storage.getLocalStorageIfSupported();

        if (storage != null){


            for (int i = 0 ; i < storage.getLength(); i++){


            }

        }


        calc_button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {


                TrianglePopUp popUp = new TrianglePopUp(triangle_table);
                popUp.center();
                popUp.show();



            }
        });



        RootPanel.get().add(calc_button);
        RootPanel.get().add(triangle_table);
        RootPanel.get().setStyleName("body");




        triangle_table.setStyleName("table",true);

        calc_button.setStyleName("button",true);


    }

}

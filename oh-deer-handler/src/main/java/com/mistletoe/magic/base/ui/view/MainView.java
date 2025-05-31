package com.mistletoe.magic.base.ui.view;

import com.mistletoe.magic.base.ui.component.ViewToolbar;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.button.Button;

/**
 * This view shows up when a user navigates to the root ('/') of the application.
 */
@Route
@PermitAll // When security is enabled, allow all authenticated users
public final class MainView extends Main {

    private final List<Book> bookList=new ArrayList<>();
    private final Grid<Book> grid=new Grid<>(Book.class);

    public MainView(){
        addClassName(LumoUtility.Padding.MEDIUM);
        setSizeFull();

        TextField titleField=new TextField("本の名前");
        TextField authorField=new TextField("作者");
        DatePicker datePicker=new DatePicker("購入日付");

        Button addButton = new Button("本を登録");
        Button deleteButton = new Button("選択した本を削除");

        HorizontalLayout form=new HorizontalLayout(titleField, authorField, datePicker, addButton, deleteButton);
        form.setSpacing(true);

        grid.setColumns("title","author","purchaseDate");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setSizeFull();

        addButton.addClickListener(e->{
            String title=titleField.getValue();
            String author=authorField.getValue();
            LocalDate date=datePicker.getValue();

            if(!title.isEmpty() && !author.isEmpty() && date !=null){
                bookList.add(new Book(title,author,date));
                grid.setItems(bookList);
                titleField.clear();
                authorField.clear();
                datePicker.clear();
            }
        });

        deleteButton.addClickListener(e->{
            Book selected=grid.asSingleSelect().getValue();
            if(selected !=null){
                bookList.remove(selected);
                grid.setItems(bookList);
            }
        });
        add(form,grid);
    }

}

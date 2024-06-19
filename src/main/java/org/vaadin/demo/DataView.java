package org.vaadin.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "data", layout = MainLayout.class)
public class DataView extends VerticalLayout {

  private List<Person> people = new ArrayList<>();
  private Grid<Person> grid = new Grid<>(Person.class);
  private ListDataProvider<Person> dataProvider
      = new ListDataProvider<>(people);

  public DataView() {
    var firstNameField = new TextField("First Name");
    var lastNameField = new TextField("Last Name");
    var addButton = new Button("Add Person",
        event -> {
          people.add(
              new Person(firstNameField.getValue(),
                         lastNameField.getValue()));
          dataProvider.refreshAll();
        });
    grid.setDataProvider(dataProvider);
    add(firstNameField, lastNameField, addButton, grid);
  }
}




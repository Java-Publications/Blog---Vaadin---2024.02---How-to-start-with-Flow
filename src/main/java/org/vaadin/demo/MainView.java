package org.vaadin.demo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView() {
        TextField textField = new TextField("Your name");
        GreetService greetService = new GreetService();
        Button button
            = new Button("Say hello",
                         e -> {
                             String value = textField.getValue();
                             String greet = greetService.greet(value);
                             Paragraph paragraph = new Paragraph(greet);
                             add(paragraph);
        });
        add(textField, button);
    }
}

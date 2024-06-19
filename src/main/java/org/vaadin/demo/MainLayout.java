package org.vaadin.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

  public MainLayout() {
    createHeader();
  }

  private void createHeader() {
    RouterLink mainLink = new RouterLink("Hello World", MainView.class);
    RouterLink dataLink = new RouterLink("Data View", DataView.class);
    addToNavbar(new HorizontalLayout(mainLink, dataLink));
  }
}


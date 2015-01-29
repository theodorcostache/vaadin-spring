package de.costache.demo;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MyVaadinUIProvider extends UIProvider {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent uiClassSelectionEvent) {
        return MyVaadinUI.class;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
        UI instance = new MyVaadinUI();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(instance);
        return instance;
    }
}
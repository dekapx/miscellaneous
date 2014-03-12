package com.kapx.gof.patterns.behavioral.observer;

public class TestObserver {

    public static void main(String[] args) {
        ViewManager viewManager = new ViewManagerImpl();

        IView outlineView = new OutlineView();
        IView propertyView = new PropertyView();

        viewManager.addView(outlineView);
        viewManager.addView(propertyView);

        Event event = new Event();
        event.setEventType("New Java File...");
        viewManager.setEvent(event);

        viewManager.removeView(propertyView);

        System.out.println("\n------------------------------------------\n");
        Event event2 = new Event();
        event2.setEventType("New XML File...");
        viewManager.setEvent(event2);
    }

}

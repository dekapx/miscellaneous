package com.kapx.gof.patterns.behavioral.observer;

public interface ViewManager {
    void addView(IView iView);

    void removeView(IView iView);

    void setEvent(Event event);
}

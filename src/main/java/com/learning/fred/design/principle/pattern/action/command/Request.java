package com.learning.fred.design.principle.pattern.action.command;

/**
 * @author fred
 * @date 2021/1/6 13:54
 * @description todo
 */
public class Request {

    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
class Event {

    public static final Event GOT_DIAMOND = null;
    public static final Event GOT_STAR = null;
    public static final Event HIT_OBSTACLE = null;
    public static final Event ARCHIVE = null;
}

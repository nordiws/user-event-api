package com.dynaccurate.UserEventsAPI.utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dynaccurate.UserEventsAPI.models.Event;

public final class EventsUtilities {

    public static List<Event> sortEvents(String sort, List<Event> array) {

        if (sort != null) {
            switch (sort) {
                case "ascending":
                    Collections.sort(array, new Comparator<Event>() {
                        public int compare(Event event1, Event event2) {
                            return event1.getEventType().compareTo(event2.getEventType());
                        }
                    });
                    break;
                case "descending":
                    Collections.sort(array, new Comparator<Event>() {
                        public int compare(Event event1, Event event2) {
                            return event2.getEventType().compareTo(event1.getEventType());
                        }
                    });
                    break;
                case "newer":
                    Collections.sort(array, new Comparator<Event>() {
                        public int compare(Event event1, Event event2) {
                            return event2.getEventDateTime().compareTo(event1.getEventDateTime());
                        }
                    });
                    break;
                case "older":
                    Collections.sort(array, new Comparator<Event>() {
                        public int compare(Event event1, Event event2) {
                            return event1.getEventDateTime().compareTo(event2.getEventDateTime());
                        }
                    });
                    break;
            }
        }
        return array;
    }

}

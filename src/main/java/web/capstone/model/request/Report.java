package web.capstone.model.request;

import lombok.Data;
import web.capstone.entities.Event;
import web.capstone.entities.Gallery;

import java.util.List;

@Data
public class Report {
    private Gallery gallery;
    private Long totalOpenCount;
    List<Event> events;

    public Report(Gallery gallery, Long totalOpenCount, List<Event> events) {
        this.gallery = gallery;
        this.totalOpenCount = totalOpenCount;
        this.events = events;
    }
}

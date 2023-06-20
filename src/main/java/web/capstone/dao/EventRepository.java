package web.capstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.Event;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.gallery.id = ?1 ORDER BY e.id ASC")
    List<Event> getAllEventsByGalleryId(Long galleryId);
}

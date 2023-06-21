package web.capstone.services;

import org.springframework.stereotype.Service;
import web.capstone.dao.EventRepository;
import web.capstone.dao.GalleryRepository;
import web.capstone.entities.Event;
import web.capstone.entities.Gallery;
import web.capstone.model.Report;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    final GalleryRepository galleryRepository;
    final EventRepository eventRepository;

    public ReportServiceImpl(GalleryRepository galleryRepository, EventRepository eventRepository) {
        this.galleryRepository = galleryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Report> getAllUserReports(Long userId) {
        List<Gallery> userGalleries = galleryRepository.findAllByUserId(userId);
        return userGalleries.stream().map(this::generateGalleryReport).toList();

    }

    private Report generateGalleryReport(Gallery gallery) {
        List<Event> events = eventRepository.getAllEventsByGalleryId(gallery.getId());
        long emailsCount = events.size();
        return new Report(gallery, emailsCount, events);
    }
}

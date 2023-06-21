package servces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web.capstone.dao.EventRepository;
import web.capstone.dao.GalleryRepository;
import web.capstone.entities.Event;
import web.capstone.entities.Gallery;
import web.capstone.entities.User;
import web.capstone.model.Report;
import web.capstone.services.ReportServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {

    @Mock
    private GalleryRepository galleryRepository;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private ReportServiceImpl reportService;

    private Gallery gallery1, gallery2;
    private Event event1, event2;

    private User user;

    @BeforeEach
    public void setup() {
        user = new User();
        user.setId(1L);
        gallery1 = new Gallery();
        gallery1.setId(1L);
        gallery1.setName("Test Gallery");
        gallery1.setDescription("Test Description");
        gallery1.setCoverUrl("Test Cover URL");
        gallery1.setUser(user);
        gallery2 = new Gallery();
        gallery2.setId(2L);
        gallery2.setUser(user);
        event1 = new Event("email1", null, gallery1);
        event2 = new Event("email2", null, gallery2);
    }

    @Test
    public void getAllUserReportsShouldReturnUserReports() {
        long userId = user.getId();
        when(galleryRepository.findAllByUserId(userId)).thenReturn(List.of(gallery1));
        when(eventRepository.getAllEventsByGalleryId(userId)).thenReturn(List.of(event1));

        List<Report> reports = reportService.getAllUserReports(userId);

        assertEquals(1, reports.size());
        verify(galleryRepository, times(1)).findAllByUserId(userId);
        verify(eventRepository, times(1)).getAllEventsByGalleryId(userId);
    }

    @Test
    public void getAllUserReportsShouldReturnEmptyListWhenNoGalleries() {
        long userId = user.getId();
        when(galleryRepository.findAllByUserId(userId)).thenReturn(List.of());

        List<Report> reports = reportService.getAllUserReports(userId);

        assertEquals(0, reports.size());
        verify(galleryRepository, times(1)).findAllByUserId(userId);
        verify(eventRepository, never()).getAllEventsByGalleryId(anyLong());
    }

    @Test
    public void getAllUserReportsShouldReturnMultipleReportsWhenMultipleGalleries() {
        long userId = user.getId();
        when(galleryRepository.findAllByUserId(userId)).thenReturn(List.of(gallery1, gallery2));
        when(eventRepository.getAllEventsByGalleryId(userId)).thenReturn(List.of(event2));

        List<Report> reports = reportService.getAllUserReports(userId);

        assertEquals(2, reports.size());
        verify(galleryRepository, times(1)).findAllByUserId(userId);
        verify(eventRepository, times(2)).getAllEventsByGalleryId(anyLong());
    }

    @Test
    public void getAllUserReportsShouldReturnReportWithZeroEventsWhenNoEvents() {
        long userId = user.getId();
        when(galleryRepository.findAllByUserId(userId)).thenReturn(List.of(gallery1));
        when(eventRepository.getAllEventsByGalleryId(userId)).thenReturn(List.of());

        List<Report> reports = reportService.getAllUserReports(userId);

        assertEquals(1, reports.size());
        assertEquals(0, reports.get(0).getEvents().size());
        verify(galleryRepository, times(1)).findAllByUserId(userId);
        verify(eventRepository, times(1)).getAllEventsByGalleryId(1L);
    }

}
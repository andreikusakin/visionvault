package web.capstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.Gallery;

import java.util.List;

@CrossOrigin
@RequestMapping("/api")
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    @Query("SELECT g FROM Gallery g WHERE g.user = ?1")
    List<Gallery> findAllByUserId(Long userId);
}

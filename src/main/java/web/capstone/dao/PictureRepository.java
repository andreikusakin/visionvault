package web.capstone.dao;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.Picture;

@CrossOrigin
@RequestMapping("/api")
public interface PictureRepository extends JpaRepository<Picture, Long> {

  @Query("SELECT p FROM Picture p WHERE p.gallery.id = ?1")
  List<Picture> findPicturesByGalleryId(Long galleryId);

  @Transactional
  @Modifying
  @Query("DELETE FROM Picture p WHERE p.gallery.id = ?1")
  void deleteAllByGalleryId(Long galleryId);
}

package web.capstone.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.Gallery;

@CrossOrigin
@RequestMapping("/api")
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

  @Query("SELECT g FROM Gallery g WHERE g.user.id = ?1 ORDER BY g.id ASC")
  List<Gallery> findAllByUserId(Long userId);

  @Query("SELECT g FROM Gallery g WHERE g.id = ?1 And g.user.id = ?2")
  Optional<Gallery> findByIdAndUserId(Long id, Long userId);

  @Query("SELECT g FROM Gallery g WHERE g.id = ?1 And g.password = ?2")
  Optional<Gallery> findByIdAndPassword(Long id, String password);
}

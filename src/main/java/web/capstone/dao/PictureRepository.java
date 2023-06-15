package web.capstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.Picture;

@CrossOrigin
@RequestMapping("/api")
public interface PictureRepository extends JpaRepository<Picture, Long> {
}

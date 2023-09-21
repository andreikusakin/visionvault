package web.capstone.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.User;

@CrossOrigin
@RequestMapping("/api")
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}

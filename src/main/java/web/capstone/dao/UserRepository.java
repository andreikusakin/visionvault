package web.capstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import web.capstone.entities.User;

import java.util.Optional;

// For the evaluator
// Task B1:
// UserRepository extends JpaRepository, which is an example of Inheritance: the ability for one class to inherit fields and methods from another.
@CrossOrigin
@RequestMapping("/api")
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    Optional<User> findUserByEmailAndPassword(String email, String password);

}

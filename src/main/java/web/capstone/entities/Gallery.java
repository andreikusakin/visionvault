package web.capstone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(
    name = "galleries",
    indexes = {@Index(name = "index_user_id", columnList = "user_id")})
public class Gallery {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String name;
  private String password;

  private String description;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @OneToMany(mappedBy = "gallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Picture> pictures;

  private String coverUrl;
}

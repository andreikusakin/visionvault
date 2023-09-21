package web.capstone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(
    name = "events",
    indexes = {@Index(name = "index_event_gallery_id", columnList = "gallery_id")})
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "gallery_id")
  @JsonIgnore
  private Gallery gallery;

  public Event(String email, Date date, Gallery gallery) {
    this.email = email;
    this.date = date;
    this.gallery = gallery;
  }

  public Event() {}
}

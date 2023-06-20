package web.capstone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "galleries", indexes = {@Index(name = "index_user_id", columnList = "user_id")})
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "gallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Picture> pictures;

    private String coverUrl;

}

package by.nexer.placesservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "place")
@Getter
@Setter
@NoArgsConstructor
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripEntity trip;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "photo_url")
    private String photoUrl;
}

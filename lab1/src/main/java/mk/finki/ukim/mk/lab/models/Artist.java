package mk.finki.ukim.mk.lab.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Random;


@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "biography")
    private String bio;

    @ManyToMany(mappedBy = "performers")
    private List<Song> songs;

    public Artist() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }
}


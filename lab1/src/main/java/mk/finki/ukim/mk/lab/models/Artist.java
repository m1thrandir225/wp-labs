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

    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getBio() {
        return this.bio;
    }

    public List<Song> getSongs() {
        return this.songs;
    }
}


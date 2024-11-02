package mk.finki.ukim.mk.lab.models;

import java.util.Random;

public class Artist {
    Long id;
    String firstName;
    String lastName;
    String bio;

    public Artist(String firstName, String lastName, String bio) {
        this.id = new Random().nextLong();
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }
}


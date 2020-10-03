package Entities;

import java.math.BigInteger;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private long card;
    private Role role;

    public User() {
    }

    public User(int id, String username, String password, String email, long card, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getCard() {
        return card;
    }

    public Role getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

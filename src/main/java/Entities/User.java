package Entities;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private long card;
    private Role role;

    protected User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    protected User(int id, String username, String password, String email, Long card,String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = new Role(roleName);
    }

    protected User(int id, String username, String password, String email, Long card,int roleId, String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = new Role(roleId,roleName);
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

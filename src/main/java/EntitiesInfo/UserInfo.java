package EntitiesInfo;

import Entities.Role;

import java.math.BigInteger;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String email;
    private long card;
    private RoleInfo role;

    protected UserInfo(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserInfo(String username, String password, String email, long card, RoleInfo role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = role;
    }

    public UserInfo(String username, String password, String email, Long card,String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = new RoleInfo(roleName);
    }

    public UserInfo(int id, String username, String password, String email, Long card,String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = new RoleInfo(roleName);
    }

    public UserInfo(int id, String username, String password, String email, Long card,int roleId, String roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.card = card;
        this.role = new RoleInfo(roleId,roleName);
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

    public RoleInfo getRole() {
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

    public void setRole(RoleInfo role) {
        this.role = role;
    }

    public void setRole(int id, String name){
        this.role.setId(id);
        this.role.setName(name);
    }
}

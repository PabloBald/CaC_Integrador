package entities;

public class Usuario {

    private int id;
    private String username;
    private String password;
    private int baja;

    public int getId() {
        return id;
    }

    public Usuario() {
    }

    public Usuario(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Usuario(int id, String username, String password, int baja) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.baja = baja;
    }

    public int getBaja() {
        return baja;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", baja=" + baja + '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

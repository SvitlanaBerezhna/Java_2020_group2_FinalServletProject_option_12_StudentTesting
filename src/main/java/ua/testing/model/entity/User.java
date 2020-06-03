package ua.testing.model.entity;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String first_name;
    private String first_name_en;
    private String last_name;
    private String last_name_en;
    private String activation_code;
    private int grade;
    private String role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name_en() {
        return first_name_en;
    }

    public void setFirst_name_en(String first_name_en) {
        this.first_name_en = first_name_en;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name_en() {
        return last_name_en;
    }

    public void setLast_name_en(String last_name_en) {
        this.last_name_en = last_name_en;
    }

    public String getActivation_code() {
        return activation_code;
    }

    public void setActivation_code(String activation_code) {
        this.activation_code = activation_code;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", first_name_en='" + first_name_en + '\'' +
                ", last_name='" + last_name + '\'' +
                ", last_name_en='" + last_name_en + '\'' +
                ", activation_code='" + activation_code + '\'' +
                ", grade=" + grade +
                ", role='" + role + '\'' +
                '}';
    }
}

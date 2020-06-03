package ua.testing.model.entity;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Theme {
    private int id;
    private String theme;
    private String theme_en;
    private String description;
    private String description_en;
    private int time;
    private int passing_grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTheme_en() {
        return theme_en;
    }

    public void setTheme_en(String theme_en) {
        this.theme_en = theme_en;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPassing_grade() {
        return passing_grade;
    }

    public void setPassing_grade(int passing_grade) {
        this.passing_grade = passing_grade;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", theme_en='" + theme_en + '\'' +
                ", description='" + description + '\'' +
                ", description_en='" + description_en + '\'' +
                ", time=" + time +
                ", passing_grade=" + passing_grade +
                '}';
    }
}

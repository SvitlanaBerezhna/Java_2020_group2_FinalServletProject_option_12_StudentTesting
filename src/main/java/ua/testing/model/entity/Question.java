package ua.testing.model.entity;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Question {
    private int theme_id;
    private int question_id;
    private String theme;
    private String question;
    private String explanation;
    private String theme_en;
    private String question_en;
    private String explanation_en;
    private List<Answer> answers;
    private int answers_count;
    private int time;

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTheme_en() {
        return theme_en;
    }

    public void setTheme_en(String theme_en) {
        this.theme_en = theme_en;
    }

    public String getQuestion_en() {
        return question_en;
    }

    public void setQuestion_en(String question_en) {
        this.question_en = question_en;
    }

    public String getExplanation_en() {
        return explanation_en;
    }

    public void setExplanation_en(String explanation_en) {
        this.explanation_en = explanation_en;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getAnswers_count() {
        return answers_count;
    }

    public void setAnswers_count(int answers_count) {
        this.answers_count = answers_count;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "theme_id=" + theme_id +
                ", question_id=" + question_id +
                ", theme='" + theme + '\'' +
                ", question='" + question + '\'' +
                ", explanation='" + explanation + '\'' +
                ", theme_en='" + theme_en + '\'' +
                ", question_en='" + question_en + '\'' +
                ", explanation_en='" + explanation_en + '\'' +
                ", answers=" + answers +
                ", answers_count=" + answers_count +
                ", time=" + time +
                '}';
    }
}

package ua.testing.model.entity;

import java.util.List;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Test {
    private int id;
    private int question_id;
    private String question;
    private String explanation;
    private int answer_id;
    private String answer_option;
    private int is_correct;
    private int answer;
    private int grade;
    private int user_id;
    private int theme_id;
    private String theme;
    private List<Answer> answers;
    private int answers_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer_option() {
        return answer_option;
    }

    public void setAnswer_option(String answer_option) {
        this.answer_option = answer_option;
    }

    public int getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(int is_correct) {
        this.is_correct = is_correct;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", question_id=" + question_id +
                ", question='" + question + '\'' +
                ", explanation='" + explanation + '\'' +
                ", answer_id=" + answer_id +
                ", answer_option='" + answer_option + '\'' +
                ", is_correct=" + is_correct +
                ", answer=" + answer +
                ", grade=" + grade +
                ", user_id=" + user_id +
                ", theme_id=" + theme_id +
                ", theme='" + theme + '\'' +
                ", answers=" + answers +
                ", answers_count=" + answers_count +
                '}';
    }
}

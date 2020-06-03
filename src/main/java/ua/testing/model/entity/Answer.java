package ua.testing.model.entity;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public class Answer {
    private int question_id;
    private int answer_id;
    private String question;
    private String answer_option;
    private String question_en;
    private String answer_option_en;
    private int is_correct;
    private int grade;
    private int answer;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_option() {
        return answer_option;
    }

    public void setAnswer_option(String answer_option) {
        this.answer_option = answer_option;
    }

    public String getQuestion_en() {
        return question_en;
    }

    public void setQuestion_en(String question_en) {
        this.question_en = question_en;
    }

    public String getAnswer_option_en() {
        return answer_option_en;
    }

    public void setAnswer_option_en(String answer_option_en) {
        this.answer_option_en = answer_option_en;
    }

    public int getIs_correct() {
        return is_correct;
    }

    public void setIs_correct(int is_correct) {
        this.is_correct = is_correct;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question_id=" + question_id +
                ", answer_id=" + answer_id +
                ", question='" + question + '\'' +
                ", answer_option='" + answer_option + '\'' +
                ", question_en='" + question_en + '\'' +
                ", answer_option_en='" + answer_option_en + '\'' +
                ", is_correct=" + is_correct +
                ", grade=" + grade +
                ", answer=" + answer +
                '}';
    }
}

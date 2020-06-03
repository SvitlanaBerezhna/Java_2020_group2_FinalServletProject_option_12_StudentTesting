package ua.testing.config;

/**
 * <h1>Final Servlet Project (option 12) – Student Testing</h1>
 *
 * @author Svitlana Berezhna
 * @version 1.0
 * @since 2020-04-21
 */
public interface Regex {
    String NAME_REGEX = "[A-Z]{1}[a-z]{1,15}";
    String NAME_UKR_REGEX = "[A-ЯҐІЇЄ]{1}[а-яґіїє']{1,15}";
    String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    String PASSWORD_REGEX = "[a-zA-Z0-9]{8,20}";
}

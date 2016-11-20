package ua.demitt.homework.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Const {

    //Items:
    public static final int ITEM_MIN_VALUE = 0;
    public static final int ITEM_MAX_VALUE = 200;
    public static final LocalDate ITEM_MIN_DATE = LocalDate.of(2016, 1, 1);
    public static final int ITEMS_COUNT = 50;
    public static final String ITEM_DEFAULT_PREFIX = "item";
    public static final String ITEM_DATE_DELIMITER = "-";
    public static final DateTimeFormatter ITEM_DATE_FORMATTER = DateTimeFormatter.ofPattern(
        "dd" + ITEM_DATE_DELIMITER + "MM" + ITEM_DATE_DELIMITER +"yyyy"
    );

    //Navigation
    public static final String NAVIGATION_LOGIN_PAGE_FULL_PATH = "/resources/templates/login.xhtml";
    public enum View {
        LOGIN("loginOutcome"),
        DISPLAY("displayOutcome"),
        ADD("addOutcome")
        ;

        private String value;

        View(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    //Session:
    public static final String SESSION_USER_ID_NAME = "userId";

    //Messages:
    public class Message {
        public class Login {
            public static final String USER_NOT_FOUND = "Такой пользователь не найден.";
        }
        public class Register {
            public static final String ERROR = "Такой пользователь уже существует или пароли не совпадают.";
            //^ TODO: по-хорошему необходимо разграничить эти два случая (например, возвратом энама или через Exception)
            public static final String COMPLETED = "Вы успешно зарегистрировались. Теперь можно авторизоваться.";
        }
        public class Item {
            public static final String ADDED = "Запись добавлена.";
            public static final String HASNT_ADDED = "Запись не добавлена, т.к. запись для этой даты уже существует.";
        }

    }

}

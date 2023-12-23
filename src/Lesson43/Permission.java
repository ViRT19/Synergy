package Lesson3;

public class Permission {
    boolean administrator;
    boolean moderator;
    boolean user;

    Permission (boolean administrator, boolean moderator, boolean user) {
        this.administrator = administrator;
        this.moderator = moderator;
        this.user = user;
    }
}

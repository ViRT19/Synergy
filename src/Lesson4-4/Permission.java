package Lesson4;

public class Permission {
    String name;
    String permission;
    Permission (String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public void printPermission() {
        System.out.println("Name: " + name + " Permission: " + permission);
    }
}

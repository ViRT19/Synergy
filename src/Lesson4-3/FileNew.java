package Lesson3;

class FileNew extends File {
    FileNew(String dirName, String fileName, double size) {
        super(dirName, fileName, size);
        Permission permission = new Permission(false, true, true);
    }
}

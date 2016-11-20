package ua.demitt.homework.dao;

public interface UserDao {
    String getPasswordByEmail(String email);
    void createUser(String email, String password);
    boolean isUserExists(String email);
}

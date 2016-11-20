package ua.demitt.homework.service;

public interface UserService {
    boolean login(String email, String password);
    boolean register(String email, String password, String passwordRepeat);
}

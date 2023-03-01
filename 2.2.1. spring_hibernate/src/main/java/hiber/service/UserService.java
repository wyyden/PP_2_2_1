package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.Calendar;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    List<User> getUser(String model, int series);
}

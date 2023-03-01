package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);
      Car car1 = new Car("Bmw", 520);
      Car car2 = new Car("Bmw", 525);
      Car car3 = new Car("Bmw", 535);
      Car car4 = new Car("Bmw", 530);
      carService.addCar(car1);
      carService.addCar(car2);
      carService.addCar(car3);
      carService.addCar(car4);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car id = "+user.getCar());
         System.out.println();
      }
      List<User> users1 = userService.getUser("bmw", 520);
      System.out.println("----------------------");
      users1.forEach(System.out::println);
      context.close();
   }
}

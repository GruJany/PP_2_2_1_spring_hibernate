package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Petr", "Verhovensky", "petr@mail.ru");
      User user2 = new User("Nicolay", "Stavrogin", "kolya@mail.ru");
      User user3 = new User("Alexey", "Kirillov", "lesha@mail.ru");
      user1.setCar(new Car("Lada", 123));
      user2.setCar(new Car("BMW", 456));
      user3.setCar(new Car("Reno", 789));
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      List<User> users = userService.listUsers();
      System.out.println(users);
      System.out.println(userService.getUserByCar("Lada", 123));
      context.close();
   }
}

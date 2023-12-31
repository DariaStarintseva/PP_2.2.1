package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new Car("Car1", 11));
      userService.add(new Car("Car2", 22));
      userService.add(new Car("Car3", 33));
      userService.add(new Car("Car4", 44));
      List<Car> cars = userService.listCars();



      userService.add(new User("User1", "Lastname1", "user1@mail.ru", cars.get(0)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", cars.get(1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", cars.get(2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", cars.get(3)));


      List<User> users = userService.listUsers();



      for (User user : users) {

         System.out.println(user);
      }

      System.out.println(userService.getUserByCarModelAndSeries("Car3", 33));


      context.close();
   }
}

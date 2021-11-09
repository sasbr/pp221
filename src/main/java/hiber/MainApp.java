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
      Car car1=new Car("Mers",12);
      Car car2=new Car("Ferr",23);
      Car car3=new Car("WV",123);



      userService.add(new User("Ivan", "Ivanov", "ii@mail.ru", car1));
      userService.add(new User("Serg", "Sergeev", "serg@mail.ru", car2 ));
      userService.add(new User("jon", "Tomov", "JT@mail.ru", car3));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id: " + user.getId());
         System.out.println("First Name: " + user.getFirstName());
         System.out.println("Last Name: " + user.getLastName());
         System.out.println("Email: " + user.getEmail());
         System.out.println("Car: " + user.getCar());
         System.out.println();
      }
      System.out.println();
      System.out.println("-----------");
      System.out.println(userService.getUserByModelSeries("Ferr", 23));
      System.out.println(userService.getUserByModelSeries("WV", 123));
      System.out.println("-----------");


      context.close();
   }
}

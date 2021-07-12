package com.epam.travelAgency.main;

import com.epam.travelAgency.controller.command.impl.SendEmail;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.DateDAO;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.entity.UserRole;
import com.epam.travelAgency.service.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.print.Doc;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestPool {
    public static void main(String[] args) throws ServiceException, IOException {

//        ResourceBundle resourceBundle = ResourceBundle.getBundle("lang");
//        ResourceBundle resource_en= ResourceBundle.getBundle("lang", new Locale("en", "USA"));
//        ResourceBundle resource_ru= ResourceBundle.getBundle("lang", new Locale("ru", "Ru"));
//
//        System.out.println(resourceBundle.getString("user.login.authorisation"));
//        System.out.println(resource_en.getString("user.login.authorisation"));
//        System.out.println(resource_ru.getString("user.login.authorisation"));

//        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
//        String dbUrl = resourceBundle.getString("dbUrl");
//        String dbUser = resourceBundle.getString("dbUser");
//        String dbPassword = resourceBundle.getString("dbPassword");
//
//        Connection conn = null;
//        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 2);
//        try{
//            conn = pool.getConnection();
//            try(Statement statement = conn.createStatement()){
//                ResultSet res = statement.executeQuery("select * from tour");
//                System.out.println("There are below tables: ");
//                while (res.next()){
//                    System.out.print(res.getString("id"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("email"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("password"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("role"));
//                    System.out.println();
////
////                    System.out.print(res.getString(1));
////                    System.out.print("| ");
////                    System.out.print(res.getString(2));
////                    System.out.print("| ");
////                    System.out.print(res.getString(3));
////                    System.out.print("| ");
////                    System.out.print(res.getString(4));
////                    System.out.print("| ");
////                    System.out.print(res.getString(5));
////                    System.out.print("| ");
////                    System.out.print(res.getString(6));
////                    System.out.print("| ");
////                    System.out.print(res.getString(7));
////                    System.out.print("| ");
////                    System.out.print(res.getString(8));
////                    System.out.print("| ");
////                    System.out.print(res.getString(9));
////                    System.out.print("| ");
////                    System.out.print(res.getString(10));
////                    System.out.print("| ");
////                    System.out.print(res.getString(11));
////                    System.out.print("| ");
////                    System.out.print(res.getString(12));
////                    System.out.print("| ");
////                    System.out.print(res.getString(13));
////                    System.out.print("| ");
////                    System.out.print(res.getString(14));
////                    System.out.println();
//                }
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        } finally {
//            if(conn != null){
//                try{
//                    pool.returnConnection(conn);
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        ServiceProvider provider = ServiceProvider.getInstance();
//        UserService userService = provider.getUserService();
//        CategoryService categoryService = provider.getCategoryService();
//        UserEntity user = null;
//        TourDAO tourDao = new TourDaoImpl();
////        UserEntity user = userDao.getUserByEmailAndPassword("lerasemenenya@gmail.com", "111");
////        System.out.println(user.toString());
////
//        try {
//            Set<TourEntity> tours = tourDao.getTourByStartParams("Отпуск", "Турция",
//                    LocalDate.of(2021, 6, 1),
//                    LocalDate.of(2021, 6, 30), 2, 0);
//
//        //    for(TourEntity tour : tours) {
//
//
//                System.out.println(tours);
//
//         //   }
//
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }

//        UserDao userDao = new UserDaoImpl();
//        UserEntity user = new UserEntity(20, "kk@gmail.com", "11223344", UserRole.CUSTOMER);
////        UserEntity user = userDao.getUserByEmailAndPassword("lerasemenenya@gmail.com", "111");
////        System.out.println(user.toString());
////
//        try {
//        //   boolean isOk = userDao.isUserUpdate(user);
//            System.out.println(isOk);
//
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//
//        UserEntity usert = new UserEntity("lera", "ttt", UserRole.AGENT);
//
//      //  userDao.addUser(usert);
//
//        ServiceProvider serviceProvider = ServiceProvider.getInstance();
//        TourService tourService = serviceProvider.getTourService();
//        MealsService mealsService = serviceProvider.getMealsService();
//        HotelService hotelService = serviceProvider.getHotelService();
//        TransportService transportService = serviceProvider.getTransportService();
//        DateTourService dateTourService = serviceProvider.getDateTourService();
//        TourCustomerService tourCustomerService = serviceProvider.getTourCustomerService();
//
//        try {
//           List<LocalDate> arrivalDates = dateTourService.getArrivalDatesByIdTour(1);
//           List<LocalDate> departureDates = dateTourService.getDepartureDatesByIdTour(1);
//
//            System.out.println(arrivalDates);
//            System.out.println(departureDates);
//            tourCustomerService.buyTour(1, 23);
//
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        System.out.println(user.toString());
//        Iterable<CategoryEntity> categories = categoryService.getAllCategories();
//
//        for(CategoryEntity categoryEntity: categories){
//           System.out.println(categoryEntity.getName());
//        }
    //    System.out.println();
   //     userDao.deleteUser(17);
//        userDao.deleteUser(14);
//        userDao.deleteUser(15);
//        userDao.deleteUser(16);

//        final Properties properties = new Properties();
//        properties.load(SendEmail.class.getClassLoader().getResourceAsStream("mail.properties"));
//
//        Session mailSession = Session.getDefaultInstance(properties);
//        MimeMessage message = new MimeMessage(mailSession);
//        try {
//            message.setFrom(new InternetAddress("happy.tour.minsk"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("lerasemenenya@gmail.com"));
//            message.setSubject("Hello");
//            message. setText("Welcome to Happy Tour :)");
//
//            Transport tr = mailSession.getTransport();
//            tr.connect(null, "happyTourMinsk");
//            tr.sendMessage(message, message.getAllRecipients());
//            tr.close();
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }
}

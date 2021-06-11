package com.epam.travelAgency.main;

import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.entity.UserEntity;
import com.epam.travelAgency.service.CategoryService;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.ServiceProvider;
import com.epam.travelAgency.service.UserService;

public class TestPool {
    public static void main(String[] args) throws ServiceException {
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
        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();
        CategoryService categoryService = provider.getCategoryService();
        UserEntity user = null;
      //  UserDaoImpl userDao = new UserDaoImpl();
//        UserEntity user = userDao.getUserByEmailAndPassword("lerasemenenya@gmail.com", "111");
//        System.out.println(user.toString());
//
//        List<UserEntity> users = userDao.getAllUsers();
//         System.out.println(users);
//
//        UserEntity usert = new UserEntity("lera", "ttt", UserRole.AGENT);
//
//      //  userDao.addUser(usert);
//
       // UserEntity user = null;
//        try {
//            user = userService.getUserByEmailAndPassword("lera", "ttt");
//        } catch ( ServiceException e) {
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
    }
}

package org.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.persistance.UserRepository;

public class ShippingListApp extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        //        User user = new User("ala", "123");
//        ShoppingList shoppingList = new ShoppingList();
//        user.getAllLists().add(shoppingList);
//        shoppingList.getItems().add(new Item("zegarek", 1, MeasureEnum.szt));
//        shoppingList.getItems().add(new Item("obroza", 1, MeasureEnum.szt));
//        UserRepository.getInstance().add(user);
//
//        UserRepository.getInstance().saveAll();
//        var users = UserRepository.getInstance().getAll();
        System.out.println("done");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ShoppingList App");
        stage.setScene(scene);
        stage.show();
    }
}

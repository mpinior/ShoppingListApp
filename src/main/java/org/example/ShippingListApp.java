package org.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.persistance.PersistanceHelper;
import org.example.persistance.UserRepository;

public class ShippingListApp extends Application {
    private Stage stage;
    private boolean loginSuccessful = false;
    private static ShippingListApp instance;

    public synchronized static ShippingListApp getInstance(){
        if(instance == null){
            instance = new ShippingListApp();
        }
        return instance;
    }
    public void userLogged(){
        this.loginSuccessful=true;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
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

        loginScene();
        if(loginSuccessful){
            stage.close();
            stage.setScene(HomeScene());
            stage.show();
        }
    }

    public Scene HomeScene() throws Exception{
        Parent home = FXMLLoader.load(getClass().getResource("/home.fxml"));
        Scene scene = new Scene(home);
        return scene;
    }

    private void loginScene(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("ShoppingList App");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

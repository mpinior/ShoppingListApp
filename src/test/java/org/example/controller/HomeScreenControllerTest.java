package org.example.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.IPersistanceHelper;
import org.example.persistance.UserRepository;
import org.example.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.ComboBoxMatchers;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.FlowView;
import java.util.ArrayList;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

public class HomeScreenControllerTest extends ApplicationTest {

    HomeScreenController controller;

//    @Override
//    public void start(Stage stage) throws Exception {
//        Flow flow = new Flow(HomeScreenController.class);
//        FlowHandler handler = flow.createHandler();
//        stage.setScene(new Scene(handler.start()));
//        stage.show();
//        FlowView view = handler.getCurrentView();
//        controller = (HomeScreenController) view.getViewContext().getController();
//    }


    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }

    ShoppingList generateSp(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("zegarek", 1, MeasureEnum.szt));
        items.add(new Item("obroza", 1, MeasureEnum.szt));
        return new ShoppingList("2022-10-10", items, "lista1");
    }

    @Test
    public void initialize() throws Exception {
//        User user = generateUser("ala", "456");
//        IPersistanceHelper iPersistanceHelper= Mockito.mock(IPersistanceHelper.class);
//        UserRepository repository = new UserRepository(iPersistanceHelper);
//        IUserService iUserService = Mockito.mock(IUserService.class);
//        when(iUserService.getCurrentUser()).thenReturn(user);
//        when(iUserService.getShippingList()).thenReturn(generateSp());
//
////        interact(() -> {
////            try {
////                start(new Stage());
////            }
////            catch(Exception e){
////                e.printStackTrace();
////            }
////            controller.initialize();
////        });
//       Platform.startup(() ->{
//        try {
//            Flow flow = new Flow(HomeScreenController.class);
//            FlowHandler handler = flow.createHandler();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(handler.start()));
//            stage.show();
//            FlowView view = handler.getCurrentView();
//            controller = (HomeScreenController) view.getViewContext().getController();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        controller.initialize();
//       });
//
//        assertThat(controller.getLists(), ComboBoxMatchers.hasItems(2));


    }


}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author a16pablovc
 */
public class FXMLDocumentController implements Initializable {
    

            
        @FXML
    private JFXComboBox<String> combo;
            
            
       @FXML
    private TableView tabla;
    
    @FXML
    private Label label;
    @FXML
    private void salir(){
        System.out.println("casa");
    }
    @FXML
    private void handleButtonAction() throws IOException {
        System.out.println("You clicked me!");
  combo.getItems().addAll("dsad","gtrgfd","654y");
         
  
                
      //  label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    /*   Parent root2 = FXMLLoader.load(getClass().getResource("documento2.fxml"));
        Scene scene2 = new Scene(root2);
        Stage stage2=new Stage();
        stage2.setScene(scene2);
        stage2.show();*/
    }    
    
}

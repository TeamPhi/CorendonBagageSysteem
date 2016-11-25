/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Atori
 */
public class TestMenuController implements Initializable {
    
    @FXML
    private AnchorPane sceneContent; //Replaceable pane in FXML
    
    //Scenes
    AnchorPane scene1;
    AnchorPane scene2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public TestMenuController() throws IOException{
        //Loading scenes in memmory
        this.scene1 = FXMLLoader.load(getClass().getResource("AddLuggage.fxml"));
        this.scene2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
    }
    
    
    
    @FXML
    private void goScene1(ActionEvent event) {
        //Click event triggered by onAction in the FXML
        this.sceneContent.getChildren().setAll(this.scene1); //Replaces scene (AnchorPane)
    }
    
    @FXML
    private void goScene2(ActionEvent event) {
        //Click event triggered by onAction in the FXML
        this.sceneContent.getChildren().setAll(this.scene2);//Replaces scene (AnchorPane)
    }
      
    
}

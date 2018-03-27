/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

/**
 *
 * @author Ryan Vickramasinghe
 */
public class BirdsController implements Initializable {

    @FXML
    private MenuBar mainMenu;
    

    @FXML
    public void exit() {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}

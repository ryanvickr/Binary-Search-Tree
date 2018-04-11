/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birds;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Ryan Vickramasinghe
 */
public class BirdsController implements Initializable {
    
    OrderedDictionaryADT myDictionary = new OrderedDictionary();
    BirdRecord currentRecord;
    
     @FXML
    private Label lblName;

    @FXML
    private Label lblDescription;
    
    @FXML
    private MenuBar mainMenu;

    @FXML
    private ImageView imageView;

    @FXML
    public void exit() {
        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void first() throws DictionaryException, MalformedURLException {
        currentRecord = myDictionary.smallest();
        lblName.setText(currentRecord.getDataKey().getBirdName());
        lblDescription.setText(currentRecord.getAbout());
        
        System.out.println("loading img:" + currentRecord.getImage());
        imageView.imageProperty().set(new Image(currentRecord.getImage()));
    }
    
    @FXML
    public void last() throws DictionaryException, MalformedURLException{
        currentRecord = myDictionary.largest();
        lblName.setText(currentRecord.getDataKey().getBirdName());
        lblDescription.setText(currentRecord.getAbout());
        
        System.out.println("loading img:" + currentRecord.getImage());
        imageView.imageProperty().set(new Image(currentRecord.getImage()));
    }
    
    @FXML
    public void next() throws DictionaryException, MalformedURLException{
        currentRecord = myDictionary.successor(currentRecord.getDataKey());
        lblName.setText(currentRecord.getDataKey().getBirdName());
        lblDescription.setText(currentRecord.getAbout());
        
        System.out.println("loading img:" + currentRecord.getImage());
        imageView.imageProperty().set(new Image(currentRecord.getImage()));
    }
    
    @FXML
    public void previous() throws DictionaryException, MalformedURLException {
        currentRecord = myDictionary.predecessor(currentRecord.getDataKey());
        lblName.setText(currentRecord.getDataKey().getBirdName());
        lblDescription.setText(currentRecord.getAbout());
        
        System.out.println("loading img:" + currentRecord.getImage());
        imageView.imageProperty().set(new Image(currentRecord.getImage()));
    }
    
    @FXML
    public void delete() throws DictionaryException {
        myDictionary.remove(currentRecord.getDataKey());
        System.out.println("Removed dictionary item " + currentRecord.getDataKey().getBirdName());
    }
    
    @FXML
    public void find() {
        
    }
    
    @FXML
    public void play() {
        
    }
    
    @FXML
    public void stop() {
        
    }
    
    @FXML
    public void loadDictionary(ActionEvent event) throws DictionaryException {
        Scanner myFile = null;
        
        //load the file
        System.out.println("Filling dictionary...");
        try {
            myFile = new Scanner(getClass().getClassLoader().getResourceAsStream("birds/BirdsDatabase.txt"));
            System.out.println("Loaded dictionary file.");
        } catch(Exception ex) {
            System.out.println("Could not find file! Error: " + ex.toString());
            throw new DictionaryException("Could not find file to load.");
        }
        
        while(myFile.hasNextLine()){
            //test for end of file(blank spaces)
            String size = myFile.nextLine();
            if(size.equals("")) { continue; }
            
            //get data from file
            int sizeInt = Integer.valueOf(size);
            String name = myFile.nextLine();
            String about = myFile.nextLine();
            
            //create a new record
            DataKey newKey = new DataKey(name, sizeInt);
            BirdRecord newRecord = new BirdRecord(newKey, about, "sounds/" + name + ".mp3", "images/" + name + ".jpg");
            
            //add recird to dictionary
            myDictionary.insert(newRecord);
        }
        System.out.println("Done loading dictionary.");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}

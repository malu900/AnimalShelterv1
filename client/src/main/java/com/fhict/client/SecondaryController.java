package com.fhict.client;

import com.fhict.server.Gender;
import com.fhict.server.ISellable;
import com.fhict.server.Webshop;
import com.fhict.server.animals.Animal;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SecondaryController {
    public ListView listViewSellables;
    public TextField badHabitsTxtArea;
    public ToggleGroup tglGender;
    public RadioButton rBtnFemale;
    public RadioButton rBtnMale;
    Webshop webshop = new Webshop();
    public ComboBox<String> SellableItemDropdown;
    public Spinner spinnerPrice;
    public TextField txtFieldName;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    void initializeComboBox(){
        SellableItemDropdown.getSelectionModel().selectFirst();
        SellableItemDropdown.getItems().addAll(FXCollections.observableArrayList( "Cat", "Dog", "Product"));
        SellableItemDropdown.getSelectionModel().selectFirst();
        rBtnFemale.setSelected(true);
    }
    public void initialize() {
        webshop = new Webshop();
        webshop.NewProduct("name", 20.05);
        webshop.NewProduct("name", 6.50);
        System.out.println(webshop.getSellables());
        initializeComboBox();

        listViewSellables.setItems(FXCollections.observableArrayList(webshop.getSellables()));
    }

    public void btnCreateSellable(ActionEvent actionEvent) {
        boolean breakmethod = true;
        if(txtFieldName.getText().trim().isEmpty()) {
            System.out.println("please fill in values");
            breakmethod = false;
        }

        if(breakmethod){
            switch (SellableItemDropdown.getValue()) {
                case "Product":
                    webshop.NewProduct(txtFieldName.getText(), (Double) spinnerPrice.getValue());
                    break;
                case "Cat": {
                    RadioButton radioButtonGender = (RadioButton) tglGender.getSelectedToggle();
                    System.out.println(txtFieldName.getText() + (Double) spinnerPrice.getValue() + Gender.valueOf(radioButtonGender.getText()));
                    webshop.NewCat(txtFieldName.getText(), (Double) spinnerPrice.getValue(), Gender.valueOf(radioButtonGender.getText()), badHabitsTxtArea.getText());
                    break;
                }
                case "Dog": {
                    RadioButton radioButtonGender = (RadioButton) tglGender.getSelectedToggle();
                    System.out.println(txtFieldName.getText() + (Double) spinnerPrice.getValue() + Gender.valueOf(radioButtonGender.getText()));
                    webshop.NewDog(txtFieldName.getText(), (Double) spinnerPrice.getValue(), Gender.valueOf(radioButtonGender.getText()));
                    break;
                }
            }
        }
        listViewSellables.setItems(FXCollections.observableArrayList(webshop.getSellables()));
            clearFields();
//        }
    }
    public void clearFields() {
        SellableItemDropdown.getSelectionModel().selectFirst();
        txtFieldName.clear();
        badHabitsTxtArea.clear();
        rBtnFemale.setDisable(false);
        rBtnMale.setDisable(false);
        rBtnFemale.setSelected(true);
    }
    public void btnBuySellable(ActionEvent actionEvent) {
        ISellable s = (ISellable) listViewSellables.getSelectionModel().getSelectedItem();

        for(ISellable sellable : webshop.getSellables()) {
            if (sellable == s ) {
                webshop.RemoveProduct(s);
                break;
            }
        }
        listViewSellables.setItems(FXCollections.observableList(webshop.getSellables()));
    }

    public void disableTextFieldSpecies(ActionEvent actionEvent) {
        if(SellableItemDropdown.getValue().equals("Dog")) {
            badHabitsTxtArea.getStyleClass().add("txtfieldDisabled");
            badHabitsTxtArea.clear();
            badHabitsTxtArea.setEditable(false);
            rBtnFemale.setDisable(false);
            rBtnFemale.setDisable(false);
        } else if (SellableItemDropdown.getValue().equals("Cat")){
            badHabitsTxtArea.getStyleClass().remove("txtfieldDisabled");
            badHabitsTxtArea.setEditable(true);
            rBtnFemale.setDisable(false);
            rBtnFemale.setDisable(false);
        } else {
            badHabitsTxtArea.getStyleClass().add("txtfieldDisabled");
            badHabitsTxtArea.clear();
            badHabitsTxtArea.setEditable(false);
            rBtnFemale.setDisable(true);
            rBtnFemale.setDisable(true);

        }
    }
}
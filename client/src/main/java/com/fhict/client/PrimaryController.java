package com.fhict.client;

import com.fhict.server.animals.Animal;
import com.fhict.server.animals.Dog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.fhict.server.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PrimaryController {
    public Label lbl;
    public ToggleGroup tlgGender;
    public Button BtnGoToWebShop;
    @FXML
    private ComboBox<String> speciesCbox;
    public TitledPane nameContainer;
    public TextField nameTxtArea;
    public RadioButton rButtonFemale;
    public RadioButton rButtonMale;
    public TextField badHabitsTxtArea;
    public Button BtnAddAnimal;
    public ListView listBoxAnimals;
    public TextField txtAreaReserverName;
    public Button btnReserve;

    Reservation res;

    public void InitializeCssClasses() {
        rButtonFemale.getStyleClass().add("female");
        rButtonMale.getStyleClass().add("male");
    }

    public void setFieldsAnimals() {
        speciesCbox.getSelectionModel().selectFirst();
        speciesCbox.getItems().addAll(FXCollections.observableArrayList("Cat","Dog"));
        speciesCbox.getSelectionModel().selectFirst();
        rButtonFemale.setSelected(true);
    }

    @FXML
    public void initialize() {
        res = new Reservation();
        setFieldsAnimals();
        InitializeCssClasses();
        btnReserve.setDisable(listBoxAnimals.getItems().isEmpty());
    }

    public void disableTextFieldSpecies(ActionEvent actionEvent) {
        if(!speciesCbox.getValue().equals("Cat")) {
            badHabitsTxtArea.getStyleClass().add("txtfieldDisabled");
            badHabitsTxtArea.clear();
            badHabitsTxtArea.setEditable(false);
        } else {
            badHabitsTxtArea.getStyleClass().remove("txtfieldDisabled");
            badHabitsTxtArea.setEditable(true);
        }
    }

    public void onAddAnimalEvent(ActionEvent actionEvent) {
        boolean breakmethod = true;

        if(nameTxtArea.getText().trim().isEmpty() || (speciesCbox.getValue().equals("Cat") && badHabitsTxtArea.getText().trim().isEmpty())) {
            lbl.setText("Please fill in the empty text field(s)! :)");
            breakmethod = false;
        }

        if (breakmethod) {
            RadioButton radioButtonGender = (RadioButton) tlgGender.getSelectedToggle();
            if (speciesCbox.getValue().equals("Dog")) {
                res.NewDog(nameTxtArea.getText(), Gender.valueOf(radioButtonGender.getText()));
            } else {
                res.NewCat(nameTxtArea.getText(), Gender.valueOf(radioButtonGender.getText()), badHabitsTxtArea.getText());
            }

            listBoxAnimals.setItems(FXCollections.observableList(res.getAnimals()));
            clearAddAnimal();
        }
    }
    public void clearAddAnimal() {
        speciesCbox.getSelectionModel().selectFirst();
        nameTxtArea.clear();
        rButtonFemale.setSelected(true);
        badHabitsTxtArea.clear();
        lbl.setText("");
    }

    public void btnReserveAction(ActionEvent actionEvent) {
        Animal s = (Animal) listBoxAnimals.getSelectionModel().getSelectedItem();

        for(Animal animal : res.getAnimals()) {
            if (animal == s && s.getReservedBy() == null) {
                lbl.setText("");
                System.out.print(s.getReservedBy());
                s.Reserve(txtAreaReserverName.getText());
                break;
            } else {
                lbl.setText("Already reserved");
            }
        }
        listBoxAnimals.setItems(FXCollections.observableList(res.getAnimals()));
        txtAreaReserverName.clear();
        btnReserve.setDisable(true);
    }

    public void selectedItem(MouseEvent mouseEvent) {
        btnReserve.setDisable(listBoxAnimals.getSelectionModel().getSelectedItem().toString().isEmpty()  || txtAreaReserverName.getText().trim().isEmpty());
    }

    public void textChangeReserveName(KeyEvent keyEvent) {
        btnReserve.setDisable(listBoxAnimals.getSelectionModel().getSelectedItem().toString().isEmpty() || txtAreaReserverName.getText().trim().isEmpty());
    }


    public void BtnGoToWebShop(ActionEvent actionEvent) throws IOException {
        App.setRoot("secondary");
    }
}

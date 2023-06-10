package joshuaburt_sec005_ex04;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


//Ex-04: This is extension to your Lab Assignment 01. You have built the following application:
    //You need to add the following validations (In addition to the existing code base) using regular expression (regex)
    //a) Phone number format: 3 digits for region code, 3 for city and 4 for number. e.g. 905-516-6211 [5 marks]
    //b) Post Code in the alternating letter and digit- Total characters – 6. e.g. L5V1S7 [5 marks]
    //c) E-mail id: accepted in the format - slohan@abc.com ( x+@x+.com) [5 marks]


public class Ex04Controller implements Initializable { //implements initializable for ChoiceBox population at start {


    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField province;
    @FXML
    private TextField city;
    @FXML
    private TextField number;
    @FXML
    private Label numberLabel;
    @FXML
    private TextField postal;
    @FXML
    private Label postalLabel;
    @FXML
    private TextField email;
    @FXML
    private Label emailLabel;
    @FXML
    private ChoiceBox<String> select;
    private String[] subjects = {"HTML/CSS/JS","SQL","Java"};
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;
    @FXML
    private CheckBox checkbox4;
    @FXML
    private CheckBox checkbox5;
    @FXML
    private CheckBox checkbox6;
    @FXML
    private RadioButton radiobutton1;
    @FXML
    private RadioButton radiobutton2;
    @FXML
    private Button display;
    @FXML
    private TextArea output;

    @Override //this requires "implements Initializable"
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select.getItems().addAll(subjects); //populates select choicebox
    }
    @FXML
    void radioSelect1(/*ActionEvent event*/) { //allows only 1 radio button to be selected
        if (radiobutton1.isSelected()) {
            radiobutton2.setSelected(false);
        }
    }
    @FXML
    void radioSelect2(/*ActionEvent event*/) { //allows only 1 radio button to be selected
        if (radiobutton2.isSelected()) {
            radiobutton1.setSelected(false);
        }
    }
    @FXML
    void setDisplay(/*ActionEvent event*/) { //sets all variables to TextArea
        output.clear(); //clears textArea if data needs to be editted
        String name1 = name.getText();
        String address1 = address.getText();
        String province1 = province.getText();
        String city1 = city.getText();
        String number1 = number.getText();
        String postal1 = postal.getText();
        String email1 = email.getText();
        String selectedSubjects= select.getValue();

        String activity = "";
        if(checkbox1.isSelected()){
            activity+="basketball ";
        }
        if(checkbox2.isSelected()){
            activity+="volleyball ";
        }
        if(checkbox3.isSelected()){
            activity+="student council ";
        }
        if(checkbox4.isSelected()){
            activity+="football ";
        }
        if(checkbox5.isSelected()){
            activity+="volunteer work ";
        }
        if(checkbox6.isSelected()){
            activity+="swimming ";
        }

        String major = "";
        if(radiobutton1.isSelected()){
            major="Computer Science";
        }
        else if(radiobutton2.isSelected()){
            major="Business Analyst";
        }

        //error reporting and validation
        int errorNum = 0;
        int errorPost = 0;
        int errorEm = 0;
        if(number.getText().matches("^\\(?\\d{3}\\)?\\-?\\d{3}\\-?\\d{4}$")) {
            errorNum = 0;
            numberLabel.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            number1 = number.getText();
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 + "\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);
        }
        else{
            errorNum = 1;
            numberLabel.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            number1 = "Phone number must in correct format ie. 222-222-2222";
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 + "\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);

        }
        if(postal.getText().matches("^([A-Za-z]\\d[A-Za-z][-]?\\d[A-Za-z]\\d)")) {
            errorPost = 0;
            postalLabel.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            postal1 = postal.getText();
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 +"\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);
        }
        else{
            errorPost=1;
            postalLabel.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            postal1 = "Postal code must be in correct format ie. M1A1G1";
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 +"\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);
        }
        if(email.getText().matches("^([A-Za-z_0-9])+@{1}([A-Za-z_0-9])+.{1}([COMcom]){3}")) {
            errorEm = 0;
            emailLabel.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            email1 = email.getText();
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 + "\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);
        }
        else {
            errorEm = 1;
            emailLabel.setBorder(new Border(new BorderStroke(Color.RED,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
            email1 = "Email must be in correct format ie. abc@yahoo.com";
            output.setText("Name: " + name1 + ", Address: " + address1 + ", Province: " + province1 + ", City: " + city1 +"\nNumber: "+ number1 + "\nPostal Code: " + postal1 + "\nEmail: " + email1+ "\nMajor: " + major+ "\nActivities: " + activity+ "\nSubjects: " + selectedSubjects);

        }
        if(errorNum == 1 || errorPost == 1 || errorEm == 1) {
            throw new IllegalArgumentException("Required field input error, check: 1. Phone number must in correct format ie. 222-222-2222. 2. Postal code must be in correct format ie. M1A1G1. 3. Email must be in correct format ie. abc@yahoo.com");
        }
    }
}
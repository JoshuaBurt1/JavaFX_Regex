module com.example.joshuaburt_comp1011sec005_labex03 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens joshuaburt_sec005_ex04 to javafx.fxml;
    exports joshuaburt_sec005_ex04;
    exports joshuaburt_sec005_ex01;
    opens joshuaburt_sec005_ex01 to javafx.fxml;
    exports joshuaburt_sec005_ex02;
    opens joshuaburt_sec005_ex02 to javafx.fxml;
    exports joshuaburt_sec005_ex03;
    opens joshuaburt_sec005_ex03 to javafx.fxml;
}
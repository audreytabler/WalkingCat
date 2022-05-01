module com.example.catspriteproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.catspriteproject to javafx.fxml;
    exports com.example.catspriteproject;
}
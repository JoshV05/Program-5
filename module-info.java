module mario.kart.program5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mario.kart.program5 to javafx.fxml;
    exports mario.kart.program5;
}
module com.example.tp2inf1008 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp2inf1008 to javafx.fxml;
    exports com.example.tp2inf1008;
}
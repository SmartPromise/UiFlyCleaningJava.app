module cleaning {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens cleaning.menu to javafx.fxml;
    exports cleaning.menu;
    exports cleaning.model;
    exports cleaning.service;
}

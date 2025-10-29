module application.examen_git {
    requires javafx.controls;
    requires javafx.fxml;

    opens application.examen_git to javafx.fxml;
    exports application.examen_git;
}

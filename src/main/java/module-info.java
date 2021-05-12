module ni.edu.uni.programacion2.examenjeison {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ni.edu.uni.programacion2.examenjeison to javafx.fxml;
    exports ni.edu.uni.programacion2.examenjeison;
    exports ni.edu.uni.programacion2.examenjeison.controller;
}

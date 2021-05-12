/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion2.examenjeison.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ni.edu.uni.programacion2.examenjeison.pojo.Empleado;
import ni.edu.uni.programacion2.examenjeison.pojo.Nomina;

/**
 * FXML Controller class
 *
 * @author JADPA18
 */
public class NominaFXMLController implements Initializable {

    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtApellido;
    @FXML
    public TextField txtFechaC;
    @FXML
    public TextField txtSalarioH;
    @FXML
    public TextField txtHoras;
    @FXML
    public Button btnAgregar;
    @FXML
    public Button btnEliminar;
    @FXML
    public TableView<Nomina> tblvNomina;
    @FXML
    public TableColumn <Nomina,String> tblcNombre;
    @FXML
    public TableColumn <Nomina,String> tblcSalario;
    @FXML
    public TableColumn<Nomina,String> tblcINSS;
    @FXML
    public TableColumn <Nomina,String> tblcIR;
    @FXML
    public TableColumn <Nomina,String> tblcAntiguedad;
    @FXML
    public TableColumn <Nomina,String>tblcSalarioNeto;
    
    private ObservableList<Nomina>nom;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tblcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
       tblcSalario.setCellValueFactory(new PropertyValueFactory("salarioneto"));
       tblcINSS.setCellValueFactory(new PropertyValueFactory("inss"));
       tblcIR.setCellFactory(new PropertyValueFactory("ir"));
       tblcAntiguedad.setCellValueFactory(new PropertyValueFactory("antiguedad"));
       tblcSalarioNeto.setCellValueFactory(new PropertyValueFactory("salarioneto"));
       tblvNomina.setItems(nom);
    }    

    @FXML
    public void btnAgregarAction(ActionEvent event) {
        String nombre,apellido;
        int fecha,antiguedad;
        int horas;
        float salario,salarioneto=0,inss,ir=0,aux;
        
        nombre= txtNombre.getText();
        apellido= txtApellido.getText();
        fecha= Integer.parseInt(txtFechaC.getText().toString());
        salario= Float.parseFloat(txtSalarioH.getText().toString());
        horas=Integer.parseInt(txtHoras.getText().toString());
        Empleado e =new Empleado(nombre,salario);
        
        inss= (float) (salario*0.7);
        
         aux= salario-inss;
        if(salario<=100000){
            salarioneto=aux;
        }
        if (salario>100000 && salario<200000) {
            salarioneto=(float) (aux-(aux*0.15));
            ir= (float) (salario-(salario*0.15));
            
        }
         if (salario>=200000 && salario<=350000) {
            salarioneto=(float) (aux-(aux*0.20));
            ir= (float) (salario-(salario*0.20));
        }
         
          if (salario>350000 && salario<500000) {
            salarioneto=(float) (aux-(aux*0.25));
            ir= (float) (salario-(salario*0.25));
        }
           if ( salario<500000) {
            salarioneto=(float) (aux-(aux*0.30));
            ir= (float) (salario-(salario*0.30));
        }
           
           antiguedad=fecha-2021;
           nom.add(new Nomina(nombre,inss,ir,antiguedad,salarioneto));
        
        
        
    }

    @FXML
    public void btnEliminarAction(ActionEvent event) {
        Nomina p = this.tblvNomina.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            // La elimino de la lista
            this.nom.remove(p);
            // Refresco la lista
            this.tblvNomina.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto eliminado");
            alert.showAndWait();
        
    }
    }

    @FXML
    public void seleccionar(MouseEvent event) {
        
    }
    
    
}

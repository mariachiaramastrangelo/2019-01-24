/**
 * Sample Skeleton for 'ExtFlightDelays.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.extflightdelays.model.Model;
import it.polito.tdp.extflightdelays.model.Raggiungibili;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExtFlightDelaysController {
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreaGrafo"
    private Button btnCreaGrafo; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBoxStati"
    private ComboBox<String> cmbBoxStati; // Value injected by FXMLLoader

    @FXML // fx:id="btnVisualizzaVelivoli"
    private Button btnVisualizzaVelivoli; // Value injected by FXMLLoader

    @FXML // fx:id="txtT"
    private TextField txtT; // Value injected by FXMLLoader

    @FXML // fx:id="txtG"
    private TextField txtG; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	model.creaGrafo();
    	txtResult.appendText(model.grafoCreato()+"\n");
    	
    }

    @FXML
    void doSimula(ActionEvent event) {
    	Map<String, Integer> result = model.getTuristiPaese(Integer.parseInt(this.txtT.getText()), Integer.parseInt(this.txtG.getText()), this.cmbBoxStati.getValue());
    	for(String s: result.keySet()) {
    		txtResult.appendText("\n" +s+" "+result.get(s));
    	}
    }

    @FXML
    void doVisualizzaVelivoli(ActionEvent event) {
    	txtResult.appendText("Stati raggiungibili da "+ this.cmbBoxStati.getValue()+":\n");
    	for(Raggiungibili r: model.statiRaggiongibili(this.cmbBoxStati.getValue())) {
    		txtResult.appendText(r.toString()+"\n");
    	}
    }
    
    public void setModel(Model model) {
		this.model = model;	
		this.cmbBoxStati.getItems().addAll(model.listAllStates());
	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnCreaGrafo != null : "fx:id=\"btnCreaGrafo\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert cmbBoxStati != null : "fx:id=\"cmbBoxStati\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnVisualizzaVelivoli != null : "fx:id=\"btnVisualizzaVelivoli\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtT != null : "fx:id=\"txtT\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert txtG != null : "fx:id=\"txtG\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'ExtFlightDelays.fxml'.";

    }
}
package edu.ucdenver.application;

import edu.ucdenver.client.*;
import edu.ucdenver.server.*;
import edu.ucdenver.library.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.*;

import java.io.IOException;

public class Controller {
    public TextField txtTestCmd;
    public Button btnTestSendCmd;
    public TextArea txtOutput;
    public TextField txtAuthorName;
    public Button btnAddAuthor;
    public TextArea txtAddAuthorOutput;
    Client client;

    public Controller(){
        client = new Client();
        client.connect();
    }

    private String sendCommand(String cmd) {
        String response;
        if (client.isConnected()) {
            try {
                response = client.sendRequest(cmd);

            } catch (IOException e) {
                response = "ERR|" + e.getMessage();

            }
        } else {
            response = "ERR| Client is not connected.";
        }
        return response;
    }

    public void addAuthor(ActionEvent actionEvent) {
        String authorNameText = txtAuthorName.getText();
        Alert alert;

        String cmd = String.format("%s|%s","A",authorNameText);
        String response = sendCommand(cmd);
        String[] respArgs = response.split("\\|");

        switch (respArgs[0]){
            case "OK":
                alert = new Alert(Alert.AlertType.CONFIRMATION, "Server Response:" + response, ButtonType.OK);
                alert.show();
                break;
            case "ERR":
                alert = new Alert(Alert.AlertType.ERROR, respArgs[1], ButtonType.OK);
                alert.show();
                break;
        }
        txtAddAuthorOutput.clear();
        for (String s: respArgs){
            txtAddAuthorOutput.appendText(s);
            txtAddAuthorOutput.appendText(System.getProperty("line.separator"));
        }
    }

    public void testSendCmd(ActionEvent actionEvent) {
        String cmd = txtTestCmd.getText();
        Alert alert;

        if(client.isConnected()) {
            try {
                String response = client.sendRequest(cmd);
                String[] respArgs = response.split("\\|");

                switch (respArgs[0]){
                    case "OK":
                        alert = new Alert(Alert.AlertType.CONFIRMATION, "Server Response:" + response, ButtonType.OK);
                        alert.show();
                        break;
                    case "ERR":
                        alert = new Alert(Alert.AlertType.ERROR, respArgs[1], ButtonType.OK);
                        alert.show();
                        break;
                }
                txtOutput.clear();
                for (String s: respArgs){
                    txtOutput.appendText(s);
                    txtOutput.appendText(System.getProperty("line.separator"));
                }
            } catch (IOException e) {
                alert = new Alert(Alert.AlertType.ERROR, "Exception:" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        }
        else {
            alert = new Alert(Alert.AlertType.ERROR, "Client is not connected.", ButtonType.OK);
            alert.show();
        }
    }
}
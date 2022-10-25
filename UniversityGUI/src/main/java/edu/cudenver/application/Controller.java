package edu.cudenver.application;

import edu.cudenver.university.Course;
import edu.cudenver.university.Student;
import edu.cudenver.university.University;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {
    public TextField txtStudentName;
    public DatePicker dtpStudentDOB;
    public Button btnAddUndergraduate;
    public Button btnAddMaster;
    public Button btnAddPhD;
    public TextField txtPhdDissertation;
    public TextField txtCourseNumber;
    public Button btnAddCourse;
    public ComboBox<String> selCourseSubject;
    public TextField txtCourseTitle;
    public Button btnExit;
    public Tab tabListStudents;
    public Tab tabListCourses;
    public ListView<Student> lstStudents;
    public ListView<Course> lstCourses;
   //.................................................................................................................//
   public Button btnEnroll;
   public Tab tabEnrollList;
    public ListView lstEnrollCourse;
    public ListView lstEnrollStudent;
    public TextField txtEnrollStudName;

    public TextField txtEnrollCourSubj;
    public TextField txtEnrollCourNum;
    //    private ListView<Course> myListView;
    //.................................................................................................................//
    private University university;

    public Controller() {
        university = new University();
        this.selCourseSubject = new ComboBox<>();
        this.lstStudents = new ListView<>();
        this.lstCourses = new ListView<>();
        this.lstEnrollCourse = new ListView<>();
        this.lstEnrollStudent = new ListView<>();
//        this.myListView = new ListView<>();
    }

    public void initialize() {
        this.selCourseSubject.setItems(FXCollections.observableArrayList("CSCI","MATH"));
        this.lstStudents.setItems(FXCollections.observableArrayList(university.getStudents()));
        this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
    //.................................................................................................................//
        this.lstEnrollCourse.setItems(FXCollections.observableArrayList(university.getCourses()));
        this.lstEnrollStudent.setItems(null);
        this.lstEnrollCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
        @Override
        public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
            System.out.println("ListView selection changed from oldValue = " + oldValue + " to newValue = " + newValue);
            int index = lstEnrollCourse.getSelectionModel().getSelectedIndex();
            newValue = university.getCourses().get(index);

            lstEnrollStudent.setItems(FXCollections.observableArrayList(newValue.getEnrolledStudents()));
        }
        });
//
    //.................................................................................................................//
    }

    private void cleanAddStudent() {
        this.txtStudentName.setText("");
        this.dtpStudentDOB.setValue(null);
        this.txtPhdDissertation.setText("");
    }

    public void addUndergraduateStudent(ActionEvent actionEvent) {
        university.addUndergrad(this.txtStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();

    }

    public void addMasterStudent(ActionEvent actionEvent) {
        university.addMaster(this.txtStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();
    }

    public void addPhDStudent(ActionEvent actionEvent) {
        university.addPhD(this.txtStudentName.getText(),this.dtpStudentDOB.getValue(),
                this.txtPhdDissertation.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User added successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();
    }

    public void addCourse(ActionEvent actionEvent) {

        try {
            university.addCourse(this.selCourseSubject.getValue(), Integer.parseInt(this.txtCourseNumber.getText()),
                    this.txtCourseTitle.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Course added successfully");
            alert.show();
            System.out.println(university);
        }
        catch(IllegalArgumentException iae) {
            Alert alert = new Alert(Alert.AlertType.ERROR, iae.getMessage());
            alert.show();
        }


    }

    public void exitApplication(ActionEvent actionEvent) {

        Stage stage = (Stage)this.btnExit.getScene().getWindow();
        stage.close();


    }

    public void listStudentsUpdate(Event event) {
        if(this.tabListStudents.isSelected()) {
            this.lstStudents.setItems(FXCollections.observableArrayList(university.getStudents()));
        }
    }

    public void listCoursesUpdate(Event event) {
        if(this.tabListCourses.isSelected()) {
            this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
        }
    }

    public void saveToFile(ActionEvent actionEvent) {
        university.saveToFile();
    }

    public void loadFromFile(ActionEvent actionEvent) {
        // load University object
        this.university = University.loadFromFile();
        //initialize GUI
        this.initialize();

    }

    //.................................................................................................................//
    public void listEnrollUpdate(Event event) {
        if(this.tabEnrollList.isSelected()) {
            this.lstEnrollCourse.setItems(FXCollections.observableArrayList(university.getCourses()));
        }
    }
    public void addEnrollment(ActionEvent actionEvent) {
        try {
            university.enrollStudentToCourse(this.txtEnrollStudName.getText(),this.txtEnrollCourSubj.getText(),
                    Integer.parseInt(this.txtCourseNumber.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Enrollment added successfully");
            alert.show();
            System.out.println(university);
        }
        catch(IllegalArgumentException iae) {
            Alert alert = new Alert(Alert.AlertType.ERROR, iae.getMessage());
            alert.show();
        }
    }
    //.................................................................................................................//
}

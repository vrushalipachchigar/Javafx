/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import appjavafx.Student;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
/**
 *
 * @author Sumit
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    Label msg;
    
    @FXML
    TextField txt1;
    
    @FXML
    ColorPicker picker1;
    
    @FXML
    private Label name1, name2, name3, name4, name5, name6, name7, name8, name9;
    
    private List<Student> students = new ArrayList<>();
    private List<Rectangle> seats;
    private List<Label> names;
    
    @FXML
    Rectangle seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      
        if(txt1.getText().equals("")){
            msg.setText("Please Student Enter Name!");
            msg.setTextFill(Color.RED);
            return;
        }
        
        if(!checkColorAvailability(picker1.getValue())){
            msg.setText("This Color Has Already Been Used!");
            msg.setTextFill(Color.RED);
            return;
        }
        
        if(students.size()>=9){
            msg.setText("All the seats are taken");
            msg.setTextFill(Color.RED);
            return;
        }
        
        designateSeat(txt1.getText(), picker1.getValue());
        msg.setTextFill(Color.BLUE);
    }
    
        private boolean checkSeatAvailability(int randomNo) {

        boolean availability = true;

        for(Student s:students){
            if (s.getSeatindex() == randomNo) {
                availability = false;
            }
        }
        return availability;
    }
        
    private boolean checkColorAvailability(Color color){

        boolean availability= true;

        for(Student s:students){
            if (s.getColor().equals(color)) {
                availability = false;
            }
        }
        return availability;

    }
    
    void designateSeat(String name, Color color){

        Random random = new Random();

        int randomNo;
        do{
            randomNo = random.nextInt(9);
        }while(!checkSeatAvailability(randomNo));

        Student student = new Student(name, randomNo, color);
        students.add(student);

        seats.get(student.getSeatindex()).setFill(student.getColor());
        names.get(student.getSeatindex()).setText(student.getName());
        
        msg.setText("Seat Allocated Successfully!");
        txt1.setText("");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        seats.add(seat6);
        seats.add(seat7);
        seats.add(seat8);
        seats.add(seat9);
        
        
        names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);
        names.add(name9);

    }    

    public FXMLDocumentController() {

    }
    
}

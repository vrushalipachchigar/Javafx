/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavafx;

import javafx.scene.paint.Color;

/**
 *
 * @author Sumit
 */
public class Student {
    String name;
    int seatindex;
    Color color;

    public Student() {
    }

    public Student(String name, int seatindex, Color color) {
        this.name = name;
        this.seatindex = seatindex;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatindex() {
        return seatindex;
    }

    public void setSeatindex(int seatindex) {
        this.seatindex = seatindex;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   
    
}

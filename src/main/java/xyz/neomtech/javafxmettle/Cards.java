/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxmettle;

import javax.sql.rowset.CachedRowSet;

/**
 * @author Dell
 */
public class Cards {

    public Enum size;
    public Enum shape;
    public Enum color;
    public Enum pattern;
    public String imageName = "";
    public boolean turnedOver = false;
    public String selectedImageID;
    public int row;
    public int column;

    public Cards() {

    }

    public Cards(Enum size, Enum shape, Enum color, Enum pattern, String imageName, boolean turnedOver) {
        this.size = size;
        this.shape = shape;
        this.color = color;
        this.pattern = pattern;
        this.imageName = imageName;
        this.turnedOver = turnedOver;
    }

    public Enum getSize() {
        return size;
    }

    public void setSize(Enum size) {
        this.size = size;
    }

    public Enum getShape() {
        return shape;
    }

    public void setShape(Enum shape) {
        this.shape = shape;
    }

    public Enum getColor() {
        return color;
    }

    public void setColor(Enum color) {
        this.color = color;
    }

    public Enum getPattern() {
        return pattern;
    }

    public void setPattern(Enum pattern) {
        this.pattern = pattern;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public boolean isTurnedOver() {
        return turnedOver;
    }

    public void setTurnedOver(boolean turnedOver) {
        this.turnedOver = turnedOver;
    }

    public String getSelectedImageID() {
        return selectedImageID;
    }

    public void setSelectedImageID(String selectedImageID) {
        this.selectedImageID = selectedImageID;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Cards{"
                + "shape=" + shape
                + "  size=" + size
                + ", color=" + color
                + ", pattern=" + pattern
                + ", imageName='" + imageName + '\''
                + ", turnedOver=" + turnedOver
                + '}';
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return size.equals(cards.size)
                || //                shape.equals(cards.shape)||
                color.equals(cards.color)
                || pattern.equals(cards.pattern);
    }
}

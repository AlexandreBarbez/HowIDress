package com.awesome.supergroup.howidress;

import android.graphics.Color;

/**
 * Created by Alx on 26/05/2015.
 */
public class Clothe {

    private int id;
    private String name;
    private e_clothes slot;
    private int color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public e_clothes getSlot() {
        return slot;
    }

    public void setSlot(e_clothes slot) {
        this.slot = slot;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slot=" + slot +
                ", color=" + color +
                '}';
    }

    public Clothe(int id, String name, e_clothes slot, int color) {
        this.id = id;
        this.name = name;
        this.slot = slot;
        this.color = color;
    }

    public Clothe() {
        super();
    }
}

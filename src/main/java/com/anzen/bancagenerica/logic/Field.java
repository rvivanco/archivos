package com.anzen.bancagenerica.logic;

/**
 * Created by raul on 7/04/17.
 */
public class Field
{
    private String nombre;
    private int longField;
    private int start;
    private int end;
    private Format format;

    public Field(String nombre, int longField, int start, int end, Format format) {
        this.nombre = nombre;
        this.longField = longField;
        this.start = start;
        this.end = end;
        this.format= format;
    }


    public boolean validar(String campo)
    {
        return format.isValid(campo);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLongField() {
        return longField;
    }

    public void setLongField(int longField) {
        this.longField = longField;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Format getFormat() {
        return format;
    }


}

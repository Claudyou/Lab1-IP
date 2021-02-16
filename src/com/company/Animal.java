package com.company;

public class Animal {

    private int CNP;
    private int habitatNr;
    private String regn;
    private String name;

    public Animal() {

    }

    public Animal(String regn, String name) {
        this.regn=regn;
        this.name=name;
    }

    public Animal(int CNP, String regn, String name) {
        this.CNP = CNP;
        this.regn = regn;
        this.name = name;
    }

    public Animal(int CNP, String regn, String name, int habitatNr) {
        this.CNP = CNP;
        this.regn = regn;
        this.name = name;
        this.habitatNr = habitatNr;
    }

    public String getReng() {
        return regn;
    }

    public int getCNP() {
        return CNP;
    }

    public String getName() {
        return name;
    }
}

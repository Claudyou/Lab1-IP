package com.company;

import java.util.ArrayList;

public class Building {

    private ArrayList<Animal> arr = new ArrayList<Animal>(); // Lista de animale din building
    private int nrDesc; // Numarul de identificare a building-ului
    private int capacity; //Capacitatea

    public Building(int nr, int capacity) {
        nrDesc = nr;
        this.capacity = capacity;
    }

    public Building(int nr) {
        nrDesc = nr;
        capacity = 3;
    }

    public int getEmptySpaces() {
        return capacity - arr.size();
    }

    public String getBuildingReng() {
        for(Animal a: arr)
        {
            return a.getReng();
        }
        return "Err";
    }

    public void addAnimal(Animal b) {
        arr.add(b);
    }

    public int getCapacity() {
        return capacity;
    }

    public void removeAnimal(Animal a) {
        arr.remove(a);
    }

    //verifica daca un animal este in cladire
    public boolean isInBuilding(Animal a) {
        return arr.contains(a);
    }

    //verifica daca un animal este in cladire dupa CNP
    public boolean isInBuilding(int CNP)
    {
        for(Animal a: arr)
        {
            if(a.getCNP() == CNP)
                return true;
        }
        return false;
    }

    public int getNrDesc() {
        return nrDesc;
    }
}

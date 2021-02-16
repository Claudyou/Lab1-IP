package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Zoo {
    private ArrayList<Building> buildings; // lista de buildings
    private ArrayList<Animal> animals;  //lista cu toate animalele din gradina zoologica

    public Zoo() {
        buildings = new ArrayList<>();
        animals = new ArrayList<>();
    }

    // obtine un numar unic pentru un building ( un numar de identificare)
    private int obtainNrDesc() {
        while(true) {
            Random nr = new Random();
            int rez = nr.nextInt(100) + 1;
            boolean ok = true;
            for(Building b: buildings)
            {
                if(b.getNrDesc() == rez)
                    ok= false;
            }
            if(ok)
                return rez;
        }
    }

    public void createBuilding() {
        Building b = new Building(obtainNrDesc());
        buildings.add(b);
    }

    public void createBuilding(int capacity) {
        Building b = new Building(obtainNrDesc(),capacity);
        buildings.add(b);
    }

    public void removeBuilding(Building b) {
        buildings.remove(b);
    }

    public void removeBuilding(int nrDesc) {
        for (Building b : buildings) {
            if (b.getNrDesc() == nrDesc) {
                buildings.remove(b);
                break;
            }
        }
    }

    //cauta un building potrivit pentru animale ( acelasi regn ca celelalte animale sau un habitat nou)
    private Building getRightBuilding(Animal a) {
        for (Building b : buildings) {
            if ((b.getEmptySpaces() != 0 && a.getReng().equals(b.getBuildingReng())) || b.getEmptySpaces() == b.getCapacity()) {
                return b;
            }
        }
        return null;
    }

    public void addAnimal(Animal a) {



        animals.add(a);
        Building b = getRightBuilding(a);
        if (b != null) {
            b.addAnimal(a);
        } else {
            createBuilding();
            b = getRightBuilding(a);
            if (b != null) {
                b.addAnimal(a);
            }
        }
    }

    public void removeAnimal(Animal a) {

        animals.remove(a);

        for (Building b : buildings) {
            if (b.isInBuilding(a)) {
                b.removeAnimal(a);
                break;
            }
        }
    }

    //printeaza gradina zoologica intr-un file descriptor primit
    public void printZoo(FileWriter file) {
        for (Building b : buildings) {
            try {
                file.write("Building: " + b.getNrDesc());
                for (Animal a : animals)
                    if (b.isInBuilding(a)) {
                        file.write("\t" + a.getName() + "\tCNP: " + a.getCNP());
                    }
            } catch (IOException e) {
                System.out.println("Error at writing!");
            }
        }
    }

    //printeaza gradica zoologica intr-un path ( creeaza un file descriptor pentru acel fisier)
    public void printZoo(String path) {
        try {
            FileWriter file = new FileWriter(path);
            printZoo(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Something went wrong when open file!");
        }

    }
}

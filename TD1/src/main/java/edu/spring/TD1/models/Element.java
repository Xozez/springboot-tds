package edu.spring.TD1.models;

import java.util.Objects;

public class Element {

    private String nom;
    private int evaluation;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getEvaluation() {
        return evaluation;
    }
    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public Element(String nom, int evaluation) {
        this.nom = nom;
        this.evaluation = evaluation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        return evaluation == element.evaluation && Objects.equals(nom, element.nom);
    }
}

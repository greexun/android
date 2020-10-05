package com.example.appli;

public class Contact {

    String nom;
    String prenom;
    String tel;
    String dateNaissance;
    boolean sexe;


    public Contact(String n,String p,String t,String d,boolean s){
        nom=n;
        prenom=p;
        tel=t;
        dateNaissance=d;
        sexe=s;


    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public boolean isSexe() {
        return sexe;
    }
}

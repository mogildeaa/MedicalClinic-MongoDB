package com.sda.entitati;

import com.sda.database.DatabaseAccess;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private final DatabaseAccess db = DatabaseAccess.getDatabaseAccess();

    private String name;
    private String specialitate;
    private List<String> pacienti;

    public Doctor(String name, String specialitate) {
        this.name = name;
        this.specialitate = specialitate;
        this.pacienti = new ArrayList<>();
        db.saveDoctor(this.toDocument());
    }

    public String getName() {
        return name;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public List<String> getPacienti() {
        return pacienti;
    }

    public void addPatient(Pacient pacient) {
        Document doctor = db.findDocument(this.name);
        List pacienti = (ArrayList) doctor.get("pacienti");
        //daca nu exista in lista , il adaugam
        if (!pacienti.contains(pacient.toJson())) {
            pacienti.add(pacient.toJson());
            db.updateDoctor(doctor, pacienti);
        }
    }

    public Document toDocument() {
        return new Document("name", name)
                .append("specialitate", specialitate)
                .append("pacienti", pacienti);
    }
}

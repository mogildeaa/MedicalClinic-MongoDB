package com.sda.clinica;

import com.sda.database.DatabaseAccess;
import com.sda.entitati.Doctor;
import com.sda.entitati.Pacient;

public class Controller {

    public static void main(String[] args) {
        DatabaseAccess db = DatabaseAccess.getDatabaseAccess();

        // Pacient without a Doctor cannot exist in the Database
        populateDatabase();
        //Show in console the Doctors with their Patients
        db.printDoctors();
        //Show in console only the Patients
//        db.printPatients();

        DatabaseAccess.closeClientConnection();
    }

    private static void populateDatabase() {
        Doctor cardiolog = new Doctor("Alex Ionescu", "cardiologie");
        Doctor chirurg = new Doctor("Vlad Ene", "chirurgie");

        Pacient pacient1 = new Pacient("Gabriel Nedelcu", "aritmie");
        Pacient pacient2 = new Pacient("Alina Sorescu", "tahicardie");
        Pacient pacient3 = new Pacient("Gigel Ionescu", "apendicita");
        Pacient pacient4 = new Pacient("Ion Popescu", "tumora operabila");
        Pacient pacient5 = new Pacient("Jon Kennedy", "tumora operabila");
        Pacient pacient6 = new Pacient("Barack Obama", "apendicita");
        Pacient pacient7 = new Pacient("Klaus Iohannis", "tahicardie severa");
        Pacient pacient8 = new Pacient("Ben Dover", "aritmie severa");

        cardiolog.addPatient(pacient1);
        cardiolog.addPatient(pacient2);
        cardiolog.addPatient(pacient7);
        cardiolog.addPatient(pacient8);
        chirurg.addPatient(pacient5);
        chirurg.addPatient(pacient6);
        chirurg.addPatient(pacient3);
        chirurg.addPatient(pacient4);
    }
}

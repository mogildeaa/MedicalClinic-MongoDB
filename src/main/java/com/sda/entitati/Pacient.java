package com.sda.entitati;

public class Pacient {

    private String name;
    private String diagnostic;

    public Pacient(String name, String diagnostic) {
        this.name = name;
        this.diagnostic = diagnostic;
    }

    public String getName() {
        return name;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String toJson() {
        return "{\"name\":" + name + "\"," +
                "\"diagnostic\":\"" + diagnostic +
                "\"}";
    }
}

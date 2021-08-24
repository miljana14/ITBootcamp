package utorak.pozoriste;

public abstract class Zaposleni {
    private String ime;
    private Pozoriste pozoriste;

    public Zaposleni(String ime, Pozoriste pozoriste) {
        this.ime = ime;
        this.pozoriste = pozoriste;
    }

    // Свака поткласа (која није апстрактна) мора да
    // имплементира ову методу
    public abstract String imePosla();

    public String getIme() {
        return ime;
    }

    public Pozoriste getPozoriste() {
        return pozoriste;
    }

    @Override
    public String toString() {
        return "Zaposleni{" +
                "ime='" + ime + '\'' +
                ", pozoriste=" + pozoriste +
                '}';
    }
}


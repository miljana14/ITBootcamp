package utorak.pozoriste;

import java.util.LinkedList;
import java.util.List;

public class Predstava {
    private String naziv;
    private Pozoriste pozoriste;
    private List<Zaposleni> zaposleni;

    public Predstava(String naziv, Pozoriste pozoriste, Reditelj reditelj){
        this.naziv = naziv;
        this.pozoriste = pozoriste;
        this.zaposleni = new LinkedList<>();
        this.zaposleni.add(reditelj);
    }

    // TODO: dodaj(Glumac glumac) - boolean
    public boolean dodaj(Glumac glumac){
        if(zaposleni.contains(glumac)){
            return false;
        }
        zaposleni.add(glumac);
        return true;
    }
    // TODO: dodaj(Kostimograf k) - boolean
    public boolean dodaj(Kostimograf k){
        if(zaposleni.contains(k)){
            return false;
        }
        zaposleni.add(k);
        return true;
    }


    public String getNaziv() {
        return naziv;
    }

    public Pozoriste getPozoriste() {
        return pozoriste;
    }

    // {naziv}:
    // {zaposleni1}
    // {zaposleni2}
    // ...
    // {zaposlenin}
    @Override
    public String toString() {
        return naziv + zaposleni;
    }
}

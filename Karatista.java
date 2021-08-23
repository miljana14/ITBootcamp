package domaciSreda;

import java.util.Arrays;
import java.util.Random;

public class Karatista {
    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public Karatista(String ime, int godine, String rang, String[] kata) {
       if(Character.isUpperCase(ime.charAt(0))) {
           this.ime = ime;
       }
       else {
           System.out.println("U imenu " + ime + " prvo slovo mora biti veliko.");
       }
        if(godine > 15){
            this.godine = godine;
        }
        else {
            System.out.println("Pogresan unos godina za karatistu pod imenom " + this.ime + ". Mora biti stariji od 15 god.");
        }
        if(rang.equals("10Kyu") || rang.equals("9Kyu") || rang.equals("8Kyu") || rang.equals("7Kyu") || rang.equals("6Kyu") || rang.equals("5Kyu") || rang.equals("4Kyu") || rang.equals("3Kyu") || rang.equals("2Kyu") || rang.equals("1Kyu") || rang.equals("1Dan") || rang.equals("2Dan") || rang.equals("3Dan") || rang.equals("4Dan") || rang.equals("5Dan") || rang.equals("6Dan") || rang.equals("7Dan") || rang.equals("8Dan") || rang.equals("9Dan") || rang.equals("10Dan")) {
            this.rang = rang;
        }
         else {
            System.out.println("Pogresan unos ranga za karatistu pod imenom " + this.ime + ". Mora biti jedan od navedenih (10Kyu, 9Kyu, ..., 1kyu, 1Dan, 2Dan, ..., 10Dan) ");
        }
        this.kata = kata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if(Character.isUpperCase(ime.charAt(0))) {
            this.ime = ime;
        }
        else {
            System.out.println("U imenu " + ime + " prvo slovo mora biti veliko.");
        }
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        if(godine > 15){
            this.godine = godine;
        }
        else {
            System.out.println("Pogresan unos godina za karatistu pod imenom " + this.ime + ". Mora biti stariji od 15 god.");
        }
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        if(rang.equals("10Kyu") || rang.equals("9Kyu") || rang.equals("8Kyu") || rang.equals("7Kyu") || rang.equals("6Kyu") || rang.equals("5Kyu") || rang.equals("4Kyu") || rang.equals("3Kyu") || rang.equals("2Kyu") || rang.equals("1Kyu") || rang.equals("1Dan") || rang.equals("2Dan") || rang.equals("3Dan") || rang.equals("4Dan") || rang.equals("5Dan") || rang.equals("6Dan") || rang.equals("7Dan") || rang.equals("8Dan") || rang.equals("9Dan") || rang.equals("10Dan")) {
            this.rang = rang;
        }
        else {
            System.out.println("Pogresan unos ranga za karatistu pod imenom " + this.ime + ". Mora biti jedan od navedenih (10Kyu, 9Kyu, ..., 1kyu, 1Dan, 2Dan, ..., 10Dan) ");
        }
    }

    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }

    public void napadni(int index){
        System.out.println("Karatista " + this.ime + " napada sa " + this.kata[index] + " katom");
    }

    public void vatreniNapad(){
        int k = new Random().nextInt(this.kata.length);
        String ka = (this.kata[k]);
        System.out.println("Karatista " + this.ime + " napada sa " + ka + " " + "katom");
    }

    public void log(){
        System.out.println("Karatistia: " + this.ime + ", " + this.godine + ", " + this.rang + " - zna naredne kate " + Arrays.toString(this.kata));
    }
}

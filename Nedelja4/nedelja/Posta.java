package domaciNedelja;

import java.util.ArrayList;

public class Posta {
    private ArrayList<Poruka> poruke;

    public Posta(ArrayList<Poruka> poruke) {
        this.poruke = poruke;
    }

    public Posta() {
    }

    public ArrayList<Poruka> getPoruke() {
        return poruke;
    }

    public void setPoruke(ArrayList<Poruka> poruke) {
        this.poruke = poruke;
    }

    public void add(Poruka p){
        for(Poruka poruka: poruke){
            if (poruka.getId() == p.getId()) {
                return;
            }
        }
        poruke.add(p);
    }

    public void remove(Poruka p){
        for (int i = 0; i < poruke.size(); i++) {
            if (poruke.get(i).getId() == p.getId()){
                poruke.remove(i);
                break;
            }
        }
    }

    public void send(Poruka p){
        System.out.println(p);
        for (int i = 0; i < poruke.size(); i++) {
            if (poruke.get(i).getId() == p.getId()){
                poruke.remove(i);
                break;
            }
        }
    }

    public void change(Poruka p, String msg){
        for (int i = 0; i < poruke.size(); i++) {
            if (poruke.get(i).getPoruka().equals(p.getPoruka())){
                poruke.get(i).setPoruka(msg);
                break;
            }
        }
    }

    public int isplata(Poruka p){
        int sum = 0;
        for (int i = 0; i < poruke.size(); i++) {
            if (poruke.get(i).getId() == p.getId()){
                sum = poruke.get(i).getSuma();
                break;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "";
        for(Poruka p : poruke){
           p.posalji();
        }
        return s;
    }
}

package domaciNedelja;

public class Poruka {
    private String poruka;
    private String posiljalac;
    private String primalac;
    int suma;
    int id;

    public Poruka(String poruka, String posiljalac, String primalac, int suma, int id) {
        this.poruka = poruka;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.suma = suma;
        this.id = id;
    }

    public Poruka() {
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void posalji(){
        if(this.suma >= 0) {
            System.out.println(this.posiljalac + " salje " + this.suma + " para " + this.primalac + "-u, uz poruku:\n" + this.poruka);
        }
        else {
            System.out.println(this.posiljalac + " prima " + this.suma + " para od " + this.primalac + "-a, uz poruku:\n" + this.poruka);
        }
    }

    @Override
    public String toString() {
        return this.posiljalac + " i " + this.primalac + " vrse transakciju od " + this.suma + ", uz poruku: " + this.poruka + " (" + this.id + ")";
    }
}


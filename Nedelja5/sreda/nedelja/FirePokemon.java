package domaciNedelja;

public class FirePokemon extends Pokemon{

    public FirePokemon(String name, int health) {
        super(name, health);
    }



    @Override
    public String napada() {
        return "Napada: vatrom";
    }

    @Override
    public String braniSe() {
        return "Brani se: telesno";
    }

    @Override
    public String pobedjuje() {
        return "Pobedjuje: Grass type";
    }

    @Override
    public String gubiOd() {
        return "Gubi od: Water type";
    }

    @Override
    public String logAll() {
        return "Ime: " + name + "\n" + napada() + "\n" + braniSe() + "\n" + pobedjuje() + "\n" + gubiOd();
    }
}

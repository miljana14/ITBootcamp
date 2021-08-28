package domaciNedelja;

public class GrassPokemon extends Pokemon{

    public GrassPokemon(String name, int health) {
        super(name, health);
    }

    @Override
    public String napada() {
        return "Napada: travom";
    }

    @Override
    public String braniSe() {
        return "Brani se: izbegava";
    }

    @Override
    public String pobedjuje() {
        return "Pobedjuje: Water type";
    }

    @Override
    public String gubiOd() {
        return "Gubi od: Fire type";
    }

    @Override
    public String logAll() {
        return "Ime: " + name + "\n" + napada() + "\n" + braniSe() + "\n" + pobedjuje() + "\n" + gubiOd();
    }
}

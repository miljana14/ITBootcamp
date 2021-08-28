package domaciNedelja;

public class WaterPokemon extends Pokemon{

    public WaterPokemon(String name, int health) {
        super(name, health);
    }

    @Override
    public String napada() {
        return "Napada: vodom";
    }

    @Override
    public String braniSe() {
        return "Brani se: vodom";
    }

    @Override
    public String pobedjuje() {
        return "Pobedjuje: Fire type";
    }

    @Override
    public String gubiOd() {
        return "Gubi od: Grass type";
    }

    @Override
    public String logAll() {
        return "Ime: " + name + "\n" + napada() + "\n" + braniSe() + "\n" + pobedjuje() + "\n" + gubiOd();
    }
}

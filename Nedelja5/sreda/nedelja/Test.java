package domaciNedelja;

public class Test {
    public static void main(String[] args) {
        FirePokemon charizard = new FirePokemon("Charizard",  100);
        Pokemon bulbasaur = new GrassPokemon("Bulbasaur", 50);
        WaterPokemon lapras = new WaterPokemon("Lapras", 120);
        System.out.println(charizard.napada());
        System.out.println("-------------------------");
        System.out.println(bulbasaur.braniSe());
        System.out.println("-------------------------");
        System.out.println(lapras.logAll());
    }
}

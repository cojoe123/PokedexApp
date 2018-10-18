package joey.com.pokedexapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/*
* Singleton class
*
* */
public class PokemonLab {

    private static PokemonLab sPokemonLab;
    private List<Pokemon> mPokemons;

    public static PokemonLab get(Context context) {
        if (sPokemonLab == null) {
            sPokemonLab = new PokemonLab(context);
        }

        return sPokemonLab;
    }

    private PokemonLab(Context context) {
        mPokemons = new ArrayList<>();

        // generating the 10 pokemon
        // 1
        Pokemon bulbasaur = new Pokemon();
        bulbasaur.setName("Bulbasaur");
        bulbasaur.setCategory("Seed");

        mPokemons.add(bulbasaur);

        // 2
        Pokemon charmander = new Pokemon();
        charmander.setName("Charmander");
        charmander.setCategory("Lizard");

        mPokemons.add(charmander);

        // 3
        Pokemon squirtle = new Pokemon();
        squirtle.setName("Squirtle");
        squirtle.setCategory("Tiny Turtle");

        mPokemons.add(squirtle);

        // 4
        Pokemon butterfree = new Pokemon();
        butterfree.setName("ButterFree");
        butterfree.setCategory("ButterFly");

        mPokemons.add(butterfree);

        // 5
        Pokemon beedrill = new Pokemon();
        beedrill.setName("BeeDrill");
        beedrill.setCategory("Poison Bee");

        mPokemons.add(beedrill);

        // 6
        Pokemon vulpix = new Pokemon();
        vulpix.setName("Vulpix");
        vulpix.setCategory("Fox");

        mPokemons.add(vulpix);

        // 7
        Pokemon ninetales = new Pokemon();
        ninetales.setName("Ninetales");
        ninetales.setCategory("Fox");

        mPokemons.add(ninetales);

        // 8
        Pokemon cubone = new Pokemon();
        cubone.setName("Cubone");
        cubone.setCategory("Lonely");

        mPokemons.add(cubone);

        // 9
        Pokemon jolteon = new Pokemon();
        jolteon.setName("Jolteon");
        jolteon.setCategory("Lightning");

        mPokemons.add(jolteon);

        // 10
        Pokemon growlithe = new Pokemon();
        growlithe.setName("Growlithe");
        growlithe.setCategory("Puppy");

        mPokemons.add(growlithe);
    }

    public List<Pokemon> getPokemons() {
        return mPokemons;
    }

    public Pokemon getPokemon(String name) {
        for (Pokemon poke : mPokemons) {
            if (poke.getName().equals(name)) {
                return poke;
            }
        }

        return null;
    }

}

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
        bulbasaur.setHeight("2' 04\" ");
        bulbasaur.setWeight("15.2 lbs");
        bulbasaur.setCategory("Seed");
        bulbasaur.setHP(2);
        bulbasaur.setAttack(3);
        bulbasaur.setDefense(2);
        bulbasaur.setSpecialAttack(3);
        bulbasaur.setSpecialDefense(3);
        bulbasaur.setSpeed(3);

        mPokemons.add(bulbasaur);

        // 2
        Pokemon charmander = new Pokemon();
        charmander.setName("Charmander");
        charmander.setHeight("2' 00\" ");
        charmander.setWeight("18.7 lbs");
        charmander.setCategory("Lizard");
        charmander.setHP(2);
        charmander.setAttack(3);
        charmander.setDefense(2);
        charmander.setSpecialAttack(3);
        charmander.setSpecialDefense(2);
        charmander.setSpeed(4);

        mPokemons.add(charmander);

        // 3
        Pokemon squirtle = new Pokemon();
        squirtle.setName("Squirtle");
        squirtle.setHeight("1' 08\" ");
        squirtle.setWeight("19.8 lbs");
        squirtle.setCategory("Tiny Turtle");
        squirtle.setHP(2);
        squirtle.setAttack(3);
        squirtle.setDefense(3);
        squirtle.setSpecialAttack(2);
        squirtle.setSpecialDefense(3);
        squirtle.setSpeed(2);

        mPokemons.add(squirtle);

        // 4
        Pokemon butterfree = new Pokemon();
        butterfree.setName("ButterFree");
        butterfree.setHeight("3' 07\" ");
        butterfree.setWeight("70.5 lbs");
        butterfree.setCategory("ButterFly");
        butterfree.setHP(3);
        butterfree.setAttack(2);
        butterfree.setDefense(2);
        butterfree.setSpecialAttack(4);
        butterfree.setSpecialDefense(3);
        butterfree.setSpeed(4);

        mPokemons.add(butterfree);

        // 5
        Pokemon beedrill = new Pokemon();
        beedrill.setName("BeeDrill");
        beedrill.setHeight("3' 03\" ");
        beedrill.setWeight("65.0 lbs");
        beedrill.setCategory("Poison Bee");
        beedrill.setHP(3);
        beedrill.setAttack(4);
        beedrill.setDefense(2);
        beedrill.setSpecialAttack(2);
        beedrill.setSpecialDefense(3);
        beedrill.setSpeed(4);

        mPokemons.add(beedrill);

        // 6
        Pokemon vulpix = new Pokemon();
        vulpix.setName("Vulpix");
        vulpix.setHeight("2' 00\" ");
        vulpix.setWeight("21.8 lbs");
        vulpix.setCategory("Fox");
        vulpix.setHP(2);
        vulpix.setAttack(2);
        vulpix.setDefense(2);
        vulpix.setSpecialAttack(2);
        vulpix.setSpecialDefense(3);
        vulpix.setSpeed(4);

        mPokemons.add(vulpix);

        // 7
        Pokemon ninetales = new Pokemon();
        ninetales.setName("Ninetales");
        ninetales.setHeight("3' 07\" ");
        ninetales.setWeight("43.9 lbs");
        ninetales.setCategory("Fox");
        ninetales.setHP(3);
        ninetales.setAttack(4);
        ninetales.setDefense(3);
        ninetales.setSpecialAttack(4);
        ninetales.setSpecialDefense(4);
        ninetales.setSpeed(5);

        mPokemons.add(ninetales);

        // 8
        Pokemon cubone = new Pokemon();
        cubone.setName("Cubone");
        cubone.setHeight("1' 04\" ");
        cubone.setWeight("14.3 lbs");
        cubone.setCategory("Lonely");
        cubone.setHP(3);
        cubone.setAttack(3);
        cubone.setDefense(4);
        cubone.setSpecialAttack(2);
        cubone.setSpecialDefense(2);
        cubone.setSpeed(2);

        mPokemons.add(cubone);

        // 9
        Pokemon jolteon = new Pokemon();
        jolteon.setName("Jolteon");
        jolteon.setHeight("2' 07\" ");
        jolteon.setWeight("54.0 lbs");
        jolteon.setCategory("Lightning");
        jolteon.setHP(3);
        jolteon.setAttack(3);
        jolteon.setDefense(3);
        jolteon.setSpecialAttack(5);
        jolteon.setSpecialDefense(4);
        jolteon.setSpeed(7);

        mPokemons.add(jolteon);

        // 10
        Pokemon growlithe = new Pokemon();
        growlithe.setName("Growlithe");
        growlithe.setHeight("2' 04\" ");
        growlithe.setWeight("41.9 lbs");
        growlithe.setCategory("Puppy");
        growlithe.setHP(2);
        growlithe.setAttack(4);
        growlithe.setDefense(2);
        growlithe.setSpecialAttack(3);
        growlithe.setSpecialDefense(2);
        growlithe.setSpeed(3);

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

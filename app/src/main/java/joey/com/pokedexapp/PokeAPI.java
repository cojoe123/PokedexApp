package joey.com.pokedexapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeAPI {

    @GET("pokemon/{pokeName}")
    Call<Pokemon> getPokemon(@Path("pokeName") String pName);

}

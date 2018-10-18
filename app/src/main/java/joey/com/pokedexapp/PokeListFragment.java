package joey.com.pokedexapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeListFragment extends Fragment {

    private RecyclerView mPokemonRecyclerView;
    private PokemonAdapter mPokemonAdapter;
    public List<Pokemon> data;
    //public static final String BASE_URL = "https://pokeapi.co/api/v2/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        mPokemonRecyclerView = (RecyclerView) view.findViewById(R.id.pokemon_recycler_view);
        mPokemonRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        PokemonLab pokemonLab = PokemonLab.get(getActivity());
        List<Pokemon> pokemons = pokemonLab.getPokemons();

        mPokemonAdapter = new PokemonAdapter(pokemons);
        mPokemonRecyclerView.setAdapter(mPokemonAdapter);

    }


    private class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mPokeTextView;
        private Pokemon mPokemon;

        public PokemonHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_pokemon, parent, false));
            itemView.setOnClickListener(this);

            mPokeTextView = (TextView) itemView.findViewById(R.id.pokemon_name);
        }

        @Override
        public void onClick(View view) {

            Bundle extras = new Bundle();
            extras.putString("poke_name", mPokemon.getName());
            extras.putString("category", mPokemon.getCategory());

            Intent intent = new Intent(getActivity(), PokeInfoActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }

        public void bind(Pokemon pokemon) {
            mPokemon = pokemon;
            mPokeTextView.setText(mPokemon.getName());

        }

    }

    private class PokemonAdapter extends RecyclerView.Adapter<PokemonHolder> {

        private List<Pokemon> mPokemons;

        public PokemonAdapter(List<Pokemon> pokemons) {
            mPokemons = pokemons;
        }

        @Override
        public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new PokemonHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(PokemonHolder holder, int position) {
            Pokemon poke = mPokemons.get(position);
            holder.bind(poke);

        }

        @Override
        public int getItemCount() {
            return mPokemons.size();
        }

    }

}

package joey.com.pokedexapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PokeListFragment extends Fragment {

    private RecyclerView mPokemonRecyclerView;
    private PokemonAdapter mPokemonAdapter;

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

    private class PokemonHolder extends RecyclerView.ViewHolder {
        public PokemonHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_pokemon, parent, false));
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

        }

        @Override
        public int getItemCount() {
            return mPokemons.size();
        }

    }

}

package joey.com.pokedexapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PokedexActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PokemonFragment();
    }
}

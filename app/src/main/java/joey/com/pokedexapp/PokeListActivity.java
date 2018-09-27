package joey.com.pokedexapp;

import android.support.v4.app.Fragment;

public class PokeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PokeListFragment();
    }

}

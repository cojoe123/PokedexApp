package joey.com.pokedexapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeInfoActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mWeight;
    private TextView mHeight;
    private TextView mCategory;
    private EditText mStats;
    private ImageView mProPic;
    private Pokemon data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokeinfo);

        Intent intent = getIntent();

        String name = intent.getStringExtra("poke_name");
        mName = (TextView) findViewById(R.id.pokeName);
        mCategory = (TextView) findViewById(R.id.category);
        mHeight = (TextView) findViewById(R.id.height);
        mWeight = (TextView) findViewById(R.id.weight);
        mProPic = (ImageView) findViewById(R.id.pokePic);
        mStats = (EditText) findViewById(R.id.pokeStats);

//        String category = getIntent().getStringExtra("category");
//        mCategory.setText(String.format("Category: %s", category));

        // connect to API
        PokeAPI service = RetrofitClient.getRetrofitInstance().create(PokeAPI.class);
        Call<Pokemon> call = service.getPokemon(name.toLowerCase());
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                data = response.body();

                mName.setText(String.format("Name: %s", data.getName()));
                mHeight.setText(String.format("Height: %s", data.getHeight()));
                mWeight.setText(String.format("Weight: %s", data.getWeight()));

                int hp = 0;
                int atk = 0;
                int def = 0;
                int specialAtk = 0;
                int specialDef = 0;
                int speed = 0;

                List<Pokemon.Stat> stats = data.getStats();

                for (Pokemon.Stat s : stats) {
                    Pokemon.Stat_ st = s.getStat();
                    if (st.getStatName().equals("speed")) {
                        speed = s.getBaseStat();
                    } else if (st.getStatName().equals("special-defense")) {
                        specialDef = s.getBaseStat();
                    } else if (st.getStatName().equals("special-attack")) {
                        specialAtk = s.getBaseStat();
                    } else if (st.getStatName().equals("defense")) {
                        def = s.getBaseStat();
                    } else if (st.getStatName().equals("attack")) {
                        atk = s.getBaseStat();
                    } else if (st.getStatName().equals("hp")) {
                        hp = s.getBaseStat();
                    }

                }

                mStats.setText(String.format(
                        String.format("Stats \n\nHP: %%d \nAttack: %%d \nDefense: %%d \nSpecial Attack: %%d \nSpecial Defense: %%d \nSpeed: %%d"),
                        hp, atk, def, specialAtk, specialDef, speed
                ));

                // logic to display image
                Bitmap bitmap;
                if (data.getName().toLowerCase().equals("bulbasaur")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bulbasaur);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("cubone")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cubone);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("charmander")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.chramander);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("squirtle")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.squirtle);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("butterfree")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.butterfree);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("beedrill")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beedrill);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("ninetales")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ninetales);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("vulpix")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.vulpix);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("jolteon")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jolteon);
                    mProPic.setImageBitmap(bitmap);
                } else if (data.getName().toLowerCase().equals("growlithe")) {
                    bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.growlithe);
                    mProPic.setImageBitmap(bitmap);
                }

                mStats.setKeyListener(null);


            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(PokeListFragment.class.getSimpleName(), t.toString());
                Toast.makeText(PokeInfoActivity.this, "Unable to load pokemon data", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

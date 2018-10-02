package joey.com.pokedexapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PokeInfoActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mWeight;
    private TextView mHeight;
    private TextView mCategory;
    private EditText mStats;
    private ImageView mProPic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pokeinfo);

        String name = getIntent().getStringExtra("poke_name");
        mName = (TextView) findViewById(R.id.pokeName);
        mName.setText(String.format("Name: %s", name));

        String height = getIntent().getStringExtra("height");
        mHeight = (TextView) findViewById(R.id.height);
        mHeight.setText(String.format("Height: %s", height));

        String weight = getIntent().getStringExtra("weight");
        mWeight = (TextView) findViewById(R.id.weight);
        mWeight.setText(String.format("Weight: %s", weight));

        String category = getIntent().getStringExtra("category");
        mCategory = (TextView) findViewById(R.id.category);
        mCategory.setText(String.format("Category: %s", category));

        int hp = getIntent().getExtras().getInt("hp");
        int atk = getIntent().getExtras().getInt("atk");
        int def = getIntent().getExtras().getInt("def");
        int specialAtk = getIntent().getExtras().getInt("special_atk");
        int specialDef = getIntent().getExtras().getInt("special_def");
        int speed = getIntent().getExtras().getInt("speed");

        mStats = (EditText) findViewById(R.id.pokeStats);
        mStats.setText(String.format(
                String.format("Stats \n\nHP: %%d \nAttack: %%d \nDefense: %%d \nSpecial Attack: %%d \nSpecial Defense: %%d \nSpeed: %%d"),
                hp, atk, def, specialAtk, specialDef, speed
        ));

        // logic to display image
        Bitmap bitmap;
        mProPic = (ImageView) findViewById(R.id.pokePic);
        if (name.toLowerCase().equals("bulbasaur")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bulbasaur);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("cubone")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cubone);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("charmander")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.chramander);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("squirtle")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.squirtle);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("butterfree")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.butterfree);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("beedrill")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beedrill);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("ninetales")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ninetales);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("vulpix")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.vulpix);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("jolteon")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jolteon);
            mProPic.setImageBitmap(bitmap);
        } else if (name.toLowerCase().equals("growlithe")) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.growlithe);
            mProPic.setImageBitmap(bitmap);
        }

        mStats.setKeyListener(null);

    }

}

package com.pokedex;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener,StatsFragment.OnFragmentInteractionListener, View.OnClickListener {



    private static final int  OPTION_DETAIL= 0;
    private static final int  OPTION_STATS= 1;

    private TextView imageoptionTv;
    private TextView statsTv;

    private Pokemon selectedPokemon;
    private  int selectedOption;

    private   Fragment currentFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageoptionTv = findViewById(R.id.activity_main_image_option_textView);
        statsTv = findViewById(R.id.activity_main_stats_option_textView);

        imageoptionTv.setBackgroundColor(ContextCompat.getColor(this, R.color.select));
        statsTv.setBackgroundColor(ContextCompat.getColor(this, R.color.not_select));

        imageoptionTv.setOnClickListener(this);
        statsTv.setOnClickListener(this);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {



    }

    @Override
    public void onPokemonSelected(Pokemon pokemon) {

        selectedPokemon = pokemon;
        setFragmentAndContent();

    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId) {
            case R.id.activity_main_image_option_textView:
                imageoptionTv.setBackgroundColor(ContextCompat.getColor(this, R.color.select));
                statsTv.setBackgroundColor(ContextCompat.getColor(this, R.color.not_select));
               selectedOption = OPTION_DETAIL;
                break;
            case R.id.activity_main_stats_option_textView:
                statsTv.setBackgroundColor(ContextCompat.getColor(this, R.color.not_select));
                statsTv.setBackgroundColor(ContextCompat.getColor(this, R.color.select));
                selectedOption = OPTION_STATS;
                break;
        }

        setFragmentAndContent();
    }

    private void setFragmentAndContent() {
        if(selectedPokemon != null){
            if(selectedOption == OPTION_DETAIL) {
                 currentFragment = DetailFragment.newInstance(selectedPokemon.getImageUrl(),
                selectedPokemon.getSoundId());
            }else if(selectedOption == OPTION_STATS){
                currentFragment = StatsFragment.newInstance(selectedPokemon.getStats());

            }
            FragmentTransaction  fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.detail_fragment_container, currentFragment);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this, "Deverá selecionar pelo menos um pokemon", Toast.LENGTH_SHORT).show();
        }

    }
}

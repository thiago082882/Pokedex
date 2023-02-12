package com.pokedex;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class PokemonListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PokemonListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        ListView pokemonListView = (ListView) view.findViewById(R.id.pokemon_listView);
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        Stats bulbasaurStats = new Stats("45","49","49","65");
        Stats ivysaurStats = new Stats("60","62","63","80");
        Stats venusaurStats = new Stats("80","82","83","100");
        Stats charmanderStats = new Stats("39","52","43","50");
        Stats charmeleonStats = new Stats("58","64","58","65");
        Stats charizardStats = new Stats("78","84","78","85");
        Stats squirtleStats = new Stats("44","48","65","64");
        Stats wartortleStats = new Stats("59","63","50","80");
        Stats blastoiseStats = new Stats("79","83","100","105");
        Stats pikachuStats = new Stats("35","55","40","50");
        Stats raichuStats = new Stats("60","85","50","85");


        pokemonList.add(new Pokemon("1", "Bulbasaur","https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",R.raw.bulbasaur, Pokemon.Type.PLANT,bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur","https://i.pinimg.com/originals/e7/91/72/e79172fef348260adb1de1406b332deb.png", R.raw.ivysaur,Pokemon.Type.PLANT,ivysaurStats));
        pokemonList.add(new Pokemon("3", "Venuasaur","https://assets.pokemon.com/assets/cms2/img/pokedex/full/003.png",R.raw.venuasaur, Pokemon.Type.PLANT,venusaurStats));
        pokemonList.add(new Pokemon("4", "Charmander","https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",R.raw.charmander, Pokemon.Type.FIRE,charmanderStats));
        pokemonList.add(new Pokemon("5", "Charmeleon","https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png",R.raw.charmeleon, Pokemon.Type.FIRE,charmeleonStats));
        pokemonList.add(new Pokemon("6", "Charizard","https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png",R.raw.charizard, Pokemon.Type.FIRE,charizardStats));
        pokemonList.add(new Pokemon("7", "Squirtle","https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",R.raw.squirtle, Pokemon.Type.WATER,squirtleStats));
        pokemonList.add(new Pokemon("8", "Wartortle","https://assets.pokemon.com/assets/cms2/img/pokedex/full/008.png",R.raw.wartortle, Pokemon.Type.WATER,wartortleStats));
        pokemonList.add(new Pokemon("9", "Blastoise","https://assets.pokemon.com/assets/cms2/img/pokedex/full/009.png",R.raw.blastoise, Pokemon.Type.WATER,blastoiseStats));
        pokemonList.add(new Pokemon("25", "Pikachu","https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",R.raw.pikachu, Pokemon.Type.ELECTRIC,pikachuStats));
        pokemonList.add(new Pokemon("26", "Raichu","https://assets.pokemon.com/assets/cms2/img/pokedex/full/026.png",R.raw.raichu, Pokemon.Type.ELECTRIC,raichuStats));

        final PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), R.layout.pokemon_list_item,
                pokemonList);
        pokemonListView.setAdapter(adapter);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pokemon selectedPokemon = adapter.getItem(position);

                if (selectedPokemon != null) {
                    mListener.onPokemonSelected(selectedPokemon);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onPokemonSelected(Pokemon pokemon);
    }
}

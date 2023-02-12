package com.pokedex;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class StatsFragment extends Fragment {


    private static final String POKEMON_STATS = "pokemon_stats";
    private OnFragmentInteractionListener mListener;

public StatsFragment() {


}
    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View view = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView  hpTextView= view.findViewById(R.id.fragments_stats_hp);
        TextView attackTextView= view.findViewById(R.id.fragments_stats_attack);
        TextView defenseTextView= view.findViewById(R.id.fragments_stats_defense);
        TextView speedTextView= view.findViewById(R.id.fragments_stats_speed);

        if (getArguments() != null) {
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);
            hpTextView.setText(pokemonStats.getHp());
            attackTextView.setText(pokemonStats.getAttack());
            defenseTextView.setText(pokemonStats.getDefense());
            speedTextView.setText(pokemonStats.getSpeed());
        }
       return view;
    }

    public void onButtonPressed(Uri uri) {
        if(mListener!= null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener) {
            mListener= (OnFragmentInteractionListener) context;
        }else {
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
        void onFragmentInteraction(Uri uri);
    }
}
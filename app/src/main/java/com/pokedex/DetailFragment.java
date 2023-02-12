package com.pokedex;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private ImageView detailsImageView;
    private static final String POKEMON_IMAGE = "pokemon_image";
    private static final String POKEMON_SOUND = "pokemon_sound";

    public static DetailFragment newInstance(String pokemonImageUrl, int pokemonSoundId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(POKEMON_IMAGE, pokemonImageUrl);
        args.putInt(POKEMON_SOUND, pokemonSoundId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        detailsImageView = view.findViewById(R.id.pokemon_detail_imageView);

        if(getArguments()!= null) {
            String pokemonImageUrl = getArguments().getString(POKEMON_IMAGE);
            int pokemonSoundId = getArguments().getInt(POKEMON_SOUND);

            setPokemonImage(pokemonImageUrl);
            playPokemonSound(pokemonSoundId);
        }

        return view;
    }

    private void setPokemonImage(String pokemonImageUrl ){
        Picasso.get().load(pokemonImageUrl).into(detailsImageView);

    }

 private  void playPokemonSound(int pokemonSoundId){
    MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),pokemonSoundId);
    mediaPlayer.start();

}

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener. onFragmentInteraction(uri);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package com.example.pukisapps.ui.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pukisapps.R;

public class MusicFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected MusicAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset11, mDataset12;
    protected int[] mDataset13;

    int [] icon = {R.drawable.ic_music_video_black_24dp, R.drawable.ic_music_video_black_24dp,
            R.drawable.ic_music_video_black_24dp,R.drawable.ic_music_video_black_24dp,
            R.drawable.ic_music_video_black_24dp,R.drawable.ic_music_video_black_24dp
            ,R.drawable.ic_music_video_black_24dp,R.drawable.ic_music_video_black_24dp};
    String [] judul = {"All The Time","Black Amplifier","Kumerindu","Kesepian Kita","Elastic Heart","Telenovia","Say So","Boss Bitch"};
    String [] penyanyi = {"The Sigit","The Sigit","Pas Band","Pas Band","Reality Club","Reality Club","Doja Cat","Doja Cat"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_music);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));

        mAdapter = new MusicAdapter(mDataset11,mDataset12,mDataset13);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);;
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }


    private void initDataset() {
        mDataset11 = new String[judul.length];
        mDataset12 = new String[penyanyi.length];
        mDataset13 = new int[icon.length];

        for (int i = 0; i < judul.length; i++) {
            mDataset11[i] = judul[i];
            mDataset12[i] = penyanyi[i];
            mDataset13[i] = icon[i];
        }

    }
}

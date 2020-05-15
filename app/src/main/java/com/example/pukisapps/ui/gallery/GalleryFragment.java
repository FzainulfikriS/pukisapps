package com.example.pukisapps.ui.gallery;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pukisapps.R;

public class GalleryFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected GalleryAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected int[]  mDataset6;

    int [] foto = {R.drawable.gambar1, R.drawable.gambar2,R.drawable.gambar3,
            R.drawable.gambar4,R.drawable.gambar5,R.drawable.gambar6,R.drawable.gambar7,
            R.drawable.gambar8,R.drawable.gambar9,R.drawable.gambar10,R.drawable.gambar11,
            R.drawable.gambar12,R.drawable.gambar13,R.drawable.gambar14,R.drawable.gambar15,
            R.drawable.gambar16};

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
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_galery);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GalleryAdapter(mDataset6);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }


    private void initDataset() {
        mDataset6 = new int[foto.length];
        for (int i = 0; i < foto.length; i++) {
            mDataset6[i] = foto[i];
        }
    }
}

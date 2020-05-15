package com.example.pukisapps.ui.daily;

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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pukisapps.CustomAdapter;
import com.example.pukisapps.R;

import java.util.ArrayList;

public class DailyFragment extends Fragment{

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value


    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView, mRecyclerView2;
    protected CustomAdapter mAdapter;
    protected FriendAdapter mAdapter2;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset, mDataset2,mDataset4;
    protected int[] mDataset3,mDataset5;

    int [] icon = {R.drawable.ic_daily, R.drawable.ic_daily,R.drawable.ic_daily,R.drawable.ic_daily
            ,R.drawable.ic_daily,R.drawable.ic_daily,R.drawable.ic_daily,R.drawable.ic_daily};
    String [] judul = {"sleep","sleep","sleep","eat","game","game","game","sleep"};
    String [] deskripsi = {"everytime","everytime","everytime","everytime","everytime","everytime"
            ,"everytime","everytime"};

    int [] foto = {R.drawable.ic_profile,R.drawable.ic_profile,R.drawable.ic_profile,
            R.drawable.ic_profile,R.drawable.ic_profile,R.drawable.ic_profile};
    String  [] nama = {"yanto basna","adam kuy","lahang jojodog","halangan diri","boa boa",
            "dosa dosa"};

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
        View rootView = inflater.inflate(R.layout.fragment_daily, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
            mRecyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler_view);


        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new CustomAdapter(mDataset,mDataset2,mDataset3);
        mAdapter2 = new FriendAdapter(mDataset4,mDataset5);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView2.setAdapter(mAdapter2);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[judul.length];
        mDataset2 = new String[deskripsi.length];
        mDataset3 = new int[icon.length];
        mDataset4 = new String[nama.length];
        mDataset5 = new int[foto.length];
        for (int i = 0; i < judul.length; i++) {
            mDataset[i] = judul[i];
            mDataset2[i] = deskripsi[i];
            mDataset3[i] = icon[i];
        }
        for (int i = 0; i < nama.length; i++){
            mDataset4[i] = nama[i];
            mDataset5[i] = foto[i];
        }
    }
}

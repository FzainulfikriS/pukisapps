package com.example.pukisapps.ui.profile;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pukisapps.R;

import java.net.URL;

public class ProfileFragment extends Fragment{

    private ProfileViewModel profileViewModel;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.instagram);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.faebook);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.maps);
        Button button = (Button) view.findViewById(R.id.button);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://instagram.com/fzainulfikri"));
                getActivity().startActivity(i);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("https://facebook.com/fzainulfikri"));
                getActivity().startActivity(ii);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii = new Intent(Intent.ACTION_VIEW);
                iii.setData(Uri.parse("https://goo.gl/maps/yApcYSqpyk2oA8F58"));
                getActivity().startActivity(iii);
            }
        });


        return view;
    }



}

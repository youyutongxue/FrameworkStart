package com.virgil.frameworkstart.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.SecondActivity;

public class HomeFragment extends Fragment {
    private Button mBtn_click;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mBtn_click = (Button) view.findViewById(R.id.btn_click);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mBtn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent().setClass(getContext(), SecondActivity.class));
            }
        });
    }
}

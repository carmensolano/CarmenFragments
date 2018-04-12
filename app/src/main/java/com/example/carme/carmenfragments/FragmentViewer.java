package com.example.carme.carmenfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentViewer extends Fragment {
    TextView text;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
     View view = inflater.inflate(R.layout.viewer_fragment, container, attachToRoot: false);

     text = view.findViewById(R.id.textId);
     Bundle bundle = this.getArguments();

     if(bundle != null){
         Toast.makeText(getActivity(), text:"Item:" + bundle.get(key: "KEY"),Toast.LENGTH_SHORT).show();

         text.setText(bundle.getString(key: "KEY"));
     }

     return view;
    }
}

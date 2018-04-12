package com.example.carme.carmenfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Plantes, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long 1){

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
           Intent newIntent = new Intent (getActivity().getApplicationContext(), Main2Activity.class);
           newIntent.setAction(Intent.ACTION_SEND);
           newIntent.setType("text/plain");
           newIntent.putExtra(Intent.EXTRA_TEXT,adapterView.getItemIdAtPosition(i).toString());
           startActivity(newIntent);
        }else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getActivity(), text: "Item:"+ adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle =new Bundle();
            bundle.putString("KEY", adapterView.getItemIdAtPosition(i).toString());
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);

            FragmentManager fragmentManager= getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();

        }

    }
}

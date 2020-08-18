package com.example.VyAppar;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class Fragment_Search extends Fragment {

    View view;
    Adapter_Search adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView l1,l2;
    SearchView sw;
    Chip chiprice,chipcat;
    BottomSheetDialog dialogadd;
    TextView head;





    public Fragment_Search() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        l1=view.findViewById(R.id.l1);
        chipcat=view.findViewById(R.id.chipcat);
        chiprice=view.findViewById(R.id.chipprice);
        chipcat.setText(setCat());
        chiprice.setText(setPrice());
        l1.setHasFixedSize(true);
        adapter=new Adapter_Search(this.getActivity(),APPLICATION_CLASS.searchresults);
        linearLayoutManager=new LinearLayoutManager(this.getActivity(),RecyclerView.VERTICAL,false);
        l1.setAdapter(adapter);
        l1.setLayoutManager(linearLayoutManager);

        sw=(SearchView) view.findViewById(R.id.sw);
        sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        chipcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogadd=new BottomSheetDialog(getContext());
                dialogadd.setContentView(R.layout.dialog_search_chip);
                dialogadd.setCanceledOnTouchOutside(true);
                head=dialogadd.findViewById(R.id.head);
                head.setText("SELECT CATEGORY");
                l2=dialogadd.findViewById(R.id.choose);
                RecyclerView.LayoutManager templ=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
                RecyclerView.Adapter tempadapt= new Adapter_Chips(getContext(),APPLICATION_CLASS.CATEGORIES);
                l2.setLayoutManager(templ);
                l2.setAdapter(tempadapt);
                dialogadd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        chipcat.setText(setCat());
                    }
                });
                dialogadd.show();
            }
        });

        chiprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogadd=new BottomSheetDialog(getContext());
                dialogadd.setContentView(R.layout.dialog_search_chip);
                dialogadd.setCanceledOnTouchOutside(true);
                head=dialogadd.findViewById(R.id.head);
                head.setText("SORT BY PRICE");
                l2=dialogadd.findViewById(R.id.choose);
                RecyclerView.LayoutManager templ=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
                RecyclerView.Adapter tempadapt= new Adapter_Chips(getContext(),APPLICATION_CLASS.PRICES);
                l2.setLayoutManager(templ);
                l2.setAdapter(tempadapt);
                dialogadd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        chiprice
                                .setText(setPrice());
                    }
                });
                dialogadd.show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_search, container, false);
        setHasOptionsMenu(true);

        return view;


    }

    private String setCat()
    {
        for(Class_Chips temp:APPLICATION_CLASS.CATEGORIES)
        {
            if(temp.getCurrent()==1)
            {
                return(temp.getItem());
            }
        }
        return ("");
    };

    private String setPrice()
    {
        for(Class_Chips temp:APPLICATION_CLASS.PRICES)
        {
            if(temp.getCurrent()==1)
            {
                return(temp.getItem());
            }
        }
        return ("");
    };


}
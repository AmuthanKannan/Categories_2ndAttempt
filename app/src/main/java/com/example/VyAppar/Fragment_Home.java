package com.example.VyAppar;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {

    public RecyclerView l1,l2,l3;
    public ImageView iwPromo,cart;
    RecyclerView.Adapter adapter1,adapter2,adapter3;
    RecyclerView.LayoutManager layoutManager2,layoutManager3,layoutManager1;
    View view;
    TextView tvAddress;
    BottomNavigationView bnw;
    BottomSheetDialog dialogadd;

    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        iwPromo=view.findViewById(R.id.iwPromo);
        iwPromo.setImageResource(R.drawable.banner);

        l1=view.findViewById(R.id.lw1);
        l2=view.findViewById(R.id.lw2);
        l3=view.findViewById(R.id.lw3);
        dialogadd=new BottomSheetDialog(getContext());
        l1.setHasFixedSize(true);
        l2.setHasFixedSize(true);
        l3.setHasFixedSize(true);
        adapter1=new Adapter_Home_Top(this.getActivity(),APPLICATION_CLASS.top);
        adapter2=new Adapter_Home_Bottom(this.getActivity(),APPLICATION_CLASS.bottom);
        adapter3=new Adapter_Home_Bottom(this.getActivity(),APPLICATION_CLASS.bottom);
        layoutManager1=new GridLayoutManager(this.getActivity(),2,RecyclerView.HORIZONTAL,false);
        layoutManager2=new LinearLayoutManager(this.getActivity(),RecyclerView.HORIZONTAL,false);
        layoutManager3=new LinearLayoutManager(this.getActivity(),RecyclerView.HORIZONTAL,false);
        l1.setAdapter(adapter1);
        l1.setLayoutManager(layoutManager1);
        l2.setAdapter(adapter2);
        l2.setLayoutManager(layoutManager2);
        l3.setAdapter(adapter3);
        l3.setLayoutManager(layoutManager3);

        dialogadd.setContentView(R.layout.dialog_address);
        setupaddress();
        dialogadd.setCanceledOnTouchOutside(true);

        tvAddress=view.findViewById(R.id.addresshome);
        tvAddress.setText(setaddress());
        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogadd.show();
            }
        });

        dialogadd.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                tvAddress.setText(setaddress());
            }
        });
        cart=view.findViewById(R.id.carthome);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.main_frame,new Fragment_Cart()).commit();
                bnw=getActivity().findViewById(R.id.bottomnw);
                bnw.setSelectedItemId(R.id.cartbottom);
            }
        });

    }

    private void setupaddress() {
        RecyclerView l= dialogadd.findViewById(R.id.chooseaddress);
        final Adapter_Address adapter=new Adapter_Address(getContext(),APPLICATION_CLASS.ADDRESSES);
        LinearLayoutManager lm=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        l.setAdapter(adapter);
        l.setLayoutManager(lm);
        FloatingActionButton btn= dialogadd.findViewById(R.id.btnaddaddress);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final androidx.appcompat.app.AlertDialog.Builder dialoguebuilder= new AlertDialog.Builder(getContext());
                dialoguebuilder.setTitle("Add Address");
                final EditText tempadr=new EditText(getContext());
                tempadr.setText("");
                dialoguebuilder.setView(tempadr);
                dialoguebuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        APPLICATION_CLASS.ADDRESSES.add(new Class_Address(tempadr.getText().toString(),0));
                        adapter.notifyDataSetChanged();
                    }

                });
                dialoguebuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialoguebuilder.show();

            }
        });



    }

    private String setaddress()
    {
        for(Class_Address temp:APPLICATION_CLASS.ADDRESSES)
        {
            if(temp.getCurrent()==1)
            {
                return(temp.getAddress());
            }
        }
        return ("");
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        return view;
    }

}
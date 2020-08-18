package com.example.VyAppar;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class Adapter_Address extends RecyclerView.Adapter<Adapter_Address.newViewHolder>
    {

        private ArrayList<Class_Address> address;
        int width;
        Context context;
        public TextView addrwhole;

        sendonItemclickaddr activity;

        public interface sendonItemclickaddr{
            void sendonclickaddr(int i);
        }

        public Adapter_Address(Context context, ArrayList<Class_Address> list){
            address=list;
            //activity=(sendonItemclickaddr) context;
            this.context=context;
        }

        public class newViewHolder extends RecyclerView.ViewHolder {
            public TextView addr;
            public RadioButton btn;
            public ImageButton edit;

            public newViewHolder(@NonNull View itemView) {
                super(itemView);

                addr=itemView.findViewById(R.id.addressholder);
                addr.setAllCaps(true);
                btn=itemView.findViewById(R.id.rbtn);
                edit=itemView.findViewById(R.id.edit);
                //WindowManager.LayoutParams layoutParams=new WindowManager.LayoutParams();
                //layoutParams.width=(int)width/4;
                //itemView.setLayoutParams(layoutParams);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       // activity.sendonclickaddr(address.indexOf(view.getTag()));
                    }
                });

            }

        }


        @NonNull
        @Override
        public Adapter_Address.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_address,parent,false);
            //width=parent.getContext().getResources().getDisplayMetrics().widthPixels;
            return new newViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull final Adapter_Address.newViewHolder holder, final int position) {

            holder.itemView.setTag(address.get(position));
            holder.addr.setText(address.get(position).getAddress());

            if (address.get(position).getCurrent()==1) {
                holder.btn.setChecked(true);
                holder.addr.setTextColor(context.getResources().getColor(R.color.lightpurple));
            }

            else
            {holder.btn.setChecked(false);
                holder.addr.setTextColor(context.getResources().getColor(android.R.color.tab_indicator_text));}


            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int i=0;i<address.size();i++)
                    {
                        address.get(i).setCurrent(0);

                    }
                    address.get(position).setCurrent(1);
                    notifyDataSetChanged();
                }
            });
            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder dialoguebuilder= new AlertDialog.Builder(context);
                    dialoguebuilder.setTitle("Edit Address");
                    final EditText tempadr=new EditText(context);
                    tempadr.setText(address.get(position).getAddress());
                    dialoguebuilder.setView(tempadr);
                    dialoguebuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            address.get(position).setAddress(tempadr.getText().toString());
                            notifyDataSetChanged();
                        }

                    });
                    dialoguebuilder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            address.remove(position);
                            notifyDataSetChanged();

                        }
                    });
                    dialoguebuilder.show();


                }
            });
        }

        @Override
        public int getItemCount() {
            return address.size();
        }
    }



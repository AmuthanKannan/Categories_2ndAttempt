package com.example.VyAppar;

import android.app.Application;

import java.util.ArrayList;

public class APPLICATION_CLASS extends Application {
    public static ArrayList<Class_Cart> cart;
    public static ArrayList<Class_Home_Category> top,bottom;
    public static ArrayList<Class_Search_Categories> searchresults;
    public static String TOTAL_PRICE, TOTAL_QUANTITY,ADDRESS,NAME;
    public static ArrayList<Class_Address> ADDRESSES;


    @Override
    public void onCreate() {
        super.onCreate();

        cart=new ArrayList<Class_Cart>();
        top=new ArrayList<Class_Home_Category>();
        bottom=new ArrayList<Class_Home_Category>();
        searchresults=new ArrayList<Class_Search_Categories>();
        ADDRESSES=new ArrayList<Class_Address>();

        // HOME PAGE DATA
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        top.add(new Class_Home_Category("Food", R.drawable.foodplaceholder));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));
        bottom.add(new Class_Home_Category("Mallu Joint", R.drawable.piza));

        //SEARCH RESULTS DATA
        searchresults.add(new Class_Search_Categories("Malayalam Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Thiru Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Amuthan Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Kanni Babu Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Bob dylan Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Malayalam Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Chinese Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));
        searchresults.add(new Class_Search_Categories("Yo mamas Foods","Tasty homemade Malayalam","Alandur","4/5", R.drawable.picklerick));

        //CART DATA

        //ADDRESSES
        ADDRESSES.add(new Class_Address("501 regalia adyar",1));
        ADDRESSES.add(new Class_Address("265 Cauvery",0));
        ADDRESSES.add(new Class_Address("269 Saras",0));

    }
}

package com.example.VyAppar;

import android.app.Application;

import java.util.ArrayList;

public class APPLICATION_CLASS extends Application {
    public static ArrayList<Class_Cart> cart;
    public static ArrayList<Class_Home_Category> top,bottom;
    public static ArrayList<Class_Search_Categories> searchresults;
    public static String TOTAL_PRICE, TOTAL_QUANTITY,ADDRESS,NAME,SEARCHCAT,SEARCHPRICE;
    public static ArrayList<Class_Chips> CATEGORIES,PRICES;
    public static ArrayList<Class_Address> ADDRESSES;


    @Override
    public void onCreate() {
        super.onCreate();

        cart=new ArrayList<Class_Cart>();
        top=new ArrayList<Class_Home_Category>();
        bottom=new ArrayList<Class_Home_Category>();
        searchresults=new ArrayList<Class_Search_Categories>();
        ADDRESSES=new ArrayList<Class_Address>();
        CATEGORIES=new ArrayList<Class_Chips>();
        PRICES=new ArrayList<Class_Chips>();
        SEARCHCAT="";
        SEARCHPRICE="";

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
        ADDRESSES.add(new Class_Address("501 Regalia Adyar",1));

        //CATEGORIES
        CATEGORIES.add(new Class_Chips("FOOD",1));
        CATEGORIES.add(new Class_Chips("FASHION",0));
        CATEGORIES.add(new Class_Chips("TUITION",0));
        CATEGORIES.add(new Class_Chips("GROCERY",0));
        CATEGORIES.add(new Class_Chips("FREELANCE",0));

        //PRICES
        PRICES.add(new Class_Chips("HIGH TO LOW",0));
        PRICES.add(new Class_Chips("LOW TO HIGH",1));


    }
}

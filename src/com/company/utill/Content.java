package com.company.utill;

import java.util.ArrayList;

public class Content {
    ArrayList<Items> itemsList = new ArrayList<>();

    public void addValues(String name, String id, int quantity){
        Items items = new Items(name,id,quantity);
        itemsList.add(items);
    }

    public ArrayList getList() {
        return itemsList;
    }


}

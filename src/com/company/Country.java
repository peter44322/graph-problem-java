package com.company;

public class Country implements Comparable<Country> {
    int id;
    boolean hasClub;

    Country(int id,boolean hasClub){
        this.id = id;
        this.hasClub = hasClub;
    }

    public void setHasClub(boolean hasClub) {
        this.hasClub = hasClub;
    }

    @Override
    public int compareTo(Country o) {
        if (o.id == this.id){
            return 0;
        }else if (id > o.id){
            return 1;
        }else {
            return -1;
        }
    }
}

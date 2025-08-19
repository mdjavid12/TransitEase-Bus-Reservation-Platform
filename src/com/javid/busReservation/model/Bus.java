package com.javid.busReservation.model;

public class Bus {
    private final int BusNo;
    private boolean Ac;
    private int Capacity;

    Bus(int BusNo, boolean Ac, int Capacity){
        this.BusNo = BusNo;
        this.Ac=Ac;
        this.Capacity = Capacity;
    }
}




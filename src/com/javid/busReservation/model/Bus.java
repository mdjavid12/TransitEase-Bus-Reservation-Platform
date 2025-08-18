package com.javid.busReservation.model;

public class Bus {
    private int BusNo;
    private boolean Ac;
    private int Capacity;

    Bus(int BusNo, boolean Ac, int Capacity){
        this.BusNo = BusNo;
        this.Ac=Ac;
        this.Capacity = Capacity;
    }

    public int getBusNo(){
        return BusNo;
    }

    public boolean isAc(){
        return Ac;
    }
    public int getCapacity(){
        return Capacity;
    }
    public void setAc(boolean ac){
        Ac=ac;
    }
    public void setCapacity(int seat){
        Capacity =seat;
    }

    public void DisplayBusInfo(){
        System.out.println("Busno:"+ BusNo +" Ac:"+Ac+" TotalCapacity:"+ Capacity);
    }

}




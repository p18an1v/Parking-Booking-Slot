package com.example.model;

public class ParkingSlot {
    private int slotNumber;
    private boolean available;

    public ParkingSlot(int slotNumber, boolean available) {
        this.slotNumber = slotNumber;
        this.available = available;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

package com.example.service;

import com.example.model.ParkingSlot;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface ParkingService {
    List<ParkingSlot> getAllSlots();
    String bookSlot(int slotNumber);

    String unbookSlot(int slotNumber);

    boolean isSlotBooked(int slotNumber);





}


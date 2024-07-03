package com.example.service.impl;

import com.example.model.ParkingSlot;
import com.example.service.ParkingService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingServiceImpl implements ParkingService {
    private List<ParkingSlot> slots;
    private Map<Integer, LocalDateTime> checkoutTimes;

    public ParkingServiceImpl() {
        // Initialize parking slots (assuming 50 slots)
        slots = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            slots.add(new ParkingSlot(i, true)); // All slots initially available
        }
        checkoutTimes = new HashMap<>();
    }

    @Override
    public List<ParkingSlot> getAllSlots() {
        return slots;
    }

    @Override
    public String bookSlot(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= slots.size()) {
            ParkingSlot slot = slots.get(slotNumber - 1);
            if (slot.isAvailable()) {
                slot.setAvailable(false);
                return "Slot " + slotNumber + " booked successfully.";
            } else {
                return "Sorry Slot " + slotNumber + " is not available.";
            }
        } else {
            return "Invalid slot number.";
        }
    }

    @Override
    public String unbookSlot(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= slots.size()) {
            ParkingSlot slot = slots.get(slotNumber - 1);
            if (!slot.isAvailable()) {
                slot.setAvailable(true);
                checkoutTimes.remove(slotNumber);
                return "Slot " + slotNumber + " unbooked successfully.";
            } else {
                return "Sorry Slot " + slotNumber + " is already available.";
            }
        } else {
            return "Invalid slot number.";
        }
    }

    @Override
    public boolean isSlotBooked(int slotNumber) {
        return checkoutTimes.containsKey(slotNumber);
    }

    public LocalDateTime getCheckoutTime(int slotNumber) {
        return checkoutTimes.get(slotNumber);
    }
}

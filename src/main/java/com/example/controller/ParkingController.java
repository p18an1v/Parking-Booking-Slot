package com.example.controller;

import com.example.service.ParkingService;
import com.example.service.impl.ParkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @GetMapping("/slots")
    public String getAllSlots(Model model) {
        System.out.println("request got");
        model.addAttribute("slots", parkingService.getAllSlots());
        return "index"; // Thymeleaf template name (index.html)
    }

    @PostMapping("/book")
    public String bookSlot(@RequestParam int slotNumber, Model model) {
        System.out.println("responsing to the request");
        String bookingResult = parkingService.bookSlot(slotNumber);
        if (bookingResult.startsWith("Slot")) {
            return "redirect:/parking/booking_success"; // Redirect to booking success page
        } else {
            model.addAttribute("error", bookingResult);
            return "redirect:/parking/booking_error"; // Redirect to booking error page with error message
        }
    }

    @RequestMapping("/unbook")
    public String unbookSlot( int slotNumber) {
        System.out.println("Request unbook");
        String unbookResult = parkingService.unbookSlot(slotNumber);
        if (unbookResult.startsWith("Slot")) {
            return "redirect:/parking/slots"; // Redirect to slots page after unbooking
        } else {
            return "redirect:/parking/booking_error"; // Redirect to booking error page with error message
        }
    }


    @GetMapping("/booking_success")
    public String bookingSuccess() {
        System.out.println("booking request");
        return "booking_success"; // Thymeleaf template name
    }

    @GetMapping("/booking_error")
    public String bookingError() {
        System.out.println("booking error request");
        return "booking_error"; // Thymeleaf template name
    }


}

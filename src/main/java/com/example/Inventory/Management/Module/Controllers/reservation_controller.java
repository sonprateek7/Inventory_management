package com.example.Inventory.Management.Module.Controllers;


import com.example.Inventory.Management.Module.Models.ItemReservationModel;
import com.example.Inventory.Management.Module.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class reservation_controller {


    @Autowired
    ReservationService reservationService;

    @GetMapping("reservations")
    public List<ItemReservationModel> getAllReservations(){
       return reservationService.getReservation();
    }

    @GetMapping("reservations/{reservation_id}")
    public Optional<ItemReservationModel> getReservationById(@PathVariable int reservation_id){
        return reservationService.getReservationById(reservation_id);
    }

    @PostMapping("reservations")
    public String addReservation(@RequestBody ItemReservationModel itemReservationModel){
       int response= reservationService.addReservation(itemReservationModel);

       if(response==1)
           return "Reservation added successfully";
       else if(response==-1)
           return "Item not found";
       return "Item quantity not sufficient";
    }

//    @PutMapping("reservations/{reservation_id}")
//    public ResponseEntity<Objects> updateReservation(@PathVariable int reservation_id, @RequestBody ItemReservationModel itemReservationModel){
//       int response= reservationService.updateReservation(itemReservationModel,reservation_id);
//       if(response==0)
//          return ResponseEntity.ok().build();
//       else if(response==-1)
//         return   ResponseEntity.notFound().build();
//       return ResponseEntity.badRequest().build();
//
//    }

    @DeleteMapping("reservations/{reservation_id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int reservation_id){
        int response=reservationService.deleteReservation(reservation_id);
        if(response==-1)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}

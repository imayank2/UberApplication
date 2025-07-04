package com.project.controllers;

import com.project.advices.ApiResponse;
import com.project.dto.*;
import com.project.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('RIDER', 'ADMIN')")
@Secured("ROLE_RIDER")
//@CrossOrigin(origins = "http://localhost:4200")

public class RiderController {
    private final RiderService riderService;

    @PostMapping("/requestRide")
    public ResponseEntity<ApiResponse<RideRequestDto>> requestRide(@RequestBody RideRequestDto rideRequestDto) {
        RideRequestDto requestedRide = riderService.requestRide(rideRequestDto);
        ApiResponse<RideRequestDto> response = new ApiResponse<>(true, "Ride requested successfully", requestedRide);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId){
        return  ResponseEntity.ok(riderService.cancelRide(rideId));
    }

    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDto> rateDriver(@RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(riderService.rateDriver(ratingDto.getRideId(), ratingDto.getRating()));
    }


    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDto> getMyProfile(){
        return ResponseEntity.ok(riderService.getMyProfile());
    }

    @GetMapping("/getMyRides")
    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                       @RequestParam(defaultValue = "10",required = false) Integer pageSize){
        PageRequest pageRequest=PageRequest.of(pageOffset,pageSize,
                Sort.by(Sort.Direction.DESC,"createdTime","id"));
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    }


}

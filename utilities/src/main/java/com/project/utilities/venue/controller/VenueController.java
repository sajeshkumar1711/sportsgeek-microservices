package com.project.utilities.venue.controller;

import com.project.sportsgeeksystemresponse.response.Result;
import com.project.utilities.venue.exception.VenueException;
import com.project.utilities.venue.model.Venue;
import com.project.utilities.venue.service.VenueService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping(path = "/venues",produces = MediaType.APPLICATION_JSON_VALUE)
public class VenueController {
    @Autowired
    VenueService venueService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = Venue.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = VenueException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<List<Venue>>> getAllVenue() {
        Result<List<Venue>> VenueList = venueService.findAllVenue();
        return new ResponseEntity<>(VenueList, HttpStatus.valueOf(VenueList.getCode()));
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = Venue.class),
                    @ApiResponse(code = 404, message = "Bad request", response = VenueException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = VenueException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<Venue>> getVenueById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id) throws Exception {
        Result<Venue> VenueList = venueService.findVenueById(id);
        return new ResponseEntity<>(VenueList, HttpStatus.valueOf(VenueList.getCode()));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 201, message = "success", response = Venue.class),
                    @ApiResponse(code = 400, message = "Bad request", response = VenueException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = VenueException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<Venue>> addVenue(@RequestBody(required = true) @Valid Venue venue) throws Exception {
        Result<Venue> VenueResult = venueService.addVenue(venue);
        return new ResponseEntity(VenueResult,HttpStatus.valueOf(VenueResult.getCode()));
    }
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 201, message = "success", response = Venue.class),
                    @ApiResponse(code = 400, message = "Bad request", response = VenueException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = VenueException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<Venue>> updateVenue(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id,@RequestBody(required = true) @Valid Venue Venue) throws Exception {
        Result<Venue> VenueResult = venueService.updateVenue(id,Venue);
        return new ResponseEntity(VenueResult,HttpStatus.valueOf(VenueResult.getCode()));
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "success", response = Venue.class),
                    @ApiResponse(code = 404, message = "Bad request", response = VenueException.class),
                    @ApiResponse(code = 500, message = "Unfortunately there is technical error while processing your request", response = VenueException.class),
                    @ApiResponse(code = 403 , message = "Forbidden!! Access is Denied!")
            }
    )
    public ResponseEntity<Result<Venue>> deleteVenueById(@PathVariable @Valid @Pattern(regexp = "[0-9]*") int id) throws Exception {
        Result<Integer> integerResult =  venueService.deleteVenue(id);
        return new ResponseEntity(integerResult,HttpStatus.valueOf(integerResult.getCode()));
    }
}

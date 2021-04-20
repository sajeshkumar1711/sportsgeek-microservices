package com.project.utilities.venue.repository;


import com.project.utilities.venue.model.Venue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "venueRepo")
public interface VenueRepository {
    public List<Venue> findAllVenue();
    public List<Venue> findVenueById(int id) throws Exception;
    public int addVenue(Venue venue) throws Exception;
    public boolean updateVenue(int id, Venue venue) throws Exception;
    public int deleteVenue(int id) throws Exception;
}

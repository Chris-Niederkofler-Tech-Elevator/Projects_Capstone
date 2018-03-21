package com.techelevator.npgeek.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.dao.ParkDao;

@Component
public class JDBCParkDao implements ParkDao {
	
	
	private JdbcTemplate jdbcTemplate;

	    public JDBCParkDao(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    @Override
	    public List<Park> getAllParks() {
	        List<Park> listOfParks = new ArrayList<>();

	        String sqlAvailableParks = "SELECT * FROM park "
	                + "ORDER BY parkname";

	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAvailableParks);

	        while(results.next()) {
	            Park newPark = mapRowToPark(results);
	            listOfParks.add(newPark);
	        }

	        return listOfParks;
	    }

	    @Override
	    public Park getParkByCode(String parkCode) {
	        Park selectedPark = new Park();
	        String sqlSelectedPark = "SELECT * FROM park "
	                + "WHERE parkcode =  ? ";
	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectedPark, parkCode);
	        if(results.next()) {
	            selectedPark = mapRowToPark(results);
	        }

	        return selectedPark;

	    }

	    private Park mapRowToPark(SqlRowSet results) {
	        Park park = new Park();
	       
	        park.setParkCode(results.getString("parkcode"));
	        park.setParkName(results.getString("parkname"));
	        park.setState(results.getString("state"));
	        park.setAcreage(results.getInt("acreage"));
	        park.setElevation(results.getInt("elevationinfeet"));
	        park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
	        park.setDescription(results.getString("parkdescription"));
	        park.setClimate(results.getString("climate"));
	        park.setMilesOfTrail(results.getFloat("milesoftrail"));
	        park.setNumCampsites(results.getInt("numberofcampsites"));
	        park.setYearFounded(results.getInt("yearfounded"));
	        park.setQuote(results.getString("inspirationalquote"));
	        park.setQuoteSource(results.getString("inspirationalquotesource"));
	        park.setEntryFee(results.getInt("entryfee"));
	        park.setNumOfSpecies(results.getInt("numberofanimalspecies"));

	        return park;
	        
	    }
}

	



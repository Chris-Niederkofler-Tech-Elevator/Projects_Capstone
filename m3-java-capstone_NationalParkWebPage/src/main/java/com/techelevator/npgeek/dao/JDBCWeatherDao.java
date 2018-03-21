package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.model.Weather;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDao implements WeatherDao	{
	private JdbcTemplate jdbcTemplate;
	
		public JDBCWeatherDao(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			
		}
					
		@Override
		public List<Weather> getFiveDay(String parkCode){
			List<Weather> fiveDayForecast = new ArrayList<>();
			String sqlFiveDayForecast = "SELECT * FROM weather "+ "WHERE parkcode = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFiveDayForecast, parkCode);
			while(results.next()) {
				fiveDayForecast.add(mapRowToWeather(results));
			}
			return fiveDayForecast;
		}
		
		private Weather mapRowToWeather(SqlRowSet results) {
			Weather weather;
			weather = new Weather();
			weather.setDay(results.getInt("fivedayforecastvalue"));
			weather.setParkCode(results.getString("parkcode"));
			weather.setForecast(results.getString("forecast"));
			weather.setLowTemp(results.getInt("low"));
			weather.setHighTemp(results.getInt("high"));
			
			return weather;
			
		}
		public List<Weather> getCelciusConversion(List<Weather> weather){
			
			for(Weather weatherObject: weather) {
				weatherObject.setLowTemp((int)((weatherObject.getLowTemp() - 32) * (5/9d)));
				weatherObject.setHighTemp((int)((weatherObject.getHighTemp() - 32) * (5/9d)));
				
			}
			return weather;
		}
		public List<Weather> getFahrenheitConversion(List<Weather> weather){
			for(Weather weatherObject: weather) {
				weatherObject.setLowTemp((int)((weatherObject.getLowTemp() * (9/5d)) + 32));
				weatherObject.setHighTemp((int)((weatherObject.getHighTemp() * (9/5d)) + 32));
		}
			return weather;
		}
}

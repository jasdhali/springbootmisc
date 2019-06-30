package appsuite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appsuite.data.repository.location.CountryRepository;
import appsuite.domain.Country;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	private CountryRepository countryRpository;

	public CountryController(CountryRepository countryRpository) {
		super();
		this.countryRpository = countryRpository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Country> getCountries() {
		List<Country> countries = countryRpository.findAll();
		return countries;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, name = "GetCountryByCode")
	public ResponseEntity<Country> getBookByCode(@PathVariable String code) {
		Country country = null;

		country = countryRpository.findOne(code);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(country, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{region}/{continet}", produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET, name = "getCountryByRegionAndContinet")
	public List<Country> getCountryByRegionAndContinet(@PathVariable(name = "region") String region,
			@PathVariable(name = "continet") String continet) {
		List<Country> country = countryRpository.findByRegion(region);
		return country;
	}

	@RequestMapping(value = "/search/{region}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, name = "getCountryByRegion")
	public List<Country> getCountryByRegion(@PathVariable(name = "region") String region) {
		List<Country> country = countryRpository.findByRegionIgnoreCase( region );
		return country;
	}
	@RequestMapping(value = "/searchorderbyarea/{region}", 
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET, name = "FindCountry By RegionIgnore Case And Order By Surface area")
	public List<Country> getCountryByRegionOrderByArea(@PathVariable(name = "region") String region) {
		List<Country> country = countryRpository.findByRegionOrderBySurfaceArea( region );
		return country;
	}
	
	
	@RequestMapping(value = "/searByAreaRange/{minArea}/{maxArea}", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET, name = "getCountryByRegionAndContinet")
	public List<Country> findByAreaRange(@PathVariable(name = "minArea") String minArea,
			@PathVariable(name = "maxArea") String maxArea) {
		List<Country> country = countryRpository.findByAreaRange(4000.2f, 10000.2f);
		return country;
	}
	
}

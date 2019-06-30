package appsuite.data.repository.location;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import appsuite.domain.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
	List<Country> findByRegion(String region);
	List<Country> findByRegionIgnoreCase(String region);
	List<Country> findByRegionOrderBySurfaceArea(String region);
	List<Country> findByRegionAndContinent(String region,String continet);
	
	@Query(value = "select b From Country b where b.surfaceArea between ?1 and ?2")
	List<Country> findByAreaRange(Float minArea,Float maxArea,Sort sort);
	
	@Query(value = "select b From Country b where b.surfaceArea between ?1 and ?2")
	List<Country> findByAreaRange(Float minArea,Float maxArea);
	
	@Query("FROM Country WHERE UPPER(headOfState) LIKE %?#{[0].toUpperCase()}%")
    List<Country> findByHeadNamePattern(String headName);	
}

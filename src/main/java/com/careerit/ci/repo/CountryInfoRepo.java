package com.careerit.ci.repo;

import com.careerit.ci.domain.CountryInfo;
import com.careerit.ci.dto.RegionStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryInfoRepo extends JpaRepository<CountryInfo, Long> {

    List<CountryInfo> findByCountryNameContainingIgnoreCase(String str);

    @Query("select distinct region from CountryInfo")
    List<String> findDistinctRegions();

    @Query("select c from CountryInfo c order by population desc limit 5")
    List<CountryInfo> findTop5PopulatedCountries();

    @Query("select new com.careerit.ci.dto.RegionStatsDto(region,sum(population)) from CountryInfo group by region order by sum(population) desc")
    List<RegionStatsDto> findRegionStats();
}

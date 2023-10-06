package com.careerit.ci.repo;

import com.careerit.ci.domain.CountryInfo;
import com.careerit.ci.dto.RegionStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryInfoRepo extends JpaRepository<CountryInfo, Long> {

    List<CountryInfo> findByCountryNameContainingIgnoreCase(String str);

    @Query("select distinct region from CountryInfo")
    List<String> findDistinctRegions();

    @Query("select c from CountryInfo c order by population desc limit 5")
    List<CountryInfo> findTop5PopulatedCountries();

    @Query("select new com.careerit.ci.dto.RegionStatsDto(region,sum(population),sum(area),max(population),min(population)) from CountryInfo group by region order by sum(population) desc")
    List<RegionStatsDto> findRegionStats();

    @Query("select new com.careerit.ci.dto.RegionStatsDto(region,sum(population),sum(area),max(population),min(population)) from CountryInfo where region=:region group by region order by sum(population) desc")
    List<RegionStatsDto> findRegionStats(@Param("region") String region);
}

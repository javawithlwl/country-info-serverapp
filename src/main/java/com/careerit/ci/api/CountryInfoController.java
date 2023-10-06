package com.careerit.ci.api;

import com.careerit.ci.dto.CountryInfoDto;
import com.careerit.ci.dto.RegionStatsDto;
import com.careerit.ci.service.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryInfoController {

    @Autowired
    private CountryInfoService countryInfoService;

    @GetMapping("/load")
    public ResponseEntity<List<CountryInfoDto>> loadCountryInfo() {
        return ResponseEntity.ok(countryInfoService.loadCountryInfo());
    }

    @GetMapping("/info")
    public ResponseEntity<List<CountryInfoDto>> getCountryInfo() {
        return ResponseEntity.ok(countryInfoService.getCountryInfoDetails());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CountryInfoDto>> search(@RequestParam("str")String str) {
        return ResponseEntity.ok(countryInfoService.search(str));
    }
    @GetMapping("/regions")
    public ResponseEntity<List<String>> getRegions(){
        return ResponseEntity.ok(countryInfoService.getRegions());
    }

    @GetMapping("/top5populated")
    public ResponseEntity<List<CountryInfoDto>> getTop5PopulatedCountries(){
        return ResponseEntity.ok(countryInfoService.getTop5PopulatedCountries());
    }
    @GetMapping("/regionstats")
    public ResponseEntity<List<RegionStatsDto>> getRegionStats(){
        return ResponseEntity.ok(countryInfoService.getRegionStats());
    }

}

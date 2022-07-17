package dev.shuktika.pensionerdetail.controller;

import dev.shuktika.pensionerdetail.entity.Pensioner;
import dev.shuktika.pensionerdetail.service.PensionerSevice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PensionerController {
    private final PensionerSevice pensionerSevice;

    @PostMapping
    public Pensioner savePensioner(@Valid @RequestBody Pensioner pensioner) {
        log.info("Inside savePensioner of PensionerController");
        return pensionerSevice.savePensioner(pensioner);
    }

    @GetMapping("/{aadharNumber}")
    public Pensioner fetchPersonByAadharNumber(@PathVariable("aadharNumber") Long aadharNumber) {
        log.info("Inside fetchPersonByAadharNumber of PensionerController");
        return pensionerSevice.fetchPersonByAadharNumber(aadharNumber);
    }
}

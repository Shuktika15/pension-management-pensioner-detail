package dev.shuktika.pensionerdetail.controller;

import dev.shuktika.pensionerdetail.entity.Pensioner;
import dev.shuktika.pensionerdetail.service.PensionerSevice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pensionerDetail")
@Slf4j
@RequiredArgsConstructor
public class PensionerController {
    private final PensionerSevice pensionerSevice;

    @PostMapping("/pensioner")
    public Pensioner savePensioner(@Valid @RequestBody Pensioner pensioner) {
        log.info("Inside savePensioner of PensionerController");
        return pensionerSevice.savePensioner(pensioner);
    }

    @GetMapping("/pensionDetailsByAadhar")
    public Pensioner fetchPersonByAadharNumber(@RequestParam("aadharNumber") Long aadharNumber) {
        Pensioner pensioner = pensionerSevice.fetchPersonByAadharNumber(aadharNumber);
        log.info("Get Request for '/pensionDetailsByAadhar/{}' response: {}", aadharNumber, pensioner.toString());
        return pensioner;
    }
}

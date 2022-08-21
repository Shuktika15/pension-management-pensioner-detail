package dev.shuktika.pensionerdetail.service;

import dev.shuktika.pensionerdetail.entity.Pensioner;
import dev.shuktika.pensionerdetail.exception.PensionerNotFoundException;
import dev.shuktika.pensionerdetail.repository.PensionerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PensionerService {
    private final PensionerRepository pensionerRepository;

    public Pensioner savePensioner(Pensioner pensioner) {
        var p = pensionerRepository.save(pensioner);
        log.info("Pensioner saved : {}", p);
        return p;
    }

    public Pensioner fetchPensionerByAadharNumber(Long aadharNumber) {
        return pensionerRepository
                .findByAadharNumber(aadharNumber)
                .orElseThrow(() -> {
                    var errMsg = String.format("Pensioner with Aadhar Number %s not found", aadharNumber);
                    log.error(errMsg);
                    return new PensionerNotFoundException(errMsg);
                });
    }
}

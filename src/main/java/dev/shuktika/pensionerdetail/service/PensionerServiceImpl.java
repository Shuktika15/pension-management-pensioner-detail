package dev.shuktika.pensionerdetail.service;

import dev.shuktika.pensionerdetail.entity.Pensioner;
import dev.shuktika.pensionerdetail.repository.PensionerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PensionerServiceImpl implements PensionerSevice {
    private final PensionerRepository pensionerRepository;
    @Override
    public Pensioner savePensioner(Pensioner pensioner) {
        return pensionerRepository.save(pensioner);
    }

    @Override
    public Pensioner fetchPersonByAadharNumber(Long aadharNumber) {
        return pensionerRepository.findByAadharNumber(aadharNumber).get();
    }
}

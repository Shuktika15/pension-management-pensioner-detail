package dev.shuktika.pensionerdetail.service;

import dev.shuktika.pensionerdetail.entity.Pensioner;

public interface PensionerSevice {
    Pensioner savePensioner(Pensioner pensioner);

    Pensioner fetchPersonByAadharNumber(Long aadharNumber);
}

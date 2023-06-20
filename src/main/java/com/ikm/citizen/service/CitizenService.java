package com.ikm.citizen.service;

import com.ikm.citizen.dto.CitizenDto;
import com.ikm.citizen.entity.Citizen;
import com.ikm.citizen.repository.CitizenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CitizenService {

    @Autowired
    ModelMapper modelMapper;

    private final CitizenRepository repository;

    String result = null;

    public String save(CitizenDto citizenDto) throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = dateFormatter.parse(dateFormatter.format(new Date()));

        Citizen citizen = modelMapper.map(citizenDto, Citizen.class);
        citizen.setCitizenDob(citizenDto.getCitizenDob());
        result = validateCitizen(citizenDto, currentDate);
        if (result.equals("Validated")) {
            citizen = repository.save(citizen);
            if (citizen != null)
                result = "Saved Successfully";
        }
        return result;
    }

    private String validateCitizen(CitizenDto citizenDto, Date currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        if (citizenDto.getCitizenName() == null || citizenDto.getCitizenName().equals(" "))
            return "Name is empty. Please enter your name";

        if (citizenDto.getCitizenAddress() == null || citizenDto.getCitizenAddress().equals(" "))
            return "Address is Empty. Please enter your addess";

        if (sdf.format(citizenDto.getCitizenDob()).equals(sdf.format(currentDate)))
            return "Date of Birth should not be current date";

        return "Validated";
    }

    public List<CitizenDto> get() {

        List<Citizen> citizen = repository.findAll();
        return citizen.stream().map(ct -> modelMapper.map(ct, CitizenDto.class)).collect(Collectors.toList());

    }
}

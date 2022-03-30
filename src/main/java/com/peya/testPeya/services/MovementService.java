package com.peya.testPeya.services;

import com.peya.testPeya.Repository.MovementRepository;
import com.peya.testPeya.domain.MovementDto;
import org.springframework.stereotype.Component;

@Component
public class MovementService implements MovementRepository {

    @Override
    public MovementDto insert(MovementDto movementDto) {
        return movementDto;
    }
}

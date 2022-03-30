package com.peya.testPeya.Repository;

import com.peya.testPeya.domain.MovementDto;
import org.springframework.stereotype.Component;

@Component
public interface MovementRepository {
    MovementDto insert(MovementDto movementDto);
}

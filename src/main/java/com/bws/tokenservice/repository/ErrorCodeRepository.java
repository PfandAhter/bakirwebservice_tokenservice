package com.bws.tokenservice.repository;

import com.bws.tokenservice.model.entity.ErrorCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCodes,Long> {
    ErrorCodes findErrorByError(String errorCode);
}

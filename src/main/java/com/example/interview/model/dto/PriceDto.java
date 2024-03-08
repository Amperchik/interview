package com.example.interview.model.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Dto
 */
@Builder
@Data
public class PriceDto {

    private String productCode;

    private String number;

    private String depart;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


    private String value;

}

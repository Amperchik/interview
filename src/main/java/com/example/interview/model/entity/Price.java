package com.example.interview.model.entity;

import com.example.interview.model.dto.PriceDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

/**
 * Витрина
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Entity
@Table(name = "price")
public class Price  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Embedded
    private PriceMetaData metaData;


    @Column(name = "price")
    private int price;

    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    public static Price priceFromDto(PriceDto src){
        return Price.builder()
                .beginDate(src.getStartDate())
                .endDate(src.getEndDate())
                .price(Integer.parseInt(src.getValue()))
                .metaData(PriceMetaData.builder()
                        .depart(Integer.parseInt(src.getDepart()))
                        .number(Integer.parseInt(src.getNumber()))
                        .productCode(src.getProductCode())
                        .build())
                .build();
    }
}

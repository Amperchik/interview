package com.example.interview.service;

import com.example.interview.model.dto.PriceDto;
import com.example.interview.model.entity.Price;
import com.example.interview.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Работает с информацией о ценах
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PriceService {


    private final PriceRepository repository;


    /**
     * Обновление цен
     */
    public void update(List<PriceDto> newPriceList) {
        var newPrice=newPriceList.stream().map(Price::priceFromDto).collect(Collectors.toList());
        var oldPrice=repository.findAllByMetaDataProductCodeIn(newPriceList.stream()
                .map(PriceDto::getProductCode)
                .collect(Collectors.toSet()));
        repository.saveAll(mergePriceList(newPrice,oldPrice));
    }

    /**
     * Загрузка цен в БД(что бы не вручную insert делать).
     */

    public void save(List<PriceDto> priceList) {
        repository.saveAll(priceList.stream().map(Price::priceFromDto).collect(Collectors.toList()));
    }

    /**
     * Целевой метод.Его правим.
     */
    private List<Price> mergePriceList(List<Price> newPrice, List<Price> oldPrice){
        var map=oldPrice.stream().collect(Collectors.groupingBy(
                Price::getMetaData,
                Collectors.mapping(Function.identity(), Collectors.toList())));
        return null;
    }
}

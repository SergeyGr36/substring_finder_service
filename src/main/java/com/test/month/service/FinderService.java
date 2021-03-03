package com.test.month.service;

import com.test.month.data.ValueDTO;

import java.util.List;

public interface FinderService {
    List<ValueDTO> findResult(String input);
    ValueDTO createNewPosition(String input);
    boolean deletePosition(ValueDTO dto);
    void updatePosition(ValueDTO dto);
}

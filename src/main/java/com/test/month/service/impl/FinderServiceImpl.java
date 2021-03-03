package com.test.month.service.impl;

import com.test.month.data.Month;
import com.test.month.data.ValueDTO;
import com.test.month.service.FinderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class FinderServiceImpl implements FinderService {
    private final List<ValueDTO> data;
    private ValueDTO dto;

    public FinderServiceImpl() {
        data = new ArrayList<>();
        fillInitialData();
    }

    public List<ValueDTO> findResult(String input) {
        return input == null ? data : data.stream()
                .filter(valueDTO -> valueDTO.getValue().toUpperCase().contains(input.toUpperCase()))
                .collect(Collectors.toList());
    }

    public ValueDTO createNewPosition(String input) {
        data.add(new ValueDTO((data.size() + 1), input));
        return data.get(data.size() - 1);
    }

    public boolean deletePosition(ValueDTO dto) {
        return data.remove(dto);
    }

    public void updatePosition(ValueDTO dto) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == dto.getId()) {
                data.get(i).setValue(dto.getValue());
            }
        }
    }

    private void fillInitialData() {
        int key;
        Month[] months = Month.values();
        for (int i = 0; i < months.length; i++) {
            key = i + 1;
            data.add(new ValueDTO(key, months[i].name()));
        }
    }
}

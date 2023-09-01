package com.maliha.main.service;

import com.maliha.main.model.House;
import com.maliha.main.model.Wizards;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HouseService {
    List<House> houseList = new ArrayList<>();
    @PostConstruct
    public void init() {
        houseList.add(new House("Griffindor",1));
        houseList.add(new House("Hufflepuff",2));
        houseList.add(new House("Ravenclaw",3));
        houseList.add(new House("Slytherin",4));
    }
    public List<House> getAllHouse() {
        return houseList;
    }
    public House findByPosition(Integer position) {
        for (House h : houseList) {
            if (Objects.equals(h.getPosition(), position))
                return h;
        }
        return null;
    }
}

package com.maliha.main.service;

import com.maliha.main.model.Wizards;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WizardsService {

    List<Wizards> wizardsList = new ArrayList<>();

    @PostConstruct
    public void init() {
        wizardsList.add(new Wizards(101, "Neville Longbottom", "Gryffindor"));
        wizardsList.add(new Wizards(102, "Newt Scamander", "Hufflepuff"));
        wizardsList.add(new Wizards(103, "Luna Lovegood", "Ravenclaw"));
        wizardsList.add(new Wizards(104, "Harry Potter", "Gryffindor"));
        wizardsList.add(new Wizards(105, "Voldemort", "Slytherin"));
    }

    public Wizards findById(Integer id) {
        for (Wizards w : wizardsList) {
            if (Objects.equals(w.getId(), id))
                return w;
        }
        return null;
    }

    public List<Wizards> getAllWizards() {
        return wizardsList;
    }

    public void addWizard(Wizards wizards) {

        wizardsList.add(wizards);
    }
    public void deleteWizard(int id){
        for(Wizards wz:wizardsList){
            if(wz.getId()==id){
                wizardsList.remove(wz);
            }
        }
    }
}

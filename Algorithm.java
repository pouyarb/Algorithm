package com.example.algorithm;

import com.example.algorithm.model.UnitsModel;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public List<UnitsModel> generateBestPlan(List<UnitsModel> selected) {

        List<UnitsModel> taken = new ArrayList<>();

        while (selected.size() != 0) {

            int conflict = selected.size();
            UnitsModel unit = selected.get(0);

            for (int i = 0; i < selected.size(); i++) {
                int conflictTmp = 0;
                for (int j = 0; j < selected.size(); j++) {
                    if (selected.get(i).getSection1() == selected.get(j).getSection1())
                        conflictTmp++;
                    if (selected.get(i).getSection1() == selected.get(j).getSection2())
                        conflictTmp++;
                    if (selected.get(i).getSection2() == selected.get(j).getSection1())
                        conflictTmp++;
                    if (selected.get(i).getSection2() == selected.get(j).getSection2())
                        conflictTmp++;
                }
                if (conflictTmp < conflict) {
                    unit = selected.get(i);
                    conflict = conflictTmp;
                }
                if (conflict == 0)
                    break;
            }
            taken.add(unit);
            int i = 0;
            while (i < selected.size()) {
                if (selected.get(i).getUnitName().equals(unit.getUnitName())) {
                    selected.remove(selected.get(i));
                    continue;
                } else if (unit.getSection1() == selected.get(i).getSection1() ||
                        unit.getSection1() == selected.get(i).getSection2() ||
                        unit.getSection2() == selected.get(i).getSection1() ||
                        unit.getSection2() == selected.get(i).getSection2()) {
                    selected.remove(selected.get(i));
                    continue;
                }
                i++;
            }
        }
        return taken;
    }
}

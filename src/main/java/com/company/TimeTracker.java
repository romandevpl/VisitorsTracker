package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTracker {

    private Map<Integer, Integer> visitorsMap;

    public void findVisitors(String input) {
        initializeVisitorsMap();
        extractVisitorTimes(input);
        List<Integer> result = findMaxValues(visitorsMap);
        System.out.println(findRange(result));
    }

    private void initializeVisitorsMap() {
        visitorsMap = new HashMap<>();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                visitorsMap.put(i * 100 + j, 0);
            }
        }
    }

    private void extractVisitorTimes(String input) {
        String[] output = input.split("\n");
        for (String line : output) {
            String[] times = line.split(",");
            addVisitorsForTimeRange(TimeConverter.convertToNumber(times[0]),
                    TimeConverter.convertToNumber(times[1]));
        }
    }


    private void addVisitorsForTimeRange(int begin, int end) {
        for (int i = begin; i < end + 1; i++) {
            if (i % 100 < 60) {
                visitorsMap.put(i, visitorsMap.get(i) + 1);
            }
        }
    }

    private List<Integer> findMaxValues(Map<Integer, Integer> map) {
        List<Integer> result = new ArrayList<>();
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
                result = new ArrayList<>();
                result.add(maxEntry.getKey());
            } else if (entry.getValue().compareTo(maxEntry.getValue()) == 0) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private String findRange(List<Integer> list) {
        if (list.size() > 1)
            return TimeConverter.convertToTime(list.get(0)) + " - "
                    + TimeConverter.convertToTime(list.get(list.size() - 1)) + "; "
                    + visitorsMap.get(list.get(0));
        else if (list.size() > 0)
            return TimeConverter.convertToTime(list.get(0)) + "; " + visitorsMap.get(list.get(0));
        else
            return "";
    }

}

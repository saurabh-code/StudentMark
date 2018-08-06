package com.bootcamp.StudentMark.components;

import javafx.util.Pair;

import java.util.*;

public class RelationProcessor {

    Map<String, List<String>> allRelations;

    public RelationProcessor(Map<String, List<String>> listOfAllRelations) {
        allRelations = listOfAllRelations;
    }

    private List<String> getCurrentListFor(String student) {
        return allRelations.get(student);
    }

    private Set<String> getAllStudents() {
        return allRelations.keySet();
    }

    private List<String> getNewListFor(String student) {
        List<String> curList = getCurrentListFor(student);
        List<String> newList = new LinkedList<String>(curList);
        for(String s : curList) {
            List<String> listForS = getCurrentListFor(s);
            newList.removeAll(listForS);
        }
        return newList;
    }

    public List<Pair<String, String>> getMinimumListOfRelations() {
        ArrayList<Pair<String, String>> minList = new ArrayList<Pair<String, String>>();
        for(String s : getAllStudents()) {
            List<String> newListForS = getNewListFor(s);
            for(String childS : newListForS) {
                minList.add(new Pair<String, String>(s, childS));
            }
        }
        return minList;
    }

}

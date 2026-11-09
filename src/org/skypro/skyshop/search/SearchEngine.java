package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchable;

    public SearchEngine(int number) {
        this.searchable = new LinkedList<>();
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> searchResult = new ArrayList<>();
        if (searchTerm != null && !searchTerm.isBlank()) {
            for (int i = 0; i < searchable.size(); i++) {
                if (searchable.get(i) != null && searchable.get(i).getSearchTerm().contains(searchTerm)) {
                    searchResult.add(searchable.get(i));
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable newSearchable) {
        if (newSearchable != null) {
            searchable.add(newSearchable);
        }
    }

    public Searchable findingMostSuitable(String search) throws BestResultNotFound {
        Searchable mostSuitable = null;
        int maxOccurrencesOfSubstring = 0;
        int counter = 0;
        for (int i = 0; i < searchable.size(); i++) {
            if (searchable.get(i) != null && searchable.get(i).getSearchTerm() != null &&
                    !searchable.get(i).getSearchTerm().isBlank()) {

                String str = searchable.get(i).getSearchTerm();

                if (search != null && !search.isBlank()) {
                    int substringIndex = str.indexOf(search);

                    while (substringIndex != -1) {
                        counter++;
                        int index = substringIndex + search.length();
                        substringIndex = str.indexOf(search, index);
                    }
                }
                if (counter > maxOccurrencesOfSubstring) {
                    maxOccurrencesOfSubstring = counter;
                    mostSuitable = searchable.get(i);
                }
                counter = 0;
            }
        }
        if (mostSuitable == null) {
            throw new BestResultNotFound("Для поискового запроса (" + search + ") ничего не найдено");
        }
        return mostSuitable;
    }
}

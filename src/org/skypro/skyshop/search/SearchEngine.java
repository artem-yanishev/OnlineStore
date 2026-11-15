package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchable;

    public SearchEngine() {
        this.searchable = new LinkedList<>();
    }

    public Map<String, Searchable> search(String searchTerm) {
        Map<String, Searchable> searchResult = new TreeMap<>();
        if (searchTerm != null && !searchTerm.isBlank()) {
            for (Searchable value : searchable) {
                if (value != null && value.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResult.put(value.getName(), value);
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
        for (Searchable value : searchable) {
            if (value != null && value.getSearchTerm() != null &&
                    !value.getSearchTerm().isBlank()) {

                String str = value.getSearchTerm().toLowerCase();

                if (search != null && !search.isBlank()) {
                    search = search.toLowerCase();
                    int substringIndex = str.indexOf(search);

                    while (substringIndex != -1) {
                        counter++;
                        int index = substringIndex + search.length();
                        substringIndex = str.indexOf(search, index);
                    }
                }
                if (counter > maxOccurrencesOfSubstring) {
                    maxOccurrencesOfSubstring = counter;
                    mostSuitable = value;
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

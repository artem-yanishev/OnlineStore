package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchable;

    public SearchEngine(int number) {
        this.searchable = new Searchable[number];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] searchResult = new Searchable[5];
        int counter = 0;
        if (!searchTerm.trim().isEmpty()) {
            for (int i = 0; i < searchable.length; i++) {
                if (searchable[i] != null && searchable[i].getSearchTerm().contains(searchTerm)) {
                    searchResult[counter] = searchable[i];
                    counter++;
                    if (counter == 5) {
                        break;
                    }
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable newSearchable) {
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] == null) {
                searchable[i] = newSearchable;
                break;
            }
        }
    }

    public Searchable findingMostSuitable(String search) throws BestResultNotFound {
        Searchable mostSuitable = null;
        int maxOccurrencesOfSubstring = 0;
        int counter = 0;
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] != null && searchable[i].getSearchTerm() != null &&
                    !searchable[i].getSearchTerm().isBlank()) {

                String str = searchable[i].getSearchTerm();

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
                    mostSuitable = searchable[i];
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

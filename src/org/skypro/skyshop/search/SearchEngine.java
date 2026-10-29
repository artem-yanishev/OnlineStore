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
}

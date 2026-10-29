package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String artTitle;
    private final String artText;

    public Article(String artTitle, String artText) {
        this.artTitle = artTitle;
        this.artText = artText;
    }

    @Override
    public String getName() {
        return artTitle;
    }

    @Override
    public String toString() {
        return artTitle + "\n" + artText;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}

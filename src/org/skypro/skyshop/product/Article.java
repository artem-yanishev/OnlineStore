package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String artTitle;
    private final String artText;

    public Article(String artTitle, String artText) {
        if (artTitle == null || artText == null || artTitle.isBlank() || artText.isBlank()) {
            throw new IllegalArgumentException("Название или текст пустые");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(artTitle, article.artTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(artTitle);
    }
}

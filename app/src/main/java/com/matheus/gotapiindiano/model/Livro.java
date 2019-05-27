package com.matheus.gotapiindiano.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Livro {

    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("authors")
    private List<String> authors = null;
    @SerializedName("numberOfPages")
    private Integer numberOfPages;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("country")
    private String country;
    @SerializedName("mediaType")
    private String mediaType;
    @SerializedName("released")
    private String released;
    @SerializedName("characters")
    private List<String> characters = null;
    @SerializedName("povCharacters")
    private List<String> povCharacters = null;

    public Livro(String url, String name, String isbn, List<String> authors, Integer numberOfPages, String publisher, String country, String mediaType, String released, List<String> characters, List<String> povCharacters) {
        super();
        this.url = url;
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.country = country;
        this.mediaType = mediaType;
        this.released = released;
        this.characters = characters;
        this.povCharacters = povCharacters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Livro withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Livro withName(String name) {
        this.name = name;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Livro withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Livro withAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Livro withNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Livro withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Livro withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Livro withMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Livro withReleased(String released) {
        this.released = released;
        return this;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public Livro withCharacters(List<String> characters) {
        this.characters = characters;
        return this;
    }

    public List<String> getPovCharacters() {
        return povCharacters;
    }

    public void setPovCharacters(List<String> povCharacters) {
        this.povCharacters = povCharacters;
    }

    public Livro withPovCharacters(List<String> povCharacters) {
        this.povCharacters = povCharacters;
        return this;
    }

}

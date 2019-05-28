package com.matheus.gotapiindiano.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Livro {
    private int id;
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
    private List<Object> characters = null;
    @SerializedName("povCharacters")
    private List<Object> povCharacters = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Livro() {
    }

    /**
     *
     * @param released
     * @param povCharacters
     * @param authors
     * @param isbn
     * @param name
     * @param numberOfPages
     * @param characters
     * @param mediaType
     * @param url
     * @param country
     * @param publisher
     */
    public Livro(String url, String name, String isbn, List<String> authors, Integer numberOfPages, String publisher, String country, String mediaType, String released, List<Object> characters, List<Object> povCharacters) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public List<Object> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Object> characters) {
        this.characters = characters;
    }

    public List<Object> getPovCharacters() {
        return povCharacters;
    }

    public void setPovCharacters(List<Object> povCharacters) {
        this.povCharacters = povCharacters;
    }

}

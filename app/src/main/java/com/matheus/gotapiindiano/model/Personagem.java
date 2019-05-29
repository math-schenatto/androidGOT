package com.matheus.gotapiindiano.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Personagem {
    private int id;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("culture")
    private String culture;
    @SerializedName("born")
    private String born;
    @SerializedName("died")
    private String died;
    @SerializedName("titles")
    private List<String> titles = null;
    @SerializedName("aliases")
    private List<String> aliases = null;
    @SerializedName("father")
    private String father;
    @SerializedName("mother")
    private String mother;
    @SerializedName("spouse")
    private String spouse;
    @SerializedName("allegiances")
    private List<String> allegiances = null;
    @SerializedName("books")
    private List<String> books = null;
    @SerializedName("povBooks")
    private List<String> povBooks = null;
    @SerializedName("tvSeries")
    private List<String> tvSeries = null;
    @SerializedName("playedBy")
    private List<String> playedBy = null;
    public  Personagem(){

    }
    public Personagem(String url, String name, String gender, String culture, String born, String died, List<String> titles, List<String> aliases, String father, String mother, String spouse, List<String> allegiances, List<String> books, List<String> povBooks, List<String> tvSeries, List<String> playedBy) {
        super();
        this.url = url;
        this.name = name;
        this.gender = gender;
        this.culture = culture;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
        this.allegiances = allegiances;
        this.books = books;
        this.povBooks = povBooks;
        this.tvSeries = tvSeries;
        this.playedBy = playedBy;
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

    public Personagem withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Personagem withName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Personagem withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public Personagem withCulture(String culture) {
        this.culture = culture;
        return this;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public Personagem withBorn(String born) {
        this.born = born;
        return this;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public Personagem withDied(String died) {
        this.died = died;
        return this;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Personagem withTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public Personagem withAliases(List<String> aliases) {
        this.aliases = aliases;
        return this;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public Personagem withFather(String father) {
        this.father = father;
        return this;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public Personagem withMother(String mother) {
        this.mother = mother;
        return this;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public Personagem withSpouse(String spouse) {
        this.spouse = spouse;
        return this;
    }

    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    public Personagem withAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Personagem withBooks(List<String> books) {
        this.books = books;
        return this;
    }

    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    public Personagem withPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
        return this;
    }

    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    public Personagem withTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
        return this;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }

    public Personagem withPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
        return this;
    }

}
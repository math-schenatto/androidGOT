package com.matheus.gotapiindiano.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Casa {

    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("coatOfArms")
    private String coatOfArms;
    @SerializedName("words")
    private String words;
    @SerializedName("titles")
    private List<String> titles = null;
    @SerializedName("seats")
    private List<String> seats = null;
    @SerializedName("currentLord")
    private String currentLord;
    @SerializedName("heir")
    private String heir;
    @SerializedName("overlord")
    private String overlord;
    @SerializedName("founded")
    private String founded;
    @SerializedName("founder")
    private String founder;
    @SerializedName("diedOut")
    private String diedOut;
    @SerializedName("ancestralWeapons")
    private List<String> ancestralWeapons = null;
    @SerializedName("cadetBranches")
    private List<Object> cadetBranches = null;
    @SerializedName("swornMembers")
    private List<String> swornMembers = null;


    public Casa(String url, String name, String region, String coatOfArms, String words, List<String> titles, List<String> seats, String currentLord, String heir, String overlord, String founded, String founder, String diedOut, List<String> ancestralWeapons, List<Object> cadetBranches, List<String> swornMembers) {
        super();
        this.url = url;
        this.name = name;
        this.region = region;
        this.coatOfArms = coatOfArms;
        this.words = words;
        this.titles = titles;
        this.seats = seats;
        this.currentLord = currentLord;
        this.heir = heir;
        this.overlord = overlord;
        this.founded = founded;
        this.founder = founder;
        this.diedOut = diedOut;
        this.ancestralWeapons = ancestralWeapons;
        this.cadetBranches = cadetBranches;
        this.swornMembers = swornMembers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Casa withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Casa withName(String name) {
        this.name = name;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Casa withRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public Casa withCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
        return this;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Casa withWords(String words) {
        this.words = words;
        return this;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public Casa withTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public Casa withSeats(List<String> seats) {
        this.seats = seats;
        return this;
    }

    public String getCurrentLord() {
        return currentLord;
    }

    public void setCurrentLord(String currentLord) {
        this.currentLord = currentLord;
    }

    public Casa withCurrentLord(String currentLord) {
        this.currentLord = currentLord;
        return this;
    }

    public String getHeir() {
        return heir;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    public Casa withHeir(String heir) {
        this.heir = heir;
        return this;
    }

    public String getOverlord() {
        return overlord;
    }

    public void setOverlord(String overlord) {
        this.overlord = overlord;
    }

    public Casa withOverlord(String overlord) {
        this.overlord = overlord;
        return this;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public Casa withFounded(String founded) {
        this.founded = founded;
        return this;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Casa withFounder(String founder) {
        this.founder = founder;
        return this;
    }

    public String getDiedOut() {
        return diedOut;
    }

    public void setDiedOut(String diedOut) {
        this.diedOut = diedOut;
    }

    public Casa withDiedOut(String diedOut) {
        this.diedOut = diedOut;
        return this;
    }

    public List<String> getAncestralWeapons() {
        return ancestralWeapons;
    }

    public void setAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    public Casa withAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
        return this;
    }

    public List<Object> getCadetBranches() {
        return cadetBranches;
    }

    public void setCadetBranches(List<Object> cadetBranches) {
        this.cadetBranches = cadetBranches;
    }

    public Casa withCadetBranches(List<Object> cadetBranches) {
        this.cadetBranches = cadetBranches;
        return this;
    }

    public List<String> getSwornMembers() {
        return swornMembers;
    }

    public void setSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
    }

    public Casa withSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
        return this;
    }

}
package com.example.covidtracker.api;

import com.google.gson.annotations.SerializedName;

public class CountryData {

    @SerializedName("updated")// using serizable we can make our own type of variable
    // like here we made private String update instead of update we can write up or some thing else
    private  String update;

    @SerializedName("country")
    private  String country;


    @SerializedName("cases")
    private  String cases;

    @SerializedName("todayCases")
    private  String todayCases;

    @SerializedName("deaths")
    private  String deaths;

    @SerializedName("todayDeaths")
    private  String todayDeaths;


    @SerializedName("recovered")
    private  String recovered;

    @SerializedName("todayRecovered")
    private  String todayRecovered;

    @SerializedName("active")
    private  String active;

    @SerializedName("tests")
    private  String tests;


    public CountryData(String update, String country,
                       String cases, String todayCases, String deaths,
                       String todayDeaths, String recovered, String todayRecovered,
                       String active, String tests) {
        this.update = update;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.tests = tests;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }
}

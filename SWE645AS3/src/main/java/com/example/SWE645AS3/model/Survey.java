package com.example.SWE645AS3.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Street address is required")
    private String streetAddress;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "ZIP code is required")
    @Pattern(regexp = "^[0-9]{5}$", message = "ZIP code must be 5 digits")
    private String zip;

    @NotBlank(message = "Telephone number is required")
    @Pattern(regexp = "^\\(\\d{3}\\) \\d{3}-\\d{4}$", message = "Phone number must be in the format (XXX) XXX-XXXX")
    private String telephone;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Date of survey is required")
    @Temporal(TemporalType.DATE)
    private Date dateOfSurvey;

    @Enumerated(EnumType.STRING)
    private CampusFeature likesMost;

    @Enumerated(EnumType.STRING)
    private InterestOrigin interestOrigin;

    @Enumerated(EnumType.STRING)
    private RecommendationLikelihood recommendationLikelihood;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public CampusFeature getLikesMost() {
        return likesMost;
    }

    public void setLikesMost(CampusFeature likesMost) {
        this.likesMost = likesMost;
    }

    public InterestOrigin getInterestOrigin() {
        return interestOrigin;
    }

    public void setInterestOrigin(InterestOrigin interestOrigin) {
        this.interestOrigin = interestOrigin;
    }

    public RecommendationLikelihood getRecommendationLikelihood() {
        return recommendationLikelihood;
    }

    public void setRecommendationLikelihood(RecommendationLikelihood recommendationLikelihood) {
        this.recommendationLikelihood = recommendationLikelihood;
    }
}

enum CampusFeature {
    STUDENTS, LOCATION, CAMPUS, ATMOSPHERE, DORM_ROOMS, SPORTS
}

enum InterestOrigin {
    FRIENDS, TELEVISION, INTERNET, OTHER
}

enum RecommendationLikelihood {
    VERY_LIKELY, LIKELY, UNLIKELY
}

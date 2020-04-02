package com.aor.refactoring.example6;

public class Location {
    private String locationLatitude;
    private String locationLongitude;
    private String locationName;

    public Location(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return locationLatitude + "," + locationLongitude + " (" + locationName + ")";
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getLocationName() {
        return locationName;
    }
}

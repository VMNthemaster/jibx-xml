package org.example;

import java.util.List;

public class HotelSettingUpdateRS {
    private int hotelID;
    private List<SettingRS> settings;

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public List<SettingRS> getSettings() {
        return settings;
    }

    public void setSettings(List<SettingRS> settings) {
        this.settings = settings;
    }
}

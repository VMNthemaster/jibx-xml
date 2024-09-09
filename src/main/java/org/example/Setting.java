package org.example;

public class Setting {
    private String settingName;
    private int settingID;
    private boolean settingValue;

    // Getters and setters
    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public int getSettingID() {
        return settingID;
    }

    public void setSettingID(int settingID) {
        this.settingID = settingID;
    }

    public boolean isSettingValue() {
        return settingValue;
    }

    public void setSettingValue(boolean settingValue) {
        this.settingValue = settingValue;
    }
}


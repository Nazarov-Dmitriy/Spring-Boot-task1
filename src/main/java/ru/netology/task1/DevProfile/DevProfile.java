package ru.netology.task1.DevProfile;

import ru.netology.task1.SystemProfile.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
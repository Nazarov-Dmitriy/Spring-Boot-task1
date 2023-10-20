package ru.netology.task1.ProductionProfile;

import ru.netology.task1.SystemProfile.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}

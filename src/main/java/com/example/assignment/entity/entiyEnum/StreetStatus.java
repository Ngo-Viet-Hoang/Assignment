package com.example.assignment.entity.entiyEnum;

public enum StreetStatus {
    USING(1),
    CONTRUCTION(0),
    REPAIR(-1);

    private int value;
    StreetStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static StreetStatus of(int value) {
        for (StreetStatus streetStatus : StreetStatus.values()) {
            if(streetStatus.getValue() == value) {
                return streetStatus;
            }
        }
        return StreetStatus.USING;
    }
}

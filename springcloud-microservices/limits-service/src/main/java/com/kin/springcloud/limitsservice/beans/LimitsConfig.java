package com.kin.springcloud.limitsservice.beans;

public class LimitsConfig {
    private int max;
    private int min;

    public LimitsConfig(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}

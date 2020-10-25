package com.company.practice13;

public class Bottle {
    private int bottleVolume;
    private int liquidVolume;

    public int getBottleVolume() {
        return bottleVolume;
    }

    public void setBottleVolume(int bottleVolume) throws Exception {
        if (bottleVolume <= 0)
            throw new Exception();
        this.bottleVolume = bottleVolume;
    }

    public int getLiquidVolume() {
        return liquidVolume;
    }

    public void addLiquidVolume(int liquidVolume) throws IncorrectLiquidVolumeException {
        if (liquidVolume < 0 || liquidVolume > bottleVolume)
            throw new IncorrectLiquidVolumeException();
        this.liquidVolume += liquidVolume;
    }

    @Override
    public String toString() {
        return "Bottle(" + bottleVolume + "){" +
                "liquidVolume=" + liquidVolume +
                '}';
    }
}

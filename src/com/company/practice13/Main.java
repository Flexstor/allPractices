package com.company.practice13;

public class Main {
    public static void main(String[] args){
        Bottle bottle = new Bottle();
        try{
            bottle.setBottleVolume(5);
            bottle.addLiquidVolume(2);
        } catch (IncorrectLiquidVolumeException iex) {
            System.out.println("Некорректные данные объема жидкости");
        } catch (Exception e) {
            System.out.println("Неккоректные данные объема бутылки");
        } finally {
            System.out.println(bottle);
        }
        throw new MyRuntimeException();
    }
}

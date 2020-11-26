package com.company.practice3;

public class Human {

    Head head;
    Leg legLeft;
    Leg legRight;
    Hand handLeft;
    Hand handRight;

    public Human(Head head, Leg legLeft, Leg legRight, Hand handLeft, Hand handRight) {
        this.head = head;
        this.legLeft = legLeft;
        this.legRight = legRight;
        this.handLeft = handLeft;
        this.handRight = handRight;

    }

    public static class Head {
        private String eyes;
        private String hair;

        public Head(String eyes, String hair) {
            this.eyes = eyes;
            this.hair = hair;
        }

        public void setEyes(String eyes) {
            this.eyes = eyes;
        }

        public String getEyes() {
            return eyes;
        }

        public void setHair(String hair) {
            this.hair = hair;
        }

        public String getHair() {
            return hair;
        }

        @Override
        public String toString() {
            return ("глаза = " + eyes +
                    ", волосы = " + hair);
        }
    }

    public static class Leg {
        private int length;
        private int width;

        public Leg(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

    public static class Hand {
        private int length;
        private int width;

        public Hand(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return ("длина = " + length +
                    ", ширина = " + width);
        }
    }

        @Override
        public String toString() {
            return ("Human: " +
                    "\nГолова: " + head +
                    "\nЛевая нога: " + legLeft +
                    "\nПравая нога: " + legRight +
                    "\nЛевая рука: " + handLeft +
                    "\nПравая рука: " + handRight);
        }
}


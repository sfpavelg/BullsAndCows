package org.example.bullsAndCowsbullsAndCows.data;

//Класс Обмена данных
public class Data {

    //Поле
    private int mis;            //таймер - миллисекунды
    private int sec;            //таймер - секунды
    private int min;            //таймер - минуты
    private int hour;           //таймер - часы
    private int numberRandom;    //число рандома
    private String numberEnter;  //вводимое число в строчном типе
    private int cows = 0;          //Количество коров
    private int bulls = 0;         //Количество Быков
    private int bitDepth = 0;      //Выбранная разрядность загаданного числа
    private int intCounter = 0;    //Количество попыток
    private String notation;     //Переменная для дополнительного сообщения (Нотация)
    private String instruction;  //Переменная для дополнительного сообщения (Инструкция)
    private String victory;  //Переменная для дополнительной информации (Победа)

    public Data() {
    }

    public int getMis() {
        return mis;
    }

    public void setMis(int mis) {
        this.mis = mis;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getNumberRandom() {
        return numberRandom;
    }

    public void setNumberRandom(int numberRandom) {
        this.numberRandom = numberRandom;
    }

    public String getNumberEnter() {
        return numberEnter;
    }

    public void setNumberEnter(String numberEnter) {
        this.numberEnter = numberEnter;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(int bitDepth) {
        this.bitDepth = bitDepth;
    }

    public int getIntCounter() {
        return intCounter;
    }

    public void setIntCounter(int intCounter) {
        this.intCounter = intCounter;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getVictory() {
        return victory;
    }

    public void setVictory(String victory) {
        this.victory = victory;
    }

    public void incrementCounter() {
        intCounter++;
    }
}

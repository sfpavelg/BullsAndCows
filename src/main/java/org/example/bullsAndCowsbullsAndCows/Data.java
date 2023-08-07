package org.example.bullsAndCowsbullsAndCows;

//Класс Данных обмена
class Data {

    //Поле
    public static long mis;            //таймер - миллисекунды
    public static long sec;            //таймер - секунды
    public static long min;            //таймер - минуты
    public static long hour;           //таймер - часы
    public static int numberRandom;    //число рандома
    public static String numberEnter;  //вводимое число в строчном типе
    public static int cows=0;          //Количество коров
    public static int bulls=0;         //Количество Быков
    public static int bitDepth=0;      //Выбранная разрядность загаданного числа
    public static int intCounter=0;    //Количество попыток
    public static String notation;     //Переменная для дополнительного сообщения (Нотация)

    Data(){
//Пустая заглушка конструктор на случай нечаянного создания экземпляра этого класса, чтобы данные поля не слетели.
//Иначе конструктор запускается автоматически с обнулением всего поля.
    }

}//конец класса

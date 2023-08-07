package org.example.bullsAndCowsbullsAndCows;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.BorderLayout;


//НАЧАЛО КЛАССА
class FrameBullsAndCows extends JFrame {

    //ПОЛЕ
    TextField numberEnter;  //поле для ввода цифр
    JButton btOk;           //кнопка Подтверждения ввода
    JButton btStart;        //кнопка  Старта
    JButton btRegistration; //кнопка регистрации
    JButton btInstruction;  //кнопка правила игры
    JPanel pnBulls;         //панель картинки Бык
    JPanel pnCows;          //панель картинки Корова
    JPanel pnBullsResult;   //панель вывода результата: Бык
    JPanel pnCowsResult;    //панель вывода результата: Корова
    JPanel pnUserName;      //панель Имени игрока
    JPanel pnTimer;         //панель Таймера
    JPanel pnCounter;       //панель Счётчика
    JPanel pnBitDepth;      //панель индикации выбранной разрядности
    JPanel pnNorth;         //панель СЕВЕР
    JPanel pnNorth1;        //панель1 СЕВЕРА, где разрядность числа
    JPanel pnNorth2;        //панель2 СЕВЕРА, где кнопка регистрации
    JPanel pnNorth3;        //панель3 СЕВЕРА, где таймер и счётчик
    //JPanel pnNorth4;        //панель4 СЕВЕРА, где счётчик
//JPanel pnNorth5;        //панель5 СЕВЕРА, где таймер
    JPanel pnSouth;         //панель ЮГ
    JPanel pnSouth1;        //панель1 ЮГА, где ввод чисел
    JPanel pnSouth2;        //панель2 ЮГА, где кнопка начала игры
    JPanel pnSouth3;        //панель3 ЮГА, где кнопка инструкции
    JPanel pnEast;          //панель ВОСТОК
    JPanel pnWest;          //панель ЗАПАД
    JPanel pnCenter;        //панель ЦЕНТР
    JLabel lblCowsResult;        //лейбл количества Коров
    JLabel lblBullsResult;       //лейбл количества Быков
    JLabel lblUserName;          //лейбл имени игрока
    JLabel lblCounter;           //лейбл количества попыток
    JLabel lblBitDepth;          //лейбл разрядности загаданного числа
    JLabel lblTimer;             //лейбл таймер
    JScrollPane scrollPaneHistory;//окно прокрутки введеных чисел
    JScrollPane scrollPaneTable;//окно прокрутки таблицы рекордов
    String randomNumberStory = "";    //Строковая переменная
    String CowsResult = "Поймано Коров 0"; //Строковая переменная
    String BullsResult = "Поймано Быков 0"; //Строковая переменная
    String stringBitDepth = "Загадано 0 значное число";//Переменная индикации разрядности
    String userName;             //Строковая переменная
    String randomNumberTable;    //Строковая переменная
    JTextArea textAreaStory; //поле истории попыток
    JTextArea textBitDepth; //поле разрядности загаданного числа
    JTextArea textAreaHighScoreTable; //поле таблицы рекордов
    int intCounter = 0; //переменная счётчика попыток
    int intBitDepth;
    public static StopWatch stopWatch; //таймер
    JFrameSelection jFrameSelection; // выбор разрядности, объект будет запущен кнопкой "Начать Игру"

    //КОНСТРУКТОР
    FrameBullsAndCows() {

//создаём окно игры
        super("Быки и Коровы");//заголовок
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
        addWindowListener(new WindowAdapter() { //при закрытии основного окна, закроет все дополнительные и отключит таймер
            @Override
            public void windowClosing(WindowEvent e) {
                FrameBullsAndCows.stopWatch.stopStopWatch();
                System.exit(0);
            }
        });


        setBounds(50, 50, 1100, 550); //размер окна и местоположение на экране
        setResizable(false); //размер окна нельзя изменить

//Создаём ОБЪЕКТЫ всех переменных
        numberEnter = new TextField(6);     //создаём окна ввода
        btOk = new JButton("OK");     //создаём кнопку
        btStart = new JButton("Начать игру");//создаём кнопку
        btInstruction = new JButton("Инструкция");//создаём кнопку
        btRegistration = new JButton("Регистрация"); //создаём кнопку
        pnBulls = new JPanel();  //создаём панель для мордочки Быка
        pnCows = new JPanel();   //создаём панель для мордочки Коровы
        pnUserName = new JPanel();  //создаём панель Имени Игрока
        pnTimer = new JPanel();    //создаём панель Таймера
        pnCounter = new JPanel();  //создаём панель Счётчика
        pnBitDepth = new JPanel(); //создаём панель выбранной разрядности
        userName = "Павел"; //Временная текстовая переменная, которая будет заглушкой для лейбела регистрации
        lblUserName = new JLabel(userName);
        lblCowsResult = new JLabel(CowsResult);   //лейбелы результатов Коров
        lblBullsResult = new JLabel(BullsResult); //лейбелы результатов Быков
//        stringBitDepth = "" + Data.bitDepth; //конвертируем int в String
//        stringBitDepth = "" + intBitDepth; //конвертируем int в String
//        lblBitDepth = new JLabel(StringBitDepth);//лейбл разрядности загаданного числа
        textBitDepth = new JTextArea(25, 8); //создаём текстовое разрядности загаданного числа
        textAreaStory = new JTextArea(25, 8); //создаём текстовое поле размещения попыток
        scrollPaneHistory = new JScrollPane(textAreaStory); //создаём скроллпанель для размещения textArea
        randomNumberTable = "1.Павел 45 sec  5 попыток"; //временная заглушка для таблицы результатов
        textAreaHighScoreTable = new JTextArea(25, 18); //создаём текстовое поле таблицы результатов
        textAreaHighScoreTable.setText(randomNumberTable); // это временный муляж таблицы
        scrollPaneTable = new JScrollPane(textAreaHighScoreTable);//создаём скроллпанель для таблицы результатов
        stopWatch = new StopWatch(); //создаём экземпляр таймера


//Блокируем поле ввода не более выбранной разрядности
//    numberEnter.addKeyListener(new KeyAdapter() {
//        @Override
//        public void keyTyped(KeyEvent e) {
//            if (numberEnter.getText().length() >= Data.bitDepth )
//                    e.consume();
//        }
//    });
// конец фрагмента ограничения на количество вводимых знаков
//при первом запуске, если не произведена селекция,Data.bitDepth будет равно 0
//ввести цифры будет невозможно


//создаём слушателей кнопок и события для них

//Слушатель кнопки (Инструкция)
        btInstruction.addActionListener(e -> new JFrameInstruction());

//Слушатель кнопки (Начать игру)
        btStart.addActionListener(e -> {
            Data.bitDepth = 0;  //пишем в переменную 0, если значение переменной уже изменялось ранее
            jFrameSelection = new JFrameSelection(); //вызвали класс выбора.
            intBitDepth = jFrameSelection.startJFrameSelection();
            stringBitDepth = "" + intBitDepth; //конвертируем int в String
            lblBitDepth.setText(stringBitDepth);
            new NumberRandom(intBitDepth);
            new Notation(intBitDepth);
            Data.bitDepth = intBitDepth;
//это мы открываем временное окно оповещения
//Главная фишка его в том, что программа стопорится и ждёт его закрытия.
            JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);
//запуск таймера, сразу после закрытия предыдущего окна
            FrameBullsAndCows.stopWatch.startStopWatch();
        });

//Слушатель кнопки (ОК)
        btOk.addActionListener(e -> {
            Data.numberEnter = numberEnter.getText();//забираем вводимое число текстовой строкой и кидаем в класс данных
            new Comparsion(Data.numberEnter); //вызвали класс сравнения, с введенным числом на входе
            CowsResult = "Поймано Коров " + Data.cows; //Строковая переменная с результатом  пойманных коров
            BullsResult = "Поймано Быков " + Data.bulls; //Строковая переменная с результатом пойманных быков
            lblCowsResult.setText(CowsResult); //вывели на лэйбл пойманных коров
            lblBullsResult.setText(BullsResult);//вывели на лэйбл пойманных быков
//заполняем историю попыток
            randomNumberStory = randomNumberStory + "\n" + Data.numberEnter + "    " + Data.bulls + "  " + Data.cows;
            textAreaStory.setText(randomNumberStory);
            intCounter++; //увеличили переменную числа попыток на +1
            Data.intCounter = intCounter;//количество попыток отправили в базу данных
            lblCounter.setText("" + intCounter);//вывели на лэбл текущее количество попыток и конвертировали в String путём конкатинации.
        });

//делим окно на пять сторон света и в каждую вставляем свою панель
        pnNorth = new JPanel();
        pnSouth = new JPanel();
        pnEast = new JPanel();
        pnWest = new JPanel();
        pnCenter = new JPanel();
        add(pnNorth, BorderLayout.NORTH);
        add(pnSouth, BorderLayout.SOUTH);
        add(pnEast, BorderLayout.EAST);
        add(pnWest, BorderLayout.WEST);
        add(pnCenter, BorderLayout.CENTER);

//теперь эти панели заполняем
        //Юг делим на три области и заполняем
        pnSouth1 = new JPanel();
        pnSouth2 = new JPanel();
        pnSouth3 = new JPanel();

        pnSouth1.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
        pnSouth2.setLayout(new FlowLayout(FlowLayout.CENTER));//ориентация по центру
        pnSouth3.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю
        pnSouth1.add(new JLabel("Поле для ввода числа"));
        pnSouth1.add(numberEnter);
        pnSouth1.add(btOk);
        pnSouth2.add(btStart);
        pnSouth3.add(btInstruction);

        pnSouth.setLayout(new BorderLayout());
        pnSouth.add(pnSouth1, BorderLayout.WEST);
        pnSouth.add(pnSouth2, BorderLayout.CENTER);
        pnSouth.add(pnSouth3, BorderLayout.EAST);

        //Север делим на три области и заполняем
        pnNorth1 = new JPanel();
        pnNorth2 = new JPanel();
        pnNorth3 = new JPanel();
//pnNorth4 = new JPanel();
//pnNorth5 = new JPanel();
        pnNorth1.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
        pnNorth2.setLayout(new FlowLayout(FlowLayout.CENTER));//ориентация по центру
        pnNorth3.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю
//pnNorth4.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
//pnNorth5.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю
        pnCounter.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
        pnTimer.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю

        pnNorth.setLayout(new BorderLayout());//без бордера элементы по углам не расходятся
        pnNorth.add(pnNorth1, BorderLayout.WEST);
        pnNorth.add(pnNorth2, BorderLayout.CENTER);
        pnNorth.add(pnNorth3, BorderLayout.EAST);

//Подсказка выбранной разрядности
        pnBitDepth.add(new JLabel("Выбрана разрядность: "));
//        lblBitDepth = new JLabel(""+ intBitDepth);
        lblBitDepth = new JLabel();
        pnBitDepth.add(lblBitDepth);

        pnNorth1.add(pnBitDepth);
//       pnNorth1.add(lblBitDepth);
        pnUserName.add(lblUserName);
        pnNorth2.add(pnUserName);
        pnNorth2.add(btRegistration);
        pnNorth3.add(pnCounter);
        pnNorth3.add(pnTimer);

//счётчик
        pnCounter.add(new JLabel("Счётчик попыток:"));
        lblCounter = new JLabel("" + intCounter);
        pnCounter.add(lblCounter);

//тут таймер
        pnTimer.setLayout(new BorderLayout());//без этого менеджера графика не рисуется?!!
        pnTimer.setPreferredSize(new Dimension(80, 30));//Так как вставка рисунка, то размеры нужно задать. автоматически панель не понимает
        pnTimer.add(new JPTimer());

//закидываем панели счётчика и таймера в панель pnNorth3
        pnNorth3.add(pnCounter);
        pnNorth3.add(pnTimer);

//тут таблица историй попыток
        pnWest.setLayout(new BorderLayout());
        pnWest.add(new JLabel("Число        Б  К"), BorderLayout.NORTH);
        pnWest.add(scrollPaneHistory, BorderLayout.SOUTH);

//Создаем экземпляры мордашек. Классы этих рисунков смотри в пакете.
        CowsSmile cs2 = new CowsSmile();
        BullsSmile bs2 = new BullsSmile();

//рамки и надписи для окон, Вариант1
        Border etched = BorderFactory.createEtchedBorder();//создаём рамку, цвет-чёрный, линяя -тонкая
        Border etched2 = BorderFactory.createMatteBorder(2, 20, 2, 20, Color.BLUE);//создаём рамку, цвет -синий, линяя -толстая

//а тут методом createTitledBorder() добавляем на рамку заголовок
        Border titled1 = BorderFactory.createTitledBorder(etched, "Здесь будет подсказка, Бык или Корова. А если повезет, то и то и другое");
        Border titled2 = BorderFactory.createTitledBorder(etched, "История");
        Border titled3 = BorderFactory.createTitledBorder(etched, "Таблица результатов");
        Border titled4 = BorderFactory.createTitledBorder(etched, "Корова");
        Border titled5 = BorderFactory.createTitledBorder(etched, "Бык");
        Border titled6 = BorderFactory.createTitledBorder(etched, "И сколько же вы поймали Коров?:");
        Border titled7 = BorderFactory.createTitledBorder(etched, "И сколько же вы поймали Быков?:");

//теперь методом setBorder одеваем нашу панель в соответствующую рамку
        pnCenter.setBorder(titled1);
        pnWest.setBorder(titled2);
        pnEast.setBorder(titled3);
        pnCows.setBorder(titled4);
        pnBulls.setBorder(titled5);
        pnCowsResult = new JPanel();  //создаём объект pnCowsResult (нужно перенести выше....)
        pnBullsResult = new JPanel(); //создаём объект pnBullsResult
        pnCowsResult.setBorder(titled6);
        pnBullsResult.setBorder(titled7);
        pnNorth.setBorder(etched);
        pnUserName.setBorder(etched2);
        pnTimer.setBorder(etched);
        pnCounter.setBorder(etched);
        pnBitDepth.setBorder(etched);


//меняем в панелях центральной части менеджер расположения
        pnCenter.setLayout(new GridLayout(1, 2));
//BorderLayout по умолчанию растягивает содержимое на весь экран
        pnCows.setLayout(new BorderLayout());
        pnBulls.setLayout(new BorderLayout());

//На панельки лепим мордашки
        pnCows.add(cs2);
        pnBulls.add(bs2);

//К панелям результатов привязываем лэйблы
        pnCowsResult.add(lblCowsResult);
        pnBullsResult.add(lblBullsResult);

//добавляем в южную часть, под мордашки панели результатов
        pnCows.add(pnCowsResult, BorderLayout.SOUTH);
        pnBulls.add(pnBullsResult, BorderLayout.SOUTH);

//в центральную панель размещаем панели с мордашками и результатами
        pnCenter.add(pnBulls);  //первой колонкой будет бык
        pnCenter.add(pnCows);   //второй колонкой будет корова
//хотите наоборот, тогда добавьте первым pnCows

//в панель ВОСТОКА добавили таблицу рекордов
        pnEast.add(scrollPaneTable);

//Делаем окно и всё что в нём видимым
        setVisible(true);
    }

    public void update() {
        int intBitDepth = Data.bitDepth;
        pnNorth1.repaint();
//        pnNorth1.validate();
    }
}

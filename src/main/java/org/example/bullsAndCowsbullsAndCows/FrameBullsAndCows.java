package org.example.bullsAndCowsbullsAndCows;

import org.example.bullsAndCowsbullsAndCows.button.ButtonInstruction;
import org.example.bullsAndCowsbullsAndCows.button.ButtonOK;
import org.example.bullsAndCowsbullsAndCows.button.ButtonStart;
import org.example.bullsAndCowsbullsAndCows.graphic.BullsSmile;
import org.example.bullsAndCowsbullsAndCows.graphic.CowsSmile;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.JPTimer;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.StopWatch;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelStory;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;


//НАЧАЛО КЛАССА
public class FrameBullsAndCows extends JFrame {

    //ПОЛЕ
    private TextField numberEnter;  //поле для ввода цифр
    private ButtonOK btOk;           //кнопка Подтверждения ввода
    private ButtonStart btStart;        //кнопка  Старта
    private JButton btRegistration; //кнопка регистрации
    private ButtonInstruction btInstruction;  //кнопка правила игры
    private JPanel pnBulls;         //панель картинки Бык
    private JPanel pnCows;          //панель картинки Корова
    private JPanel pnBullsResult;   //панель вывода результата: Бык
    private JPanel pnCowsResult;    //панель вывода результата: Корова
    private JPanel pnUserName;      //панель Имени игрока
    private JPanel pnTimer;         //панель Таймера
    private JPanel pnCounter;       //панель Счётчика
    private JPanel pnBitDepth;      //панель индикации выбранной разрядности
    private JPanel pnNorth;         //панель СЕВЕР
    private JPanel pnNorth1;        //панель1 СЕВЕРА, где разрядность числа
    private JPanel pnNorth2;        //панель2 СЕВЕРА, где кнопка регистрации
    private JPanel pnNorth3;        //панель3 СЕВЕРА, где таймер и счётчик
    private JPanel pnSouth;         //панель ЮГ
    private JPanel pnSouth1;        //панель1 ЮГА, где ввод чисел
    private JPanel pnSouth2;        //панель2 ЮГА, где кнопка начала игры
    private JPanel pnSouth3;        //панель3 ЮГА, где кнопка инструкции
    private JPanel pnEast;          //панель ВОСТОК
    private JPanel pnWest;          //панель ЗАПАД
    private JPanel pnCenter;        //панель ЦЕНТР
    private JLabel lblCowsResult;        //лейбл количества Коров
    private JLabel lblBullsResult;       //лейбл количества Быков
    private JLabel lblUserName;          //лейбл имени игрока
    private JLabel lblCounter;           //лейбл количества попыток
    private JLabel lblBitDepth;          //лейбл разрядности загаданного числа
    private JLabel lblTimer;             //лейбл таймер
    private JScrollPane scrollPaneHistory;//окно прокрутки введённых чисел
    private JScrollPane scrollPaneTable;//окно прокрутки таблицы рекордов
    private String CowsResult = "Поймано Коров 0"; //Строковая переменная
    private String BullsResult = "Поймано Быков 0"; //Строковая переменная
    private String stringBitDepth; //Переменная индикации разрядности
    private String userName;             //Строковая переменная
    private String randomNumberTable;    //Строковая переменная
    private JTextArea textAreaHighScoreTable; //поле таблицы рекордов
    private int intCounter = 0; //переменная счётчика попыток
    public static StopWatch stopWatch; //таймер
    private JTable tableStory; //Табличная панель для истории попыток
    private TableModelStory tableModel; //Это модель принимающая данные истории попыток

    //КОНСТРУКТОР
    FrameBullsAndCows() {

//создаём окно игры
        super("Быки и Коровы");  //заголовок
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //завершение программы при закрытии окна
        setBounds(50, 50, 1150, 550); //размер окна и местоположение на экране
        setResizable(false); //размер окна нельзя изменить

//при закрытии основного окна, закроет все дополнительные и отключит таймер, если он запущен
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FrameBullsAndCows.stopWatch.stopStopWatch();
                System.exit(0);
            }
        });

//Создаём ОБЪЕКТЫ всех переменных
        numberEnter = new TextField(6);  //создаём окна ввода угадываемого числа
        pnBulls = new JPanel();  //создаём панель для мордочки Быка
        pnCows = new JPanel();   //создаём панель для мордочки Коровы
        pnUserName = new JPanel();  //создаём панель Имени Игрока
        pnTimer = new JPanel();    //создаём панель Таймера
        pnCounter = new JPanel();  //создаём панель Счётчика
        pnBitDepth = new JPanel(); //создаём панель выбранной разрядности
        pnCowsResult = new JPanel();  //создаём объект pnCowsResult (нужно перенести выше....)
        pnBullsResult = new JPanel(); //создаём объект pnBullsResult
        userName = "Павел"; //Временная текстовая переменная, которая будет заглушкой для лейбла регистрации
        lblUserName = new JLabel(userName);
        lblCowsResult = new JLabel(CowsResult);   //лейбл результатов Коров
        lblBullsResult = new JLabel(BullsResult); //лейбл результатов Быков
        lblBitDepth = new JLabel();//лейбл разрядности загаданного числа
        lblCounter = new JLabel("" + intCounter); //лейбл счётчика попыток
        randomNumberTable = "1.Павел 45 sec  5 попыток"; //временная заглушка для таблицы результатов
        textAreaHighScoreTable = new JTextArea(25, 18); //создаём текстовое поле таблицы результатов
        textAreaHighScoreTable.setText(randomNumberTable); // это временный муляж таблицы
        scrollPaneTable = new JScrollPane(textAreaHighScoreTable);//создаём скролл панель для таблицы результатов
        stopWatch = new StopWatch(); //создаём экземпляр таймера
        tableModel = new TableModelStory(new Object[0][0]);//Объект модели истории попыток
        tableStory = new JTable(tableModel); //Табличная панель истории попыток
        scrollPaneHistory = new JScrollPane(tableStory); //создаём скролл панель для размещения таблицы истории попыток

// Размеры таблицы истории угадываемых чисел
        /**
         * JTable помещается в JScrollPane, а JScrollPane помещается в JPanel,
         * но в данном случае размер нужно задавать именно для JScrollPane
         * JPanel с помощью менеджера компоновки будет ориентироваться на вложенный контейнер
         * поэтому размер указываем именно для JScrollPane
         * Но для JTable мы определим размеры колонок,
         * первая должна вместить 7 символов, это будет угадываемое число,
         * вторая и третья по одному символу, это будут быки и коровы
         */
        scrollPaneHistory.setPreferredSize(new Dimension(120, 400)); // Установим предпочитаемый размер JScrollPane
        tableStory.getColumnModel().getColumn(0).setPreferredWidth(70); // Установим ширину столбца угадываемого числа
        tableStory.getColumnModel().getColumn(1).setPreferredWidth(5);  // Установим ширину столбца быки
        tableStory.getColumnModel().getColumn(2).setPreferredWidth(5);  // Установим ширину столбца коровы

//кнопки
        btInstruction = new ButtonInstruction(this); //создаём кнопку "Инструкция"
        btOk = new ButtonOK(numberEnter, lblCowsResult, lblBullsResult, lblCounter, tableModel);     //создаём кнопку "ОК"
        btStart = new ButtonStart(lblBitDepth, this); //создаём кнопку "Старт Игры!"
        stringBitDepth = btStart.buttonStart(); //Запускаем слушателя в кнопке "Старт Игры!" и ловим выбранную разрядность числа типа String
        btRegistration = new JButton("Регистрация"); //создаём кнопку "Регистрация"

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

//Определяем ориентацию компонентов в панелях
        pnNorth1.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
        pnNorth2.setLayout(new FlowLayout(FlowLayout.CENTER));//ориентация по центру
        pnNorth3.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю
        pnCounter.setLayout(new FlowLayout(FlowLayout.LEFT));//ориентация по левому краю
        pnTimer.setLayout(new FlowLayout(FlowLayout.RIGHT));//ориентация по правому краю
        pnNorth.setLayout(new BorderLayout());//без менеджера BorderLayout элементы по углам не расходятся
        pnNorth.add(pnNorth1, BorderLayout.WEST);
        pnNorth.add(pnNorth2, BorderLayout.CENTER);
        pnNorth.add(pnNorth3, BorderLayout.EAST);

//Подсказка выбранной разрядности
        stringBitDepth = "Разрядность ещё не выбрана"; // Значение разрядности до выбора
        // использование лейбла и метода setText() позволяют обновлять графический компонент автоматически, при изменении значения stringBitDepth
        lblBitDepth.setText(stringBitDepth);
        pnBitDepth.add(lblBitDepth);

//Заполняем северные панели
        pnNorth1.add(pnBitDepth);
        pnUserName.add(lblUserName);
        pnNorth2.add(pnUserName);
        pnNorth2.add(btRegistration);
        pnNorth3.add(pnCounter);
        pnNorth3.add(pnTimer);

//счётчик
        pnCounter.add(new JLabel("Счётчик попыток:"));
        pnCounter.add(lblCounter);

//тут таймер
        pnTimer.setLayout(new BorderLayout());//без этого менеджера графика не рисуется?!!
        pnTimer.setPreferredSize(new Dimension(80, 30));//Так как вставка рисунка, то размеры нужно задать, автоматически панель не понимает
        pnTimer.add(new JPTimer());

//закидываем панели счётчика и таймера в панель pnNorth3
        pnNorth3.add(pnCounter);
        pnNorth3.add(pnTimer);

//В панель ЗПАДА добавили таблицу истории попыток
        pnWest.add(scrollPaneHistory);
//В панель ВОСТОКА добавили таблицу рекордов
        pnEast.add(scrollPaneTable);

//Создаем экземпляры мордашек. Классы этих рисунков смотри в пакете.
        CowsSmile cs2 = new CowsSmile();
        BullsSmile bs2 = new BullsSmile();

//рамки и надписи для окон, Вариант1
        Border etched = BorderFactory.createEtchedBorder(); //создаём рамку, цвет-чёрный, линяя -тонкая
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

//К панелям результатов привязываем лейбл
        pnCowsResult.add(lblCowsResult);
        pnBullsResult.add(lblBullsResult);

//добавляем в южную часть, под мордашки панели результатов
        pnCows.add(pnCowsResult, BorderLayout.SOUTH);
        pnBulls.add(pnBullsResult, BorderLayout.SOUTH);

//в центральную панель размещаем панели с мордашками и результатами
        pnCenter.add(pnBulls);  //первой колонкой будет бык
        pnCenter.add(pnCows);   //второй колонкой будет корова
//хотите наоборот, тогда добавьте первым pnCows

//Делаем окно и всё что в нём видимым
        setVisible(true);
    }
}

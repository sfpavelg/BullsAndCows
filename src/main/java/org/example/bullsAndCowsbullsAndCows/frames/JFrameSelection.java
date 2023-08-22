package org.example.bullsAndCowsbullsAndCows.frames;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;

import javax.swing.*;

//Класс Окна выбора разрядности
public class JFrameSelection {
    private FrameBullsAndCows frameBullsAndCows;

    public JFrameSelection(FrameBullsAndCows frameBullsAndCows) {
        this.frameBullsAndCows = frameBullsAndCows;
    }

    public int startJFrameSelection() {
        Object[] options = {3, 4, 5, 6, 7};
        /**
         * `JOptionPane.showOptionDialog()` является методом для отображения окна выбора с несколькими вариантами.
         * Вот подробное описание аргументов метода `showOptionDialog()`:
         * 1. `Component parentComponent`: Компонент-родитель, который будет использоваться как родительское окно диалога.
         *   Может быть использовано значение `null`, что означает использование текущего фрейма (текущее рабочее окно) в качестве родительского окна.
         *   Но мы привяжем к окну самой игры frameBullsAndCows, поэтому принимаем этот объект через конструктор.
         * 2. `Object message`: Сообщение или вопрос, отображаемые в диалоговом окне.
         * 3. `String title`: Заголовок окна диалога.
         * 4. `int optionType`: Тип вопроса, определяющий отображаемые кнопки выбора. Возможные значения:
         *    - `JOptionPane.DEFAULT_OPTION` - Стандартный набор кнопок, который включает в себя "ОК", "Отмена" и "Закрыть".
         *    - `JOptionPane.YES_NO_OPTION` - Включает кнопки "Да" и "Нет".
         *    - `JOptionPane.YES_NO_CANCEL_OPTION` - Включает кнопки "Да", "Нет" и "Отмена".
         *    - `JOptionPane.OK_CANCEL_OPTION` - Включает кнопки "ОК" и "Отмена".
         *    - Можно также использовать `JOptionPane.PLAIN_MESSAGE`, `JOptionPane.ERROR_MESSAGE`, `JOptionPane.INFORMATION_MESSAGE`,
         *    `JOptionPane.WARNING_MESSAGE` и `JOptionPane.QUESTION_MESSAGE`.
         * 5. `int messageType`: Тип сообщения, определяющий иконку, которая будет отображаться рядом с сообщением. Возможные значения:
         *    - `JOptionPane.DEFAULT_OPTION` или `JOptionPane.PLAIN_MESSAGE` - Нет иконки.
         *    - `JOptionPane.ERROR_MESSAGE` - Отображает иконку ошибки.
         *    - `JOptionPane.INFORMATION_MESSAGE` - Отображает иконку информации.
         *    - `JOptionPane.WARNING_MESSAGE` - Отображает иконку предупреждения.
         *    - `JOptionPane.QUESTION_MESSAGE` - Отображает иконку вопроса.
         * 6. `Icon icon`: Пользовательская иконка для отображения рядом с сообщением.
         *   В данном случае передано значение `null`, поэтому будет использоваться стандартная иконка.
         * 7. `Object[] options`: Массив объектов, представляющих варианты выбора. В этом случае это массив значений 3, 4, 5, 6 и 7.
         * 8. `Object initialValue`: Значение, которое будет выбрано по умолчанию при открытии окна диалога.
         *  В этом случае передано значение `options[0]`, то есть 3 будет выбрано по умолчанию.
         * Метод `showOptionDialog()` вернет индекс выбранного элемента массива `options`, который соответствует выбранному варианту пользователем.
         */

        int result = JOptionPane.showOptionDialog(frameBullsAndCows,
                "Выберите разрядность загадываемого числа:",
                "Разрядность",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
        return (int) options[result];
    }
}

package com.mycompany.stealthchatnew;

/*
Класс SpellCheckThread представляет поток с проверкой орфографии текста в текстовой области (JTextArea).
*Он использует библиотеку LanguageTool для проверки текста на соответствие правилам языка. В методе run()
*выполняется проверка текста, исправление найденных ошибок и обновление текстовой области с исправленным
*текстом. Если возникают ошибки ввода-вывода, они выводятся.
*/

import org.languagetool.JLanguageTool;
/*Импорт класса JLanguageTool из библиотеки languagetool*/
import org.languagetool.language.Russian;
/*Импорт класса Russian из библиотеки languagetool.language*/
import org.languagetool.rules.RuleMatch;
/*Импорт класса RuleMatch из библиотеки languagetool.rules*/
import javax.swing.JTextArea;
/*Импорт класса JTextArea из пакета javax.swing*/
import javax.swing.SwingUtilities;
/*Импорт класса SwingUtilities из пакета javax.swing*/
import java.io.IOException;
/*Импорт класса IOException*/
import java.util.List;
/*Импорт класса List из пакета java.util*/

public class SpellCheckThread implements Runnable {
    private final JTextArea textArea;
    /*Определение приватной переменной textArea типа JTextArea*/
    private final JLanguageTool languageTool;
    /*Определение приватной переменной languageTool типа JLanguageTool*/

    /*
     * Конструктор класса SpellCheckThread.
     * textArea - текстовая область, в которой будет выполняться проверка орфографии.
     */
    public SpellCheckThread(JTextArea textArea) {
        this.textArea = textArea;
        this.languageTool = new JLanguageTool(new Russian());
        /*Инициализация переменной languageTool с использованием класса JLanguageTool и языка Russian*/
    }

    @Override
    public void run() {
        try {
            String text = textArea.getText();
            /*Получение текста из текстовой области*/
            List<RuleMatch> matches = languageTool.check(text);
            /*Проверка текста на соответствие правилам языка*/

            /*Проходимся по каждой ошибке и исправляем ее*/
            for (int i = matches.size() - 1; i >= 0; i--) {
                RuleMatch match = matches.get(i);
                /*Получение текущей ошибки*/
                List<String> suggestedReplacements = match.getSuggestedReplacements();
                /*Получение списка предлагаемых замен для ошибки*/
                if (!suggestedReplacements.isEmpty()) {
                    String suggested = suggestedReplacements.get(0);
                    /*Получение первой предлагаемой замены*/
                    int fromPos = match.getFromPos();
                    /*Получение начальной позиции ошибки*/
                    int toPos = match.getToPos();
                    /*Получение конечной позиции ошибки*/
                    if (fromPos >= 0 && fromPos < text.length() && toPos >= 0 && toPos <= text.length()) {
                        text = text.substring(0, fromPos) + suggested + text.substring(toPos);
                        /*Замена ошибки на предлагаемую замену в тексте*/
                    }
                }
            }

            final String updatedText = text;
            /*Создание финальной переменной updatedText, содержащей исправленный текст*/

            SwingUtilities.invokeLater(() -> textArea.setText(updatedText));
            /*Обновление текстовой области с исправленным текстом*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

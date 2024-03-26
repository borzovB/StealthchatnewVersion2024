package com.mycompany.stealthchatnew;

/*Класс, который позволяет сохранять шифр медиафайлов в файл формата txt, тут назначается имя файла*/

import javax.swing.*;
import java.io.File;

/*Определение класса FileSaveDialogExample, который наследует JFrame*/
public class FileSaveDialogExample extends JFrame {

    /*Метод для выбора файла*/
    public static String fileChooserGUI() {
        String filePath = null;
        /*Переменная для хранения пути к выбранному файлу*/
        JFileChooser fileChooser = new JFileChooser();
        /*Создание объекта для выбора файла*/
        int returnValue = fileChooser.showOpenDialog(null);
        /*Открытие диалогового окна для выбора файла*/
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            /*Если выбор файла подтвержден*/
            File selectedFile = fileChooser.getSelectedFile();
            /*Получение выбранного файла*/
            filePath = selectedFile.getAbsolutePath();
            /*Получение пути к выбранному файлу*/
        }
        return filePath;
        /*Возвращение пути к выбранному файлу*/
    }

    /*Метод для выбора места сохранения файла*/
    public static String getFileSavePath() {
        String filePath = null;
        /*Переменная для хранения пути к сохраненному файлу*/
        JFileChooser fileChooser = new JFileChooser();
        /*Создание объекта для выбора файла*/
        fileChooser.setDialogTitle("Выберите место сохранения");
        /*Установка заголовка диалогового окна*/
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        /*Установка режима выбора только каталогов*/
        int userSelection = fileChooser.showSaveDialog(null);
        /*Открытие диалогового окна для выбора места сохранения*/
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            /*Если выбор места сохранения подтвержден*/
            File selectedFolder = fileChooser.getSelectedFile();
            /*Получение выбранного каталога*/
            String fileName = JOptionPane.showInputDialog(null, "Введите название файла:");
            /*Запрос пользовательского ввода имени файла*/
            if (fileName != null && !fileName.isEmpty()) {
                /*Если имя файла введено и не пустое*/
                File fileToSave = new File(selectedFolder, fileName + ".txt");
                /*Создание файла для сохранения*/
                filePath = fileToSave.getAbsolutePath();
                /*Получение пути к сохраненному файлу*/
            } else {
                /*Вывод сообщения об ошибке, если имя файла неверное или пустое*/
                JOptionPane.showMessageDialog(null, "Неверное название файла.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        return filePath;
        /*Возвращение пути к сохраненному файлу*/
    }

    /*Метод для удаления всех файлов в указанной папке*/
    public static void deleteAllFiles() {
        try {
            File folder = new File("temporary_store_audio/");
            /*Получение папки, содержащей временно сохраненные аудиофайлы*/

            /*Получаем список всех файлов в папке*/
            File[] files = folder.listFiles();

            if (files != null) {
                /*Удаляем каждый файл*/
                for (File file : files) {
                    if (file.isFile()) {
                        boolean deleted = file.delete();
                        /*Удаление файла и сохранение результата операции*/
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            /*Вывод стека вызовов исключения в случае ошибки*/
        }
    }

}


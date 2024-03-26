package com.mycompany.stealthchatnew;

/*Класс содержит методы для расшифровки аудио, видео, изображения, текста*/

import javax.imageio.ImageIO;
/*Импорт классов для работы с изображениями*/
import javax.sound.sampled.*;
/*Импорт классов для работы со звуком*/
import javax.swing.*;
/*Импорт классов для создания графического интерфейса*/
import java.awt.*;
/*Импорт классов для работы с графикой*/
import java.awt.image.BufferedImage;
/*Импорт класса для работы с изображениями в памяти*/
import java.io.*;
/*Импорт классов для работы с потоками ввода-вывода*/
import java.nio.file.Files;
/*Импорт классов для работы с файловой системой*/
import java.nio.file.Path;
/*Импорт класса для представления пути к файлу*/
import java.nio.file.Paths;
/*Импорт класса для создания объектов Path*/
import java.nio.file.StandardCopyOption;
/*Импорт класса для опций копирования файлов*/
import java.util.Random;
/*Импорт класса для генерации случайных чисел*/

public class DecryptFiles {
    private JTextField tfKeyword;
    /*Текстовое поле для ввода ключа*/
    private JTextArea textCode;
    /*Текстовое поле для ввода зашифрованного текста*/
    private JTextArea textResult;
    /*Текстовое поле для вывода расшифрованного текста*/
    private static CheckingInput checkingInput;
    /*Экземпляр класса для проверки ввода*/
    private static final int max_attempt = 91962520;
    /*Максимальное количество попыток*/
    private static ChainShot chainShot;
    /*Экземпляр класса для дешифрования текста*/
    private static FileSaveDialogExample fileSaveDialogExample;
    /*Экземпляр класса для сохранения файла*/

    /*Конструктор класса DecryptFiles*/
    public DecryptFiles(JTextArea textCode, JTextArea textResult, JTextField tfKeyword) {
        this.tfKeyword = tfKeyword;
        /*Инициализация текстового поля для ключа*/
        this.textCode = textCode;
        /*Инициализация текстового поля для кода*/
        this.textResult = textResult;
        /*Инициализация текстового поля для результата*/
        checkingInput = new CheckingInput();
        /*Создание экземпляра класса для проверки ввода*/
        chainShot = new ChainShot();
        /*Создание экземпляра класса для дешифрования текста*/
        fileSaveDialogExample = new FileSaveDialogExample();
        /*Создание экземпляра класса для сохранения файла*/
    }

    /*Метод для проверки корректности ввода ключа и текста для расшифровки*/
    public void deciferCheck() {
        /*Получаем ключ и текст из текстовых полей*/
        String key = tfKeyword.getText();
        /*Получаем ключ из текстового поля tfKeyword*/
        String text = textCode.getText();
        /*Получаем текст из текстового поля textCode*/

        /*Проверяем, совпадает ли ключ с текстом*/
        if (!checkingInput.checkKeyword(key, text)) {
            /*Если ключ не совпадает с текстом, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Не правильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверяем, есть ли несуществующие символы в тексте*/
            if (checkingInput.checkTextAlphabet(key, text)) {
                /*Если в тексте есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Не существующие символы в строке!!!");
            } else {
                /*Проверяем, есть ли несуществующие символы в ключе*/
                if (checkingInput.checkKeyAlphabet(key, text)) {
                    /*Если в ключе есть несуществующие символы, выводим сообщение об ошибке*/
                    JOptionPane.showMessageDialog(null, "Error: Не существующие символы в ключе!!!");
                } else {
                    /*Если ключ и текст прошли все проверки, дешифруем текст*/
                    String decodedText = decryptText(text, key);
                    /*Выводим дешифрованный текст в текстовое поле*/
                    textResult.setText(decodedText);
                }
            }
        }
    }

    /*Метод для проверки корректности ключа и расшифровки изображения*/
    public void dencryptCheckImage() {
        /*Получаем ключ из текстового поля tfKeyword*/
        String key = tfKeyword.getText();

        String outputDirectoryPathImage = "output_image/";
        /*Путь к каталогу для сохранения изображений*/

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(key, outputDirectoryPathImage) || key.length() == 0) {
            /*Если ключ не соответствует тексту или пустой, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в ключе*/
            if (checkingInput.checkKeyAlphabet(key, outputDirectoryPathImage)) {
                /*Если в ключе есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePath = fileSaveDialogExample.fileChooserGUI();
                /*Открываем диалоговое окно для выбора файла*/
                if (filePath != null) {
                    decodeAndSaveFilesImage(filePath, key, outputDirectoryPathImage);
                    /*Расшифровываем и сохраняем изображение*/
                    JOptionPane.showMessageDialog(null, "Изображение расшифровано. Обновите панель!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Загрузите файл с шифром!!!");
                }
            }
        }
    }

    /*Метод для проверки корректности ключа и расшифровки аудио*/
    public void dencryptCheckAudio() {
        /*Получаем ключ из текстового поля tfKeyword*/
        String keyword = tfKeyword.getText();
        String outputDirectoryPathAudio = "output_audio/";
        /*Путь к каталогу для сохранения аудио файлов*/

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(keyword, outputDirectoryPathAudio) || keyword.length() == 0) {
            /*Если ключ не соответствует тексту или пустой, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в ключе*/
            if (checkingInput.checkKeyAlphabet(keyword, outputDirectoryPathAudio)) {
                /*Если в ключе есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePathAudio = fileSaveDialogExample.fileChooserGUI();
                /*Открываем диалоговое окно для выбора файла*/
                if (filePathAudio != null) {
                    decodeAndSaveFilesAudio(filePathAudio, keyword, outputDirectoryPathAudio);
                    /*Расшифровываем и сохраняем аудио файл*/
                    JOptionPane.showMessageDialog(null, "Аудио расшифровано.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Загрузите файл с шифром!!!");
                }
            }
        }
    }

    /*Метод для проверки корректности ключа и расшифровки видео*/
    public void dencryptCheckVideo() {
        /*Получаем ключ из текстового поля tfKeyword*/
        String keyword = tfKeyword.getText();
        String outputDirectoryPathVideo = "output_video/";
        /*Путь к каталогу для сохранения видео файлов*/

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(keyword, outputDirectoryPathVideo) || keyword.length() == 0) {
            /*Если ключ не соответствует тексту или пустой, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в ключе*/
            if (checkingInput.checkKeyAlphabet(keyword, outputDirectoryPathVideo)) {
                /*Если в ключе есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePathVideo = fileSaveDialogExample.fileChooserGUI();
                /*Открываем диалоговое окно для выбора файла*/
                if (filePathVideo != null) {
                    decodeAndSaveFilesVideo(filePathVideo, keyword, outputDirectoryPathVideo);
                    /*Расшифровываем и сохраняем видео файл*/
                    JOptionPane.showMessageDialog(null, "Видео расшифровано.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Загрузите файл с шифром!!!");
                }
            }
        }
    }

    /*Считывание файла с шифром для видео*/
    public static void decodeAndSaveFilesVideo(String filePath, String keyword, String outputDirectoryPathVideo){
        /*Флаг для проверки, были ли использованы все возможные имена файлов*/
        boolean allFileNamesUsed = false;
        /*Флаг для контроля остановки декодирования*/
        boolean stop = false;
        /*Переменные для хранения пути к выходному файлу и имени файла*/
        String outputImagePath = null;
        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder currentString = new StringBuilder();
            /*Создаем StringBuilder для хранения текущей строки из файла*/
            int character;
            /*Переменная для хранения текущего символа из файла*/
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            /*Создаем ByteArrayOutputStream для записи данных*/

            /*Генерируем уникальное имя файла*/
            outputImagePath = generateUniqueFileName();
            if(outputImagePath == null){
                System.out.println("Имя файла из всех возможных вариантов были использованы.");
            } else {
                FileOutputStream fos = new FileOutputStream(outputDirectoryPathVideo+outputImagePath+".mp4"); // Создаем FileOutputStream для записи видео в файл
                while ((character = reader.read()) != -1) {
                    /*Читаем файл посимвольно*/
                    if (character == '⑳'||character == 'Ⓝ') {
                        /*Если встречаем маркер окончания блока*/
                        String result = String.valueOf(currentString);
                        /*Получаем строку из StringBuilder*/
                        if (result.contains(String.valueOf("⋆"))) {
                            /*Если в строке содержится маркер окончания декодирования*/
                            stop = true;
                            /*Устанавливаем флаг остановки декодирования*/
                        }
                        if(character != 'Ⓝ'){
                            /*Если не достигнут конец файла*/
                            int[] intArrayToMP4 = decryptVideo(keyword, result);
                            /*Декодируем строку в массив интов для видео*/
                            for (int num : intArrayToMP4) {
                                /*Проходим по всему массиву интов*/
                                byteArrayOutputStream.write((byte) num);
                                /*Записываем данные в ByteArrayOutputStream*/
                            }
                            fos.write(byteArrayOutputStream.toByteArray());
                            /*Записываем данные из ByteArrayOutputStream в файл*/
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            /*Создаем новый ByteArrayOutputStream для следующего блока данных*/
                            currentString.setLength(0);
                            /*Очищаем StringBuilder для следующей строки*/
                        } else {
                            /*Если достигнут конец файла*/
                            int[] intArrayToMP4 = decryptVideo(keyword, result);
                            /*Декодируем строку в массив интов для видео*/
                            for (int num : intArrayToMP4) {
                                /*Проходим по всему массиву интов*/
                                byteArrayOutputStream.write((byte) num);
                                /*Записываем данные в ByteArrayOutputStream*/
                            }
                            fos.write(byteArrayOutputStream.toByteArray());
                            /*Записываем данные из ByteArrayOutputStream в файл*/
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            /*Создаем новый ByteArrayOutputStream для следующего блока данных*/
                            fos.close();
                            /*Закрываем FileOutputStream*/
                            System.gc();
                            /*Вызываем сборщик мусора*/
                            currentString.setLength(0);
                            /*Очищаем StringBuilder для следующей строки*/

                            /*Генерируем новое уникальное имя файла*/
                            fileName = generateUniqueFileName();
                            if (fileName != null && stop == false) {
                                /*Если не достигнут конец файла*/
                                fos = new FileOutputStream(outputDirectoryPathVideo+fileName+".mp4");
                                /*Создаем новый FileOutputStream для следующего файла*/
                            } else if(fileName == null){
                                /*Если достигнут предел уникальных имен файлов*/
                                allFileNamesUsed = true;
                                /*Устанавливаем флаг, что были использованы все возможные имена файлов*/
                                System.out.println("Имя файла из всех возможных вариантов были использованы.");
                                break;
                                /*Выходим из цикла*/
                            }
                            currentString.setLength(0);
                            /*Очищаем StringBuilder для следующей строки*/
                        }
                    } else {
                        currentString.append((char) character);
                        /*Добавляем символ к текущей строке*/
                    }
                }
            }
            /*Обработка последней строки, если выход из цикла не произошел*/
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла");
        }

        if (allFileNamesUsed) {
            /*Если были использованы все возможные имена файлов*/
            System.exit(0);
            /*Завершаем программу*/
        }
    }

    /*Метод для дешифровки аудиофайлов и их сохранения*/
    public static void decodeAndSaveFilesAudio(String filePath, String keyword, String outputDirectoryPathVideo){
        /*Инициализация флагов для проверки использования всех имён файлов и остановки*/
        boolean allFileNamesUsed = false;
        boolean stop = false;
        String outputAudioPath =null;
        /*Путь к выходному аудиофайлу*/
        String fileName = null;
        /*Имя файла*/

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder currentString = new StringBuilder();
            /*Инициализация строки для хранения текущего содержимого файла*/
            int character;
            /*Переменная для хранения текущего символа*/
            /*Создаем объект AudioFormat на основе ваших параметров аудио*/
            AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, false);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            /*Поток для записи байтов аудиофайла*/
            outputAudioPath = generateUniqueFileName();
            /*Генерация уникального имени для выходного файла*/

            if(outputAudioPath == null){
                System.out.println("Имя файла из всех возможных вариантов были использованы.");
            } else {
                /*Чтение файла посимвольно*/
                while ((character = reader.read()) != -1) {
                    if (character == '⑳'||character == 'Ⓝ') {
                        String result = String.valueOf(currentString);
                        /*Преобразование текущей строки в строку*/
                        if (result.contains(String.valueOf("⋆"))) {
                            stop = true;
                            /*Проверка на остановку*/
                        }
                        if(character != 'Ⓝ'){
                            /*Если символ не является 'Ⓝ'*/
                            int[] intArrayToMP4 = decryptVideo(keyword, result);
                            /*Расшифровка видео*/
                            for (int num : intArrayToMP4) {
                                byteArrayOutputStream.write((byte) num);
                                /*Запись расшифрованных байтов*/
                            }
                            byteArrayOutputStream.toByteArray();
                            /*Преобразование буфера в массив байтов*/
                            currentString.setLength(0);
                            /*Очистка текущей строки*/
                        } else {
                            int[] intArrayToMP4 = decryptVideo(keyword, result);
                            /*Расшифровка видео*/
                            for (int num : intArrayToMP4) {
                                byteArrayOutputStream.write((byte) num);
                                /*Запись расшифрованных байтов*/
                            }

                            int startIndex = result.indexOf("⁂") + 1;
                            /*Получение индекса начала второй части строки*/
                            String subString = result.substring(startIndex);
                            /*Получение подстроки после разделителя*/
                            String[] numbers = subString.split("\\⁂");
                            /*Разделение подстроки*/
                            int secondNumber = Integer.valueOf(numbers[1]);
                            /*Преобразование второго числа в целочисленное значение*/

                            byteArrayOutputStream.toByteArray();
                            /*Преобразование буфера в массив байтов*/

                            /*Создание объекта AudioInputStream из массива байтов*/
                            AudioInputStream audioInputStream = new AudioInputStream(
                                    new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray()),
                                    audioFormat,
                                    byteArrayOutputStream.toByteArray().length / audioFormat.getFrameSize()
                            );
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            /*Очистка буфера*/

                            System.gc();
                            /*Вызов сборщика мусора*/
                            currentString.setLength(0);
                            /*Очистка текущей строки*/

                            fileName = generateUniqueFileName();
                            /*Генерация уникального имени файла*/
                            if (fileName != null && stop == false) {
                                String outputAudio = "temporary_store_audio\\2.wav";
                                /*Путь для временного сохранения аудиофайла*/
                                File outputFile = new File(outputAudio);
                                /*Создание объекта файла*/

                                /*Запись AudioInputStream в файл*/
                                try {
                                    AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);

                                    if (secondNumber == 1) {
                                        moveAndRenameFile(outputAudio, outputDirectoryPathVideo + fileName + ".wav");
                                        /*Перемещение и переименование файла*/
                                    } else if (secondNumber == 2) {
                                        convertWavToMp3(outputAudio, outputDirectoryPathVideo + fileName + ".mp3");
                                        /*Конвертация в MP3 и удаление временных файлов*/
                                        Runtime.getRuntime().gc();
                                        /*Вызов сборщика мусора*/
                                        fileSaveDialogExample.deleteAllFiles();
                                        /*Удаление всех файлов*/
                                    }

                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                    /*Выброс исключения в случае ошибки*/
                                }
                            } else if(fileName == null){
                                allFileNamesUsed = true;
                                /*Использованы все возможные имена файлов*/
                                System.out.println("Имя файла из всех возможных вариантов были использованы.");
                                break;
                                /*Выход из цикла*/
                            }
                            currentString.setLength(0);
                            /*Очистка текущей строки*/
                        }
                    } else {
                        currentString.append((char) character);
                        /*Добавление символа к текущей строке*/
                    }
                }
            }
            /*Обработка последней строки, если выход из цикла не произошел*/
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла");
            /*Вывод сообщения об ошибке*/
        }

        if (allFileNamesUsed) {
            System.exit(0);
            /*Завершение программы*/
        }
    }

    /*Метод для конвертации аудиофайла из WAV в MP3 формат*/
    private static void convertWavToMp3(String wavFilePath, String mp3FilePath) {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(wavFilePath))) {
            /*Получение формата исходного аудиофайла*/
            AudioFormat sourceFormat = audioInputStream.getFormat();

            /*Создание формата для конвертирования аудиофайла в PCM_SIGNED*/
            AudioFormat convertFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    sourceFormat.getSampleRate(), 16, sourceFormat.getChannels(),
                    sourceFormat.getChannels() * 2, sourceFormat.getSampleRate(), false);

            try (AudioInputStream convertedStream = AudioSystem.getAudioInputStream(convertFormat, audioInputStream)) {

                /*Установка формата кодека для MP3*/
                AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                        sourceFormat.getSampleRate(), 16, 1, 2, sourceFormat.getSampleRate(), false);

                try (AudioInputStream mp3Stream = AudioSystem.getAudioInputStream(targetFormat, convertedStream)) {

                    /*Запись аудиофайла в формате MP3*/
                    AudioSystem.write(mp3Stream, AudioFileFormat.Type.WAVE, new File(mp3FilePath));

                }
            }

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
            /*Обработка и вывод исключений*/
        }
    }

    /*Метод для перемещения и переименования файла*/
    public static void moveAndRenameFile(String sourcePath, String newFolderPathAndName) {
        try {
            /*Создание объекта File для исходного файла*/
            File sourceFile = new File(sourcePath);

            /*Разделение нового пути и имени файла*/
            String[] parts = newFolderPathAndName.split("/");
            String newFolder = parts[0];
            String newFileName = parts[1];

            /*Создание объекта Path для нового пути и имени файла*/
            Path newPath = Paths.get(newFolder, newFileName);

            /*Перемещение и переименование файла*/
            Files.move(sourceFile.toPath(), newPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            /*Обработка и вывод исключений*/
        }
    }

    /*Метод для расшифровки видео*/
    private static int[] decryptVideo(String keyword, String result) {
        int startIndex = 0;
        /*Инициализация переменной для индекса начала подстроки для дешифровки*/
        String subString = null;
        /*Инициализация переменной для хранения подстроки результата*/
        int firstNumber = 0;
        /*Инициализация переменной для хранения первого числа*/
        String substringBeforePlus = null;
        /*Инициализация переменной для хранения подстроки до разделителя*/

        /*Проверка наличия разделителя в строке результата*/
        if (result.contains(String.valueOf('⁂'))) {
            startIndex = result.indexOf("⁂") + 1;
            /*Находим индекс начала подстроки для дешифровки*/
            subString = result.substring(startIndex);
            /*Получаем подстроку после разделителя*/
            String[] numbers = subString.split("\\⁂");
            /*Разделяем подстроку на числа*/
            firstNumber = Integer.valueOf(numbers[0]);
            /*Получаем первое число*/

            /*Получение подстроки до разделителя*/
            int index = result.indexOf("⁂");
            substringBeforePlus = index != -1 ? result.substring(0, index).trim() : result.trim();
        } else {
            firstNumber = 0;
            /*Если разделитель отсутствует, первое число равно нулю*/
            substringBeforePlus = result;
            /*Подстрока до разделителя равна всей строке*/
        }

        /*Вычисление длины строки для расшифровки*/
        int lengthDecryptionCipher = substringBeforePlus.length();

        /*Создание массива символов для строки*/
        char[] charArrayDecryptionCipher = new char[lengthDecryptionCipher];

        /*Заполнение массива символами из строки*/
        for (int i = 0; i < lengthDecryptionCipher; i++) {
            charArrayDecryptionCipher[i] = substringBeforePlus.charAt(i);
        }

        /*Получение длины ключевого слова*/
        int lengthKeyword = keyword.length();
        char[] charArrayKeyword = new char[lengthKeyword];

        /*Создание массива символов для ключевого слова*/
        for (int i = 0; i < lengthKeyword; i++) {
            charArrayKeyword[i] = keyword.charAt(i);
        }

        /*Вычисление размера массива числовых значений символов ключевого слова*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);

        /*Создание объекта для преобразования символов в числа*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);

        /*Получение числовых значений алфавита*/
        int[] intergersAlphabetArray = convertingCharactersToNumbers.alphabetArray();

        /*Вычисление детерминанта матрицы*/
        AlgebraicCofactorMatrix matrixDeterminant = new AlgebraicCofactorMatrix(convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant());
        int conditionDeterminant = matrixDeterminant.calculation(convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant());

        /*Получение числа для модульной арифметики*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        ChainShot chainShot = new ChainShot();
        int theNumberModulo = chainShot.getMyField(conditionDeterminant, numberInStorage);

        /*Получение алгебраических дополнений матрицы*/
        AlgebraicCofactorMatrix algebraicCofactorMatrix = new AlgebraicCofactorMatrix(convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant());
        int[][] arraAddition = algebraicCofactorMatrix.getMatrix1(convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant());

        /*Умножение матрицы на число*/
        int[][] resultMatrixByNumber = chainShot.multiplicationMatrixByNumber(arraAddition, numberInStorage, theNumberModulo);
        int[] arrayOfText1 = new int[arrayNumKey];

        /*Вычисление размерности*/
        int dimension1 = intergersAlphabetArray.length % arrayNumKey != 0 ?
                intergersAlphabetArray.length + (arrayNumKey - intergersAlphabetArray.length % arrayNumKey) :
                intergersAlphabetArray.length;

        int[] colorBar = new int[lengthDecryptionCipher + firstNumber];
        int j = 0;

        /*Цикл для расшифровки данных*/
        for (int m = 0; m < dimension1; m += arrayNumKey) {
            int elementsToCopy1 = Math.min(arrayNumKey, dimension1 - m);

            /*Начальная итерация для копирования значений из intergersAlphabetArray в arrayOfText1*/
            for (int l = 0; l < elementsToCopy1; l++) {
                arrayOfText1[l] = intergersAlphabetArray[m + l];
            }

            /*Умножение матрицы на вектор*/
            int[] arrayMatrixRGB = chainShot.multiplyingMatrixByMatrixMedia(resultMatrixByNumber, arrayOfText1, numberInStorage, arrayNumKey);

            /*Заполнение массива чисел для расшифровки*/
            for (int i = 0; i < arrayNumKey; i++, j++) {
                colorBar[j] = arrayMatrixRGB[i];
            }
        }

        return colorBar;
        /*Возвращаем массив чисел для расшифровки*/
    }


    /*Метод для расшифровки текста*/
    public static String decryptText(String decryptionCipher, String keyword){
        /*Вычисляем длину строки decryptionCipher*/
        int lengthDecryptionCipher = decryptionCipher.length();
        /*Создаем массив символов для строки decryptionCipher*/
        char[] charArrayDecryptionCipher = new char[lengthDecryptionCipher];
        /*Заполняем массив charArrayDecryptionCipher символами из decryptionCipher*/
        for (int i = 0; i < lengthDecryptionCipher; i++) {
            charArrayDecryptionCipher[i] = decryptionCipher.charAt(i);
        }

        int lengthKeyword = keyword.length();
        /*Вычисляем длину ключевого слова keyword*/
        int squareRoot1 = (int) Math.sqrt(lengthKeyword);
        /*Вычисляем квадратный корень от длины ключевого слова*/
        char[] charArrayKeyword = new char[lengthKeyword];
        /*Создаем массив символов для ключевого слова keyword*/
        /*Заполняем массив charArrayKeyword символами из keyword*/
        for (int i = 0; i < lengthKeyword; i++) {
            charArrayKeyword[i] = keyword.charAt(i);
        }
        /*Вычисляем размер массива для числовых значений символов ключевого слова*/
        int arrayNumKey =  (int)Math.sqrt(charArrayKeyword.length);
        /*
        *Создаем объект ConvertingCharactersToNumbers для преобразования символов
        *ключевого слова и строки в числа
        */
        ConvertingCharactersToNumbers convertingCharactersToNumbers =new ConvertingCharactersToNumbers(charArrayKeyword,
                arrayNumKey, charArrayDecryptionCipher);
        /*Создаём матрицы для ключа и строки текста*/
        int[][] intergers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
        int[] intergersAlphabetArray = convertingCharactersToNumbers.alphabetArray();
        /*Находим алгебраическое дополнение*/
        AlgebraicCofactorMatrix matrixDeterminant = new AlgebraicCofactorMatrix(intergers);
        /*Вызываем метод для определения размера алфавита*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        /*Вычисляем определителя матрицы ключа*/
        int conditionDeterminant = matrixDeterminant.calculation(intergers);
        /*Создаем объект ChainShot для работы с шифрованными данными, передавая детерминант и число в хранилище*/

        /*Получаем обратное значение определителя матрицы ключа по модулю*/
        int theNumberModulo = chainShot.getMyField(conditionDeterminant, numberInStorage);

        /*Создаем объект AlgebraicCofactorMatrix для работы с алгебраическими дополнениями матрицы, передавая матрицу intergers*/
        AlgebraicCofactorMatrix algebraicCofactorMatrix = new AlgebraicCofactorMatrix(intergers);

        /*Получаем матрицу алгебраических дополнений*/
        int[][] arraAddition = algebraicCofactorMatrix.getMatrix1(intergers);

        /*Получаем результат умножения матрицы на число*/
        int[][] resultMatrixByNumber = chainShot.multiplicationMatrixByNumber(arraAddition, numberInStorage, theNumberModulo);

        /*Создаем массив arrayOfText1 для хранения чисел, которые будут преобразованы в текст*/
        int[] arrayOfText1 = new int[arrayNumKey];

        /*Вычисляем остаток от деления длины массива intergersAlphabetArray на ArrayNumKey*/
        int remains1 = intergersAlphabetArray.length % arrayNumKey;

        /*Вычисляем размерность (dimension1) для последующего расшифрования*/
        int dimension1;

        /*Если остаток от деления не равен нулю, увеличиваем размерность до ближайшего кратного ArrayNumKey числа*/
        if (remains1 != 0) {
            dimension1 = intergersAlphabetArray.length + (arrayNumKey - remains1);
        } else {
            /*Иначе, оставляем размерность без изменений*/
            dimension1 = intergersAlphabetArray.length;
        }

        int number = lengthDecryptionCipher%squareRoot1;
        int roundedUpInteger = 0;
        int whole = lengthDecryptionCipher/squareRoot1;
        if(number == 0){
            roundedUpInteger = whole;
        }else{
            roundedUpInteger = whole+1;
        }
        String []resultArray = new String [roundedUpInteger];
        for (int m = 0, g = 0; m < dimension1; m += arrayNumKey, g++){
            /*Вычисляем количество элементов, которые нужно скопировать на текущей итерации*/
            int elementsToCopy1 = Math.min(arrayNumKey, dimension1 - m);

            /*Начинаем цикл для копирования значений из intergersAlphabetArray в arrayOfText1*/
            for (int l = 0; l < elementsToCopy1; l++) {
                /*Проверяем, вышли ли за пределы массива intergersAlphabetArray*/
                if (m + l >= intergersAlphabetArray.length) {
                    /*Если вышли за пределы массива, устанавливаем значение 35 (ASCII-код символа '#')*/
                    arrayOfText1[l] = 35;
                } else {
                    /*Иначе, копируем значение из intergersAlphabetArray в arrayOfText1*/
                    arrayOfText1[l] = intergersAlphabetArray[m + l];
                }
            }
            char[] arrayMatrix1 = chainShot.multiplyingMatrixByMatrix(resultMatrixByNumber,
                    arrayOfText1, numberInStorage, arrayNumKey);
            /*Инициализация объекта StringBuilder для построения строки*/
            StringBuilder stringBuilder = new StringBuilder();

            /*Объединение элементов массива в строку с разделителем*/
            for (char c : arrayMatrix1) {
                stringBuilder.append(c);
            }

            /*Получение результирующей строки*/
            String resultString = stringBuilder.toString();
            resultArray[g] = resultString;

        }

        /*Создаем объект StringBuilder для объединения элементов массива*/
        StringBuilder str = new StringBuilder();

        /*Объединение элементов массива в строку с разделителем (пустой строкой)*/
        for (String c : resultArray) {
            str.append(c);
        }

        /*Получение результирующей строки*/
        String resultString = str.toString();
        return resultString;

    }

    /*Метод для декодирования и сохранения файлов изображений*/
    public static void decodeAndSaveFilesImage(String filePath, String keyword, String outputDirectoryPathImage){
        /*Флаг, указывающий, использованы ли все имена файлов*/
        boolean allFileNamesUsed = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            /*StringBuilder для построения текущей строки*/
            StringBuilder currentString = new StringBuilder();
            int character;
            /*Поток для записи байтов*/
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            /*Матрица цветов изображения*/
            Color[][] colorNum = new Color[0][0];
            /*Чтение файла посимвольно*/
            while ((character = reader.read()) != -1) {
                /*Проверка на символы-разделители*/
                if (character == '⑳' || character == 'Ⓝ') {
                    String result = String.valueOf(currentString);
                    if (character != 'Ⓝ') {
                        /*Дешифрование изображения*/
                        int[] intArrayToMP4 = decryptImage(keyword, result, 0);
                        /*Запись в буфер*/
                        for (int num : intArrayToMP4) {
                            byteArrayOutputStream.write((byte) num);
                        }
                        currentString.setLength(0);
                    } else {
                        /*Генерация уникального имени файла*/
                        String outputImagePath = generateUniqueFileName();
                        if (outputImagePath != null) {
                            /*Извлечение информации о размерах изображения из строки*/
                            int startIndex = result.indexOf("⁂") + 1;
                            String subString = result.substring(startIndex);
                            String[] numbers = subString.split("\\⁂");
                            int firstNumber = Integer.valueOf(numbers[0]);
                            int secondNumber = Integer.valueOf(numbers[1]);
                            int thirdNumber = Integer.valueOf(numbers[2]);

                            /*Обрезка строки до первого символа-разделителя*/
                            String substringBeforePlus = cutString(result, subString.length() + 1);
                            /*Дешифрование изображения с учетом смещения*/
                            int[] intArrayToMP4 = decryptImage(keyword, substringBeforePlus, firstNumber);
                            for (int num : intArrayToMP4) {
                                byteArrayOutputStream.write((byte) num);
                            }

                            /*Создание матрицы цветов из байтов*/
                            colorNum = new Color[secondNumber][thirdNumber];
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            int l = 0;
                            for (int y = 0; y < thirdNumber; y++) {
                                for (int x = 0; x < secondNumber; x++) {
                                    byte[] rgb = new byte[3];
                                    System.arraycopy(byteArray, l, rgb, 0, 3);
                                    int newRed = rgb[0] & 0xFF;
                                    int newGreen = rgb[1] & 0xFF;
                                    int newBlue = rgb[2] & 0xFF;
                                    Color newColorChanged = new Color(newRed, newGreen, newBlue);
                                    colorNum[x][y] = newColorChanged;
                                    l += 3;
                                }
                            }

                            /*Создание изображения из матрицы цветов*/
                            BufferedImage image1 = new BufferedImage(secondNumber, thirdNumber, BufferedImage.TYPE_INT_RGB);
                            for (int y = 0; y < thirdNumber; y++) {
                                for (int x = 0; x < secondNumber; x++) {
                                    /*Получение цвета из матрицы*/
                                    Color pixelColor = colorNum[x][y];
                                    /*Установка цвета пикселя*/
                                    image1.setRGB(x, y, pixelColor.getRGB());
                                }
                            }
                            /*Запись изображения в файл*/
                            File outputImageFile = new File(outputDirectoryPathImage + outputImagePath + ".jpg");
                            try {
                                ImageIO.write(image1, "jpg", outputImageFile);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            /*Очистка буфера и строки*/
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            System.gc();
                            currentString.setLength(0);
                        } else {
                            allFileNamesUsed = true;
                            System.out.println("Имя файла из всех возможных вариантов были использованы.");
                            break;
                            /*Выход из цикла*/
                        }
                        currentString.setLength(0);
                    }
                } else {
                    currentString.append((char) character);
                }
            }
            /*Обработка последней строки, если выход из цикла не произошел*/
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла");
        }

        /*Если все имена файлов использованы, завершаем программу*/
        if (allFileNamesUsed) {
            System.exit(0);
        }
    }

    /*Метод для дешифрования изображения*/
    private static int[] decryptImage(String keyword, String substringBeforePlus, int firstNumber){

        /*Получение длины строки дешифровки*/
        int lengthDecryptionCipher = substringBeforePlus.length();
        /*Создаем массив символов для строки дешифровки*/
        char[] charArrayDecryptionCipher = new char[lengthDecryptionCipher];
        /*Заполняем массив charArrayDecryptionCipher символами из строки дешифровки*/
        for (int i = 0; i < lengthDecryptionCipher; i++) {
            charArrayDecryptionCipher[i] = substringBeforePlus.charAt(i);
        }

        /*Получение длины ключевого слова*/
        int lengthKeyword = keyword.length();
        /*Вычисляем квадратный корень от длины ключевого слова*/
        int squareRoot1 = (int) Math.sqrt(lengthKeyword);
        /*Создаем массив символов для ключевого слова*/
        char[] charArrayKeyword = new char[lengthKeyword];
        /*Заполняем массив charArrayKeyword символами из keyword*/
        for (int i = 0; i < lengthKeyword; i++) {
            charArrayKeyword[i] = keyword.charAt(i);
        }
        /*Вычисляем размер массива для числовых значений символов ключевого слова*/
        int arrayNumKey =  (int)Math.sqrt(charArrayKeyword.length);
        /*
        *Создаем объект ConvertingCharactersToNumbers для преобразования символов
        *ключевого слова и строки в числа
        */
        ConvertingCharactersToNumbers convertingCharactersToNumbers =new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);
        /*Получаем числовые значения символов из ключевого слова*/
        int[][] intergers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
        /*Получаем числовые значения алфавита*/
        int[] intergersAlphabetArray = convertingCharactersToNumbers.alphabetArray();
        /*Создаем объект AlgebraicCofactorMatrix для вычисления детерминанта матрицы*/
        AlgebraicCofactorMatrix matrixDeterminant = new AlgebraicCofactorMatrix(intergers);
        /*Вычисляем детерминант матрицы*/
        int conditionDeterminant = matrixDeterminant.calculation(intergers);
        /*Получаем размер хранилища*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        /*Получаем значение для модульной арифметики*/
        int theNumberModulo = chainShot.getMyField(conditionDeterminant, numberInStorage);

        /*Создаем объект AlgebraicCofactorMatrix для работы с алгебраическими дополнениями матрицы*/
        AlgebraicCofactorMatrix algebraicCofactorMatrix = new AlgebraicCofactorMatrix(intergers);
        /*Получаем матрицу алгебраических дополнений*/
        int[][] arraAddition = algebraicCofactorMatrix.getMatrix1(intergers);

        /*Получаем результат умножения матрицы на число*/
        int[][] resultMatrixByNumber = chainShot.multiplicationMatrixByNumber(arraAddition, numberInStorage, theNumberModulo);
        /*Создаем массив для хранения чисел, которые будут преобразованы в текст*/
        int[] arrayOfText1 = new int[arrayNumKey];

        /*Вычисляем остаток от деления длины массива intergersAlphabetArray на ArrayNumKey*/
        int remains1 = intergersAlphabetArray.length % arrayNumKey;
        /*Вычисляем размерность (dimension1) для последующего расшифрования*/
        int dimension1;

        /*Если остаток от деления не равен нулю, увеличиваем размерность до ближайшего кратного ArrayNumKey числа*/
        if (remains1 != 0) {
            dimension1 = intergersAlphabetArray.length + (arrayNumKey - remains1);
        } else {
            /*Иначе, оставляем размерность без изменений*/
            dimension1 = intergersAlphabetArray.length;
        }

        int[] colorBar = new int[lengthDecryptionCipher+firstNumber];
        int j = 0;

        for (int m = 0, g = 0; m < dimension1; m += arrayNumKey, g++){
            /*Вычисляем количество элементов, которые нужно скопировать на текущей итерации*/
            int elementsToCopy1 = Math.min(arrayNumKey, dimension1 - m);

            /*Начинаем цикл для копирования значений из intergersAlphabetArray в arrayOfText1*/
            for (int l = 0; l < elementsToCopy1; l++) {
                /*Проверяем, вышли ли за пределы массива intergersAlphabetArray*/
                if (m + l >= intergersAlphabetArray.length) {
                    /*Если вышли за пределы массива, устанавливаем значение 35 (ASCII-код символа '#')*/
                    arrayOfText1[l] = 35;
                } else {
                    /*Иначе, копируем значение из intergersAlphabetArray в arrayOfText1*/
                    arrayOfText1[l] = intergersAlphabetArray[m + l];
                }
            }
            /*Вызов метода multiplyingMatrixByMatrixMedia для вычисления значений матрицы RGB*/
            int[] arrayMatrixRGB = chainShot.multiplyingMatrixByMatrixMedia(resultMatrixByNumber, arrayOfText1, numberInStorage, arrayNumKey);
            for (int i =0;i<arrayNumKey;i++,j++) {
                colorBar[j]=arrayMatrixRGB[i];
                /*Цикл для заполнения массива colorBar значениями из arrayMatrixRGB*/
            }

        }

        /*Вычисление нового размера массива newColorBar*/
        int newSize = lengthDecryptionCipher - firstNumber;
        /*Создание нового массива newColorBar с новым размером*/
        int[] newColorBar = new int[newSize];
        /*Копирование элементов из массива colorBar в newColorBar*/
        System.arraycopy(colorBar, 0, newColorBar, 0, newSize);

        /*Возвращение нового массива newColorBar*/
        return newColorBar;
    }

    /*Метод для генерации уникального имени файла*/
    public static String generateUniqueFileName() {
        String outputImageBaseName = null;
        /*Инициализация переменной для хранения имени файла*/
        Alphabet alphabet = new Alphabet();
        /*Создание объекта класса Alphabet для получения алфавита*/
        char[] charArray = alphabet.getAlphabetImageName();
        /*Получение массива символов алфавита*/

        Random random = new Random();
        /*Инициализация генератора случайных чисел*/
        StringBuilder randomNameBuilder = new StringBuilder();
        /*Создание объекта StringBuilder для построения случайного имени*/

        /*Генерация случайного имени из 7 символов*/
        for (int i = 0; i < 7; i++) {
            int randomIndex = random.nextInt(charArray.length);
            /*Генерация случайного индекса в пределах длины массива символов*/
            randomNameBuilder.append(charArray[randomIndex]);
            /*Добавление случайного символа к имени*/
        }

        outputImageBaseName = randomNameBuilder.toString();
        /*Преобразование StringBuilder в строку и сохранение имени файла*/

        int attempt = 0;
        /*Переменная для отслеживания числа попыток*/
        boolean isUnique = false;
        /*Флаг, указывающий, найдено ли уникальное имя файла*/
        while (!isUnique && attempt < max_attempt) {
            /*Цикл проверки уникальности имени файла*/
            File outputFile = new File(outputImageBaseName);
            /*Создание объекта File для проверки существования файла*/
            if (!outputFile.exists()) {
                /*Если файл не существует*/
                isUnique = true;
                /*Устанавливаем флаг уникальности*/
            }
            attempt++;
            /*Увеличение числа попыток*/
        }

        return outputImageBaseName;
        /*Возвращение уникального имени файла*/
    }

    /*Метод для обрезания строки до определенной длины*/
    public static String cutString(String s, int n) {
        return s.substring(0, s.length() - n);
        /*Возвращение подстроки из строки s, начиная с индекса 0 до s.length() - n*/
    }


}

package com.mycompany.stealthchatnew;

import javazoom.jl.converter.Converter;
/*Импорт класса Converter из библиотеки javazoom.jl для конвертации аудиофайлов*/
import javazoom.jl.decoder.JavaLayerException;
/*Импорт класса JavaLayerException из библиотеки javazoom.jl для обработки исключений при декодировании аудио*/
import javax.imageio.ImageIO;
/*Импорт класса ImageIO из библиотеки javax.imageio для работы с изображениями*/
import javax.sound.sampled.AudioInputStream;
/*Импорт класса AudioInputStream из библиотеки javax.sound.sampled для работы с аудиоданными ввода*/
import javax.sound.sampled.AudioSystem;
/*Импорт класса AudioSystem из библиотеки javax.sound.sampled для доступа к звуковой системе*/
import javax.sound.sampled.UnsupportedAudioFileException;
/*
*Импорт класса UnsupportedAudioFileException из библиотеки javax.sound.sampled
*для обработки исключений связанных с неподдерживаемыми аудиофайлами
 */
import javax.swing.*;
/*Импорт всех классов из пакета javax.swing для создания графического интерфейса пользователя (GUI)*/
import java.awt.*;
/*Импорт всех классов из пакета java.awt для создания графического интерфейса*/
import java.awt.image.BufferedImage;
/*Импорт класса BufferedImage из пакета java.awt.image для работы с изображениями*/
import java.io.*;
/*Импорт всех классов из пакета java.io для работы с потоками ввода-вывода*/
import java.nio.file.Files;
/*Импорт класса Files из пакета java.nio.file для работы с файловой системой*/
import java.nio.file.Path;
/*Импорт класса Path из пакета java.nio.file для работы с путями к файлам и каталогам*/
import java.nio.file.StandardCopyOption;
/*Импорт класса StandardCopyOption из пакета java.nio.file для определения стандартных опций копирования файлов*/
import java.util.Arrays;
/*Импорт класса Arrays для работы с массивами*/

public class EncryptFiles {
    private JTextField tfKeyword;
    /*Приватное поле для текстового поля ключа*/
    private JTextArea textPanel;
    /*Приватное поле для текстовой области ввода текста*/
    private JTextArea textResult;
    /*Приватное поле для текстовой области вывода результата*/
    private static CheckingInput checkingInput;
    /*Статическое поле для экземпляра класса CheckingInput, используемого для проверки ввода*/
    private static ChainShot chainShot;
    /*Статическое поле для экземпляра класса ChainShot, используемого для шифрования файлов*/
    private static FileSaveDialogExample fileSaveDialogExample;
    /*Статическое поле для экземпляра класса FileSaveDialogExample, используемого для сохранения файлов*/

    public EncryptFiles(JTextField tfKeyword, JTextArea textPanel, JTextArea textResult) {
        this.tfKeyword = tfKeyword;
        /*Присвоение переданного текстового поля ключа в поле класса*/
        this.textPanel = textPanel;
        /*Присвоение переданной текстовой области ввода текста в поле класса*/
        this.textResult = textResult;
        /*Присвоение переданной текстовой области вывода результата в поле класса*/
        checkingInput = new CheckingInput();
        /*Создание нового экземпляра CheckingInput и присвоение его статическому полю checkingInput*/
        chainShot = new ChainShot();
        /*Создание нового экземпляра ChainShot и присвоение его статическому полю chainShot*/
        fileSaveDialogExample = new FileSaveDialogExample();
        /*Создание нового экземпляра FileSaveDialogExample и присвоение его статическому полю fileSaveDialogExample*/
    }

    /*Метод для проверки корректности ввода ключа и текста для зашифровки и зашифровка текста*/
    public void encryptCheck() {
        /*Получаем ключ и текст из текстовых полей*/
        String key = tfKeyword.getText();
        /*Получаем ключ из текстового поля tfKeyword*/
        String text = textPanel.getText();
        /*Получаем текст из текстового поля textPanel*/

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(key, text)) {
            /*Если ключ не соответствует тексту, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в тексте*/
            if (checkingInput.checkTextAlphabet(key, text)) {
                /*Если в тексте есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в строке!!!");
            } else {
                /*Проверка наличия несуществующих символов в ключе*/
                if (checkingInput.checkKeyAlphabet(key, text)) {
                    /*Если в ключе есть несуществующие символы, выводим сообщение об ошибке*/
                    JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
                } else {
                    /*Если ключ и текст прошли все проверки, шифруем текст*/
                    String encodedText = encryptText(text, key);
                    /*Устанавливаем зашифрованный текст в текстовое поле textResult*/
                    textResult.setText(encodedText);
                }
            }
        }
    }

    /*Метод для зашифровки изображения и проверка ввода ключа*/
    public void encryptCheckImage() {
        /*Получаем ключ и текст из текстовых полей*/
        String key = tfKeyword.getText();
        /*Получаем ключ из текстового поля tfKeyword*/
        String inputFolderImage = "input_image/";
        File inputDirImage = new File(inputFolderImage);
        File[] inputFilesImage = inputDirImage.listFiles();

        /*Проверка пустоты папки*/
        if (inputFilesImage == null || inputFilesImage.length == 0) {
            JOptionPane.showMessageDialog(null, "Error: Загрузите изображение!!!");
            return;
            /*Выходим из метода, так как нет файлов для обработки*/
        }

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(key, inputFolderImage)||key.length() == 0) {
            /*Если ключ не соответствует тексту и его длина равна 0, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в тексте*/
            if (checkingInput.checkKeyAlphabet(key, inputFolderImage)) {
                /*Если в тексте есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePathImage = fileSaveDialogExample.getFileSavePath();

                int filesProcessedImage = 0;
                /*Переменная для отслеживания количества обработанных файлов*/
                for (File inputFileImage : inputFilesImage) {
                    if (inputFileImage.isFile()) {
                        encryptImage(key, inputFileImage.getAbsolutePath(), filePathImage);
                        filesProcessedImage++;
                        /*Увеличиваем счетчик обработанных файлов*/
                        if (filesProcessedImage < inputFilesImage.length) {
                            /*Если текущий файл не последний в массиве, вызываем метод writeToFile("Ⓝ")*/
                            writeToFile("Ⓝ", filePathImage);
                        } else {
                            writeToFile("Ⓝ ", filePathImage);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Файл готов");
            }
        }
    }

    /*Зашифровка видео и проверки ввода ключа*/
    public void encryptCheckVideo() {
        /*Получаем ключ и текст из текстовых полей*/
        String keyword = tfKeyword.getText();
        String inputFolderVideo = "input_video/";
        File inputDirVideo = new File(inputFolderVideo);
        File[] inputFilesVideo = inputDirVideo.listFiles();

        /*Проверка пустоты папки*/
        if (inputFilesVideo == null || inputFilesVideo.length == 0) {
            JOptionPane.showMessageDialog(null, "Error: Загрузите видео!!!");
            return;
            /*Выходим из метода, так как нет файлов для обработки*/
        }

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(keyword, inputFolderVideo)||keyword.length() == 0) {
            /*Если ключ не соответствует тексту и его длина равна 0, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в тексте*/
            if (checkingInput.checkKeyAlphabet(keyword, inputFolderVideo)) {
                /*Если в тексте есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePathVideo = fileSaveDialogExample.getFileSavePath();

                int filesProcessedVideo = 0;
                /*Переменная для отслеживания количества обработанных файлов*/
                for (File inputFileVideo : inputFilesVideo) {
                    if (inputFileVideo.isFile()) {
                        encryptVideo(keyword, inputFileVideo.getAbsolutePath(), filePathVideo);
                        filesProcessedVideo++;
                        /*Увеличиваем счетчик обработанных файлов*/
                        if (filesProcessedVideo < inputFilesVideo.length) {
                            /*Если текущий файл не последний в массиве, вызываем метод writeToFile("Ⓝ")*/
                            writeToFile("Ⓝ", filePathVideo);
                        }else {
                            writeToFile("⋆Ⓝ ", filePathVideo);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Файл готов");
            }
        }
    }

    /*Зашифровка аудио файлов и проверки ввода ключа*/
    public void encryptCheckAudio() {
        /*Получаем ключ и текст из текстовых полей*/
        String keyword = tfKeyword.getText();
        String inputFolderAudio = "input_audio/";
        File inputDirAudio = new File(inputFolderAudio);
        File[] inputFilesAudio = inputDirAudio.listFiles();

        /*Проверка пустоты папки*/
        if (inputFilesAudio == null || inputFilesAudio.length == 0) {
            JOptionPane.showMessageDialog(null, "Error: Загрузите аудио!!!");
            return;
            /*Выходим из метода, так как нет файлов для обработки*/
        }

        /*Проверка корректности ключа*/
        if (!checkingInput.checkKeyword(keyword, inputFolderAudio)||keyword.length() == 0) {
            /*Если ключ не соответствует тексту и его длина равна 0, выводим сообщение об ошибке*/
            JOptionPane.showMessageDialog(null, "Error: Неправильный ввод ключа, введите другой ключ!!!");
        } else {
            /*Проверка наличия несуществующих символов в тексте*/
            if (checkingInput.checkKeyAlphabet(keyword, inputFolderAudio)) {
                /*Если в тексте есть несуществующие символы, выводим сообщение об ошибке*/
                JOptionPane.showMessageDialog(null, "Error: Несуществующие символы в ключе!!!");
            } else {
                FileSaveDialogExample fileSaveDialogExample = new FileSaveDialogExample();
                String filePathAudio = fileSaveDialogExample.getFileSavePath();

                int attemptsAudio = 0;
                /*Переменная для отслеживания количества обработанных файлов*/
                for (File inputFileAudio : inputFilesAudio) {
                    if (inputFileAudio.isFile()) {
                        encryptAudio(keyword, inputFileAudio.getAbsolutePath(), filePathAudio);
                        attemptsAudio++;
                        /*Увеличиваем счетчик обработанных файлов*/
                        if (attemptsAudio < inputFilesAudio.length) {
                            /*Если текущий файл не последний в массиве, вызываем метод writeToFile("Ⓝ")*/
                            writeToFile("Ⓝ", filePathAudio);
                        }else {
                            writeToFile("Ⓝ ", filePathAudio);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Файл готов");
            }
        }
    }

    /*Метод для зашифровки текста*/
    public static String encryptText(String decryptionCipher, String keyword) {
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
        /*Создаем объект CheckingTheAlphabet для преобразования символов в числа для ключа и строки текста*/
        int[][] intergers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
        int[] intergersAlphabetArray = convertingCharactersToNumbers.alphabetArray();

        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        /*Создаем массив arrayOfText для хранения чисел, которые будут преобразованы в текст*/
        int[] arrayOfText = new int[arrayNumKey];

        /*Вычисляем остаток от деления длины массива intergersAlphabetArray на ArrayNumKey чтобы определить число итераций*/
        int remains = intergersAlphabetArray.length % arrayNumKey;

        /*
        *Вычисляем размерность (dimension) для последующего зашифровки, необходимо, чтобы была возможность разделить строку
        *на массивы равной длины
        * */
        int dimension;

        /*Если остаток от деления не равен нулю, увеличиваем размерность до ближайшего кратного ArrayNumKey числа*/
        if (remains != 0) {
            dimension = intergersAlphabetArray.length + (arrayNumKey - remains);
        } else {
            /*Иначе, оставляем размерность без изменений*/
            dimension = intergersAlphabetArray.length;
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
        /*Начинаем итерацию по массиву intergersAlphabetArray с шагом ArrayNumKey*/
        for (int i = 0, m = 0; i < dimension; i += arrayNumKey, m++) {
            /*Вычисляем количество элементов, которые нужно скопировать на текущей итерации*/
            int elementsToCopy = Math.min(arrayNumKey, dimension - i);

            /*Заполняем массив arrayOfText числами из intergersAlphabetArray*/
            for (int j = 0; j < elementsToCopy; j++) {
                if (i + j >= intergersAlphabetArray.length) {
                    /*Если вышли за пределы массива, используем символ с ASCII-кодом 35 (например, ' ')*/
                    arrayOfText[j] = 35;
                } else {
                    /*Иначе, копируем значение из intergersAlphabetArray в arrayOfText*/
                    arrayOfText[j] = intergersAlphabetArray[i + j];
                }
            }

            /*Выполняем умножение матриц и получаем массив символов*/
            char[] arrayMatrix1 = chainShot.multiplyingMatrixByMatrix(intergers, arrayOfText, numberInStorage, arrayNumKey);

            /*Инициализация объекта StringBuilder для построения строки*/
            StringBuilder stringBuilder = new StringBuilder();

            /*Объединение элементов массива в строку с разделителем*/
            for (char c : arrayMatrix1) {
                stringBuilder.append(c);
            }

            /*Получение подстроки*/
            String resultString = stringBuilder.toString();
            resultArray[m] = resultString;

        }
        StringBuilder str = new StringBuilder();

        for (String c : resultArray) {
            str.append(c);
        }
        String resultString = str.toString();
        /*Получение результирующей строки*/
        return resultString;

    }

    /* Метод для зашифровки изображений */
    private static void encryptImage(String keyword, String inputImagePath, String filePathImage) {
        /*Преобразование ключевого слова и пути изображения в массивы символов*/
        char[] charArrayKeyword = keyword.toCharArray();
        char[] charArrayDecryptionCipher = inputImagePath.toCharArray();

        /*Вычисление размерности массива ключа*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);

        /*Создание экземпляра класса ConvertingCharactersToNumbers для преобразования символов ключа в числа*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);

        /*Получение матрицы чисел из символов ключа*/
        int[][] integers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();

        /*Получение массива байтов изображения*/
        byte[] mp4Bytes = rgb(inputImagePath);
        BufferedImage image = null;
        try {
            /*Чтение изображения из файла*/
            image = ImageIO.read(new File(inputImagePath));
        } catch (IOException e) {
            /*Генерация исключения в случае ошибки*/
            throw new RuntimeException(e);
        }
        /*Получение ширины и высоты изображения*/
        int width = image.getWidth();
        int height = image.getHeight();

        /*Установка начального размера массива*/
        int initialSize = 100;

        //*Вычисление размера фрагмента массива байтов*/
        int chunkSize = (findMaxArraySize(initialSize) / integers.length) + (findMaxArraySize(initialSize) % integers.length);

        /*Инициализация переменных для подсчета оставшихся элементов*/
        int insertingElements = 0;
        int remains = 0;

        /*Получение размера алфавита*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        String resultImage = null;

        /*Вычисление числа фрагментов*/
        int numOfChunks = (int) Math.ceil((double) mp4Bytes.length / chunkSize);
        int start = 0;
        /*Обработка каждого фрагмента*/
        for (int i = 0; i < numOfChunks; ++i) {
            int length = Math.min(mp4Bytes.length - start, chunkSize);
            byte[] chunk = Arrays.copyOfRange(mp4Bytes, start, start + length);
            int[] mp4IntArray = new int[chunk.length];
            /*Преобразование байтов в положительные числа*/
            for (int k = 0, j = 0; k < mp4IntArray.length; k++, j++) {
                mp4IntArray[j] = chunk[k] & 0xFF;
            }

            /*Зашифровка фрагмента и получение результата*/
            resultImage = videoNum(mp4IntArray, integers, numberInStorage);

            /*Обновление переменной start*/
            start += chunkSize;

            /*Проверка, является ли текущий фрагмент последним*/
            boolean isLastChunk = (i == numOfChunks - 1);

            /*Запись результата в файл, отделяя фрагменты символом "⑳", кроме последнего фрагмента*/
            if (!isLastChunk) {
                writeToFile(resultImage, filePathImage);
                writeToFile("⑳", filePathImage); // Символ "⑳"
            } else {
                remains = mp4IntArray.length % integers.length;
                if (remains == 0) {
                    insertingElements = 0;
                } else {
                    insertingElements = integers.length - remains;
                }
                /*Запись результата в файл, отделяя последний фрагмент специальным образом*/
                writeToFile(resultImage, filePathImage);
                String result = "⁂" + insertingElements + "⁂" + width + "⁂" + height + "⁂";
                /*Специальная метка для последнего фрагмента*/
                writeToFile(result, filePathImage);
            }
        }
    }

    /*
    *Метод для шифрования видеофайлов.
    *Принимает ключ шифрования (keyword), путь к исходному видеофайлу (inputVideoPath)
    *и путь к файлу, в который будет сохранено зашифрованное видео (filePathVideo).
    */
    private static void encryptVideo(String keyword, String inputVideoPath, String filePathVideo) {
        /*Преобразуем ключ и путь к исходному видеофайлу в массив символов*/
        char[] charArrayKeyword = keyword.toCharArray();
        char[] charArrayDecryptionCipher = inputVideoPath.toCharArray();
        /*Вычисляем размерность массива ключа*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);
        /*Создаем объект для преобразования символов ключа в числовую матрицу*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);
        /*Получаем числовую матрицу из символов ключа*/
        int[][] integers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
        try {
            /*Создаем объект файла и открываем поток для чтения*/
            File file = new File(inputVideoPath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] mp4Bytes = new byte[(int) file.length()]; // Создаем массив для хранения байтов видеофайла

            /*Чтение байтов из файла в массив байтов*/
            bis.read(mp4Bytes);
            bis.close();

            /*Устанавливаем начальный размер массива*/
            int initialSize = 100;
            /*Начнем с относительно небольшого размера*/

            /*Вычисляем размер чанка (подмассива)*/
            int chunkSize = (findMaxArraySize(initialSize) / integers.length) + (findMaxArraySize(initialSize) % integers.length);
            int insertingElements = 0;
            int remains = 0;

            int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
            /*Получаем размер алфавита*/

            String resultImage = null;
            /*Инициализируем переменную для хранения результата шифрования*/
            int numOfChunks = (int) Math.ceil((double) mp4Bytes.length / chunkSize);
            /*Вычисляем количество чанков*/
            int start = 0;
            /*Инициализируем начальный индекс для чтения байтов*/
            for (int i = 0; i < numOfChunks; ++i) {
                int length = Math.min(mp4Bytes.length - start, chunkSize);
                /*Вычисляем длину текущего чанка*/
                byte[] chunk = Arrays.copyOfRange(mp4Bytes, start, start + length);
                /*Выделяем текущий чанк из массива байтов*/
                int[] mp4IntArray = new int[chunk.length];
                /*Создаем массив для хранения целочисленных значений байтов*/
                for (int k = 0, j = 0; k < mp4IntArray.length; k++, j++) {
                    mp4IntArray[j] = chunk[k] & 0xFF;
                    /*Преобразуем байт в положительное число*/
                }

                resultImage = videoNum(mp4IntArray, integers, numberInStorage);
                /*Получаем зашифрованные данные*/

                start += chunkSize;
                /*Увеличиваем индекс для чтения следующего чанка*/

                /*Проверяем, последний ли это чанк*/
                boolean isLastChunk = (i == numOfChunks - 1);

                /*Записываем результат в файл, разделяя чанки символом "*", кроме последнего*/
                if (!isLastChunk) {
                    writeToFile(resultImage, filePathVideo);
                    /*Записываем зашифрованные данные в файл*/
                    writeToFile("⑳", filePathVideo);
                    /*Записываем разделитель между чанками*/
                } else {
                    remains = mp4IntArray.length % integers.length;
                    /*Вычисляем количество оставшихся элементов для дополнения*/
                    if (remains == 0) {
                        insertingElements = 0;
                    } else {
                        insertingElements = integers.length - remains;
                        /*Вычисляем количество элементов для дополнения*/
                    }
                    writeToFile(resultImage, filePathVideo);
                    /*Записываем зашифрованные данные в файл*/
                    String result = "⁂" + insertingElements + "⁂";
                    /*Формируем строку с информацией о дополнении*/
                    writeToFile(result, filePathVideo);
                    /*Записываем информацию о дополнении в файл*/
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            /*Выводим информацию о возможной ошибке в случае исключения*/
        }
    }

    /*
     * Метод для зашифровки аудиофайлов
     * keyword - ключевое слово для шифрования
     * inputAudioPath - путь к входному аудиофайлу
     * filePathAudio - путь для сохранения зашифрованного аудиофайла
     */
    private static void encryptAudio(String keyword, String inputAudioPath, String filePathAudio) {
        /*Преобразование ключевого слова и пути аудиофайла в массивы символов*/
        char[] charArrayKeyword = keyword.toCharArray();
        byte[] audioArray = null;
        /*Массив байтов для хранения аудиоданных*/
        char[] charArrayDecryptionCipherAudio = inputAudioPath.toCharArray();

        /*Вычисление размерности массива ключа*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);
        /*Создание объекта для преобразования символов ключа в числовую матрицу*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipherAudio);
        /*Получение числовой матрицы из символов ключа*/
        int[][] integers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();

        try {
            /*Чтение аудиофайла в массив байтов*/
            audioArray = audio(inputAudioPath);
            /*Вызов сборщика мусора для освобождения ресурсов*/
            Runtime.getRuntime().gc();
            /*Удаление временных файлов*/
            fileSaveDialogExample.deleteAllFiles();
        } catch (IOException e) {
            /*В случае ошибки ввода-вывода выбрасывается исключение RuntimeException*/
            throw new RuntimeException(e);
        }

        /*Начальный размер массива*/
        int initialSize = 100;
        /*Начнем с относительно небольшого размера*/

        /*Вычисление размера блока данных*/
        int chunkSize = (findMaxArraySize(initialSize) / integers.length) + (findMaxArraySize(initialSize) % integers.length);
        int insertingElements = 0;
        /*Количество элементов для вставки*/
        int remains = 0;
        /*Остаток после деления длины массива на размер блока*/

        /*Получение размера алфавита*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        String resultImage = null;
        /*Результат шифрования*/
        int type = fileType(inputAudioPath);
        /*Тип аудиофайла*/

        /*Вычисление количества блоков*/
        int numOfChunks = (int) Math.ceil((double) audioArray.length / chunkSize);
        int start = 0;
        /*Начальный индекс для чтения*/
        for (int i = 0; i < numOfChunks; ++i) {
            int length = Math.min(audioArray.length - start, chunkSize);
            /*Длина текущего блока*/
            byte[] chunk = Arrays.copyOfRange(audioArray, start, start + length);
            /*Копирование блока из массива аудио*/
            int[] mp3IntArray = new int[chunk.length];
            /*Создание массива для хранения целых чисел из блока*/
            for (int k = 0, j = 0; k < mp3IntArray.length; k++, j++) {
                mp3IntArray[j] = chunk[k] & 0xFF;
                /*Преобразование байта в положительное число*/
            }

            /*Получение результата шифрования блока аудио*/
            resultImage = videoNum(mp3IntArray, integers, numberInStorage);
            start += chunkSize;
            /*Переход к следующему блоку данных*/

            /*Проверка, является ли текущий блок последним*/
            boolean isLastChunk = (i == numOfChunks - 1);

            /*Запись результата в файл*/
            if (!isLastChunk) {
                writeToFile(resultImage, filePathAudio);
                writeToFile("⑳", filePathAudio);
            } else {
                /*Расчет количества элементов для вставки в последний блок*/
                remains = mp3IntArray.length % integers.length;
                if (remains == 0) {
                    insertingElements = 0;
                } else {
                    insertingElements = integers.length - remains;
                }
                /*Запись результата и информации о типе файла в файл*/
                writeToFile(resultImage, filePathAudio);
                String result = "⁂" + insertingElements + "⁂" + type + "⁂";
                writeToFile(result, filePathAudio);
            }
        }
    }

    /*
     * Метод определяет тип файла по его расширению.
     * inputImagePath путь к файлу
     *  возвращает 1 для wav, 2 для mp3, 0 если тип не определен
     */
    public static int fileType(String inputImagePath){
        /*Создаем объект File на основе переданного пути к файлу*/
        File file = new File(inputImagePath);
        /*Инициализируем переменную для хранения типа файла (по умолчанию неизвестный тип)*/
        int type = 0;

        /*Проверяем, существует ли файл и является ли он файлом (а не директорией)*/
        if (file.exists() && file.isFile()) {
            /*Получаем имя файла*/
            String fileName = file.getName();
            /*Получаем расширение файла*/
            String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

            /*Проверяем расширение файла и присваиваем соответствующий тип*/
            if ("wav".equals(fileExtension)) {
                type = 1; // WAV аудио
            } else if ("mp3".equals(fileExtension)) {
                type = 2; // MP3 аудио
            }
        }
        /*Возвращаем определенный тип файла*/
        return  type;
    }

    /*
     * Метод читает аудиофайл и возвращает его в виде массива байтов.
     * inputAudioPath путь к аудиофайлу
     * массив байтов аудиофайла
     * IOException если возникают проблемы при чтении файла
     */
    public static byte[] audio(String inputAudioPath) throws IOException {
        byte[] audioByte = null;
        /*Путь к временному WAV файлу*/
        String wavFilePath = "temporary_store_audio\\1.wav";
        /*Создаем объект File на основе переданного пути к файлу*/
        File file = new File(inputAudioPath);

        /*Проверяем, существует ли файл и является ли он файлом (а не директорией)*/
        if (file.exists() && file.isFile()) {
            /*Получаем имя файла*/
            String fileName = file.getName();
            /*Получаем расширение файла*/
            String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

            /*Проверяем тип аудиофайла*/
            if ("wav".equals(fileExtension)) {
                /*Если это WAV аудио, копируем его в временный файл и считываем массив байтов*/
                fileTransferring(inputAudioPath, wavFilePath);
                audioByte = audioArray();
            } else if ("mp3".equals(fileExtension)) {
                /*Если это MP3 аудио, конвертируем его в WAV формат, затем копируем в временный файл и считываем массив байтов*/
                convertMP3toWAV(inputAudioPath, wavFilePath);
                audioByte = audioArray();
            }
        }

        /*Возвращаем массив байтов аудио*/
        return audioByte;
    }

    /*
     * Метод считывает массив байтов из файла WAV.
     *  возвращает массив байтов аудиофайла
     */
    public static byte[] audioArray() {
        /*Создаем объект File для временного WAV файла*/
        File wav_file = new File("temporary_store_audio\\1.wav");
        /*Создаем ByteArrayOutputStream для записи байтов из AudioInputStream*/
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        /*Инициализируем AudioInputStream как null*/
        AudioInputStream in = null;

        try {
            /*Получаем AudioInputStream из временного WAV файла*/
            in = AudioSystem.getAudioInputStream(wav_file);
        } catch (UnsupportedAudioFileException | IOException e) {
            /*Если происходит исключение, выбрасываем RuntimeException*/
            throw new RuntimeException(e);
        }

        int read;
        byte[] buff = new byte[4096];
        try {
            /*Читаем байты из AudioInputStream и записываем их в ByteArrayOutputStream*/
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
            /*Сбрасываем выходной поток*/
            out.flush();
        } catch (IOException e) {
            /*Если происходит исключение, выбрасываем RuntimeException*/
            throw new RuntimeException(e);
        }
        /*Преобразуем байты из ByteArrayOutputStream в массив байтов и возвращаем его*/
        byte[] audioBytes = out.toByteArray();

        return audioBytes;
    }

    /*
     * Метод конвертирует MP3 в WAV.
     * mp3FilePath путь к MP3 файлу
     * wavFilePath путь для сохранения WAV файла
     */
    public static void convertMP3toWAV(String mp3FilePath, String wavFilePath) {
        try {
            // Используем JLayer для декомпрессии MP3 в WAV
            Converter converter = new Converter();
            converter.convert(mp3FilePath, wavFilePath);

        } catch (JavaLayerException e) {
        }
    }

    /*
     * Метод копирует MP3 файл в выходной каталог и переименовывает его в 1.wav.
     * mp3FilePath путь к MP3 файлу
     * wavFilePath путь для сохранения WAV файла
     */
    public static void fileTransferring(String mp3FilePath, String wavFilePath) {
        try {
            /*Копируем MP3 файл в выходной каталог и переименовываем его в 1.wav*/
            Path sourcePath = new File(mp3FilePath).toPath();
            Path destinationPath = new File(wavFilePath).toPath();
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            /*Обработка исключений, например, вывод информации о проблеме*/
            e.printStackTrace();
        }
    }


    /*Этот метод videoNum предназначен для обработки видео данных с использованием матричных операций.*/
    private static String videoNum(int[] video, int[][] integers, int numberInStorage) {
        /*Вычисляем остаток от деления длины видео на количество массивов чисел*/
        int remains = video.length % integers.length;
        int dimension;
        /*Создаем массив для хранения чисел*/
        int[] arrayOfText = new int[integers.length];
        /*Проверяем, нужно ли увеличить размерность*/
        if (remains != 0) {
            dimension = video.length + (integers.length - remains);
        } else {
            /*Иначе оставляем размерность без изменений*/
            dimension = video.length;
        }

        /*Создаем объект StringBuilder для конкатенации результатов*/
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        /*Проходим по всем элементам массива видео*/
        for (int i = 0, m = 0; i < dimension; i += integers.length, m++) {
            /*Определяем количество элементов для копирования*/
            int elementsToCopy = Math.min(integers.length, dimension - i);

            /*Заполняем массив arrayOfText числами из video*/
            for (int j = 0; j < elementsToCopy; j++) {
                int index = i + j;
                /*Если индекс выходит за пределы массива, используем символ #*/
                arrayOfText[j] = (index >= video.length) ? 35 : video[index];
            }

            /*Выполняем умножение матриц и получаем массив символов*/
            char[] arrayMatrix1 = chainShot.multiplyingMatrixByMatrix(integers, arrayOfText, numberInStorage, integers.length);

            /*Очищаем StringBuilder перед повторным использованием*/
            stringBuilder.setLength(0);

            /*Объединяем элементы массива в строку с разделителем*/
            for (char c : arrayMatrix1) {
                stringBuilder.append(c);
            }
            /*Добавляем строку в общий результат*/
            resultBuilder.append(stringBuilder.toString());
        }

        /*Преобразуем результат в строку*/
        String combinedResult = resultBuilder.toString();

        return combinedResult;
    }

    /*Метод для записи строки в конец файла без перехода на новую строку*/
    public static void writeToFile(String data, String fileName) {
        if (data == null || fileName == null) {
            throw new IllegalArgumentException("Data or fileName cannot be null");
        }

        boolean success = false;
        /*Флаг для отслеживания успешности записи*/

        while (!success) {
            /*Повторяем до тех пор, пока запись не будет успешной*/
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(data);
                writer.flush();
                success = true;
                /*Установим флаг успешности записи в true*/
            } catch (IOException e) {
                /*В случае ошибки, вызываем метод showErrorDialog для вывода сообщения об ошибке*/
                JOptionPane.showMessageDialog(null, "Ошибка записи в файл. Повторите попытку.");
                e.printStackTrace();
            }
        }
    }

    /*
    *findMaxArraySize: Этот метод пытается определить максимальный размер массива, который можно создать без ошибки OutOfMemoryError.
    *Он начинает с небольшого размера и удваивает его, пока не произойдет ошибка
    */
    private static int findMaxArraySize(int initialSize) {
        /*Начинаем с небольшого размера и постепенно увеличиваем до тех пор, пока не произойдет ошибка*/
        int size = initialSize;
        /*Устанавливаем начальный размер*/
        int[] testArray;
        /*Объявляем временный массив для тестирования*/
        try {
            while (true) {
                testArray = new int[size];
                /*Пытаемся создать массив заданного размера*/
                size *= 2;
                /*Удваиваем размер массива на каждой итерации*/
            }
        } catch (OutOfMemoryError e) {
            /*Уменьшаем размер на единицу, чтобы получить максимальный доступный размер без ошибки*/
            size /= 2;
            return size;
            /*Возвращаем максимальный размер массива*/
        }
    }

    /*
    *rgb: Этот метод загружает изображение из файла, а затем преобразует его пиксели в массив байтов RGB.
    *Каждый пиксель кодируется тремя значениями: красным, зеленым и синим каналами
    */
    public static byte[] rgb(String inputImagePath){
        byte[] rgbArray = null;
        /*Инициализируем массив для хранения RGB значений*/
        try {
            /*Загрузка изображения*/
            BufferedImage image = ImageIO.read(new File(inputImagePath));

            /*Получение размеров изображения*/
            int width = image.getWidth();
            /*Получаем ширину изображения*/
            int height = image.getHeight();
            /*Получаем высоту изображения*/

            int size = width*height*3;
            /*Определяем размер массива на основе ширины, высоты и количества каналов RGB*/
            rgbArray = new byte[size];
            /*Создаем массив для хранения RGB значений*/

            /*Переменная для отслеживания числа элементов*/
            int pixelCount = 0;
            /*Счетчик пикселей*/
            int i=0;
            /*Индекс в массиве RGB значений*/
            /*Преобразование RGB значений пикселей*/
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    /*Получение цвета пикселя*/
                    Color color = new Color(image.getRGB(x, y));
                    /*Получаем цвет пикселя из изображения*/
                    rgbArray[i] = (byte) color.getRed();
                    /*Записываем значение красного канала*/
                    rgbArray[i+1] = (byte) color.getGreen();
                    /*Записываем значение зеленого канала*/
                    rgbArray[i+2] = (byte) color.getBlue();
                    /*Записываем значение синего канала*/
                    i+=3;
                    /*Увеличиваем индекс на 3 для следующего пикселя (так как каждый пиксель имеет 3 канала)*/
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            /*Выводим информацию о возможных ошибках ввода-вывода*/
        }
        return rgbArray;
        /*Возвращаем массив RGB значений*/
    }


}

package com.mycompany.stealthchatnew;

/*Основной класс программы*/
import java.awt.BorderLayout;
/*Импорт пакета для управления компоновкой элементов интерфейса*/
import java.awt.Color;
/*Импорт пакета для работы с цветами*/
import java.awt.Dimension;
/*Импорт пакета для работы с размерами компонентов*/
import java.awt.Font;
/*Импорт пакета для работы с шрифтами*/
import java.awt.Toolkit;
/*Импорт пакета для работы с системными ресурсами, такими как экран*/
import javax.swing.*;
/*Импорт основных классов и интерфейсов библиотеки Swing для построения графического интерфейса*/
import java.awt.datatransfer.Clipboard;
/*Импорт класса для работы с буфером обмен.*/
import java.awt.datatransfer.StringSelection;
/*Импорт класса для копирования строковых данных в буфер обмена*/
import java.awt.datatransfer.*;
/*Импорт классов для работы с буфером обмена*/
import java.awt.dnd.DnDConstants;
/*Импорт констант для работы с Drag and Drop (перетаскивание и отпускание)*/
import java.awt.dnd.DropTarget;
/*Импорт класса, который поддерживает целевые компоненты приема для операций Drag and Drop*/
import java.awt.dnd.DropTargetAdapter;
/*Импорт адаптера для обработки событий операций Drag and Drop*/
import java.awt.dnd.DropTargetDropEvent;
/* Импорт класса событий для операции отпускания при Drag and Drop*/
import java.awt.event.*;
/*Импорт классов для обработки событий*/
import java.io.*;
/*Импорт пакета для работы с потоками ввода-вывода*/
import java.nio.file.Files;
/*Импорт класса для работы с файлами и каталогами*/
import java.nio.file.StandardCopyOption;
/*Импорт класса для указания опций копирования файлов*/
import java.util.*;
/*Импорт пакета для работы с коллекциями и утилитами*/
import javax.swing.UIManager.LookAndFeelInfo;
/*Импорт класса для управления внешним видом и оформлением интерфейса*/
import java.awt.*;
/*Импорт классов и интерфейсов для работы с графикой и изображениями*/
import java.awt.geom.AffineTransform;
/*Импорт класса для определения аффинных преобразований графики*/
import java.io.File;
/*Импорт класса для работы с файлами*/
import java.io.IOException;
/*Импорт класса для обработки исключений ввода-вывода*/
import javax.imageio.ImageIO;
/*Импорт класса для работы с изображениями*/
import java.awt.image.BufferedImage;
/*Импорт класса для работы с изображениями в памяти*/
import java.util.List;
/*Импорт класса для работы с коллекциями списков*/
import java.util.Random;
/*Импорт класса для генерации случайных чисел*/
import java.io.BufferedReader;
/*Импорт класса для считывания текстовых данных из потока ввода символов*/
import java.io.FileReader;
/*Импорт класса для считывания текстовых данных из файла*/

public class StealthchatNew extends javax.swing.JFrame implements java.awt.event.ActionListener{
    private ArrayList<Image> imagesResult;
    /*Список изображений для результатов*/
    private int currentIndexResult;
    /*Текущий индекс выбранного изображения в результатах*/
    private double scaleResult;
    /*Масштаб изображения в результатах*/
    private double offsetX, offsetY;
    /*Смещение изображения в результатах*/
    private JScrollPane scrollPaneResult;
    /*Панель прокрутки для результатов*/
    private JLabel imageNumberLabelResult;
    /*Метка для отображения номера текущего изображения в результатах*/
    private static UIManager.LookAndFeelInfo[] installedLookAndFeels;
    /*Массив с информацией об установленных внешних видах интерфейса*/
    /*Индекс текущего выбранного внешнего вида*/
    private static int currentStyleIndex = 0;
    /*Индекс текущего выбранного стиля интерфейса*/
    /*Название файла, в котором будет храниться информация о стиле*/
    private static final String styleFileName = "style.txt";
    /*Имя файла для хранения информации о стиле*/
    /*Поле ввода ключа*/
    javax.swing.JTextField tfKeyword;
    /*Поле для ввода ключа*/
    javax.swing.JTextArea textField;
    /*Многострочное текстовое поле*/
    javax.swing.JTextArea textResult;
    /*Третье многострочное текстовое поле*/
    javax.swing.JTextArea textCode;
    /*Пятое многострочное текстовое поле*/
    private ArrayList<Image> images;
    /*Список изображений.*/
    private int currentIndex;
    /*Текущий индекс выбранного изображения*/
    private double scale;
    /*Масштаб изображения*/
    private JScrollPane scrollPane;
    /*Панель прокрутки*/
    private JLabel imageNumberLabel;
    /*Метка для отображения номера текущего изображения*/
    private File uploadedImagesFolder;
    /*Папка с загруженными изображениями*/
    private DefaultListModel<String> listModelVideo;
    /*Модель списка видеофайлов*/
    private JList<String> listVideo;
    /*Список видеофайлов*/
    private JLabel labelVideo;
    /*Метка для видеофайлов*/
    private List<String> pathsVideo;
    /*Список путей к видеофайлам*/
    private int currentIndexVideo;
    /*Текущий индекс выбранного видеофайла*/
    private DefaultListModel<String> listModelVideoResult;
    /*Модель списка результатов видео*/
    private JList<String> listVideoResult;
    /*Список результатов видео*/
    private JLabel labelVideoResult;
    /*Метка для результатов видео*/
    private List<String> pathsVideoResult;
    /*Список путей к результатам видео*/
    private int currentIndexVideoResult;
    /*Текущий индекс выбранного результата видео*/
    private DefaultListModel<String> listModelAudio;
    /*Модель списка аудиофайлов*/
    private JList<String> listAudio;
    /*Список аудиофайлов*/
    private JLabel labelAudio;
    /*Метка для аудиофайлов*/
    private List<String> pathsAudio;
    /*Список путей к аудиофайлам*/
    private int currentIndexAudio;
    /*Текущий индекс выбранного аудиофайла*/
    private DefaultListModel<String> listModelAudioResult;
    /*Модель списка результатов аудио*/
    private JList<String> listAudioResult;
    /*Список результатов аудио*/
    private JLabel labelAudioResult;
    /*Метка для результатов аудио*/
    private List<String> pathsAudioResult;
    /*Список путей к результатам аудио*/
    private int currentIndexAudioResult;
    /*Текущий индекс выбранного результата аудио*/
    private static EncryptFiles encryptFiles;
    /*Объект для шифрования файлов*/
    private static DecryptFiles decryptFiles;
    /*Объект для дешифрования файлов*/


    public StealthchatNew(){
        /*Метод содержащий графический интерфейс*/
        super("StealthChatNew");
        /*Вызов конструктора суперкласса с передачей ему заголовка окна "StealthChatNew"*/
        labelVideo = new JLabel("Выберите видео");
        /*Создание метки с текстом "Выберите видео"*/
        listModelVideo = new DefaultListModel<>();
        /*Создание модели списка видеофайлов*/
        listVideo = new JList<>(listModelVideo);
        /*Создание списка видеофайлов на основе модели*/
        JScrollPane scrollPane = new JScrollPane(listVideo);
        /*Создание панели прокрутки для списка видеофайлов*/
        installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        /*Получение массива установленных внешних видов интерфейса*/

        /*Создание нового списка для хранения путей к аудиофайлам результата*/
        pathsAudioResult = new ArrayList<>();
        /*Создание нового списка для хранения путей к аудиофайлам*/
        pathsAudio = new ArrayList<>();
        /*Создание нового списка для хранения путей к видеофайлам результата*/
        pathsVideoResult = new ArrayList<>();
        /*Создание нового списка для хранения путей к видеофайлам*/
        pathsVideo = new ArrayList<>();
        /*Создание нового списка для хранения изображений*/
        images = new ArrayList<>();
        /*Создание нового списка для хранения изображений результата*/
        imagesResult = new ArrayList<>();
        /*Инициализация переменной для отслеживания текущего индекса видеофайла результата*/
        currentIndexVideoResult = -1;
        /*Инициализация переменной для отслеживания текущего индекса аудиофайла*/
        currentIndexAudio = -1;
        /*Инициализация переменной для отслеживания текущего индекса аудиофайла результата*/
        currentIndexAudioResult = -1;
        /*Инициализация переменной для отслеживания текущего индекса видеофайла*/
        currentIndexVideo = -1;
        /*Инициализация переменной для отслеживания текущего индекса результата*/
        currentIndexResult = 0;


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                deleteAllImages();
            }
        });
        /*Добавление слушателя событий закрытия окна, который вызывает метод deleteAllImages() при закрытии окна*/
        tfKeyword = new JTextField(40);
        /*Создаем поле ввода ключа*/
        Font font = new Font("Arial", Font.BOLD, 14);
        tfKeyword.setForeground(Color.RED);
        /*Устанавливаем размер,цвет и толщину текста в этом окне*/
        /*Эти параметры мы будем использовать для других окон*/
        tfKeyword.setFont(font);

        /*Панель для ввода шифра*/
        /*Кнопка расшифровки для текста*/
        JButton btnDeciferText = new JButton("Расшифровать");
        /*Создаем кнопку для для расшифрования текста*/
        btnDeciferText.addActionListener(this);
        /*Добавляем слушатель действия на кнопку для обработки событий нажатия*/
        btnDeciferText.setActionCommand("cmd_decifer_text");
        /*Устанавливаем команду действия для кнопки, которая будет использоваться для идентификации действия*/
        Font boldFont = btnDeciferText.getFont().deriveFont(Font.BOLD);
        /*Создаем параметор подписи кнопок, его мы применяем ко всем кнопкам*/
        btnDeciferText.setFont(boldFont);
        /*Устанавливаем жирный шрифт для текста на кнопке*/
        btnDeciferText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnDeciferText.setMaximumSize(new Dimension(700,  btnDeciferText.getMaximumSize().height));
        /*Устанавливаем максимальную ширину кнопки и ограничиваем ее высоту*/

        /*Основкая панель, находится в верхней части окна*/
        /*При нажатии на кнопку в поле ключа помещается ключ, который соответствует всем условиям*/
        JButton keyGeneration = new JButton("Генерация ключа");
        /*Создадим кпопку для генерации ключа*/
        keyGeneration.addActionListener(this);
        /*Добавляем слушатель действия на кнопку для обработки событий нажатия*/
        keyGeneration.setActionCommand("cmd_key_generation");
        /*Устанавливаем команду действия для кнопки, которая будет использоваться для идентификации действия*/
        keyGeneration.setFont(boldFont);
        /*Устанавливаем жирный шрифт для текста на кнопке*/

        /*Основкая панель, находится в верхней части окна*/
        /*Изменяет стиль окна программы*/
        JButton styleButton = new JButton("Изменить стиль");
        /*Создаем кнопку для изменения фона или стиля приложения*/
        styleButton.addActionListener(this);
        /*Добавляем слушатель действия на кнопку для обработки событий нажатия*/
        styleButton.setActionCommand("cmd_style");
        /*Устанавливаем команду действия для кнопки, которая будет использоваться для идентификации действия*/
        styleButton.setFont(boldFont);
        /*Устанавливаем жирный шрифт для текста на кнопке*/

        /*Основная панель, находится в нижней части панели*/
        /*Создаем новую кнопку с текстом "Закрыть"*/
        JButton closeButton = new JButton("Закрыть");
        /*Добавляем обработчика событий для кнопки, в данном случае, this указывает на текущий объект, который обрабатывает
        события (скорее всего, текущий класс реализует интерфейс ActionListener)*/
        closeButton.addActionListener(this);
        /*Устанавливаем команду (ActionCommand), которая будет связана с этой кнопкой
        Это полезно, если у вас есть несколько кнопок, и вы хотите различать их события*/
        closeButton.setActionCommand("cmd_close_window");
        /*Устанавливаем красный фон для кнопки*/
        closeButton.setBackground(Color.RED);
        /*Устанавливаем черный цвет текста на кнопке*/
        closeButton.setForeground(Color.BLACK);
        /*Устанавливаем шрифт для текста на кнопке, boldFont - это уже ранее определенный шрифт (возможно, жирный)*/
        closeButton.setFont(boldFont);

        /*Панель для зашифровки введенного текста*/
        /*Создаем кнопку для зашифровывания текста*/
        JButton btnEncryptText = new JButton("Зашифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnEncryptText.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnEncryptText.setActionCommand("cmd_encrypt_text");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnEncryptText.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnEncryptText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnEncryptText.setMaximumSize(new Dimension(700,  btnDeciferText.getMaximumSize().height));

        /*Панель для зашифровки изображения*/
        /*Создаем кнопку для зашифровки изображений*/
        JButton btnEncryptImage = new JButton("Зашифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnEncryptImage.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnEncryptImage.setActionCommand("cmd_encrypt_image");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnEncryptImage.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnEncryptImage.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnEncryptImage.setMaximumSize(new Dimension(700,  btnEncryptImage.getMaximumSize().height));

        /*Панель для расшифровки изображений*/
        /*Создаем кнопку для расшифроки изображения*/
        JButton btnDencryptImage = new JButton("Расшифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnDencryptImage.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnDencryptImage.setActionCommand("cmd_dencrypt_image");
        /*Устанавливаем шрифт для текста на кнопке */
        btnDencryptImage.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnDencryptImage.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnDencryptImage.setMaximumSize(new Dimension(700,  btnDencryptImage.getMaximumSize().height));

        /*Панель для зашифровки текста*/
        /*Создаем кнопку для копирования текста в буфер обмена(поле ввода текста)*/
        JButton copeButtonText = new JButton("Скопировать текст в буфер обмена");
        /* Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        copeButtonText.addActionListener(this);
        /* Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         * для определения, какое действие должно быть выполнено при нажатии кнопки*/
        copeButtonText.setActionCommand("cmd_text_field_copy");
        /* Устанавливаем шрифт для текста на кнопке */
        copeButtonText.setFont(boldFont);
        /* Устанавливаем горизонтальное выравнивание кнопки по центру*/
        copeButtonText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /* Устанавливаем максимальную ширину кнопки, но ограничиваем ее по высоте*/
        copeButtonText.setMaximumSize(new Dimension(700, copeButtonText.getMaximumSize().height));

        /*Панель для ввода шифра текста*/
        /*Создаем кнопку для копирования текста в буфер обмена(поле ввода шифра)*/
        JButton btnTextaCode = new JButton("Скопировать текст в буфер обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnTextaCode.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnTextaCode.setActionCommand("cmd_text_code_cope");
        /*Устанавливаем шрифт для текста на кнопке */
        btnTextaCode.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру */
        btnTextaCode.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, но ограничиваем ее по высоте */
        btnTextaCode.setMaximumSize(new Dimension(700, btnTextaCode.getMaximumSize().height));

        /*Панель вывода результата после расшифровки и зашифровки текста*/
        /*Создаем кнопку для копирования результата в буфер обмена(вывод результата)*/
        JButton copeTextResult = new JButton("Скопировать результат в буфер обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        copeTextResult.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться, чтобы определить,
        какое действие должно быть выполнено при нажатии кнопки*/
        copeTextResult.setActionCommand("cmd_text_result_cope");
        /*Устанавливаем шрифт для текста на кнопке*/
        copeTextResult.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        copeTextResult.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        copeTextResult.setMaximumSize(new Dimension(700, copeTextResult.getMaximumSize().height));

        /*Основная панель, находится в нижней части панели*/
        /*Создаем кнопку для копирования ключа в буфер обмена*/
        JButton btnKey = new JButton("Скопировать ключ в буфер обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnKey.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        btnKey.setActionCommand("cmd_keycopy");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnKey.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnKey.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        /*Основная панель, находится в нижней части панели*/
        /*Создаем кнопку для вставки текста из буфера обмена в поле ввода ключа*/
        JButton pasteButtonKey = new JButton("Вставить в поле ввода ключа из буфера обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        pasteButtonKey.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        pasteButtonKey.setActionCommand("cmd_paste_key");
        /*Устанавливаем шрифт для текста на кнопке*/
        pasteButtonKey.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnKey.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        /*Основная панель, находится в нижней части панели*/
        /*Создаем кнопку для очистки поля ключа*/
        JButton clearKeyword = new JButton("Очистить поле ключа");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        clearKeyword.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        clearKeyword.setActionCommand("cmd_clear_keyword");
        /*Устанавливаем шрифт для текста на кнопке*/
        clearKeyword.setFont(boldFont);

        /*Панель для зашифровки текста*/
        /*Создаем кнопку для очистки поля ввода текста*/
        JButton clearButtonText = new JButton("Очистить поле ввода текста");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        clearButtonText.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        clearButtonText.setActionCommand("cmd_clear_text");
        /*Устанавливаем шрифт для текста на кнопке*/
        clearButtonText.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        clearButtonText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        clearButtonText.setMaximumSize(new Dimension(700, clearButtonText.getMaximumSize().height));

        /*Панель для ввода шифра для расшифровки текста*/
        /*Создаем кнопку для очистки поля ввода шифра*/
        JButton clearButtonTextCode = new JButton("Очистить поле ввода шифра");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        clearButtonTextCode.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        clearButtonTextCode.setActionCommand("cmd_clear_text_code");
        /*Устанавливаем шрифт для текста на кнопке*/
        clearButtonTextCode.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        clearButtonTextCode.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        clearButtonTextCode.setMaximumSize(new Dimension(700, clearButtonTextCode.getMaximumSize().height));

        /*Панель для вывода результатов расшифровки и зашифровки текста*/
        /*Создаем кнопку для очистки поля вывода результата*/
        JButton clearButtonResult = new JButton("Очистить поле вывода результата");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        clearButtonResult.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        clearButtonResult.setActionCommand("cmd_clear_result");
        /*Устанавливаем шрифт для текста на кнопке*/
        clearButtonResult.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        clearButtonResult.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        clearButtonResult.setMaximumSize(new Dimension(700, clearButtonResult.getMaximumSize().height));

        /*Основная панель, находится в нижней части панели*/
        /*Создаем кнопку для очистки всех полей*/
        JButton clearButtonAllFields = new JButton("Очистить все поля");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        clearButtonAllFields.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        clearButtonAllFields.setActionCommand("cmd_clear_all_fields");
        /*Устанавливаем шрифт для текста на кнопке*/
        clearButtonAllFields.setFont(boldFont);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        clearButtonAllFields.setMaximumSize(new Dimension(700, clearButtonAllFields.getMaximumSize().height));

        /*Панель для зашифровки текста*/
        /*Создаем кнопку для вставки текста из буфера обмена в поле ввода текста*/
        JButton pasteButtonText = new JButton("Вставить в поле ввода текста из буфера обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        pasteButtonText.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        pasteButtonText.setActionCommand("cmd_paste_text_field");
        /*Устанавливаем шрифт для текста на кнопке*/
        pasteButtonText.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        pasteButtonText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        pasteButtonText.setMaximumSize(new Dimension(700, pasteButtonText.getMaximumSize().height));

        /*Панель для расшифровки текста*/
        /*Создаем кнопку для сохранения в файл текста из поля для ввода текста*/
        JButton saveCodeFile= new JButton("Сохранить");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        saveCodeFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        saveCodeFile.setActionCommand("cmd_save_code_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        saveCodeFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        saveCodeFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        saveCodeFile.setMaximumSize(new Dimension(700, saveCodeFile.getMaximumSize().height));

        /*Панель для зашифровки текста*/
        /*Создаем кнопку для вставки текста из буфера обмена в поле ввода шифра*/
        JButton pasteButtonCodeText = new JButton("Вставить в поле ввода текста из буфера обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        pasteButtonCodeText.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        pasteButtonCodeText.setActionCommand("cmd_paste_text_code");
        /*Устанавливаем шрифт для текста на кнопке*/
        pasteButtonCodeText.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        pasteButtonCodeText.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        pasteButtonCodeText.setMaximumSize(new Dimension(700, pasteButtonCodeText.getMaximumSize().height));

        /*Панель для зашифровки текста*/
        /*Открыть текстовый файл для вставки записей в текстовое поле*/
        JButton openTextFile = new JButton("Открыть");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        openTextFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        openTextFile.setActionCommand("cmd_open_text_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        openTextFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        openTextFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        openTextFile.setMaximumSize(new Dimension(700, openTextFile.getMaximumSize().height));

        /*Панель для зашифровки текста*/
        /*Создаем кнопку для сохранения текста в файл из поля для ввода текста*/
        JButton saveTextFile = new JButton("Сохранить");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        saveTextFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        saveTextFile.setActionCommand("cmd_save_text_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        saveTextFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        saveTextFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        saveTextFile.setMaximumSize(new Dimension(700, saveTextFile.getMaximumSize().height));

        /*Панель для расшифровки текста*/
        /*Создаем кнопку для открывания текстового файла с кодом и вставки его в поле ввода шифра*/
        JButton openCodeFile = new JButton("Открыть");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        openCodeFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        openCodeFile.setActionCommand("cmd_open_code_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        openCodeFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        openCodeFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        openCodeFile.setMaximumSize(new Dimension(700, openCodeFile.getMaximumSize().height));

        /*Панель для вывода результатов шифрования и расшифрования текста*/
        /*Создаем кнопку для вставки текста из буфера обмена в поле вывода текста*/
        JButton pasteButtonTextResult = new JButton("Вставить в поле вывода текста из буфера обмена");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        pasteButtonTextResult.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        pasteButtonTextResult.setActionCommand("cmd_paste_text_result");
        /*Устанавливаем шрифт для текста на кнопке*/
        pasteButtonTextResult.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        pasteButtonTextResult.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        pasteButtonTextResult.setMaximumSize(new Dimension(700, pasteButtonTextResult.getMaximumSize().height));

        /*Панель для вывода результатов шифрования и расшифрования текста*/
        /*Создаем кнопку для сохранения результата в файл*/
        JButton saveResultFile = new JButton("Сохранить");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        saveResultFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        saveResultFile.setActionCommand("cmd_save_result_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        saveResultFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        saveResultFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        saveResultFile.setMaximumSize(new Dimension(700, saveResultFile.getMaximumSize().height));

        /*Панель для вывода результатов шифрования и расшифрования текста*/
        /*Создаем кнопку для открытия файла и вставки его содержимого в панель для вывода результатов*/
        JButton openResultFile = new JButton("Открыть");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        openResultFile.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться,
        чтобы определить, какое действие должно быть выполнено при нажатии кнопки*/
        openResultFile.setActionCommand("cmd_open_result_file");
        /*Устанавливаем шрифт для текста на кнопке*/
        openResultFile.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        openResultFile.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        openResultFile.setMaximumSize(new Dimension(700, openResultFile.getMaximumSize().height));

        /*Панель для зашифровки видео*/
        /*Создаем кнопку для зашифровки видео*/
        JButton btnEncryptVideo = new JButton("Зашифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnEncryptVideo.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnEncryptVideo.setActionCommand("cmd_encrypt_video");
        /*Устанавливаем шрифт для текста на кнопке */
        btnEncryptVideo.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnEncryptVideo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnEncryptVideo.setMaximumSize(new Dimension(700,  btnEncryptVideo.getMaximumSize().height));

        /*Панель для расшифровки видео*/
        /*Создаем кнопку для расшифровки видео*/
        JButton btnDencryptVideo = new JButton("Расшифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnDencryptVideo.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки.*/
        btnDencryptVideo.setActionCommand("cmd_decrypt_video");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnDencryptVideo.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnDencryptVideo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnDencryptVideo.setMaximumSize(new Dimension(700,  btnDencryptVideo.getMaximumSize().height));

        /*Панель для зашифровки аудио*/
        /*Создаем кнопку для зашифровки аудио*/
        JButton btnEncryptAudio = new JButton("Зашифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnEncryptAudio.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnEncryptAudio.setActionCommand("cmd_encrypt_audio");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnEncryptAudio.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnEncryptAudio.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnEncryptAudio.setMaximumSize(new Dimension(700,  btnEncryptAudio.getMaximumSize().height));

        /*Панель для расщифровки аудио*/
        /*Создаем кнопку для расшифровки аудио*/
        JButton btnDencryptAudio = new JButton("Расшифровать");
        /*Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие*/
        btnDencryptAudio.addActionListener(this);
        /*Устанавливаем команду действия для кнопки. Эта команда будет использоваться
         *для определения, какое действие должно быть выполнено при нажатии кнопки*/
        btnDencryptAudio.setActionCommand("cmd_decrypt_audio");
        /*Устанавливаем шрифт для текста на кнопке*/
        btnDencryptAudio.setFont(boldFont);
        /*Устанавливаем горизонтальное выравнивание кнопки по центру*/
        btnDencryptAudio.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /*Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте*/
        btnDencryptAudio.setMaximumSize(new Dimension(700,  btnDencryptAudio.getMaximumSize().height));

        /*Панель для ввода текста для зашифровки*/
        /*Создаём кнопку для редактирования текста в поле ввода текста*/
        JButton textEditing = new JButton("Редактировать текст");
        /* Устанавливаем цвет фона кнопки */
        textEditing.setBackground(new Color(255, 204, 204)); // Например, розовый
        /* Устанавливаем цвет текста кнопки */
        textEditing.setForeground(Color.BLUE); // Например, синий
        /* Устанавливаем шрифт для текста на кнопке */
        boldFont = new Font("Arial", Font.BOLD, 14);
        textEditing.setFont(boldFont);
        /* Добавляем слушателя событий к кнопке, чтобы реагировать на нажатие */
        textEditing.addActionListener(this);
        /* Устанавливаем команду действия для кнопки */
        textEditing.setActionCommand("cmd_text_editing");
        /* Устанавливаем горизонтальное выравнивание кнопки по центру */
        textEditing.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        /* Устанавливаем максимальную ширину кнопки, ограничивая ее по высоте */
        textEditing.setMaximumSize(new Dimension(700, textEditing.getMaximumSize().height));
        // Далее приведены аналогичные настройки для других кнопок, описанные в коде.

        /*Панель для результата расшифровки изображения*/
        /*Создание кнопки с надписью "Следующее", которая позволяет пролистывать изображения во вкладке с результатом расшифровки*/
        JButton nextButtonResultImage = new JButton("Следующее");
        /*Добавление слушателя событий ActionListener к кнопке nextButtonResult*/
        /*При возникновении события (в данном случае, нажатии на кнопку), будет вызван метод actionPerformed()*/
        nextButtonResultImage.addActionListener(this);
        /*Установка команды действия для кнопки. Эта команда будет использоваться для идентификации
        события в методе actionPerformed(), чтобы определить, какая кнопка была нажата*/
        nextButtonResultImage.setActionCommand("cmd_next_button_result");

        /*Панель для расшифровки изображения*/
        JButton prevButtonResultImage = new JButton("Предыдущее");
        /*Создание кнопки с надписью "Предыдущее", которая позволяет пролистывать изображения во вкладке с результатом расшифровки*/
        prevButtonResultImage.addActionListener(this);
        /* Добавление слушателя событий ActionListener к кнопке prevButtonResultImage*/
        prevButtonResultImage.setActionCommand("cmd_prev_button_result");
        /* Установка команды действия для кнопки prevButtonResultImage */

        /*Панель для зашифровки видео*/
        JButton openButtonVideo = new JButton("Добавить видео");
        /*Создание кнопки "Добавить видео"*/
        openButtonVideo.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке openButtonVideo*/
        openButtonVideo.setActionCommand("cmd_open_button_video");
        /*Установка команды действия для кнопки openButtonVideo*/

        /*Панель для зашифровки видео*/
        JButton nextButtonVideo = new JButton("Следующее");
        /*Создание кнопки "Следующее" для видео, панель для зашифровки видео*/
        nextButtonVideo.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке nextButtonVideo*/
        nextButtonVideo.setActionCommand("cmd_next_button_video");
        /*Установка команды действия для кнопки nextButtonVideo*/

        /*Панель для зашифровки видео*/
        JButton prevButtonVideo = new JButton("Предыдущее");
        /*Создание кнопки "Предыдущее" для видео, панель для зашифровки видео*/
        prevButtonVideo.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке prevButtonVideo*/
        prevButtonVideo.setActionCommand("cmd_prev_button_video");
        /*Установка команды действия для кнопки prevButtonVideo*/

        /*Панель для зашифровки видео*/
        JButton deleteButtonVideo = new JButton("Удалить видео");
        /*Создание кнопки "Удалить видео", панель для зашифровки*/
        deleteButtonVideo.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteButtonVideo*/
        deleteButtonVideo.setActionCommand("cmd_delete_button_video");
        /*Установка команды действия для кнопки deleteButtonVideo*/

        /*Панель для зашифровки видео*/
        JButton deleteAllButtonVideo = new JButton("Удалить все файлы");
        /*Создание кнопки "Удалить все файлы"*/
        deleteAllButtonVideo.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteAllButtonVideo*/
        deleteAllButtonVideo.setActionCommand("cmd_delete_all_button_video");
        /*Установка команды действия для кнопки deleteAllButtonVideo*/

        /*Панель для зашифровки изображения*/
        JButton openButton = new JButton("Открыть изображение");
        /*Создание кнопки "Открыть изображение"*/
        openButton.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке openButton*/
        openButton.setActionCommand("cmd_open_button");
        /*Установка команды действия для кнопки openButton*/

        /*Панель для зашифровки изображения*/
        JButton prevButtonImage = new JButton("Предыдущее");
        /*Создание кнопки "Предыдущее" для перехода к следующему изображению, панель для зашифровки изображений*/
        prevButtonImage.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке prevButton*/
        prevButtonImage.setActionCommand("cmd_prev_button");
        /*Установка команды действия для кнопки prevButton*/

        /*Панель для зашифровки изображения*/
        JButton nextButtonImage = new JButton("Следующее");
        /*Создание кнопки "Следующее" для перехода к предыдущему изображению, панель для зашифровки изображений*/
        nextButtonImage.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке nextButton*/
        nextButtonImage.setActionCommand("cmd_next_button");
        /*Установка команды действия для кнопки nextButton*/

        /*Панель для зашифровки изображения*/
        JButton deleteButton = new JButton("Удалить");
        /*Создание кнопки "Удалить" на панели зашифровки изображений*/
        deleteButton.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteButton*/
        deleteButton.setActionCommand("cmd_delete_button");
        /*Установка команды действия для кнопки deleteButton*/

        /*Панель для зашифровки изображения*/
        JButton deleteButtonAll = new JButton("Удалить все изображения");
        /*Создание кнопки "Удалить все изображения"*/
        deleteButtonAll.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteButtonAll*/
        deleteButtonAll.setActionCommand("cmd_delete_button_all");
        /*Установка команды действия для кнопки deleteButtonAll*/

        /*Панель для расшифровки изображений*/
        JButton saveFilesImage = new JButton("Сохранить файлы");
        /*Создание кнопки "Сохранить файлы" для изображений*/
        saveFilesImage.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке saveFilesImage*/
        saveFilesImage.setActionCommand("cmd_save_files_image");
        /*Установка команды действия для кнопки saveFilesImage*/

        /*Панель для зашифровки аудио*/
        JButton nextButtonAudioResult = new JButton("Следующее");
        /*Создание кнопки "Следующее" для аудиофайлов результата расшифрования, позволяет переходить на следующее видео*/
        nextButtonAudioResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке nextButtonAudioResult*/
        nextButtonAudioResult.setActionCommand("cmd_next_button_audio_result");
        /*Установка команды действия для кнопки nextButtonAudioResult*/

        /*Панель для зашифровки аудио*/
        JButton prevButtonAudioResult = new JButton("Предыдущее");
        /*Создание кнопки "Предыдущее" для аудиофайлов результата расшифрования, позволяет переходить на предыдущее видео*/
        prevButtonAudioResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке prevButtonAudioResult*/
        prevButtonAudioResult.setActionCommand("cmd_prev_button_audio_result");
        /*Установка команды действия для кнопки prevButtonAudioResult*/

        /*Панель для зашифровки аудио*/
        JButton deleteAllButtonAudioResult = new JButton("Удалить все файлы");
        /*Создание кнопки "Удалить все файлы" для аудиофайлов результата, для панели расшифровка аудиофайла*/
        deleteAllButtonAudioResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteAllButtonAudioResult*/
        deleteAllButtonAudioResult.setActionCommand("cmd_delete_all_button_audio_result");
        /*Установка команды действия для кнопки deleteAllButtonAudioResult*/

        /*Панель для расшифровки аудио*/
        JButton saveFilesButtonAudioResult = new JButton("Сохранить файлы");
        /*Создание кнопки "Сохранить файлы" для аудиофайлов результата, позволяет все файлы, которые были расшифрованы, помещать в папку
        и сохранять по указанию*/
        saveFilesButtonAudioResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке saveFilesButtonAudioResult*/
        saveFilesButtonAudioResult.setActionCommand("cmd_save_files_button_audio_result");
        /*Установка команды действия для кнопки saveFilesButtonAudioResult*/

        /*Панель для зашифровки аудио*/
        JButton openButtonAudio = new JButton("Добавить аудио");
        /*Создание кнопки "Добавить аудио"*/
        openButtonAudio.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке openButtonAudio*/
        openButtonAudio.setActionCommand("cmd_open_button_audio");
        /*Установка команды действия для кнопки openButtonAudio*/

        /*Панель для зашифровки аудио*/
        JButton nextButtonAudio = new JButton("Следующее");
        /*Создание кнопки "Следующее" для перехода на следующий аудио файл, на панели зашифровка аудио*/
        nextButtonAudio.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке nextButtonAudio*/
        nextButtonAudio.setActionCommand("cmd_next_button_audio");
        /*Установка команды действия для кнопки nextButtonAudio*/

        /*Панель для зашифровки аудио*/
        JButton prevButtonAudio = new JButton("Предыдущее");
        /*Создание кнопки "Предыдущее" для аудиофайлов для перехода на предыдущее аудио, на панели зашифровки аудио*/
        prevButtonAudio.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке prevButtonAudio*/
        prevButtonAudio.setActionCommand("cmd_prev_button_audio");
        /*Установка команды действия для кнопки prevButtonAudio*/

        /*Панель для зашифровки аудио*/
        JButton deleteButtonAudio = new JButton("Удалить аудио");
        /*Создание кнопки "Удалить аудио"*/
        deleteButtonAudio.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteButtonAudio*/
        deleteButtonAudio.setActionCommand("cmd_delete_button_audio");
        /*Установка команды действия для кнопки deleteButtonAudio*/

        /*Панель для зашифровки аудио*/
        JButton deleteAllButtonAudio = new JButton("Удалить все файлы");
        /*Создание кнопки "Удалить все файлы" для аудиофайлов*/
        deleteAllButtonAudio.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteAllButtonAudio*/
        deleteAllButtonAudio.setActionCommand("cmd_delete_all_button_audio");
        /*Установка команды действия для кнопки deleteAllButtonAudio*/

        /*Панель для расшифровки изображений*/
        JButton deleteButtonAllResult = new JButton("Удалить все изображения");
        /*Создание кнопки "Удалить все изображения" для результата*/
        deleteButtonAllResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteButtonAllResult*/
        deleteButtonAllResult.setActionCommand("cmd_delete_button_all_result");
        /*Установка команды действия для кнопки deleteButtonAllResult*/

        /*Панель для расшифрования видео*/
        JButton nextButtonVideoResult = new JButton("Следующее");
        /*Создание кнопки "Следующее" для перехода к следующему файлу результата расшифрования*/
        nextButtonVideoResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке nextButtonVideoResult*/
        nextButtonVideoResult.setActionCommand("cmd_next_button_video_result");
        /*Установка команды действия для кнопки nextButtonVideoResult*/

        /*Панель для расшифрования видео*/
        JButton prevButtonVideoResult = new JButton("Предыдущее");
        /*Создание кнопки "Предыдущее" для перехода к предыдущему видео*/
        prevButtonVideoResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке prevButtonVideoResult*/
        prevButtonVideoResult.setActionCommand("cmd_prev_button_video_result");
        /*Установка команды действия для кнопки prevButtonVideoResult*/

        /*Панель для расшифрования видео*/
        JButton deleteAllButtonVideoResult = new JButton("Удалить все файлы");
        /*Создание кнопки "Удалить все файлы" для видеофайлов результата*/
        deleteAllButtonVideoResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке deleteAllButtonVideoResult*/
        deleteAllButtonVideoResult.setActionCommand("cmd_delete_all_button_video_result");
        /*Установка команды действия для кнопки deleteAllButtonVideoResult*/

        /*Панель для расшифрования видео*/
        JButton saveFilesButtonVideoResult = new JButton("Сохранить файлы");
        /*Создание кнопки "Сохранить файлы" для видеофайлов результата*/
        saveFilesButtonVideoResult.addActionListener(this);
        /*Добавление слушателя событий ActionListener к кнопке saveFilesButtonVideoResult*/
        saveFilesButtonVideoResult.setActionCommand("cmd_save_files_button_video_result");
        /*Установка команды действия для кнопки saveFilesButtonVideoResult*/


        /*Создаем метку (Label) для ввода ключа*/
        JLabel lbKeyword = new JLabel("Ввод ключа");
        /*Устанавливаем цвет текста метки в синий*/
        lbKeyword.setForeground(Color.BLUE);
        /*Устанавливаем шрифт для текста метки*/
        lbKeyword.setFont(font);
        /*Создаем панель (Panel) для группировки элементов интерфейса, связанных с вводом ключа*/
        /*Верхняя панель*/
        JPanel pKeyword = new JPanel();
        /*Добавляем метку в панель*/
        pKeyword.add(lbKeyword);
        /*Добавляем поле для ввода ключа (tfKeyword) в панель*/
        pKeyword.add(tfKeyword);
        /*Добавляем кнопку keyGeneration в панель (предположительно, кнопка для генерации ключа)*/
        pKeyword.add(keyGeneration);
        /* Добавляем styleButton в панель (предположительно, еще одна кнопка для выбора стиля ключа)*/
        pKeyword.add(styleButton);

        /*Создаем панель для управления элементами интерфейса*/
        JPanel pControls = new JPanel();
        pControls.add(closeButton);
        pControls.add(clearKeyword);
        pControls.add(clearButtonAllFields);
        pControls.add(btnKey);
        pControls.add(pasteButtonKey);

        /*Создаем JTextArea для ввода текста*/
        textField = new JTextArea();
        /*Устанавливаем цвет текста в JTextArea textField на красный*/
        textField.setForeground(Color.RED);
        /*Устанавливаем шрифт для текста в JTextArea textField*/
        textField.setFont(font);

        /*Создаем JTextArea для отображения результата*/
        textResult = new JTextArea();
        /*Устанавливаем цвет текста в JTextArea textResult на красный*/
        textResult.setForeground(Color.RED);
        /*Устанавливаем шрифт для текста в JTextArea textResult*/
        textResult.setFont(font);

        /*Создаем JTextArea для ввода кода */
        textCode = new JTextArea();
        /*Устанавливаем цвет текста в JTextArea textCode на красный*/
        textCode.setForeground(Color.RED);
        /*Устанавливаем шрифт для текста в JTextArea textCode*/
        textCode.setFont(font);

        /*Создаем элемент меню для ввода текста*/
        JMenuItem inputTextMenuItem = new JMenuItem("Вводите текст");
        /*Создаем элемент меню для ввода шифра*/
        JMenuItem inputCipherMenuItem = new JMenuItem("Вводите шифр");
        /*Создаем элемент меню для отображения результата*/
        JMenuItem resultMenuItem = new JMenuItem("Результат");
        /*Создаем меню "Работа с текстом"*/
        JMenu textMenu = new JMenu("Работа с текстом");
        /*Добавляем в меню элементы для ввода текста, ввода шифра и отображения результата*/
        textMenu.add(inputTextMenuItem);
        textMenu.add(inputCipherMenuItem);
        textMenu.add(resultMenuItem);

        /*Создаем элементы меню для работы с изображениями*/
        JMenuItem inputImageMenuItem = new JMenuItem("Вводите изображение");
        JMenuItem resultMenuItemImage = new JMenuItem("Результат");

        /*Создаем меню "Работа с изображением" и добавляем в него созданные элементы*/
        JMenu imageMenu = new JMenu("Работа с изображением");
        imageMenu.add(inputImageMenuItem);
        /*Добавляем пункт для ввода изображения в меню*/
        imageMenu.add(resultMenuItemImage);
        /*Добавляем пункт для отображения результата работы с изображением в меню*/

        /*Создаем элементы меню для работы с аудио*/
        JMenuItem inputAudioMenuItem = new JMenuItem("Вводите аудио");
        JMenuItem resultMenuItemAudio = new JMenuItem("Результат");

        /*Создаем меню "Работа с аудио" и добавляем в него созданные элементы*/
        JMenu audioMenu = new JMenu("Работа с аудио");
        audioMenu.add(inputAudioMenuItem);
        /*Добавляем пункт для ввода аудио в меню*/
        audioMenu.add(resultMenuItemAudio);
        /*Добавляем пункт для отображения результата работы с аудио в меню*/

        /*Создаем элементы меню для работы с видео*/
        JMenuItem inputVideoMenuItem = new JMenuItem("Вводите видео");
        JMenuItem resultMenuItemVideo = new JMenuItem("Результат");

        JMenu videoMenu = new JMenu("Работа с видео");
        /*Создаем меню "Работа с видео" и добавляем в него созданные элементы*/
        videoMenu.add(inputVideoMenuItem);
        /*Добавляем пункт для ввода видео в меню*/
        videoMenu.add(resultMenuItemVideo);
        /*Добавляем пункт для отображения результата работы с видео в меню*/

        JMenuBar menuBar = new JMenuBar();
        /*Создаем строку меню и добавляем в нее все созданные меню*/
        setJMenuBar(menuBar);
        /*Устанавливаем строку меню в качестве строки меню для текущего окна*/
        menuBar.add(textMenu);
        /*Добавляем меню для работы с текстом в строку меню*/
        menuBar.add(imageMenu);
        /*Добавляем меню для работы с изображениями в строку меню*/
        menuBar.add(audioMenu);
        /*Добавляем меню для работы с аудио в строку меню*/
        menuBar.add(videoMenu);
        /*Добавляем меню для работы с видео в строку меню*/

        JPanel encodeControls = new JPanel();
        /*Создаем панель для элементов управления кодированием текста*/
        encodeControls.setLayout(new BoxLayout(encodeControls, BoxLayout.PAGE_AXIS));
        encodeControls.add(new JScrollPane(textField));
        /*Добавляем поле для ввода текста с возможностью прокрутки*/
        encodeControls.add(clearButtonText);
        /*Добавляем кнопку для очистки текста*/
        encodeControls.add(copeButtonText);
        /*Добавляем кнопку для копирования текста*/
        encodeControls.add(pasteButtonText);
        /*Добавляем кнопку для вставки текста*/
        encodeControls.add(btnEncryptText);
        /*Добавляем кнопку для шифрования текста*/
        encodeControls.add(saveTextFile);
        /*Добавляем кнопку для сохранения текста в файл*/
        encodeControls.add(openTextFile);
        /*Добавляем кнопку для открытия текстового файла*/
        encodeControls.add(textEditing);
        /*Добавляем компонент для редактирования текста*/

        JPanel encodeControlsCode = new JPanel();
        /*Создаем панель для элементов управления кодированием шифра*/
        encodeControlsCode.setLayout(new BoxLayout(encodeControlsCode, BoxLayout.PAGE_AXIS));
        encodeControlsCode.add(new JScrollPane(textCode));
        /*Добавляем поле для ввода шифра с возможностью прокрутки*/
        encodeControlsCode.add(clearButtonTextCode);
        /*Добавляем кнопку для очистки шифра*/
        encodeControlsCode.add(btnTextaCode);
        /*Добавляем кнопку для получения шифра из текста*/
        encodeControlsCode.add(pasteButtonCodeText);
        /*Добавляем кнопку для вставки шифра из текста*/
        encodeControlsCode.add(btnDeciferText);
        /*Добавляем кнопку для дешифрования текста*/
        encodeControlsCode.add(saveCodeFile);
        /*Добавляем кнопку для сохранения шифра в файл*/
        encodeControlsCode.add(openCodeFile);
        /*Добавляем кнопку для открытия файла с шифром*/

        JPanel encodeControlsResult = new JPanel();
        /*Создаем панель для элементов управления отображением результата*/
        encodeControlsResult.setLayout(new BoxLayout(encodeControlsResult, BoxLayout.PAGE_AXIS));
        encodeControlsResult.add(new JScrollPane(textResult));
        /*Добавляем поле для отображения результата с возможностью прокрутки*/
        encodeControlsResult.add(clearButtonResult);
        /*Добавляем кнопку для очистки результата*/
        encodeControlsResult.add(copeTextResult);
        /*Добавляем кнопку для копирования результата*/
        encodeControlsResult.add(pasteButtonTextResult);
        /*Добавляем кнопку для вставки результата*/
        encodeControlsResult.add(openResultFile);
        /*Добавляем кнопку для открытия файла с результатом*/
        encodeControlsResult.add(saveResultFile);
        /*Добавляем кнопку для сохранения результата в файл*/

        /*Создаем панель для элементов управления вывода результата дешифрования*/
        JPanel encodeControlsCodeOut = new JPanel();
        encodeControlsCodeOut.setLayout(new BoxLayout(encodeControlsCodeOut, BoxLayout.PAGE_AXIS));

        /*Показываем панель для управления кодированием текста*/
        showPanel(encodeControls, pKeyword, pControls);

        JPanel buttonPanel = new JPanel();
        /*Создаем панель с кнопками для работы с изображениями*/
        buttonPanel.add(openButton);
        /*Добавляем кнопку для открытия изображения*/
        buttonPanel.add(prevButtonImage);
        /*Добавляем кнопку для просмотра предыдущего изображения*/
        buttonPanel.add(nextButtonImage);
        /*Добавляем кнопку для просмотра следующего изображения*/
        buttonPanel.add(deleteButton);
        /*Добавляем кнопку для удаления текущего изображения*/
        buttonPanel.add(deleteButtonAll);
        /*Добавляем кнопку для удаления всех изображений*/
        buttonPanel.add(btnEncryptImage);
        /*Добавляем кнопку для шифрования изображения*/

        /*Создаем метку для отображения номера текущего изображения*/
        imageNumberLabel = new JLabel("Номер изображения: " + (currentIndex + 1));

        /*Создаем панель для отображения статуса*/
        JPanel statusPanel = new JPanel();
        statusPanel.add(imageNumberLabel);

        JPanel buttonPanelRez = new JPanel();
        /*Создаем панель с кнопками для работы с результатами изображений*/
        buttonPanelRez.add(deleteButtonAllResult);
        /*Добавляем кнопку для удаления всех результатов*/
        buttonPanelRez.add(prevButtonResultImage);
        /*Добавляем кнопку для просмотра предыдущего результата изображения*/
        buttonPanelRez.add(btnDencryptImage);
        /*Добавляем кнопку для дешифрования изображения*/
        buttonPanelRez.add(nextButtonResultImage);
        /*Добавляем кнопку для просмотра следующего результата изображения*/
        buttonPanelRez.add(saveFilesImage);
        /*Добавляем кнопку для сохранения изображений*/
        scrollPaneResult = new JScrollPane(new ImagePanelResult());
        /*Создаем панель с результатами изображений и добавляем ее в прокрутку*/
        JPanel statusPanelResult = new JPanel(new FlowLayout(FlowLayout.CENTER));
        /*Создаем панель для отображения статуса результата изображения*/

        /*Создаем метку для отображения номера текущего результата изображения*/
        imageNumberLabelResult = new JLabel("Номер изображения: " + (currentIndexResult + 1));
        /*Добавляем метку на панель статуса результата*/
        statusPanelResult.add(imageNumberLabelResult);

        /*Создаем панель управления элементами для работы с видео*/
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(btnEncryptVideo);
        /*Кнопка для шифрования видео*/
        controlPanel.add(openButtonVideo);
        /*Кнопка для открытия видео*/
        controlPanel.add(prevButtonVideo);
        /*Кнопка для просмотра предыдущего видео*/
        controlPanel.add(labelVideo);
        /*Метка для отображения информации о видео*/
        controlPanel.add(nextButtonVideo);
        /*Кнопка для просмотра следующего видео*/
        controlPanel.add(deleteButtonVideo);
        /*Кнопка для удаления текущего видео*/
        controlPanel.add(deleteAllButtonVideo);
        /*Кнопка для удаления всех видео*/

        /*Создаем главную панель для работы с видео*/
        JPanel mainPanelVideo = new JPanel(new BorderLayout());
        mainPanelVideo.add(scrollPane, BorderLayout.CENTER);
        /*Добавляем панель для прокрутки с видео*/
        mainPanelVideo.add(controlPanel, BorderLayout.SOUTH);
        /*Добавляем панель управления видео внизу*/

        /*Создаем список для отображения результатов работы с видео*/
        listModelVideoResult = new DefaultListModel<>();
        listVideoResult = new JList<>(listModelVideoResult);
        JScrollPane scrollPaneVideoResult = new JScrollPane(listVideoResult);
        /*Создаем панель прокрутки для списка результатов видео*/

        labelVideoResult = new JLabel("Видео не загружено");
        /*Метка для отображения статуса загрузки видео*/

        /*Панель управления элементами для работы с результатами видео*/
        JPanel controlPanelVideoResult = new JPanel(new FlowLayout());
        controlPanelVideoResult.add(saveFilesButtonVideoResult);
        /*Кнопка для сохранения файлов видео*/
        controlPanelVideoResult.add(prevButtonVideoResult);
        /*Кнопка для просмотра предыдущего результата видео*/
        controlPanelVideoResult.add(labelVideoResult);
        /*Метка для отображения статуса видео*/
        controlPanelVideoResult.add(nextButtonVideoResult);
        /*Кнопка для просмотра следующего результата видео*/
        controlPanelVideoResult.add(deleteAllButtonVideoResult);
        /*Кнопка для удаления всех результатов видео*/
        controlPanelVideoResult.add(btnDencryptVideo);
        /*Кнопка для дешифрования видео*/

        /*Главная панель для отображения результатов работы с видео*/
        JPanel mainPanelVideoResult = new JPanel(new BorderLayout());
        mainPanelVideoResult.add(scrollPaneVideoResult, BorderLayout.CENTER);
        /*Добавляем список результатов видео на панель*/
        mainPanelVideoResult.add(controlPanelVideoResult, BorderLayout.SOUTH);
        /*Добавляем панель управления внизу*/

        /*Создаем модель списка для аудиофайлов и сам список аудиофайлов*/
        listModelAudio = new DefaultListModel<>();
        listAudio = new JList<>(listModelAudio);
        JScrollPane scrollPaneAudio = new JScrollPane(listAudio);
        /*Создаем панель с прокруткой для списка аудиофайлов*/

        /*Создаем метку для отображения статуса выбора аудиофайла*/
        labelAudio = new JLabel("Выберите аудио");

        /*Создаем панель управления аудиофайлами*/
        JPanel controlPanelAudio = new JPanel(new FlowLayout());
        controlPanelAudio.add(btnEncryptAudio);
        /*Кнопка для шифрования аудиофайла*/
        controlPanelAudio.add(openButtonAudio);
        /*Кнопка для открытия аудиофайла*/
        controlPanelAudio.add(prevButtonAudio);
        /*Кнопка для просмотра предыдущего аудиофайла*/
        controlPanelAudio.add(labelAudio);
        /*Метка для отображения статуса выбора аудиофайла*/
        controlPanelAudio.add(nextButtonAudio);
        /*Кнопка для просмотра следующего аудиофайла*/
        controlPanelAudio.add(deleteButtonAudio);
        /*Кнопка для удаления выбранного аудиофайла*/
        controlPanelAudio.add(deleteAllButtonAudio);
        /*Кнопка для удаления всех аудиофайлов*/

        /*Создаем главную панель для отображения аудиофайлов и их управления*/
        JPanel mainPanelAudio = new JPanel(new BorderLayout());
        mainPanelAudio.add(scrollPaneAudio, BorderLayout.CENTER);
        /*Добавляем список аудиофайлов на главную панель*/
        mainPanelAudio.add(controlPanelAudio, BorderLayout.SOUTH);
        /*Добавляем панель управления аудиофайлами на главную панель*/

        /*Создаем модель списка для результатов работы с аудиофайлами и сам список результатов*/
        listModelAudioResult = new DefaultListModel<>();
        listAudioResult = new JList<>(listModelAudioResult);
        JScrollPane scrollPaneAudioResult = new JScrollPane(listAudioResult);
        /*Создаем панель с прокруткой для списка результатов*/

        /*Создаем метку для отображения статуса выбора аудиофайла*/
        labelAudioResult = new JLabel("Аудио не загружено");

        /*Создаем панель управления результатами работы с аудиофайлами*/
        JPanel controlPanelAudioResult = new JPanel(new FlowLayout());
        controlPanelAudioResult.add(saveFilesButtonAudioResult);
        /*Кнопка для сохранения файлов с результатами*/
        controlPanelAudioResult.add(prevButtonAudioResult);
        /*Кнопка для просмотра предыдущего результата*/
        controlPanelAudioResult.add(labelAudioResult);
        /*Метка для отображения статуса выбора аудиофайла*/
        controlPanelAudioResult.add(nextButtonAudioResult);
        /*Кнопка для просмотра следующего результата*/
        controlPanelAudioResult.add(deleteAllButtonAudioResult);
        /*Кнопка для удаления всех результатов*/
        controlPanelAudioResult.add(btnDencryptAudio);
        /*Кнопка для дешифрования аудиофайла*/

        /*Создаем главную панель для отображения результатов работы с аудиофайлами и их управления*/
        JPanel mainPanelAudioResult = new JPanel(new BorderLayout());
        mainPanelAudioResult.add(scrollPaneAudioResult, BorderLayout.CENTER);
        /*Добавляем список результатов на главную панель*/
        mainPanelAudioResult.add(controlPanelAudioResult, BorderLayout.SOUTH);
        /*Добавляем панель управления результатами на главную панель*/


        /*Добавляем слушателя для элемента меню "Вводите текст",
        который вызывает метод для отображения панели с элементами для ввода текста*/
        inputTextMenuItem.addActionListener(e -> showPanel(encodeControls, pKeyword, pControls));

        /*Добавляем слушателя для элемента меню "Вводите шифр",
        который вызывает метод для отображения панели с элементами для ввода шифра*/
        inputCipherMenuItem.addActionListener(e -> showPanel(encodeControlsCode, pKeyword, pControls));

        /*Добавляем слушателя для элемента меню "Результат",
        который вызывает метод для отображения панели с результатами*/
        resultMenuItem.addActionListener(e -> showPanel(encodeControlsResult, pKeyword, pControls));

        /*Добавляем слушателя для элемента меню "Вводите изображение",
        который вызывает метод для отображения панели для работы с изображениями*/
        inputImageMenuItem.addActionListener(e -> showPanelImage(pKeyword, buttonPanel, pControls, statusPanel));

        /*Добавляем слушателя для элемента меню "Результат" для изображений,
        который выполняет загрузку изображений, их отображение и масштабирование*/
        resultMenuItemImage.addActionListener(e -> {
            loadImagesFromFolderResult();
            /*Загружаем изображения из папки результата*/
            showPanelImageResult(pKeyword, pControls, statusPanelResult, scrollPaneResult, buttonPanelRez);
            /*Отображаем результаты работы с изображениями*/
            scaleImageToFitResult();
            /*Масштабируем изображения для подгонки к размерам*/
            scrollPaneResult.revalidate();
            /*Перерисовываем панель прокрутки*/
        });

        /*Добавляем слушателя для элемента меню "Вводите видео",
        который вызывает метод для отображения панели для работы с видео*/
        inputVideoMenuItem.addActionListener(e -> {
            showPanelVideo(mainPanelVideo, pKeyword, pControls);
            /*Отображаем панель для работы с видео*/

            /*Добавляем поддержку перетаскивания файлов только для mainPanelVideo*/
            DropTarget dropTargetVideo = new DropTarget(mainPanelVideo, DnDConstants.ACTION_COPY, new DropTargetAdapter() {
                @Override
                public void drop(DropTargetDropEvent dtde) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    /*Подтверждаем операцию копирования*/
                    Transferable transferable = dtde.getTransferable();
                    /*Получаем передаваемые данные*/
                    if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        /*Проверяем поддерживаемый формат данных*/
                        try {
                            List<File> droppedFiles = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                            /*Получаем список переданных файлов*/
                            for (File file : droppedFiles) {
                                /*Итерируем по списку файлов*/
                                if (file.isFile() && isVideoFile(file)) {
                                    /*Проверяем, является ли файл видеофайлом*/
                                    copyVideoFile(file);
                                    /*Копируем видеофайл*/
                                    nextVideo();
                                    /*Переходим к следующему видео*/
                                } else {
                                    /*Выводим сообщение об ошибке, если файл не является видеофайлом*/
                                    JOptionPane.showMessageDialog(StealthchatNew.this,
                                            "Ошибка загрузки видео",
                                            "Ошибка",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            /*Выводим информацию об ошибке в консоль*/
                        }
                    }
                    dtde.dropComplete(true);
                    /*Завершаем операцию перетаскивания*/
                }
            });
        });

        /*Добавляем слушатель для пункта меню "Результат видео"*/
        resultMenuItemVideo.addActionListener(e -> showPanelVideo(mainPanelVideoResult, pKeyword, pControls));

        /*Добавляем слушатель для пункта меню "Вводите аудио", который также включает поддержку перетаскивания файлов*/
        inputAudioMenuItem.addActionListener(e -> {
            /*Отображаем панель для работы с аудио*/
            showPanelVideo(mainPanelAudio, pKeyword, pControls);

            /*Добавляем поддержку перетаскивания файлов только для mainPanelAudio*/
            DropTarget dropTargetAudio = new DropTarget(mainPanelAudio, DnDConstants.ACTION_COPY, new DropTargetAdapter() {
                @Override
                public void drop(DropTargetDropEvent dtde) {
                    /*Подтверждаем операцию копирования*/
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);

                    /*Получаем передаваемые данные*/
                    Transferable transferable = dtde.getTransferable();
                    /*Проверяем поддерживаемый формат данных*/
                    if (transferable.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        try {
                            /*Получаем список переданных файлов*/
                            List<File> droppedFiles = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                            /*Итерируем по списку файлов*/
                            for (File file : droppedFiles) {
                                /*Проверяем, является ли файл аудиофайлом*/
                                if (file.isFile() && isFileAudio(file)) {
                                    /*Копируем аудиофайл*/
                                    copyVideoFileAudio(file);
                                    /*Переходим к следующему аудио*/
                                    nextAudio();
                                } else {
                                    /*Выводим сообщение об ошибке, если файл не является аудиофайлом*/
                                    JOptionPane.showMessageDialog(StealthchatNew.this,
                                            "Ошибка загрузки аудио",
                                            "Ошибка",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            /*Выводим информацию об ошибке в консоль*/
                        }
                    }
                    dtde.dropComplete(true);
                    /*Завершаем операцию перетаскивания*/
                }
            });
        });

        /*Добавляем слушатель для пункта меню "Результат аудио"*/
        resultMenuItemAudio.addActionListener(e -> showPanelVideo(mainPanelAudioResult, pKeyword, pControls));

        /*Закрываем приложение при нажатии на крестик*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Создаем объекты для шифрования и дешифрования файлов*/
        encryptFiles = new EncryptFiles(tfKeyword, textField, textResult);
        decryptFiles = new DecryptFiles(textCode, textResult, tfKeyword);

        /*Устанавливаем размеры окна*/
        setSize(1401, 701);
        setMinimumSize(new Dimension(1400, 700));

        /*Загружаем стиль приложения*/
        loadStyle();

    }

    /*Создание слушателя для кнопок*/
    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {
        /*Определяем, какое действие было выполнено на основе команды действия*/
        /*Обработчик событий для различных команд*/
        switch (ae.getActionCommand()) {

            case "cmd_encrypt_image" -> encryptFiles.encryptCheckImage();
            /*Вызываем метод для зашифровки текста*/
            case "cmd_decifer_text" -> decryptFiles.deciferCheck();
            /*Вызов метода для расшифровки текстовых сообщений*/
            case "cmd_encrypt_text" -> encryptFiles.encryptCheck();
            /*Вызываем метод для зашифровки текста*/
            case "cmd_dencrypt_image" -> decryptFiles.dencryptCheckImage();
            /*Вызываем метод для дешифровки изображения*/
            case "cmd_encrypt_video" -> encryptFiles.encryptCheckVideo();
            /*Вызываем метод для шифрования видео*/
            case "cmd_encrypt_audio" -> encryptFiles.encryptCheckAudio();
            /*Вызываем метод для шифрования аудио*/
            case "cmd_prev_button" -> showPreviousImage();
            /*Отображаем предыдущее изображение*/
            case "cmd_next_button" -> showNextImage();
            /*Отображаем следующее изображение*/
            case "cmd_delete_button" -> deleteCurrentImage();
            /*Удаляем текущее изображение*/
            case "cmd_delete_button_all" -> deleteAllImage();
            /*Удаляем все изображения*/
            case "cmd_save_files_image" -> saveFiles("output_image");
            /*Сохраняем файлы изображений*/
            case "cmd_next_button_audio_result" -> nextAudioResult();
            /*Переходим к следующему аудио результату*/
            case "cmd_prev_button_audio_result" -> prevAudioResult();
            /*Переходим к предыдущему аудио результату*/
            case "cmd_delete_all_button_audio_result" -> deleteAllFilesAndPathsAudioResult();
            /*Удаляем все файлы и пути для аудио результатов*/
            case "cmd_save_files_button_audio_result" -> saveFiles("output_audio");
            /*Сохраняем файлы аудио результатов*/
            case "cmd_open_button_audio" -> openAudio();
            /*Открываем аудио файл*/
            case "cmd_next_button_audio" -> nextAudio();
            /*Переходим к следующему аудио*/
            case "cmd_prev_button_audio" -> prevAudio();
            /*Переходим к предыдущему аудио*/
            case "cmd_delete_button_audio" -> deleteCurrentAudio();
            /*Удаляем текущее аудио*/
            case "cmd_delete_all_button_audio" -> deleteAllFilesAndPathsAudio();
            /*Удаляем все файлы и пути для аудио*/
            case "cmd_prev_button_result" -> showPreviousImageResult();
            /*Отображаем предыдущий результат*/
            case "cmd_delete_button_all_result" -> deleteAllImageResult();
            /*Удаляем все результаты изображений*/
            case "cmd_next_button_video_result" -> nextVideoResult();
            /*Переходим к следующему видео результату*/
            case "cmd_prev_button_video_result" -> prevVideoResult();
            /*Переходим к предыдущему видео результату*/
            case "cmd_delete_all_button_video_result" -> deleteAllFilesAndPathsVideoResult();
            /*Удаляем все файлы и пути для видео результатов*/
            case "cmd_save_files_button_video_result" -> saveFiles("output_video");
            /*Сохраняем файлы видео результатов*/
            case "cmd_open_button_video" -> openVideo();
            /*Открываем видео файл*/
            case "cmd_next_button_video" -> nextVideo();
            /*Переходим к следующему видео*/
            case "cmd_prev_button_video" -> prevVideo();
            /*Переходим к предыдущему видео*/
            case "cmd_delete_button_video" -> deleteCurrentVideo();
            /*Удаляем текущее видео*/
            case "cmd_delete_all_button_video" -> deleteAllFilesAndPaths();
            /*Удаляем все файлы и пути*/
            case "cmd_style" -> changeStyle();
            /*Изменяем стиль приложения*/
            case "cmd_open_text_file" -> openFileText();
            /*Открываем текстовый файл*/
            case "cmd_save_text_file" -> saveFileText();
            /*Сохраняем текстовый файл*/
            case "cmd_open_result_file" -> openFileResult();
            /*Открываем результатный файл*/
            case "cmd_save_result_file" -> saveFileResult();
            /*Сохраняем результатный файл*/
            case "cmd_open_code_file" -> openFileCode();
            /*Открываем файл с кодом*/
            case "cmd_save_code_file" -> saveFileCode();
            /*Сохраняем файл с кодом*/
            case "cmd_next_button_result" -> showNextImageResult();
            /*Отображаем следующий результат*/
            case "cmd_clear_keyword" -> tfKeyword.setText("");
            /*Очищаем поле ключа*/
            case "cmd_clear_text" -> textField.setText("");
            /*Очищаем поле текста*/
            case "cmd_clear_result" -> textResult.setText("");
            /*Очищаем поле результата*/
            /*Установка пустого текста в поле для кода*/
            case "cmd_clear_text_code" -> textCode.setText("");

            /*Дешифрование видео и добавление видео из выходной папки результатов*/
            case "cmd_decrypt_video" -> {
                decryptFiles.dencryptCheckVideo();
                addVideosFromOutputFolderVideoResult();
            }

            /*Дешифрование аудио и добавление аудио из выходной папки результатов*/
            case "cmd_decrypt_audio" -> {
                decryptFiles.dencryptCheckAudio();
                addFromOutputFolderAudioResult();
            }

            /*Очистка всех полей и удаление всех файлов и путей*/
            case "cmd_clear_all_fields" -> {
                clearText();
                /*Очищаем все поля для текста*/
                if(scrollPane!=null){
                    deleteAllImage();
                    /*Очищаем все поля для изображения*/
                }
                if(scrollPaneResult!=null){
                    deleteAllImageResult();
                    /*Очищаем все поля для изображения*/
                }
                deleteAllFilesAndPaths();
                /*Удаляем все файлы и пути*/
                deleteAllFilesAndPathsVideoResult();
                /*Удаляем все файлы и пути*/
                deleteAllFilesAndPathsAudio();
                /*Удаляем все файлы и пути*/
                deleteAllFilesAndPathsAudioResult();
                /*Удаляем все файлы и пути*/
            }

            /*Генерация ключа и установка его в текстовое поле*/
            case "cmd_key_generation" -> {
                String array = generateKey();
                tfKeyword.setText(array);
                /*Генерируем и устанавливаем ключ*/
            }

            /*Закрытие приложения и удаление всех изображений*/
            case "cmd_close_window" -> {
                deleteAllImages();
                /*Удаляем все изображения*/
                System.exit(0);
                /*Закрываем приложение*/
            }

            case "cmd_text_field_copy" -> {
                String textToCopy = textField.getText();
                copyTextToClipboard(textToCopy);
                /*Копируем текст из поля ввода в буфер обмена*/
            }
            case "cmd_text_result_cope" -> {
                String textToCopy2 = textResult.getText();
                copyTextToClipboard(textToCopy2);
                /*Копируем текст из поля вывода в буфер обмена*/
            }
            case "cmd_text_code_cope" -> {
                String textToCopy2 = textCode.getText();
                copyTextToClipboard(textToCopy2);
                /*Копируем текст из поля вывода в буфер обмена*/
            }
            case "cmd_keycopy" -> {
                String textToCopy3 = tfKeyword.getText();
                copyTextToClipboard(textToCopy3);
                /*Копируем ключ в буфер обмена*/
            }
            case "cmd_paste_text_field" -> {
                String clipboardText1 = pasteTextFromClipboard();
                textField.append(clipboardText1);
                /*Вставляем текст из буфера обмена в поле ввода текста*/
            }
            case "cmd_paste_text_result" -> {
                String clipboardText2 = pasteTextFromClipboard();
                textResult.append(clipboardText2);
                /*Вставляем текст из буфера обмена в поле вывода текста*/
            }
            case "cmd_paste_text_code" -> {
                String clipboardText2 = pasteTextFromClipboard();
                textCode.append(clipboardText2);
                /*Вставляем текст из буфера обмена в поле вывода текста*/
            }
            case "cmd_paste_key" -> {
                String clipboardText3 = pasteTextFromClipboard();
                tfKeyword.setText(clipboardText3);
                /*Вставляем текст из буфера обмена в поле ключа*/
            }
            /*Запуск потока проверки орфографии*/
            case "cmd_text_editing" -> {
                SpellCheckThread spellCheckThread = new SpellCheckThread(textField);
                spellCheckThread.run();
            }

            /*Открытие файла изображения*/
            case "cmd_open_button" -> {
                /*Проверяем, есть ли место для дополнительных изображений*/
                if (images.size() > 25) {
                    /*Выводим сообщение об ошибке, если место для изображений закончилось*/
                    JOptionPane.showMessageDialog(StealthchatNew.this,
                            "Место для изображений закончилось.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    /*Открываем диалоговое окно выбора файла*/
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showOpenDialog(StealthchatNew.this);

                    /*Если пользователь выбрал файл*/
                    if (result == JFileChooser.APPROVE_OPTION) {
                        /*Получаем выбранный файл*/
                        File selectedFile = fileChooser.getSelectedFile();
                        /*Загружаем изображение*/
                        loadImage(selectedFile);
                    }
                }
            }

        }
    }

    // Метод для переключения между панелями
    private void showPanel(JPanel encodeControls, JPanel pKeyword, JPanel pControls) {
        // Очищаем содержимое основного контейнера
        getContentPane().removeAll();
        // Добавляем новую панель с элементами управления
        getContentPane().add(encodeControls, BorderLayout.CENTER);
        // Добавляем верхнюю панель с ключом
        add(pKeyword, java.awt.BorderLayout.NORTH);
        // Добавляем нижнюю панель с элементами управления
        add(pControls, java.awt.BorderLayout.SOUTH);
        // Пересоздаем интерфейс
        revalidate();
        // Обновляем интерфейс
        repaint();
    }

    /*Метод для отображения панели с результатами изображения*/
    private void showPanelImageResult(JPanel pKeyword, JPanel pControls, JPanel statusPanelResult, JScrollPane scrollPaneResult, JPanel buttonPanelRez) {

        /*/Получаем контейнер для отображения результатов*/
        Container containerResult = getContentPane();
        /*Устанавливаем компоновщик BorderLayout для контейнера*/
        containerResult.setLayout(new BorderLayout());
        /*Очищаем содержимое контейнера*/
        containerResult.removeAll();
        /*Добавляем панель с результатами изображения*/
        containerResult.add(scrollPaneResult, BorderLayout.CENTER);

        /*Создаем панель для описания изображения*/
        JPanel decription = new JPanel();
        decription.setLayout(new BorderLayout());

        /*Добавляем верхнюю панель с ключом*/
        decription.add(pKeyword, BorderLayout.NORTH);
        /*Добавляем нижнюю панель с кнопками*/
        decription.add(buttonPanelRez, BorderLayout.SOUTH);

        /*Добавляем панель с описанием и панель с кнопками к контейнеру*/
        containerResult.add(decription, BorderLayout.NORTH);
        /*Создаем панель для размещения статуса и элементов управления*/
        JPanel buttonResult = new JPanel();
        buttonResult.setLayout(new BoxLayout(buttonResult, BoxLayout.Y_AXIS));
        buttonResult.add(statusPanelResult);
        buttonResult.add(pControls);
        /*Добавляем эту панель к контейнеру*/
        containerResult.add(buttonResult, BorderLayout.SOUTH);

        /*Добавляем слушателя изменения размеров для масштабирования изображения*/
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleImageToFitResult();
            }
        });

        /*Делаем контейнер видимым*/
        setVisible(true);
        /*Обновляем контейнер*/
        containerResult.revalidate();
        /*Обновляем интерфейс*/
        containerResult.repaint();

    }

    private void showPanelVideo(JPanel buttonPanelVideo, JPanel pKeyword, JPanel pControls) {
        /*Получаем родительскую панель для кнопки*/
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        /*Очищаем содержимое контейнера*/
        container.removeAll();
        /*Добавляем панель с кнопками видео в центр контейнера*/
        container.add(buttonPanelVideo, BorderLayout.CENTER);
        /*Добавляем верхнюю панель с ключом*/
        container.add(pKeyword, BorderLayout.NORTH);
        /*Добавляем нижнюю панель с элементами управления*/
        container.add(pControls, BorderLayout.SOUTH);

        /*Пересоздаем интерфейс*/
        container.revalidate();
        /*/Обновляем интерфейс*/
        container.repaint();
    }

    private void showPanelImage(JPanel pKeyword, JPanel buttonPanel, JPanel pControls, JPanel statusPanel) {
        /*Получаем контейнер для отображения изображения*/
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        /*Очищаем содержимое контейнера*/
        container.removeAll();

        /*Создаем верхнюю панель, содержащую кнопки, ключ и панель состояния*/
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(buttonPanel, BorderLayout.CENTER);
        /*Добавляем кнопки изображения*/
        topPanel.add(pKeyword, BorderLayout.NORTH);
        /*Добавляем верхнюю панель с ключом*/
        container.add(topPanel, BorderLayout.NORTH);

        /*Создаем панель прокрутки для отображения изображения*/
        scrollPane = new JScrollPane(new ImagePanel());
        container.add(scrollPane, BorderLayout.CENTER);
        /*Добавляем панель прокрутки с изображением*/

        /*Создаем нижнюю панель, содержащую элементы управления и панель состояния*/
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(pControls, BorderLayout.SOUTH);
        /*Добавляем элементы управления*/
        bottomPanel.add(statusPanel, BorderLayout.NORTH);
        /*Добавляем панель состояния*/
        container.add(bottomPanel, BorderLayout.SOUTH);

        /*Пересоздаем интерфейс*/
        container.revalidate();
        /*Обновляем интерфейс*/
        container.repaint();

        /*Устанавливаем обработчик перетаскивания изображений*/
        setTransferHandler(new ImageTransferHandler());

        /*Создаем папку для загруженных изображений, если она не существует*/
        uploadedImagesFolder = new File("input_image/");
        if (!uploadedImagesFolder.exists()) {
            uploadedImagesFolder.mkdir();
        }

        /*Добавляем слушателя изменения размеров для масштабирования изображения*/
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleImageToFit();
            }
        });
    }

    private void showPreviousImageResult() {
        /*Показывает предыдущее изображение в результате, если оно существует*/
        if (currentIndexResult > 0) {
            currentIndexResult--;
            updateImageInfoResult();
            /*Обновляет информацию об изображении*/
            scaleImageToFitResult();
            /*Масштабирует изображение, чтобы оно поместилось в окно*/
        }
    }

    private void showNextImageResult() {
        /*Показывает следующее изображение в результате, если оно существует*/
        if (currentIndexResult < imagesResult.size() - 1) {
            currentIndexResult++;
            updateImageInfoResult();
            /*Обновляет информацию об изображении*/
            scaleImageToFitResult();
            /*Масштабирует изображение, чтобы оно поместилось в окно*/
        }
    }

    private void nextAudioResult() {
        /*Показывает следующий аудиофайл в результатах, если они существуют*/
        if (!pathsAudioResult.isEmpty()) {
            currentIndexAudioResult = (currentIndexAudioResult + 1) % pathsAudioResult.size();
            displayCurrentAudioResult();
            /*Отображает текущий аудиофайл*/
        }
    }

    private void prevAudioResult() {
        /*Показывает предыдущий аудиофайл в результатах, если они существуют*/
        if (!pathsAudioResult.isEmpty()) {
            currentIndexAudioResult = (currentIndexAudioResult - 1 + pathsAudioResult.size()) % pathsAudioResult.size();
            displayCurrentAudioResult();
            /*Отображает текущий аудиофайл*/
        }
    }

    private void nextAudio() {
        /*Показывает следующий аудиофайл, если они существуют*/
        if (!pathsAudio.isEmpty()) {
            currentIndexAudio = (currentIndexAudio + 1) % pathsAudio.size();
            displayCurrentAudio();
            /*Отображает текущий аудиофайл*/
        }
    }

    private void prevAudio() {
        /*Показывает предыдущий аудиофайл, если они существуют*/
        if (!pathsAudio.isEmpty()) {
            currentIndexAudio = (currentIndexAudio - 1 + pathsAudio.size()) % pathsAudio.size();
            displayCurrentAudio();
            /*Отображает текущий аудиофайл*/
        }
    }

    private void nextVideoResult() {
        /*Показывает следующий видеофайл в результатах, если они существуют*/
        if (!pathsVideoResult.isEmpty()) {
            currentIndexVideoResult = (currentIndexVideoResult + 1) % pathsVideoResult.size();
            displayCurrentVideoResult();
            /*Отображает текущий видеофайл*/
        }
    }

    private void prevVideoResult() {
        /*Показывает предыдущий видеофайл в результатах, если они существуют*/
        if (!pathsVideoResult.isEmpty()) {
            currentIndexVideoResult = (currentIndexVideoResult - 1 + pathsVideoResult.size()) % pathsVideoResult.size();
            displayCurrentVideoResult();
            /*Отображает текущий видеофайл*/
        }
    }

    private void nextVideo() {
        // Показывает следующий видеофайл, если они существуют
        if (!pathsVideo.isEmpty()) {
            currentIndexVideo = (currentIndexVideo + 1) % pathsVideo.size();
            displayCurrentVideo(); // Отображает текущий видеофайл
        }
    }

    private void prevVideo() {
        /*Показывает предыдущий видеофайл, если они существуют*/
        if (!pathsVideo.isEmpty()) {
            currentIndexVideo = (currentIndexVideo - 1 + pathsVideo.size()) % pathsVideo.size();
            displayCurrentVideo();
            /*Отображает текущий видеофайл*/
        }
    }

    private void deleteAllFilesAndPathsAudioResult() {
        /*Удаляет все аудиофайлы и пути к ним из результатов*/
        for (String audioPath : pathsAudioResult) {
            File fileToDelete = new File(audioPath);
            fileToDelete.delete();
            /*Удаляет файл*/
        }
        listModelAudioResult.clear();
        /*Очищает список аудиофайлов*/
        pathsAudioResult.clear();
        /*Очищает пути к аудиофайлам*/
        currentIndexAudioResult = -1;
        /*Сбрасывает индекс текущего аудиофайла*/
        labelAudioResult.setText("Выберите видео");
        /*Устанавливает текст на метке*/
    }

    private void deleteCurrentAudio() {
        /*Удаляет текущий аудиофайл, если он существует*/
        if (!pathsAudio.isEmpty() && currentIndexAudio >= 0 && currentIndexAudio < pathsAudio.size()) {
            listModelAudio.removeElementAt(currentIndexAudio);
            /*Удаляет элемент из списка*/
            File fileToDelete = new File(pathsAudio.get(currentIndexAudio));
            fileToDelete.delete();
            /*Удаляет файл с диска*/
            pathsAudio.remove(currentIndexAudio);
            /*Удаляет путь к файлу из списка*/
            updateFileNumbersAudio();
            /*Обновляет номера файлов после удаления*/
            if (!pathsAudio.isEmpty()) {
                currentIndexAudio = Math.min(currentIndexAudio, pathsAudio.size() - 1);
                displayCurrentAudio();
                /*Отображает текущий аудиофайл*/
            } else {
                labelAudio.setText("Выберите аудио");
            }
        }
    }

    private void deleteAllFilesAndPathsAudio() {
        /*Удаляет все аудиофайлы и их пути*/
        for (String audioPath : pathsAudio) {
            File fileToDelete = new File(audioPath);
            fileToDelete.delete();
            /*Удаляет файл с диска*/
        }
        listModelAudio.clear();
        /*Очищает список аудиофайлов*/
        pathsAudio.clear();
        /*Очищает пути к аудиофайлам*/
        currentIndexAudio = -1;
        /*Сбрасывает индекс текущего аудиофайла*/
        labelAudio.setText("Выберите аудио");
        /*Устанавливает текст на метке*/
    }

    private void deleteAllFilesAndPathsVideoResult() {
        /*Удаляет все видеофайлы и их пути из результатов*/
        for (String videoPath : pathsVideoResult) {
            File fileToDelete = new File(videoPath);
            fileToDelete.delete();
            /*Удаляет файл с диска*/
        }
        listModelVideoResult.clear();
        /*Очищает список видеофайлов*/
        pathsVideoResult.clear();
        /*Очищает пути к видеофайлам*/
        currentIndexVideoResult = -1;
        /*Сбрасывает индекс текущего видеофайла*/
        labelVideoResult.setText("Видео не загружено");
        /*Устанавливает текст на метке*/
    }

    private void deleteAllImage() {
        /*Удаляет все изображения из папки "input_image"*/
        File folder = new File("input_image");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("Файл " + file.getName() + " удален успешно.");
                    } else {
                        System.err.println("Не удалось удалить файл " + file.getName());
                    }
                }
            }
        }
        images.clear();
        /*Очищает список изображений*/
        currentIndex = 0;
        /*Сбрасывает индекс текущего изображения*/
        updateImageInfo();
        /*Обновляет информацию об изображении*/
        scaleImageToFit();
        /*Масштабирует изображение для соответствия размерам окна*/
        refreshScrollPane();
        /*Обновляет панель прокрутки*/
    }

    private void deleteAllImageResult() {
        /*Удаляет все изображения из папки "output_image"*/
        File folder = new File("output_image");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("Файл " + file.getName() + " удален успешно.");
                    } else {
                        System.err.println("Не удалось удалить файл " + file.getName());
                    }
                }
            }
        }
        imagesResult.clear();
        /*Очищает список изображений*/
        currentIndexResult = 0;
        /*Сбрасывает индекс текущего изображения*/
        updateImageInfo();
        /*Обновляет информацию об изображении*/
        scaleImageToFit();
        /*Масштабирует изображение для соответствия размерам окна*/
        refreshScrollPaneResult();
        /*Обновляет панель прокрутки*/
    }

    private void deleteCurrentVideo() {
        /*Удаляет текущий видеофайл, если он существует*/
        if (!pathsVideo.isEmpty() && currentIndexVideo >= 0 && currentIndexVideo < pathsVideo.size()) {
            listModelVideo.removeElementAt(currentIndexVideo);
            /*Удаляет элемент из списка*/
            File fileToDelete = new File(pathsVideo.get(currentIndexVideo));
            fileToDelete.delete();
            /*Удаляет файл с диска*/
            pathsVideo.remove(currentIndexVideo);
            /*Удаляет путь к файлу из списка*/
            updateFileNumbers();
            /*Обновляет номера файлов после удаления*/
            if (!pathsVideo.isEmpty()) {
                currentIndexVideo = Math.min(currentIndexVideo, pathsVideo.size() - 1);
                displayCurrentVideo();
                /*Отображает текущий видеофайл*/
            } else {
                labelVideo.setText("Выберите видео");
            }
        }
    }

    private void deleteAllFilesAndPaths() {
        /*Удаляет все видеофайлы и их пути*/
        for (String videoPath : pathsVideo) {
            File fileToDelete = new File(videoPath);
            fileToDelete.delete();
            /*Удаляет файл с диска*/
        }
        listModelVideo.clear();
        /*Очищает список видеофайлов*/
        pathsVideo.clear();
        /*Очищает пути к видеофайлам*/
        currentIndexVideo = -1;
        /*Сбрасывает индекс текущего видеофайла*/
        labelVideo.setText("Выберите видео");
        /*Устанавливает текст на метке*/
    }

    private void deleteCurrentImage() {
        /*Проверяем, что список изображений не пустой*/
        if (!images.isEmpty()) {
            int deletedIndex = currentIndex + 1;
            /*Индекс удаляемого изображения (1-based)*/

            File folder = new File("input_image");
            /*Получаем папку с изображениями*/
            File[] files = folder.listFiles();
            /*Получаем список файлов в папке*/

            /*Проверяем, что список файлов не пустой и содержит достаточное количество файлов*/
            if (files != null && files.length >= deletedIndex) {
                File deletedFile = files[deletedIndex - 1];
                /*Получаем удаляемый файл (индексация 0-based)*/

                if (deletedFile.exists()) {
                    /*Проверяем, что файл существует*/
                    if (deletedFile.delete()) {
                        /*Удаляем файл с диска*/
                        System.out.println("Файл " + deletedFile.getName() + " удален успешно.");
                    } else {
                        System.err.println("Не удалось удалить файл " + deletedFile.getName());
                    }
                }

                images.remove(currentIndex);
                /*Удаляем изображение из списка*/

                /*Обновляем текущий индекс и проверяем, что он не выходит за границы списка*/
                if (currentIndex >= images.size() && currentIndex > 0) {
                    currentIndex = images.size() - 1;
                }

                updateImageInfo();
                /*Обновляем информацию об изображении*/
                scaleImageToFit();
                /*Масштабируем изображение для соответствия размерам окна*/
                refreshScrollPane();
                /*Обновляем панель прокрутки*/
            }
        }
    }

    private void deleteAllImages() {
        /*Удаляет все файлы изображений из указанных папок*/
        String[] folderNames = {"input_image/", "output_image/", "input_video/", "input_audio/", "output_audio", "output_video"}; // Указываем имена папок
        for (String folderName : folderNames) {
            File folder = new File(folderName);
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                    /*Удаляем файл с диска*/
                }
            }
        }
    }

    /*Очищает текстовые поля: ключа (tfKeyword),
    ввода текста (textField) и вывода результата (textResult, textCode)*/
    public void clearText() {
        /*Очищаем поле ключа*/
        tfKeyword.setText("");
        /*Очищаем поле ввода текста*/
        textField.setText("");
        /*Очищаем поле вывода результата*/
        textResult.setText("");
        /*Очищаем поле кода*/
        textCode.setText("");
    }

    private void displayCurrentAudioResult() {
        /*Отображает текущее аудиофайл в результатах*/
        labelAudioResult.setText("Аудио: " + (currentIndexAudioResult + 1) + " / " + pathsAudioResult.size());
    }

    private void displayCurrentAudio() {
        /*Отображает текущее аудиофайл*/
        labelAudio.setText("Аудио: " + (currentIndexAudio + 1) + " / " + pathsAudio.size());
    }

    private void displayCurrentVideoResult() {
        /*Отображает текущий видеофайл в результатах*/
        labelVideoResult.setText("Видео: " + (currentIndexVideoResult + 1) + " / " + pathsVideoResult.size());
    }

    private void updateImageInfoResult() {
        /*Обновляет информацию о текущем изображении в результатах*/
        imageNumberLabelResult.setText("Номер изображения: " + (currentIndexResult + 1));
    }

    private void updateImageInfo() {
        /*Обновляет информацию о текущем изображении*/
        imageNumberLabel.setText("Номер изображения: " + (currentIndex + 1));
    }

    private void displayCurrentVideo() {
        /*Отображает текущий видеофайл*/
        labelVideo.setText("Видео: " + (currentIndexVideo + 1) + " / " + pathsVideo.size());
    }

    private void addFromOutputFolderAudioResult() {
        /*Добавляет аудиофайлы из папки "output_audio" в список результатов*/
        File outputFolder = new File("output_audio");
        if (outputFolder.exists() && outputFolder.isDirectory()) {
            File[] files = outputFolder.listFiles();
            if (files != null) {
                int startIndex = listModelAudioResult.size() + 1;
                /*Стартовый индекс для нумерации*/
                for (File file : files) {
                    if (file.isFile()) {
                        String filename = file.getName();
                        listModelAudioResult.addElement(startIndex + ". " + filename);
                        /*Добавляем с номером*/
                        pathsAudioResult.add(file.getAbsolutePath());
                        startIndex++;
                    }
                }
                /*Обновляем метку для аудиофайлов*/
                if (!pathsAudioResult.isEmpty()) {
                    currentIndexAudioResult = pathsAudioResult.size() - 1;
                    labelAudioResult.setText("Аудио: " + (currentIndexAudioResult + 1) + " / " + pathsAudioResult.size());
                }
            }
        }
    }

    public void addVideosFromOutputFolderVideoResult() {
        /*Добавляет видеофайлы из папки "output_video" в список результатов*/
        File outputFolder = new File("output_video");
        if (outputFolder.exists() && outputFolder.isDirectory()) {
            File[] files = outputFolder.listFiles();
            if (files != null) {
                int startIndex = listModelVideoResult.size() + 1;
                /*Стартовый индекс для нумерации*/
                for (File file : files) {
                    if (file.isFile()) {
                        String filename = file.getName();
                        listModelVideoResult.addElement(startIndex + ". " + filename);
                        /*Добавляем с номером*/
                        pathsVideoResult.add(file.getAbsolutePath());
                        startIndex++;
                    }
                }
                /*Обновляем метку для видеофайлов*/
                if (!pathsVideoResult.isEmpty()) {
                    currentIndexVideoResult = pathsVideoResult.size() - 1;
                    labelVideoResult.setText("Видео: " + (currentIndexVideoResult + 1) + " / " + pathsVideoResult.size());
                }
            }
        }
    }

    private void openAudio() {
        /*Открывает диалоговое окно для выбора аудиофайлов*/
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                if (!isFileAudio(file)) {
                    JOptionPane.showMessageDialog(StealthchatNew.this,
                            "Ошибка загрузки видео",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
                String filename = file.getName();
                File destFile = new File("input_audio" + File.separator + filename);
                if (destFile.exists()) {
                    JOptionPane.showMessageDialog(this, "Файл с именем " + filename + " уже существует", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    continue;
                    /*Пропускаем этот файл и переходим к следующему*/
                }
                try {
                    copyVideoFileAudio(file);
                    nextAudio();
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Ошибка при копировании файла: " + filename, "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /*Открывает файл с результатом*/
    private void openFileResult() {
        /*Открывает диалоговое окно для выбора файла*/
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                /*Читает текст из файла и отображает его в текстовом поле результата*/
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder text = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                reader.close();
                textResult.setText(text.substring(0, text.length() - 1));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    /*Открывает текстовый файл и отображает его содержимое в текстовом поле*/
    private void openFileText() {
        /*Открывает диалоговое окно для выбора файла*/
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                /*Читает текст из файла и отображает его в текстовом поле ввода*/
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder text = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                reader.close();
                textField.setText(text.substring(0, text.length() - 1));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    /*Открывает файл с кодом и отображает его содержимое в текстовом поле для кода*/
    private void openFileCode() {
        /*Открывает диалоговое окно для выбора файла*/
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                /*Читает текст из файла и отображает его в текстовом поле для кода*/
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder text = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                reader.close();
                textCode.setText(text.substring(0, text.length() - 1));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    private void openVideo() {
        /*Открывает диалоговое окно для выбора видеофайлов*/
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                if (!isVideoFile(file)) {
                    JOptionPane.showMessageDialog(StealthchatNew.this,
                            "Ошибка загрузки видео",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
                String filename = file.getName();
                File destFile = new File("input_video" + File.separator + filename);
                if (destFile.exists()) {
                    JOptionPane.showMessageDialog(this,
                            "Файл с именем " + filename + " уже существует",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    break;
                }
                try {
                    copyVideoFile(file);
                    nextVideo();
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this,
                            "Ошибка при копировании файла: " + filename,
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    private boolean isFileAudio(File file) {
        /*Проверяет, является ли файл аудиофайлом по расширению*/
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        return extension.equals("mp3") || extension.equals("wav");
    }

    private void copyVideoFileAudio(File sourceFile) throws IOException {
        /*Копирует выбранный аудиофайл в папку "input_audio"*/
        String filename = sourceFile.getName();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);
        String newFilename = (pathsAudio.size() + 1) + "." + extension;
        File destFile = new File("input_audio" + File.separator + newFilename);
        if (destFile.exists()) {
            JOptionPane.showMessageDialog(this, "Файл с именем " + newFilename + " уже существует", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        listModelAudio.addElement((pathsAudio.size() + 1) + ". " + filename);
        /*Добавляем номер файла перед именем в список отображаемых файлов*/
        pathsAudio.add(destFile.getAbsolutePath());
        labelAudio.setText(filename);
        /*Обновляем отображаемое имя аудио на экране*/
    }

    private void updateFileNumbersAudio() {
        /*Обновляет номера аудиофайлов в списке*/
        for (int i = 0; i < listModelAudio.size(); i++) {
            String oldElement = listModelAudio.getElementAt(i);
            String[] parts = oldElement.split("\\. ", 2);
            /*Разделяем номер файла и имя файла*/
            listModelAudio.setElementAt((i + 1) + ". " + parts[1], i);
            /*Обновляем номера файлов в списке*/
        }
    }

    private void loadImageResult(File file) {
        /*Загружает изображение из файла и добавляет его в список результатов*/
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = bufferedImage.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);
            imagesResult.add(image);

            updateImageInfoResult();
            scaleImageToFitResult();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ошибка загрузки изображения", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isVideoFile(File file) {
        /*Проверяет, является ли файл видеофайлом по расширению*/
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        return extension.equals("mp4") || extension.equals("avi") || extension.equals("mkv");
    }

    private void copyVideoFile(File sourceFile) throws IOException {
        /*Копирует выбранный видеофайл в папку "input_video"*/
        String filename = sourceFile.getName();
        String extension = filename.substring(filename.lastIndexOf(".") + 1);
        String newFilename = (pathsVideo.size() + 1) + "." + extension;
        File destFile = new File("input_video" + File.separator + newFilename);
        if (destFile.exists()) {
            JOptionPane.showMessageDialog(this, "Файл с именем " + newFilename + " уже существует", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        listModelVideo.addElement((pathsVideo.size() + 1) + ". " + filename);
        /*Добавляем номер файла перед именем в список отображаемых файлов*/
        pathsVideo.add(destFile.getAbsolutePath());
        labelVideo.setText(filename);
        /*Обновляем отображаемое имя видео на экране*/
    }

    private void updateFileNumbers() {
        /*Обновляет номера видеофайлов в списке*/
        for (int i = 0; i < listModelVideo.size(); i++) {
            String oldElement = listModelVideo.getElementAt(i);
            String[] parts = oldElement.split("\\. ", 2);
            /*Разделяем номер файла и имя файла*/
            listModelVideo.setElementAt((i + 1) + ". " + parts[1], i);
            /*Обновляем номера файлов в списке*/
        }
    }

    private void scaleImageToFitResult() {
        /*Масштабирует изображение для соответствия размерам панели результатов*/
        if (!imagesResult.isEmpty()) {
            Image currentImage = imagesResult.get(currentIndexResult);

            int panelWidth = scrollPaneResult.getWidth();
            int panelHeight = scrollPaneResult.getHeight();

            double scaleWidth = (double) panelWidth / currentImage.getWidth(null);
            double scaleHeight = (double) panelHeight / currentImage.getHeight(null);

            scaleResult = Math.min(scaleWidth, scaleHeight);

            offsetX = (panelWidth - currentImage.getWidth(null) * scaleResult) / 2;
            offsetY = (panelHeight - currentImage.getHeight(null) * scaleResult) / 2;

            repaint();
        }
    }

    /*Создание внутреннего класса ImagePanelResult, наследующего JPanel*/
    private class ImagePanelResult extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            /*Вызов метода paintComponent() суперкласса для рисования фона*/
            if (!imagesResult.isEmpty()) {
                /*Проверка, что список изображений не пуст*/
                Image currentImage = imagesResult.get(currentIndexResult);
                /*Получение текущего изображения из списка*/
                Graphics2D g2d = (Graphics2D) g.create();
                /*Создание объекта Graphics2D из Graphics*/
                AffineTransform transform = new AffineTransform();
                /*Создание объекта AffineTransform для преобразования изображения*/
                transform.translate(offsetX, offsetY);
                /*Перенос изображения на определенные координаты*/
                transform.scale(scaleResult, scaleResult);
                /*Масштабирование изображения*/
                g2d.drawImage(currentImage, transform, this);
                /*Отрисовка изображения с преобразованием*/
                g2d.dispose();
                /*Освобождение ресурсов Graphics2D*/
            }
        }
    }

    /*Метод загрузки изображений из папки "output_image"*/
    private void loadImagesFromFolderResult() {
        File[] files = new File("output_image/").listFiles();
        /*Получение списка файлов из папки "output_image"*/
        if (files != null) {
            /*Проверка, что список файлов не пуст*/
            for (File file : files) {
                /*Итерация по каждому файлу в списке*/
                loadImageResult(file);
                /*Загрузка изображения из файла*/
            }
        }
    }

    /*Внутренний класс ImageTransferHandler, расширяющий TransferHandler*/
    private class ImageTransferHandler extends TransferHandler {
        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
            /*Проверка, поддерживается ли передача списка файлов*/
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                /*Проверка, что импорт данных поддерживается*/
                return false;
            }

            Transferable transferable = support.getTransferable();
            /*Получение объекта Transferable*/

            try {
                List<File> files = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor); // Получение списка файлов из Transferable
                for (File file : files) {
                    /*Итерация по каждому файлу в списке*/
                    if (images.size() > 25) {
                        /*Проверка, что количество изображений не превышает 25*/
                        JOptionPane.showMessageDialog(StealthchatNew.this,
                                /*Вывод сообщения об ошибке*/
                                "Место для изображений закончилось.",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    } else {
                        if (file.isFile()) {
                            /*Проверка, что файл является файлом, а не директорией*/
                            loadImage(file);
                            /*Загрузка изображения из файла*/
                        }
                    }
                }
            } catch (UnsupportedFlavorException | IOException e) {
                /*Обработка исключений UnsupportedFlavorException и IOException*/
                e.printStackTrace();
                /*Вывод стека вызовов исключения*/
                return false;
                /*Возврат false в случае ошибки*/
            }

            return true;
            /*Возврат true в случае успешного импорта данных*/
        }
    }
    /*
     * Показывает следующее изображение в списке изображений.
     * Если список не пустой и текущий индекс не является последним индексом,
     * мы увеличиваем текущий индекс, обновляем информацию об изображении и масштабируем изображение.
     */
    private void showNextImage() {
        if (!images.isEmpty() && currentIndex < images.size() - 1) {
            currentIndex++;
            /*Увеличиваем текущий индекс*/
            updateImageInfo();
            /*Обновляем информацию об изображении*/
            scaleImageToFit();
            /*Масштабируем изображение*/
        }
    }

    /*
     * Обновляет видимую область прокрутки, вызывая методы revalidate и repaint.
     */
    private void refreshScrollPane() {
        scrollPane.revalidate();
        /*Вызываем метод revalidate для прокрутки*/
        scrollPane.repaint();
        /*Перерисовываем прокрутку*/
    }

    /*
     * Обновляет видимую область прокрутки результата, вызывая методы revalidate и repaint.
     */
    private void refreshScrollPaneResult() {
        scrollPaneResult.revalidate();
        /*Вызываем метод revalidate для прокрутки результата*/
        scrollPaneResult.repaint();
        /*Перерисовываем прокрутку результата*/
    }

    /*
     * Загружает изображение из заданного файла.
     * Читает файл изображения, добавляет масштабированное изображение в список изображений,
     * устанавливает текущий индекс в качестве индекса нового изображения,
     * обновляет информацию об изображении и масштабирует изображение.
     */
    private void loadImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            /*Читаем файл изображения*/
            Image image = bufferedImage.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_SMOOTH);  // Масштабируем изображение
            images.add(image);
            /*Добавляем масштабированное изображение в список*/

            int newIndex = images.size();
            /*Получаем индекс нового добавленного изображения*/
            String fileName = "input_image/" + newIndex + ".jpg";
            /*Создаем новое имя файла для изображения*/
            File destFile = new File(fileName);

            try {
                ImageIO.write(bufferedImage, "jpg", destFile);
                /*Записываем изображение в файл*/
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            currentIndex = newIndex - 1;
            /*Устанавливаем текущий индекс в качестве индекса нового изображения*/
            updateImageInfo();
            /*Обновляем информацию об изображении*/
            scaleImageToFit();
            /*Масштабируем изображение*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ошибка загрузки изображения", "Ошибка", JOptionPane.ERROR_MESSAGE);  // Отображаем сообщение об ошибке, если происходит ошибка при загрузке изображения
        }
    }

    /*
     * Показывает предыдущее изображение в списке изображений.
     * Если список не пустой и текущий индекс не является первым индексом,
     * мы уменьшаем текущий индекс, обновляем информацию об изображении и масштабируем изображение.
     */
    private void showPreviousImage() {
        if (!images.isEmpty() && currentIndex > 0) {
            currentIndex--;
            /*Уменьшаем текущий индекс*/
            updateImageInfo();
            /*Обновляем информацию об изображении*/
            scaleImageToFit();
            /*Масштабируем изображение*/
        }
    }

    /*
     * Масштабирует текущее изображение для соответствия размеру области прокрутки.
     * Рассчитывает коэффициент масштабирования, необходимый для вписывания изображения в область прокрутки,
     * а также смещение по x и y для центрирования изображения в области прокрутки.
     * Перерисовывает изображение, чтобы отразить новый размер и позицию.
     */
    private void scaleImageToFit() {
        if (!images.isEmpty()) {
            Image currentImage = images.get(currentIndex);
            /*Получаем текущее изображение*/

            int panelWidth = scrollPane.getWidth();
            /*Получаем ширину области прокрутки*/
            int panelHeight = scrollPane.getHeight();
            /*Получаем высоту области прокрутки*/

            double scaleWidth = (double) panelWidth / currentImage.getWidth(null);
            /*Рассчитываем коэффициент масштабирования для ширины*/
            double scaleHeight = (double) panelHeight / currentImage.getHeight(null);
            /*Рассчитываем коэффициент масштабирования для высоты*/

            scale = Math.min(scaleWidth, scaleHeight);
            /*Получаем минимальный коэффициент масштабирования*/

            offsetX = (panelWidth - currentImage.getWidth(null) * scale) / 2;
            /*Рассчитываем смещение по x для центрирования изображения*/
            offsetY = (panelHeight - currentImage.getHeight(null) * scale) / 2;
            /*Рассчитываем смещение по y для центрирования изображения*/

            repaint();
            /*Перерисовываем изображение*/
        }
    }

    /*
     * Сохраняет файлы в указанной папке.
     * Открывает диалоговое окно выбора папки для сохранения файлов.
     * Если пользователь выбрал папку, запрашивает у него имя для новой папки.
     * Если имя не пустое, создает новую папку в выбранной папке.
     * Копирует файлы из исходной папки "fileOutput" в новую папку.
     * Если происходит ошибка при копировании файлов, выводит сообщение об ошибке.
     * fileOutput путь к исходной папке файлов.
     */
    private void saveFiles(String fileOutput) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите место для сохранения файлов");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();

            /*Запрашиваем у пользователя имя новой папки*/
            String folderName = JOptionPane.showInputDialog(this, "Введите имя для новой папки:");

            if (folderName != null && !folderName.isEmpty()) {
                File newFolder = new File(selectedFolder.getAbsolutePath() + File.separator + folderName);
                if (newFolder.mkdir()) {
                    /*Пытаемся создать новую папку*/
                    File inputFolder = new File(fileOutput);

                    /*Проверяем существование папки input_file и ее тип*/
                    if (inputFolder.exists() && inputFolder.isDirectory()) {
                        File[] filesToCopy = inputFolder.listFiles();

                        if (filesToCopy != null && filesToCopy.length > 0) {
                            for (File file : filesToCopy) {
                                try {
                                    File destinationFile = new File(newFolder.getAbsolutePath() + File.separator + file.getName());
                                    Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    JOptionPane.showMessageDialog(this, "Ошибка при копировании файлов", "Ошибка", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Файлы успешно сохранены в новой папке", "Информация", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "В папке input_file нет файлов для сохранения", "Предупреждение", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Папка input_file не существует или не является директорией", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Не удалось создать новую папку", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Имя папки не может быть пустым", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*
     * Класс, представляющий панель для отображения изображения.
     */
    private class ImagePanel extends JPanel {
        /*
         * Переопределенный метод paintComponent, который отрисовывает изображение на панели.
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (!images.isEmpty()) {
                Image currentImage = images.get(currentIndex);
                /*Получаем текущее изображение*/
                Graphics2D g2d = (Graphics2D) g.create();
                /*Создаем новый объект Graphics2D*/
                AffineTransform transform = new AffineTransform();
                /*Создаем новый объект AffineTransform*/
                transform.translate(offsetX, offsetY);
                /*Смещаем изображение на offsetX и offsetY*/
                transform.scale(scale, scale);
                /*Масштабируем изображение на scale по обоим осям*/
                g2d.drawImage(currentImage, transform, this);
                /*Рисуем изображение с учетом преобразований*/
                g2d.dispose();
                /*Освобождаем ресурсы Graphics2D*/
            }
        }
    }

    /*Загружает предыдущий стиль приложения из файла и устанавливает его*/
    private void loadStyle() {
        try (BufferedReader reader = new BufferedReader(new FileReader(styleFileName))) {
            String line = reader.readLine();
            if (line != null) {
                /*Преобразуем строку в целое число (индекс стиля)*/
                currentStyleIndex = Integer.parseInt(line);

                /*Уменьшаем индекс на 1, так как в массиве индексы начинаются с 0*/
                currentStyleIndex--;

                /*Устанавливаем загруженный стиль*/
                changeStyle();

                /*Получаем информацию о текущем стиле*/
                LookAndFeelInfo currentStyle = installedLookAndFeels[currentStyleIndex];

                try {
                    /*Устанавливаем стиль через UIManager*/
                    UIManager.setLookAndFeel(currentStyle.getClassName());
                } catch (Exception e) {
                    /*В случае ошибки при установке стиля, выводим сообщение с ошибкой*/
                    JOptionPane.showMessageDialog(null, "Error: Ошибка при установке стиля: " + e.getMessage());
                }
            }
        } catch (IOException | NumberFormatException e) {
            /*В случае ошибки ввода/вывода или неверного формата данных в файле, выводим сообщение с ошибкой*/
            JOptionPane.showMessageDialog(null, "Error: Ошибка при чтении файла: " + e.getMessage());
        }
    }

    /*Метод для копирования текста в буфер обмена*/
    private void copyTextToClipboard(String text) {
        /*Получаем системный буфер обмена*/
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        /*Создаем объект StringSelection, содержащий текст для копирования*/
        StringSelection selection = new StringSelection(text);

        /*Устанавливаем содержимое буфера обмена на текстовое выделение*/
        clipboard.setContents(selection, null);
    }


    /*Генерирует случайный ключ на основе заданных параметров и возвращает его в виде строки*/
    public static String generateKey() {
        int minArrayKey = 2;
        /*Минимальный размер матрицы*/
        int maxArrayKey = 8;
        /*Максимальный размер матрицы*/
        Random random = new Random();
        /*Генератор случайных чисел*/
        int randomArray = 0;
        String myKey;
        boolean check = true;
        /*Флаг для проверки условия детерминанта*/
        int[][] arrayKey = null;
        /*Матрица ключа, изначально пустая*/
        int i = 0;
        /*Генерируем случайную матрицу до тех пор, пока не выполнится условие детерминанта*/
        while (check) {
            randomArray = random.nextInt(maxArrayKey - minArrayKey + 1) + minArrayKey;
            /*Генерируем случайный размер матрицы*/
            i++;
            arrayKey = generateRandomArray(randomArray);
            /*Генерируем случайную матрицу*/
            int conditionDeterminantKey = AlgebraicCofactorMatrix.calculation(arrayKey);

            if (conditionDeterminantKey == -1||conditionDeterminantKey == 0 || conditionDeterminantKey == 1) {
                check = true;
            } else {
                myKey = creatingKey(randomArray, arrayKey);
                /*Создаем ключ на основе матрицы*/
                if(checkingWork(myKey)){
                    check = false;
                    return myKey;
                }else {
                    check = true;
                }
            }
        }

        return null;
    }

    /*
     * Метод для проверки работоспособности шифрования и дешифрования текста.
     * key - ключ, используемый для шифрования и дешифрования текста.
     * true, если текст успешно зашифрован и дешифрован, иначе false.
     */
    public static boolean checkingWork(String key) {

        /*Задаем текст, который будет использоваться для проверки*/
        String verificationLine = "Подсолнечник";

        /*Шифруем текст, используя заданный ключ*/
        String verificationTextNumberOne = encryptFiles.encryptText(verificationLine, key);

        /*/Дешифруем зашифрованный текст, используя тот же ключ*/
        String verificationTextNumberTwo = decryptFiles.decryptText(verificationTextNumberOne, key);

        /*Проверяем, идентичны ли исходный и дешифрованный текст*/
        /*Если да, то возвращаем true, иначе - false*/
        if (verificationTextNumberTwo.equals(verificationLine)) {
            return true;
        } else {
            return false;
        }
    }

    /*Генерация многомерного массива*/
    public static int[][] generateRandomArray(int randomArray) {
        Alphabet alphabet = new Alphabet();
        char[] charArray = alphabet.getAlphabet();
        int minImumNumber = 0;
        /*Минимальное значение элемента матрицы*/
        int maxImumNumber = charArray.length;
        int[][] arrayKey = new int[randomArray][randomArray];
        /*Создаем массив заданного размера*/
        Random random = new Random();

        for (int i = 0; i < randomArray; i++) {
            for (int j = 0; j < randomArray; j++) {
                int array = random.nextInt(maxImumNumber - minImumNumber + 1) + minImumNumber;

                if (array == 71) {
                    arrayKey[i][j] = 15;
                    /*Если случайное число равно 71, устанавливаем значение 15*/
                } else {
                    arrayKey[i][j] = array;
                    /*В противном случае устанавливаем случайное значение*/
                }
            }
        }

        return arrayKey;
        /*Возвращаем сгенерированную матрицу*/
    }

    /*Генерация ключа*/
    public static String creatingKey(int a, int[][] arrayKey) {
        /*Создаем одномерный массив для хранения элементов из двумерного массива*/
        int[][] arrayKey1 = new int[a * a][1];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                /*Заполняем одномерный массив значениями из двумерного массива*/
                arrayKey1[i * a + j][0] = arrayKey[i][j];
            }
        }

        /*Создаем объект для преобразования числового кода в символы*/
        ConvertingNumericCodeIntoCharacters converter = new ConvertingNumericCodeIntoCharacters(arrayKey1, a * a);

        /*Получаем символьный массив на основе числового кода*/
        char[] charArray = converter.сonvertingStringCodeFromNumbersToCharacters();

        /*Преобразуем символьный массив в строку и возвращаем ключ*/
        String str = new String(charArray);
        return str;
    }

    /*Метод для вставки текста из буфера обмена*/
    private String pasteTextFromClipboard() {
        /*Получаем доступ к системному буферу обмена*/
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            /*Получаем данные из буфера обмена*/
            Transferable data = clipboard.getContents(null);
            /*Проверяем, поддерживается ли формат данных DataFlavor для текста*/
            if (data != null && data.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                /*Преобразовываем данные в текстовый формат и возвращаем*/
                return (String) data.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception ex) {
            /*В случае возникновения ошибки, выводим стек трассировки в консоль*/
            ex.printStackTrace();
        }
        /*Возвращаем пустую строку, если не удалось получить текст из буфера обмена*/
        return "";
    }

    /*Меняет стиль пользовательского интерфейса приложения на следующий доступный стиль*/
    /*При этом происходит сохранение выбранного стиля и обновление интерфейса*/
    private void changeStyle() {
        /*Увеличиваем индекс текущего стиля на 1 и берем остаток от деления на количество доступных стилей,
        чтобы получить следующий стиль или вернуться к началу, если достигнут последний стиль*/
        currentStyleIndex = (currentStyleIndex + 1) % installedLookAndFeels.length;
        /*Получаем информацию о текущем стиле*/
        UIManager.LookAndFeelInfo currentStyle = installedLookAndFeels[currentStyleIndex];
        try {
            /*Устанавливаем выбранный стиль через UIManager*/
            UIManager.setLookAndFeel(currentStyle.getClassName());
            /*Обновляем все компоненты интерфейса с учетом нового стиля*/
            SwingUtilities.updateComponentTreeUI(this);
            /*Сохраняем текущий стиль*/
            saveStyle();
        } catch (Exception ex) {
            /*В случае ошибки выводим стек трассировки в консоль*/
            ex.printStackTrace();
        }
    }

    /*
     * Метод для сохранения текста в файл.
     * Открывает диалоговое окно выбора файла для сохранения.
     * Если файл успешно выбран, записывает содержимое поля textField в выбранный файл.
     * Если возникнет ошибка ввода-вывода, выводит сообщение об ошибке.
     */
    private void saveFileText() {
        JFileChooser fileChooser = new JFileChooser();
        /*Открывает диалоговое окно выбора файла для сохранения*/
        int returnVal = fileChooser.showSaveDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            /*Получает выбранный файл*/
            File file = fileChooser.getSelectedFile();
            try {
                /*Создает объект FileWriter для записи текста в файл*/
                FileWriter writer = new FileWriter(file);
                /*Записывает текст из поля textField в файл*/
                writer.write(textField.getText());
                /*Закрывает объект FileWriter*/
                writer.close();
            } catch (IOException ex) {
                /*Выводит сообщение об ошибке, если возникла ошибка ввода-вывода*/
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    /*
     * Метод для сохранения результата в файл.
     * Открывает диалоговое окно выбора файла для сохранения.
     * Если файл успешно выбран, записывает содержимое поля textResult в выбранный файл.
     * Если возникнет ошибка ввода-вывода, выводит сообщение об ошибке.
     */
    private void saveFileResult() {
        JFileChooser fileChooser = new JFileChooser();
        /*Открывает диалоговое окно выбора файла для сохранения*/
        int returnVal = fileChooser.showSaveDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            /*Получает выбранный файл*/
            File file = fileChooser.getSelectedFile();
            try {
                /*Создает объект FileWriter для записи текста в файл*/
                FileWriter writer = new FileWriter(file);
                /*Записывает текст из поля textResult в файл*/
                writer.write(textResult.getText());
                /*Закрывает объект FileWriter*/
                writer.close();
            } catch (IOException ex) {
                /*Выводит сообщение об ошибке, если возникла ошибка ввода-вывода*/
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    /*
     * Метод для сохранения кода в файл.
     * Открывает диалоговое окно выбора файла для сохранения.
     * Если файл успешно выбран, записывает содержимое поля textCode в выбранный файл.
     * Если возникнет ошибка ввода-вывода, выводит сообщение об ошибке.
     */
    private void saveFileCode() {
        JFileChooser fileChooser = new JFileChooser();
        /*Открывает диалоговое окно выбора файла для сохранения*/
        int returnVal = fileChooser.showSaveDialog(super.getContentPane());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            /*Получает выбранный файл*/
            File file = fileChooser.getSelectedFile();
            try {
                /*Создает объект FileWriter для записи текста в файл*/
                FileWriter writer = new FileWriter(file);
                /*Записывает текст из поля textCode в файл*/
                writer.write(textCode.getText());
                /*Закрывает объект FileWriter*/
                writer.close();
            } catch (IOException ex) {
                /*Выводит сообщение об ошибке, если возникла ошибка ввода-вывода*/
                JOptionPane.showMessageDialog(super.getContentPane(), "Ошибка: файл не найден!");
            }
        }
    }

    /*Сохраняет текущий стиль приложения в файл*/
    private void saveStyle() {
        try (PrintWriter writer = new PrintWriter(styleFileName)) {
            /*Записываем индекс текущего стиля в файл*/
            writer.println(currentStyleIndex);
        } catch (IOException e) {
            /*В случае ошибки ввода/вывода, ничего не предпринимаем, так как это не фатальная ошибка*/
        }
    }

    /*Класс для запуска программы*/
    public static void main(String[] args) {
        /*Создаем экземпляр класса StealthchatNew*/
        StealthchatNew chatWindow = new StealthchatNew();
        /*Устанавливаем видимость окна*/
        chatWindow.setVisible(true);
    }

}

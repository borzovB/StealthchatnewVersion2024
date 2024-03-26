package com.mycompany.stealthchatnew;

/*Класс для проверки ввода данных*/
public class CheckingInput {

    /*Проверка ключа*/
    public boolean checkKeyword(String keyword, String decryptionCipher) {
        /*Преобразуем ключ и расшифровывающий шифр в массивы символов*/
        char[] charArrayDecryptionCipher = decryptionCipher.toCharArray();
        char[] charArrayKeyword = keyword.toCharArray();
        /*Вычисляем размерность массива ключа*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);
        /*Создаем объект для преобразования символов в числа*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);
        /*Получаем матрицу чисел из символов ключа*/
        int[][] integers = convertingCharactersToNumbers.getArrayCharConvertingCharactersToNumbersForTheDeterminant();
        /*Получаем размер алфавита*/
        int numberInStorage = convertingCharactersToNumbers.getArrayAlphabetSize();
        /*Создаем объект для вычисления алгебраического дополнения матрицы*/
        AlgebraicCofactorMatrix matrixDeterminant = new AlgebraicCofactorMatrix(integers);
        /*Вычисляем определитель матрицы*/
        int conditionDeterminant = matrixDeterminant.calculation(integers);
        /*Проверяем определенные условия*/
        int checkingConverted = checkingConvertedFraction(conditionDeterminant, numberInStorage);
        double squareRoot = Math.sqrt(keyword.length());
        int squareRootAsInt = (int) squareRoot;
        /*Возвращаем true, если все условия выполнены*/
        return (squareRoot == squareRootAsInt && keyword.length() != 1 && conditionDeterminant != 0 && conditionDeterminant != 1 && checkingConverted != 1);
    }

    /*Проверка правильности ввода ключа*/
    public static int checkingConvertedFraction(int numerator, int denominator){

        int denominator1 = 0;
        /*Инициализация переменной denominator1*/
        int numerator1 = 0;
        /*Инициализация переменной numerator1*/

        if(numerator>denominator){
            denominator1 = Math.floorMod(numerator, denominator);
            /*Вычисление остатка от деления*/
            numerator1 = denominator;
        }else{
            if (numerator < 0) {
                /*Проверка, если числитель меньше нуля*/
                denominator1 = Math.floorMod(numerator, denominator);
                /*Вычисление остатка от деления*/
                numerator1 = denominator;
                /*Присвоение значения числителю*/
            } else {
                /*В противном случае*/
                if (numerator < denominator) {
                    /*Проверка, если числитель меньше знаменателя*/

                    denominator1 = denominator;
                    /*Присвоение значения знаменателю*/
                    numerator1 = numerator;
                    /*Присвоение значения числителю*/

                } else {
                    /*В противном случае*/
                    denominator1 = denominator;
                    /*Присвоение значения знаменателю*/
                    numerator1 = numerator;
                    /*Присвоение значения числителю*/
                }
            }
        }

        int verification = 0;
        if(denominator1 == 1){
            verification = 1;
        }
        return verification;
    }

    /*Проверка соответствия символов в ключе и тексте с алфавитом*/
    public boolean checkTextAlphabet(String keyword, String decryptionCipher) {
        /*Преобразуем расшифровывающий шифр и текст в массивы символов*/
        char[] charArrayDecryptionCipher = decryptionCipher.toCharArray();
        char[] charArrayKeyword = keyword.toCharArray();
        /*Вычисляем размерность массива ключа*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);
        /*Создаем объект для преобразования символов в числа*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);
        /*Проверяем текст на соответствие алфавиту, заданному расшифровывающим шифром*/
        int checkingLine = convertingCharactersToNumbers.сheck(charArrayDecryptionCipher);
        /*Возвращаем true, если текст не соответствует алфавиту*/
        return checkingLine != charArrayDecryptionCipher.length;
    }

    /*Проверяет, содержит ли ключ (keyword) только существующие символы,
     которые могут быть использованы в дешифровке текста (decryptionCipher)
     keyword. Ключ, который необходимо проверить
     decryptionCipher. Текст, который будет дешифрован с использованием данного ключа
     возвращает true, если все символы в ключе существуют в тексте дешифровки, иначе false*/
    public boolean checkKeyAlphabet(String keyword, String decryptionCipher) {
        /*Преобразование текста дешифровки в массив символов*/
        char[] charArrayDecryptionCipher = decryptionCipher.toCharArray();
        /*Преобразование ключа в массив символов*/
        char[] charArrayKeyword = keyword.toCharArray();
        /*Расчет числа элементов в квадратной матрице для дальнейшей проверки*/
        int arrayNumKey = (int) Math.sqrt(charArrayKeyword.length);
        /*Создание экземпляра класса для преобразования символов в числа и выполнения проверок*/
        ConvertingCharactersToNumbers convertingCharactersToNumbers = new ConvertingCharactersToNumbers(charArrayKeyword, arrayNumKey, charArrayDecryptionCipher);
        /*Выполнение проверки ключа на существующие символы*/
        int checkingKey = convertingCharactersToNumbers.сheck(charArrayKeyword);
        /*Если количество существующих символов в ключе не совпадает с длиной ключа, возвращаем false*/
        return checkingKey != charArrayKeyword.length;
    }
}

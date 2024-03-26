package com.mycompany.stealthchatnew;

/*Класс, который находит модуль элемента по модуля и работы с матрицами*/
public class ChainShot {
    // Объявление класса ChainShot

    public int getMyField(int numerator, int denominator) {
        /*Объявление метода getMyField()*/
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

        int[] result = printContinuedFraction(numerator1, denominator1);
        /*Вызов метода printContinuedFraction() и сохранение результата в массив result*/
        int elements = result.length;
        /*Получение длины массива*/
        int resultModule = module(result, denominator1, numerator1, elements);
        /*Вызов метода Module() и сохранение результата в resultModule*/
        return resultModule;
        /*Возврат результата из метода*/
    }

    /*Объявление статического метода printContinuedFraction() с двумя параметрам*/
    public static int[] printContinuedFraction(int numerator, int denominator) {
        /*Объявление статического метода printContinuedFraction() с двумя параметрами*/
        int[] quotientArray = new int[0];
        /*Создание пустого массива для хранения частных*/

        while (denominator != 0) {
            /*Начало цикла, пока знаменатель не равен нулю*/
            int quotient = numerator / denominator;
            /*Вычисление частного*/
            int remainder = numerator % denominator;
            /*Вычисление остатка от деления*/

            /*Увеличение размера массива на 1 и добавление частного*/
            int[] newArray = new int[quotientArray.length + 1];
            /*Создание нового массива большего размера*/
            System.arraycopy(quotientArray, 0, newArray, 0, quotientArray.length);
            /*Копирование данных из старого массива в новый*/
            newArray[quotientArray.length] = quotient;
            /*Добавление частного в конец нового массива*/
            quotientArray = newArray;
            /*Присвоение нового массива старой переменной*/

            if (remainder != 0) {
                /*Проверка, если остаток не равен нулю*/
                numerator = denominator;
                /*Замена числителя знаменателем*/
                denominator = remainder;
                /*Присвоение нового значения знаменателю*/
            } else {
                break;
                /*Выход из цикла, если остаток равен нулю*/
            }
        }

        return quotientArray;
        /*Возврат массива частных из метода*/
    }

    /*Нахождение модуля*/
    public static int module(int array[], int num, int num1, int elements) {
        /*Объявление статического метода Module() с четырьмя параметрами*/
        int[] myArray = new int[array.length];
        /*Создание нового массива*/

        int firstX = 0;
        /*Инициализация переменной firstX*/

        if (array.length == 2) {
            /*Проверка, если длина массива равна 2*/
            myArray[0] = array[0];
            /*Присвоение первому элементу массива значения из параметра*/
            myArray[1] = myArray[0] * array[1] + 1;
            /*Вычисление значения второго элемента массива*/
            int firstX1 = (int) (Math.pow(-1, elements - 1) * myArray[0]);
            /*Вычисление значения firstX1*/
            int firstX2 = Math.floorMod(firstX1, num1);
            /*Вычисление остатка от деления*/
            return firstX2;
            /*Возврат значения firstX2 из метода*/
        } else {
            /*В противном случае*/
            myArray[0] = array[0];
            /*Присвоение первому элементу массива значения из параметра*/
            myArray[1] = myArray[0] * array[1] + 1;
            /*Вычисление значения второго элемента массива*/

            for (int i = 2, j = 1, m = 0; i < myArray.length; i++, j++, m++) {
                /*Цикл для вычисления значений остальных элементов массива*/
                myArray[i] = myArray[j] * array[i] + myArray[m];
                /*Вычисление значения элемента массива*/

                if (myArray[i] == num || myArray[i] == num1) {
                    /*Проверка, если элемент равен num или num1*/
                    firstX = myArray[i - 1];
                    /*Присвоение значению firstX предыдущего элемента*/
                }
            }

            int firstX1 = (int) (Math.pow(-1, elements - 1) * firstX);
            /*Вычисление значения firstX1*/
            int firstX2 = Math.floorMod(firstX1, num1);
            /*Вычисление остатка от деления*/
            return firstX2;
            /*Возврат значения firstX2 из метода*/
        }
    }

    /*Метод для умножения матрицы на массив и возврата результата в виде массива символов*/
    public static char[] multiplyingMatrixByMatrix(int[][] array1, int[] array2, int number, int lens) {
        int[][] arrayMatrix = new int[lens][lens];
        int[][] arrayMatrix1 = new int[lens][lens];
        char []conversionToText = new char[lens];
        /*Заполняем первый столбец матрицы arrayMatrix значениями из Array2*/
        for (int i = 0; i < lens; i++) {
            arrayMatrix[i][0] = array2[i];
        }
        /*Вызов метода для умножения матриц*/
        arrayMatrix1 = multiplication(array1, arrayMatrix, number);
        /*Преобразуем числовой код в символы и сохраняем результат в conversionToText*/
        ConvertingNumericCodeIntoCharacters convertingNumericCodeIntoCharacters = new ConvertingNumericCodeIntoCharacters(arrayMatrix1, lens);
        conversionToText = convertingNumericCodeIntoCharacters.сonvertingStringCodeFromNumbersToCharacters();
        return conversionToText;
    }

    /*Метод для умножения матрицы на число*/
    public static int[][] multiplicationMatrixByNumber(int[][] array1, int number, int number2) {
        int rows1 = array1.length;
        /*Количество строк в Array1*/
        int[][] result = new int[rows1][rows1];

        /*Проходимся по каждому элементу массива*/
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < rows1; j++) {
                /*Вычисляем произведение элемента массива на number2 и берем остаток по модулю числа*/
                result[i][j] = Math.floorMod(array1[i][j] * number2,number);
            }
        }

        return result;
        /*Возвращаем результирующий массив*/
    }

    /*Метод для умножения матрицы на вектор и возвращения результатов в виде массива целых чисел*/
    public static int[] multiplyingMatrixByMatrixMedia(int[][] array1, int[] array2, int number, int lens) {
        /*Инициализация матрицы arrayMatrix и arrayMatrix1 с размером lens x lens*/
        int[][] arrayMatrix = new int[lens][lens];
        int[][] arrayMatrix1 = new int[lens][lens];

        /*Заполнение первого столбца матрицы arrayMatrix значениями из array2*/
        for (int i = 0; i < lens; i++) {
            arrayMatrix[i][0] = array2[i];
        }

        /*Вызов метода multiplication для умножения матриц array1 и arrayMatrix*/
        arrayMatrix1 = multiplication(array1, arrayMatrix, number);

        /*Инициализация массива toNumbersOne для хранения результатов умножения*/
        int[] toNumbersOne = new int[lens];

        /*Получение значений первого столбца из матрицы arrayMatrix1 и сохранение их в массиве toNumbersOne*/
        for (int i = 0; i < lens; i++) {
            toNumbersOne[i] = arrayMatrix1[i][0];
        }

        /*Возвращение массива toNumbersOne*/
        return toNumbersOne;
    }

    /*Метод для умножения матриц и взятия остатка*/
    public static int[][] multiplication(int[][] array1, int[][] array2, int number) {
        int rows1 = array1.length;
        /*Количество строк в Array1*/
        int[][] result = new int[rows1][rows1];
        /*Результат умножения матриц*/
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < rows1; j++) {
                int sum = 0;
                for (int k = 0; k < rows1; k++) {
                    /*Умножение элементов матрицы Array1 на элементы матрицы Array2*/
                    sum += array1[i][k] * array2[k][j];

                }
                /*Взятие остатка от суммы и сохранение результата в матрице result*/
                result[i][j] = sum%number;

            }
        }

        return result;
        /*Возвращение результирующей матрицы*/
    }

}



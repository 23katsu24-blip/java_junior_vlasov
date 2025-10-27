package academy.tochkavhoda.introduction;

public class ZeroSteps1
{
    /**
     * Возвращает сумму чисел x и y
     */
    public int sum(int x, int y) {
        return x + y;
    }

    /**
     * Возвращает произведение чисел x и y
     */
    public int mul(int x, int y) {
        return x * y;
    }

    /**
     * Возвращает частное от деления чисел x и y.
     * Гарантируется, что y != 0
     */
    public int div(int x, int y) {
        return x / y;
    }

    /**
     * Возвращает остаток от деления чисел x и y.
     * Гарантируется, что y != 0
     */
    public int mod(int x, int y) {
        return x % y;
    }

    /**
     * Возвращает true, если x равен y, иначе false
     */
    public boolean isEqual(int x, int y) {
        return x == y;
    }

    /**
     * Возвращает true, если x больше y, иначе false
     */
    public boolean isGreater(int x, int y) {
        return x > y;
    }

    /**
     * Прямоугольный треугольник задан двумя катетами. Найти его площадь.
     */
    public double calculateTriangleSquare(int side1, int side2) {
        return (side1 * side2) / 2.0;
    }

    /**
     * Прямоугольный треугольник задан двумя катетами. Найти его периметр.
     */
    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + hypotenuse;
    }

    /**
     * Дано целое трехзначное число. Получить число, которое получится из него путем
     * выписывания его цифр в обратном порядке.
     */
    public int reverseNumber(int number) {
        int result = 0;
        while (number > 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }
        return result;
    }

    /**
     * Дано целое число. Возвести его в степень 15, используя не более 5 умножений
     */
    public long calculate15Degree(int number) {
        // number^2 = number * number (1)
        long n2 = (long)number * number;
        // number^4 = number^2 * number^2 (2)
        long n4 = n2 * n2;
        // number^8 = number^4 * number^4 (3)
        long n8 = n4 * n4;
        // number^14 = number^8 * number^4 * number^2 (4)
        long n14 = n8 * n4 * n2;
        // number^15 = number^14 * number (5)
        return n14 * number;
    }

    /**
     * Определяет, лежит ли точка (x,y) внутри прямоугольника
     */
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    /**
     * Находит квадратный корень абсолютной величины числа
     */
    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    /**
     * Определяет, существует ли треугольник с такими сторонами
     */
    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3 &&
                side2 + side3 > side1 &&
                side1 + side3 > side2;
    }

    /**
     * Возвращает произведение цифр четырехзначного целого числа
     */
    public int getDigitsProduction(int number) {
        int result = 1;
        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    /**
     * Определяет, может ли круг радиуса radius поместиться внутри квадрата со
     * стороной side, не касаясь окружности
     */
    public boolean isCircleInsideSquare(int radius, int side) {
        // Диаметр круга должен быть строго меньше стороны квадрата
        return 2 * radius < side;
    }

    /**
     * Возвращает символ с кодом code
     */
    public char getCharByCode(short code) {
        return (char)code;
    }

    /**
     * Возвращает код символа character
     */
    public short getCodeByChar(char character) {
        return (short)character;
    }

    /**
     * Возвращает код символа, который имеет код на offset больше, чем символ ch
     */
    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char)(ch + offset);
    }

    /**
     * Возвращает true, если код ch1 больше или равен коду ch2, иначе false
     */
    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    /**
     * Возвращает символ с кодом, равным полусумме кодов ch1 и ch2
     */
    public char getAverageChar(char ch1, char ch2) {
        return (char)((ch1 + ch2) / 2);
    }

}

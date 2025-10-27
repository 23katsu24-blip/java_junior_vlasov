package academy.tochkavhoda.introduction;

public class ZeroSteps2
{
    /**
     * Возвращает сумму квадратов целых чисел от 1 до count
     */
    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }

    /**
     * Возвращает сумму нечетных целых чисел от 1 до count
     */
    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Возвращает сумму обратных величин целых чисел от 1 до count
     */
    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    /**
     * Возвращает произведение целых чисел от 1 до count (факториал от count)
     */
    public long factorial(int count) {
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Возвращает произведение цифр целого числа value
     */
    public int prodDigits(int value) {
        if (value == 0) return 0;
        int product = 1;
        while (value != 0) {
            product *= Math.abs(value % 10);
            value /= 10;
        }
        return product;
    }

    /**
     * Возвращает число Фибоначчи номер number. Не использовать рекурсию.
     */
    public int fibonacci(int number) {
        if (number <= 1) return number;

        int prev = 0, curr = 1;
        for (int i = 2; i <= number; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * Возвращает сумму всех степеней 2 от 2^0 до 2^max
     */
    public long sum2Powers(int max) {
        long sum = 0;
        long power = 1;  // 2^0
        for (int i = 0; i <= max; i++) {
            sum += power;
            power *= 2;  // Следующая степень
        }
        return sum;
    }

    /**
     * Возвращает сумму квадратов целых чисел от 1 до count.
     * Суммирование прекращается как только сумма станет больше barrier
     */
    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int square = i * i;
            if (sum > barrier) {
                break;
            }
            sum += square;
        }
        return sum;
    }

    /**
     * Возвращает сумму всех произведений i*j (1 <=i <= count1 и 1 <=j <= count2)
     */
    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    /**
     * Возвращает сумму тех произведений i*j, которые меньше barrier
     */
    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int prod = i * j;
                if (prod < barrier) {
                    sum += prod;
                }
            }
        }
        return sum;
    }

    /**
     * Возвращает сумму всех величин 1/(i*j)
     */
    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    /**
     * Возвращает сумму всех произведений i*j*k
     */
    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    /**
     * Возвращает значение числа e, вычисляемое как сумма ряда
     */
    public double calculateE() {
        double sum = 1.0;  // Первый член ряда
        double term = 1.0;
        int factorial = 1;
        int i = 1;

        while (term >= 1E-6) {
            factorial *= i;
            term = 1.0 / factorial;
            sum += term;
            i++;
        }

        return sum;
    }

    /**
     * Возвращает значение числа π по формуле: 4*(1 - 1/3 + 1/5 - 1/7 + 1/9 ...)
     */
    public double calculatePi() {
        double sum = 0.0;
        double term;
        int denominator = 1;
        int sign = 1;

        do {
            term = 4.0 / denominator * sign;
            sum += term;
            denominator += 2;
            sign = -sign;
        } while (Math.abs(term) >= 1E-8);

        return sum;
    }

    /**
     * Вычисляет площадь круга методом Монте-Карло
     */
    public double calculateCircleSquare(double length, int count) {
        int inside = 0;
        double center = length / 2.0;
        double radius = center;

        java.util.Random random = new java.util.Random();

        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * length;
            double y = random.nextDouble() * length;

            // Проверяем, попала ли точка внутрь круга
            double dx = x - center;
            double dy = y - center;
            if (dx * dx + dy * dy <= radius * radius) {
                inside++;
            }
        }

        return length * length * inside / (double)count;
    }
}
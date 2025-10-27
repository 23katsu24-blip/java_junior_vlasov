package academy.tochkavhoda.introduction;

public class ZeroSteps3
{
    /**
     * Возвращает сумму чисел в массиве
     */
    public int sum(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    /**
     * Возвращает произведение чисел в массиве
     */
    public int mul(int[] array) {
        if (array == null || array.length == 0) return 0;
        int product = 1;
        for (int value : array) {
            product *= value;
        }
        return product;
    }

    /**
     * Возвращает минимальное число в массиве
     */
    public int min(int[] array) {
        if (array == null || array.length == 0) return Integer.MAX_VALUE;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Возвращает максимальное число в массиве
     */
    public int max(int[] array) {
        if (array == null || array.length == 0) return Integer.MIN_VALUE;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Возвращает среднее значение чисел в массиве
     */
    public double average(int[] array) {
        if (array == null || array.length == 0) return 0.0;
        return (double)sum(array) / array.length;
    }

    /**
     * Проверяет, упорядочен ли массив по убыванию
     */
    public boolean isSortedDescendant(int[] array) {
        if (array == null || array.length <= 1) return true;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] <= array[i]) return false;
        }
        return true;
    }

    /**
     * Возводит все элементы массива в куб
     */
    public void cube(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    /**
     * Ищет заданное значение в массиве
     */
    public boolean find(int[] array, int value) {
        if (array == null) return false;
        for (int v : array) {
            if (v == value) return true;
        }
        return false;
    }

    /**
     * Переворачивает массив
     */
    public void reverse(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * Проверяет, является ли массив палиндромом
     */
    public boolean isPalindrome(int[] array) {
        if (array == null || array.length <= 1) return true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Заменяет элементы массива на их квадраты до первого нуля
     */
    public void replaceBySquare(int[] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) break;
            array[i] = array[i] * array[i];
        }
    }

    /**
     * Возвращает произведение ненулевых элементов массива
     */
    public int mulNonZero(int[] array) {
        if (array == null || array.length == 0) return 0;
        int product = 1;
        boolean hasNonZero = false;
        for (int value : array) {
            if (value != 0) {
                product *= value;
                hasNonZero = true;
            }
        }
        return hasNonZero ? product : 0;
    }

    /**
     * Проверяет, все ли элементы массива положительные
     */
    public boolean allPositive(int[] array) {
        if (array == null || array.length == 0) return false;
        for (int value : array) {
            if (value <= 0) return false;
        }
        return true;
    }

    /**
     * Проверяет, все ли элементы массива равны между собой
     */
    public boolean allEqual(int[] array) {
        if (array == null || array.length <= 1) return true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0]) return false;
        }
        return true;
    }

    /**
     * Возвращает индекс первого элемента, который больше своих соседей
     */
    public int greaterThanNeighbours(int[] array) {
        if (array == null || array.length <= 2) return -1;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i-1] && array[i] > array[i+1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Проверяет, есть ли элемент, равный полусумме соседей
     */
    public boolean neighboursAverage(double[] array) {
        if (array == null || array.length <= 2) return false;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == (array[i-1] + array[i+1]) / 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает сумму элементов между двумя нулями
     */
    public int sumBetween2Zeros(int[] array) {
        if (array == null) return 0;
        int firstZero = -1;
        int sum = 0;
        boolean summing = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (firstZero == -1) {
                    firstZero = i;
                    summing = true;
                } else {
                    return sum;
                }
            } else if (summing) {
                sum += array[i];
            }
        }
        return sum;
    }

    /**
     * Считает количество совпадающих элементов в одинаковых позициях
     */
    public int sameAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return 0;
        int count = 0;
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) count++;
        }
        return count;
    }

    /**
     * Проверяет, есть ли позиция, где в обоих массивах стоят нули
     */
    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return false;
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) return true;
        }
        return false;
    }

    /**
     * Заменяет каждый элемент массива на сумму от начала до него
     */
    public void accumulatedSum(int[] array) {
        if (array == null || array.length == 0) return;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i-1];
        }
    }

    /**
     * Объединяет два отсортированных массива в один отсортированный
     */
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) result[k++] = array1[i++];
        while (j < array2.length) result[k++] = array2[j++];

        return result;
    }

    /**
     * Подсчитывает количество точек внутри круга
     */
    public int insideCircle(int[] x, int[] y, int radius) {
        if (x == null || y == null || x.length != y.length) return 0;
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] * x[i] + y[i] * y[i] <= radius * radius) {
                count++;
            }
        }
        return count;
    }

    /**
     * Вычисляет скалярное произведение векторов
     */
    public double scalarProduct(double[] array1, double[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) return 0.0;
        double product = 0.0;
        for (int i = 0; i < array1.length; i++) {
            product += array1[i] * array2[i];
        }
        return product;
    }
}

package academy.tochkavhoda.base;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
public class NumberOperations
{/**
 * 1. Ищет первый индекс в массиве array, где значение равно value.
 * Возвращает индекс или null, если не найдено или массив null.
 */
public static Integer find(int[] array, int value) {
    if (array == null) return null;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == value) return i;
    }
    return null;
}

    /**
     * 2. Ищет первый индекс в массиве array, где |array[i] - value| <= eps.
     * Возвращает индекс или null при отсутствии совпадений или если array null.
     */
    public static Integer find(double[] array, double value, double eps) {
        if (array == null) return null;
        if (eps < 0) eps = Math.abs(eps);
        for (int i = 0; i < array.length; i++) {
            if (Double.isNaN(array[i]) || Double.isNaN(value)) continue;
            if (Math.abs(array[i] - value) <= eps) return i;
        }
        return null;
    }

    /**
     * 3. Вычисляет плотность weight/volume как Double.
     * Возвращает значение если min <= density <= max, иначе null.
     * Если volume == 0 или какой-то аргумент NaN/Infinite, возвращает null.
     */
    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if (volume == 0.0) return null;
        double density = weight / volume;
        if (Double.isNaN(density) || Double.isInfinite(density)) return null;
        if (density < min || density > max) return null;
        return density;
    }

    /**
     * 4. Ищет первый индекс в массиве BigInteger[], где элемент равен value.
     * Возвращает индекс или null, если не найдено или массив null.
     */
    public static Integer find(BigInteger[] array, BigInteger value) {
        if (array == null) return null;
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], value)) return i;
        }
        return null;
    }

    /**
     * 5. Вычисляет плотность в BigDecimal: weight / volume.
     * Возвращает вычисленное значение, если min <= density <= max, иначе null.
     * Если volume == 0 или любой аргумент null — возвращает null.
     * Деление выполняется с достаточной точностью (MathContext.DECIMAL128) и масштабом возвращаемого значения
     * не изменяется дополнительно (результат в MathContext.DECIMAL128).
     */
    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (weight == null || volume == null || min == null || max == null) return null;
        if (BigDecimal.ZERO.compareTo(volume) == 0) return null;
        // Выполняем деление с высокой точностью
        BigDecimal density;
        try {
            density = weight.divide(volume, MathContext.DECIMAL128);
        } catch (ArithmeticException ex) {
            // если деление бесконечное, выполнить с округлением
            density = weight.divide(volume, 16, RoundingMode.HALF_UP);
        }
        if (density == null) return null;
        if (density.compareTo(min) < 0) return null;
        if (density.compareTo(max) > 0) return null;
        // Возвращаем density (в MathContext.DECIMAL128 или с установленным scale)
        return density.stripTrailingZeros();
    }
}

package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;  // Левая верхняя точка
    private int size;      // Длина стороны квадрата

    // 1. Конструктор по topLeft и размеру
    public Square(Point leftTop, int size) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.size = size;
    }

    // 2. Конструктор по координатам и размеру
    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    // 3. Конструктор по размеру; левый верхний угол в (0,-size)
    public Square(int size) {
        this.topLeft = new Point(0, -size);  // Верхний левый угол должен быть в точке (0, -size)
        this.size = size;
    }

    // 4. Конструктор по умолчанию: размер 1, topLeft = (0,-1)
    public Square() {
        this.topLeft = new Point(0, -1);  // Верхний левый угол в точке (0, -1)
        this.size = 1;
    }

    // 5. Возвращает копию topLeft
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    // 6. Возвращает правый нижний угол (копию)
    public Point getBottomRight() {
        // The bottom right point should be at (x + size, y + size)
        // Bottom right is increased by size in both x and y directions
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    // 7. Устанавливает новый topLeft (копированием)
    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    // 8. Возвращает длину стороны
    public int getLength() {
        return size;
    }

    // 9. Перемещает квадрат так, чтобы topLeft стал (x, y)
    public void moveTo(int x, int y) {
        this.topLeft = new Point(x, y);
    }

    // 10. Перемещает в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 11. Сдвигает на (dx, dy)
    public void moveRel(int dx, int dy) {
        this.topLeft = new Point(this.topLeft.getX() + dx, this.topLeft.getY() + dy);
    }

    // 12. Изменяет размер в ratio раз, сохраняя topLeft; дробная часть отбрасывается
    public void resize(double ratio) {
        if (ratio <= 0) return;
        int newSize = (int) (this.size * ratio);
        this.size = Math.max(1, newSize);
    }

    // 13. Площадь квадрата
    public double getArea() {
        return (double) size * size;
    }

    // 14. Периметр квадрата
    public double getPerimeter() {
        return 4.0 * size;
    }

    // 15. Проверяет, лежит ли точка (x, y) внутри или на границе квадрата
    public boolean isInside(int x, int y) {
        // Point is inside if it's within the rectangle bounded by topLeft and bottomRight
        return x >= topLeft.getX() && x <= topLeft.getX() + size &&
                y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    // 16. Проверяет, лежит ли точка point внутри или на границе квадрата
    public boolean isInside(Point point) {
        if (point == null) return false;
        return isInside(point.getX(), point.getY());
    }

    // 17. Пересечение с другим квадратом (включая касание)
    public boolean isIntersects(Square square) {
        if (square == null) return false;
        int thisLeft = this.topLeft.getX();
        int thisTop = this.topLeft.getY();      // This is more negative (higher up)
        int thisRight = thisLeft + this.size;
        int thisBottom = thisTop + this.size;    // This is less negative (lower down)

        int otherLeft = square.topLeft.getX();
        int otherTop = square.topLeft.getY();    // More negative (higher up)
        int otherRight = otherLeft + square.size;
        int otherBottom = otherTop + square.size; // Less negative (lower down)

        // For y coordinates, remember that more negative is "higher up"
        boolean noOverlap = thisRight < otherLeft
                || otherRight < thisLeft
                || thisBottom < otherTop     // If our bottom edge is higher than their top edge
                || otherBottom < thisTop;     // If their bottom edge is higher than our top edge
        return !noOverlap;
    }

    // 18. Проверяет, лежит ли весь square внутри текущего (границы считаются внутри)
    public boolean isInside(Square square) {
        if (square == null) return false;
        int thisLeft = this.topLeft.getX();
        int thisTop = this.topLeft.getY();
        int thisRight = thisLeft + this.size;
        int thisBottom = thisTop + this.size;

        int otherLeft = square.topLeft.getX();
        int otherTop = square.topLeft.getY();
        int otherRight = otherLeft + square.size;
        int otherBottom = otherTop + square.size;

        return otherLeft >= thisLeft && otherTop >= thisTop
                && otherRight <= thisRight && otherBottom <= thisBottom;
    }

    // 19. equals и hashCode (сгенерированы по полям topLeft и size)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }

}

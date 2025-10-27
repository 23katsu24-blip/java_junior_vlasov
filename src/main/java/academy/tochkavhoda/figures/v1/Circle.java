package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Circle {
    private Point center;
    private int radius;
    // 1. Конструктор по центру и радиусу
    public Circle(Point center, int radius) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    // 2. Конструктор по координатам центра и радиусу
    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    // 3. Конструктор по радиусу, центр в (0,0)
    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
    }

    // 4. Конструктор по умолчанию: центр (0,0), радиус 1
    public Circle() {
        this(1);
    }

    // 5. Получить копию центра
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    // 6. Получить радиус
    public int getRadius() {
        return radius;
    }

    // 7. Установить центр (копирование)
    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    // 8. Установить радиус
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // 9. Переместить центр в (x, y)
    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    // 10. Переместить центр в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 11. Сдвинуть центр на (dx, dy)
    public void moveRel(int dx, int dy) {
        this.center = new Point(this.center.getX() + dx, this.center.getY() + dy);
    }

    // 12. Увеличить радиус в ratio раз, отбрасывая дробную часть
    public void resize(double ratio) {
        if (ratio <= 0) return;
        int newRadius = (int) (this.radius * ratio);
        this.radius = Math.max(1, newRadius);
    }

    // 13. Площадь круга
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 14. Периметр (длина окружности)
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    // 15. Точка (x,y) внутри или на окружности
    public boolean isInside(int x, int y) {
        long dx = x - center.getX();
        long dy = y - center.getY();
        long dist2 = dx * dx + dy * dy;
        long r2 = (long) radius * radius;
        return dist2 <= r2;
    }

    // 16. Точка point внутри или на окружности
    public boolean isInside(Point point) {
        if (point == null) return false;
        return isInside(point.getX(), point.getY());
    }

    // 17. equals и hashCode (сгенерированы по полям center и radius)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}

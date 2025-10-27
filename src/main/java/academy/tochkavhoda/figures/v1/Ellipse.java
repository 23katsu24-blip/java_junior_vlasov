package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;
    // 1. Конструктор по центру и размерам осей
    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    // 2. Конструктор по координатам центра и размерам осей
    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    // 3. Конструктор с центром в (0,0)
    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    // 4. Конструктор по умолчанию: центр (0,0), оси = 1
    public Ellipse() {
        this(0, 0, 1, 1);
    }

    // 5. Получить центр (возвращаем копию)
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    // 6. Размер оси по X (полная длина)
    public int getXAxis() {
        return xAxis;
    }

    // 7. Размер оси по Y (полная длина)
    public int getYAxis() {
        return yAxis;
    }

    // 8. Установить размер оси по X
    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    // 9. Установить размер оси по Y
    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    // 10. Установить центр (копированием)
    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    // 11. Передвинуть центр в (x, y)
    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    // 12. Передвинуть центр в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 13. Сместить центр на (dx, dy)
    public void moveRel(int dx, int dy) {
        this.center = new Point(this.center.getX() + dx, this.center.getY() + dy);
    }

    // 14. Увеличить оси во ratio раз, отбрасывая дробную часть, центр не меняется
    public void resize(double ratio) {
        if (ratio <= 0) return;
        int newX = (int) (this.xAxis * ratio);
        int newY = (int) (this.yAxis * ratio);
        this.xAxis = Math.max(1, newX);
        this.yAxis = Math.max(1, newY);
    }

    // 15. Увеличить оси по отдельным коэффициентам
    public void stretch(double xRatio, double yRatio) {
        if (xRatio <= 0 || yRatio <= 0) return;
        int newX = (int) (this.xAxis * xRatio);
        int newY = (int) (this.yAxis * yRatio);
        this.xAxis = Math.max(1, newX);
        this.yAxis = Math.max(1, newY);
    }

    // 16. Площадь эллипса: π * a * b, где a и b — полуоси
    public double getArea() {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return Math.PI * a * b;
    }

    // 17. Периметр по заданной формуле P = 2π * sqrt((XAxis^2 + YAxis^2) / 8)
    public double getPerimeter() {
        double x2 = (double) xAxis * xAxis;
        double y2 = (double) yAxis * yAxis;
        return 2.0 * Math.PI * Math.sqrt((x2 + y2) / 8.0);
    }

    // 18. Проверка, лежит ли точка (x,y) внутри эллипса (включая границу)
    public boolean isInside(int x, int y) {
        double dx = x - center.getX();
        double dy = y - center.getY();
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        if (a == 0 || b == 0) {
            // вырожденный эллипс: считать внутри только если точка совпадает с центром и соответствующая полуось 0
            boolean insideX = a == 0 ? dx == 0 : Math.abs(dx) <= a;
            boolean insideY = b == 0 ? dy == 0 : Math.abs(dy) <= b;
            return insideX && insideY;
        }
        double value = (dx * dx) / (a * a) + (dy * dy) / (b * b);
        return value <= 1.0;
    }

    // 19. Проверка для объекта Point
    public boolean isInside(Point point) {
        if (point == null) return false;
        return isInside(point.getX(), point.getY());
    }

    // 20. equals и hashCode (сгенерированы по полям center, xAxis, yAxis)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}

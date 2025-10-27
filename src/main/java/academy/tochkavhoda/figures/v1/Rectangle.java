package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle
{
    private Point topLeft;
    private Point bottomRight;

    // 1. По двум точкам (левый верхний и правый нижний)
    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.bottomRight = new Point(rightBottom.getX(), rightBottom.getY());
    }

    // 2. По координатам
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
    }

    // 3. По длине и ширине; левый нижний угол в начале координат (0,0)
    public Rectangle(int length, int width) {
        // Rectangle should be positioned with its bottom edge at y=0 and top edge at y=-width
        this.topLeft = new Point(0, -width);     // верхняя точка при высоте width
        this.bottomRight = new Point(length, 0);  // нижняя точка в начале координат
    }

    // 4. Пустой конструктор: размер 1x1, левый нижний в (0,0)
    public Rectangle() {
        this.topLeft = new Point(0, -1);     // y=-1 для верхней точки
        this.bottomRight = new Point(1, 0);   // y=0 для нижней точки
    }

    // 5. getTopLeft
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    // 6. getBottomRight
    public Point getBottomRight() {
        return new Point(bottomRight.getX(), bottomRight.getY());
    }

    // 7. setTopLeft
    public void setTopLeft(Point topLeft) {
        if (topLeft == null) throw new IllegalArgumentException();
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    // 8. setBottomRight
    public void setBottomRight(Point bottomRight) {
        if (bottomRight == null) throw new IllegalArgumentException();
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
    }

    // 9. getLength (по оси X)
    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    // 10. getWidth (по оси Y)
    public int getWidth() {
        // Since our rectangles are oriented with bottom at higher Y than top,
        // we take bottom Y - top Y to get positive width
        return bottomRight.getY() - topLeft.getY();
    }

    // 11. moveTo(int x, int y) — переместить левую верхнюю вершину в (x,y)
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.topLeft = new Point(x, y);
        // In our coordinate system, adding width to y moves down
        this.bottomRight = new Point(x + length, y + width);
    }

    // 12. moveTo(Point point)
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 13. moveRel(dx, dy)
    public void moveRel(int dx, int dy) {
        this.topLeft = new Point(this.topLeft.getX() + dx, this.topLeft.getY() + dy);
        this.bottomRight = new Point(this.bottomRight.getX() + dx, this.bottomRight.getY() + dy);
    }

    // 14. resize(ratio) — сохраняем topLeft, изменяем размеры, дробную часть отбрасываем
    public void resize(double ratio) {
        if (ratio <= 0) return;
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        this.bottomRight = new Point(this.topLeft.getX() + Math.max(1, newLength), this.topLeft.getY() + Math.max(1, newWidth));
    }

    // 15. stretch(xRatio, yRatio)
    public void stretch(double xRatio, double yRatio) {
        if (xRatio <= 0 || yRatio <= 0) return;
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        this.bottomRight = new Point(this.topLeft.getX() + Math.max(1, newLength), this.topLeft.getY() + Math.max(1, newWidth));
    }

    // 16. getArea
    public double getArea() {
        return (double) getLength() * getWidth();
    }

    // 17. getPerimeter
    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    // 18. isInside(int x, int y) — точка внутри или на границе
    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    // 19. isInside(Point point)
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // 20. isIntersects(Rectangle rectangle)
    // Два прямоугольника пересекаются, если их проекции по обеим осям пересекаются (включая касание).
    public boolean isIntersects(Rectangle rectangle) {
        if (rectangle == null) return false;

        // Не пересекаются, если один полностью слева/справа или выше/ниже другого
        boolean noOverlap = this.bottomRight.getX() < rectangle.topLeft.getX()
                || rectangle.bottomRight.getX() < this.topLeft.getX()
                || this.bottomRight.getY() < rectangle.topLeft.getY()
                || rectangle.bottomRight.getY() < this.topLeft.getY();
        return !noOverlap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }

    // 21. Проверяет, лежит ли rectangle целиком внутри текущего Rectangle
    public boolean isInside(Rectangle rectangle) {
        if (rectangle == null) return false;
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }
}

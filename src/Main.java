//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    // Практическое задание №1 Лекция 11 Создаем классы Собака и Кот с наследованием от класса Животные
//Создаем родительский класс "Животное"
    /*class Animal {
        protected String name;
        protected int runLimit;
        protected int swimLimit;
        private static int animalCount = 0;

        public Animal(String name, int runLimit, int swimLimit) {
            this.name = name;
            this.runLimit = runLimit;
            this.swimLimit = swimLimit;
            animalCount++;
        }

        public void run(int distance) {
            System.out.println(name + (distance <= runLimit ? " пробежал " + distance + " м." : " не смог пробежать " + distance + " м."));
        }

        public void swim(int distance) {
            if (swimLimit == 0) {
                System.out.println(name + " не умеет плавать.");
            } else {
                System.out.println(name + (distance <= swimLimit ? " проплыл " + distance + " м." : " не смог проплыть " + distance + " м."));
            }
        }

        public static int getAnimalCount() { return animalCount; }
    }
class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name, int runLimit) {
        super(name, runLimit, 0);
        this.isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int foodAmount) {
        isFull = bowl.eatFood(foodAmount);
        System.out.println(name + (isFull ? " покушал и теперь сыт." : " остался голодным, так как в миске недостаточно еды."));
    }

    public static int getCatCount() { return catCount; }
    public boolean isFull() { return isFull; }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        dogCount++;
    }
    public static int getDogCount() { return dogCount; }
}
class Bowl {
    private int food;

    public Bowl(int food) { this.food = Math.max(food, 0); }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Миска пополнена. Теперь в миске: " + food);
        }
    }

   public boolean eatFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Cat[] cats = { new Cat("Барсик", 150), new Cat("Мурзик", 180), new Cat("Том", 160) };
        Dog[] dogs = { new Dog("Рекс", 400, 5), new Dog("Шарик", 450, 7) };
        Bowl bowl = new Bowl(50);

        System.out.println("Тестируем бег и плавание:");
        for (Animal animal : cats) { animal.run(animal.runLimit); animal.swim(5); }
        for (Animal animal : dogs) { animal.run(animal.runLimit); animal.swim(animal.swimLimit); }

        System.out.printf("\nОбщее количество животных: %d\nКотов: %d\nСобак: %d\n", Animal.getAnimalCount(), Cat.getCatCount(), Dog.getDogCount());

        System.out.println("\nКоты пытаются покушать:");
        for (Cat cat : cats) cat.eat(bowl, 20);

        System.out.println("\nСытость котов:");
        for (Cat cat : cats) System.out.println(cat.name + " - " + (cat.isFull() ? "Сыт" : "Голоден"));

        System.out.println("\nПополняем миску...");
        bowl.addFood(30);

        System.out.println("Коты пытаются покушать снова:");
        for (Cat cat : cats) if (!cat.isFull()) cat.eat(bowl, 20);

        System.out.println("\nИтоговая сытость котов:");
        for (Cat cat : cats) System.out.println(cat.name + " - " + (cat.isFull() ? "Сыт" : "Голоден"));
    }
}*/

// Практическое задание №2 Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольниу.
/*interface Shape {
    double getArea();
//дефолтный метод
    default double getPerimeter() {
        if (this instanceof Circle) {
            Circle c = (Circle) this;
            return 2 * Math.PI * c.getRadius();
        } else if (this instanceof Rectangle) {
            Rectangle r = (Rectangle) this;
            return 2 * (r.getWidth() + r.getHeight());
        }
        return 0;
    }

    String getFillColor();
    String getBorderColor();
}

abstract class AbstractShape implements Shape {
    private final String fillColor;
    private final String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Circle extends AbstractShape {
    private final double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle extends AbstractShape {
    private final double width, height;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Triangle extends AbstractShape {
    private final double a, b, c;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5, "Red", "Black"),
                new Rectangle(4, 6, "Blue", "Green"),
                new Triangle(3, 4, 5, "Yellow", "Purple")
        };

        for (Shape shape : shapes) {
            printShapeInfo(shape);
        }
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Площадь: " + shape.getArea());
        System.out.println("Периметр: " + shape.getPerimeter());
        System.out.println("Цвет фона: " + shape.getFillColor());
        System.out.println("Цвет границ: " + shape.getBorderColor());
        System.out.println("----------------------");
    }
}*/

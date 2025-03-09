//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    // Практическое задание №1 Лекция 11 Создаем классы Собака и Кот с наследованием от класса Животные
//Создаем родительский класс "Животное"
    /*class Animal {
        protected String name;
        protected int runLimit;
        protected int swimLimit;
        static int animalCount = 0;

        public Animal(String name, int runLimit, int swimLimit) {
            this.name = name;
            this.runLimit = runLimit;
            this.swimLimit = swimLimit;
            animalCount++;
        }

        public void run(int distance) {
            if (distance <= runLimit) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не смог пробежать " + distance + " м.");
            }
        }

        public void swim(int distance) {
            if (swimLimit == 0) {
                System.out.println(name + " не умеет плавать.");
            } else if (distance <= swimLimit) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println(name + " не смог проплыть " + distance + " м.");
            }
        }
    }

    // создаем класс "Кот" с наследованием от класса "Животное", где кот с ограничением бег- 200м и не может плавать
    class Cat extends Animal {
        static int catCount = 0;
        private boolean satiety; // Сытость

        public Cat(String name) {
            super(name, 200, 0);
            this.satiety = false;
            catCount++;
        }

        public boolean isSatiety() {
            return satiety;
        }

        public void eat(Bowl bowl, int foodAmount) {
            if (bowl.getFood() >= foodAmount) {
                bowl.decreaseFood(foodAmount);
                this.satiety = true;
                System.out.println(name + " поел " + foodAmount + " ед. и теперь сыт!");
            } else {
                System.out.println(name + " пытался поесть, но еды не хватило!");
            }
        }
    }

    // создаем класс "Собака" с наследованием от класса "Животное", где собака с ограничение бег 500м, плавание -10м
    class Dog extends Animal {
        static int dogCount = 0;

        public Dog(String name) {
            super(name, 500, 10);
            dogCount++;
        }
    }

    // Класс "Миска с едой"
    class Bowl {
        private int food;

        public Bowl(int food) {
            this.food = food;
        }

        public int getFood() {
            return food;
        }

        public void decreaseFood(int amount) {
            if (food >= amount) {
                food -= amount;
            } else {
                food = 0;
            }
        }

        public void addFood(int amount) {
            food += amount;
            System.out.println("В миску добавили " + amount + " ед. еды.");
        }

        public void displayFood() {
            System.out.println("В миске осталось " + food + " ед. еды.");
        }
    }

    // Главный класс Main
    public class Main {
        public static void main(String[] args) {
            Cat cat1 = new Cat("Барсик");
            Cat cat2 = new Cat("Мурзик");
            Dog dog1 = new Dog("Бобик");

            cat1.run(150);
            cat2.run(250);
            dog1.run(400);
            dog1.swim(5);

            System.out.println("Всего животных: " + Animal.animalCount);
            System.out.println("Котов: " + Cat.catCount);
            System.out.println("Собак: " + Dog.dogCount);

            Bowl bowl = new Bowl(20);
            bowl.displayFood();

            Cat[] cats = {cat1, cat2};
            for (Cat cat : cats) {
                cat.eat(bowl, 15);
            }

            bowl.displayFood();
            bowl.addFood(10);
            bowl.displayFood();
        }
    }*/
// Практическое задание №2 Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольниу.
interface Shape {
    double getArea();

    default double getPerimeter() {
        return 0; // Дефолтное значение, переопределяется в классах
    }

    default void displayInfo() {
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
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
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println("Круг:");
        circle.displayInfo();

        System.out.println("\nПрямоугольник:");
        rectangle.displayInfo();

        System.out.println("\nТреугольник:");
        triangle.displayInfo();
    }
}

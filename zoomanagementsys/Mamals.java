package zoomanagementsys;
// Mammal class inherit Animal class properties
abstract public class Mamals extends Animal {
    int runningSpeed;
    // Mammal constructor
    public Mamals(int age, String name, String category, float weight, int speed, String sound) {
        super(age, name, category, weight, sound);
        runningSpeed = speed;
    }

    abstract public int topSpeed();
}
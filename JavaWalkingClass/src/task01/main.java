package task01;

public class main {
    public static void main(String[] args) {
        Dog firstDog = new Dog("땅콩", "웰시코기", 3);
        Dog secondDog = new Dog("샌드", "시바견", 2);
        Dog thirdDog = new Dog("위치", "믹스견", 1);

        System.out.println("첫 번째 강아지는 : " + firstDog.name + " " + firstDog.breed + " " + firstDog.age + "살 입니다.");
        System.out.println("두 번째 강아지는 : " + secondDog.name + " " + secondDog.breed + " " + secondDog.age + "살 입니다.");
        System.out.println("세 번째 강아지는 : " + thirdDog.name + " " + thirdDog.breed + " " + thirdDog.age + "살 입니다.");
    }
}

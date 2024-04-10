package Ueb06;

public class Town {

    public static void main(String[] args) {

        System.out.println(Person.getPersonCounter());

        Person haensel = new Person("Hänsel", new int[]{1995, 1, 11}, 2);
        System.out.println(Person.getPersonCounter());

        Person gretel = new Person("Gretel" , new int[]{1999, 11, 1});
        System.out.println(Person.getPersonCounter());

//        System.out.println(haensel.numberOfFriends);
//        haensel.numberOfFriends = -3;
//        System.out.println(haensel.numberOfFriends);
//
//        System.out.println(haensel.getNumberOfFriends());
//        haensel.setNumberOfFriends(5);
//        System.out.println(haensel.getNumberOfFriends());

        int[] x = gretel.getBirthDateAsNewArray();
        System.out.println(x[0]);
        x[0] = 2000;
        System.out.println(gretel.getBirthDate()[0]);

        int[] today = new int[]{2023, 12, 14};
        System.out.println(haensel.getAge(today));
        System.out.println(gretel.getAge(today));

    }
}

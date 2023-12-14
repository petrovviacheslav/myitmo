package premises;

import activity.GoOut;
import human.Person;

public class Rocket{

    public static class Cockpit implements GoOut {
        private static String PassengerName;

        public static void setPassenger(Person passenger){
            Cockpit.PassengerName = passenger.getName();
            System.out.println(passenger.getName() + " сел в кабину ракеты.");
        }

        public static String getPassenger(Person passenger){
            return passenger.getName();
        }
        public static void RemoveFromTheCabin(){
            System.out.println(PassengerName + " вышел из кабины ракеты.");
            PassengerName = "";
        }

        @Override
        public void goOut(Person person){
            System.out.println(person + " покинул кабину ракеты");
            Cockpit.PassengerName = "НИКОГО В КАБИНЕ НЕТ";
        }

    }
}

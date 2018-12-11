package hu.javadummy;

import hu.javadummy.entities.Aircraft;
import hu.javadummy.entities.Tank;
import hu.javadummy.repositories.AircraftRepository;
import hu.javadummy.repositories.TankRepository;

public class Main {


    public static void main(String[] args) {
        tankDemo();
        airCraftDemo();
    }

    private static void tankDemo() {
        System.out.println();

        TankRepository tankRepository = new TankRepository();
        int size = tankRepository.selectAll().size();
        if (size == 0) {
            for (int j = 0; j < 10; j++) {
                Tank tank = new Tank();
                tank.setName("Tank_" + j);
                tankRepository.save(tank);
            }
        }

        Tank updatable = tankRepository.findById(1L);
        updatable.setName("módosított");
        tankRepository.update(updatable);

        tankRepository.selectAll().forEach(tank -> {
            StringBuilder builder = new StringBuilder();
            builder.append("id: ");
            builder.append(tank.getId());
            builder.append(", name: ");
            builder.append(tank.getName());
            builder.append(", last modified date: ");
            builder.append(tank.getLastModifiedDate());
            System.out.println(builder.toString());
        });


    }

    private static void airCraftDemo() {
        System.out.println();

        AircraftRepository aircraftRepository = new AircraftRepository();
        int size = aircraftRepository.selectAll().size();
        if (size == 0) {
            for (int j = 0; j < 10; j++) {
                Aircraft aircraft = new Aircraft();
                aircraft.setName("Aircraft_" + j);
                aircraftRepository.save(aircraft);
            }
        }
        Aircraft updatable = aircraftRepository.findById(1L);
        updatable.setName("módosított");
        aircraftRepository.update(updatable);

        aircraftRepository.selectAll().forEach(tank -> {
            StringBuilder builder = new StringBuilder();
            builder.append("id: ");
            builder.append(tank.getId());
            builder.append(", name: ");
            builder.append(tank.getName());
            builder.append(", last modified date: ");
            builder.append(tank.getLastModifiedDate());
            System.out.println(builder.toString());
        });
    }
}
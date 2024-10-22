package com.namur.towerbridge;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the number of cars for the test : ");
        int carsNumber = scanner.nextInt(); // Bridge capacity
        
        System.out.print("Enter bridge capacity : ");
        int bridgeCapacity = scanner.nextInt(); // Use to generate cars and random directions on bridge
        
        scanner.close();
        
        System.out.print("The directions of the cars will be configured randomly\n\n");
    
        Direction[] directions = Direction.values();
        
        // Same bridge sends to all cars
        Bridge bridge = new Bridge(bridgeCapacity);
    
    
        FIFO leftQueue = new FIFO(Direction.LEFT);
        FIFO rightQueue = new FIFO(Direction.RIGHT);
    
        System.out.println("CARS IN COMPETITION\n===================");
        Car[] cars = new Car[carsNumber];
        for (int i = 0; i < cars.length; i++) {
            // Random chosen direction for car instance
            Direction randomDirection = directions[(int) (Math.random() * directions.length)];
    
            // Indicates car queue
            if(randomDirection == Direction.LEFT){
                cars[i] = new Car("Car"+(i+1), bridge, leftQueue);
            }else{
                cars[i] = new Car("Car"+(i+1), bridge, rightQueue);
            }
        }
        for (Car car : cars) {
            car.start();
        }
        
        System.out.println("\n===========================\n");
    }
}
package UberRentalSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class RideBookingSystem {
    List<Customer> customers;
    List<Driver> drivers;
    List<Ride> rides;

    void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    Ride bookRide(Customer customer) {
        Stream<Driver> driver_stream=drivers.stream();
        driver_stream.filter((driver) -> driver.isAvailable()==true);
        if(driver_stream.count()==0) {
            throw new InvalidRideException("sorry no rides are available...go to destination via public transport");
        }
        else {
            Object[] available_driver=driver_stream.toArray();//Stream is extracting Object type
            Ride ride=new Ride(customer,(Driver)available_driver[0]);
            return ride;
        }
    }

    void saveRides() throws Exception{
        String path="C:\\Users\\User\\Desktop\\Uber\\rides.txt";
        File file=new File(path);
        for(Ride ride: rides) {
            String message=ride.rideDetails();
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);

            for(int i=0;i<message.length();i++) {
                bw.write(message.charAt(i));
                bw.flush();
                fw.flush();
            }
        }
    }

    void loadDriverFromFile() throws Exception {
        String path="C:\\Users\\User\\Desktop\\Uber\\rides.txt";
        File file=new File(path);
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            boolean isHeader=true;
            while((line=br.readLine()) != null){
                if(isHeader) {
                    isHeader=false;
                    continue;
                }
                String[] values=line.split(",");
                String id=values[0];
                String name=values[1];
                String status=values[2];
                System.out.println(id+" "+name+" "+status);
                Driver driver=new Driver(id,name);
                RideBookingSystem obj=new RideBookingSystem();
                obj.registerDriver(driver);
            }
        }
    }

    void saveDriversToFile() throws Exception{
        String path="C:\\Users\\User\\Desktop\\Uber\\drivers.txt";
        File file=new File(path);
        for(Driver driver: drivers) {
            String message=driver.getID()+","+driver.getName();
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);

            for(int i=0;i<message.length();i++) {
                bw.write(message.charAt(i));
                bw.flush();
                fw.flush();
            }
        }
    }

    void showAllDrivers() {
        for(Driver driver : drivers) {
            driver.showProfiles();
        }
    }
}

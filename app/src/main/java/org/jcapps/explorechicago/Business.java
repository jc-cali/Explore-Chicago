package org.jcapps.explorechicago;

import java.io.Serializable;

/**
 * Created by JC on 8/11/16.
 */
public class Business implements Serializable {
    private int id;
    private String category, name, address, city, state, zip, phone;


    public Business(int id, String category, String name, String address, String city, String state, String zip, String phone) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

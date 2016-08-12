package org.jcapps.explorechicago;

import java.io.Serializable;

/**
 * Created by JC on 8/11/16.
 */
public class Business implements Serializable {
    private int id;
    private String category, name, address, city, state, zip, phone, hours, web, favorite;


    public Business(int id, String category, String name, String address, String city, String state, String zip, String phone, String hours, String web, String favorite) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.hours = hours;
        this.web = web;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
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

    public String getHours() {
        return hours;
    }

    public String getWeb() {
        return web;
    }

    public String getFavorite() {
        return favorite;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", hours='" + hours + '\'' +
                ", web='" + web + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }
}

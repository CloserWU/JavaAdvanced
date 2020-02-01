package com.closer;

/**
 * <p>Person</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-01 09:56
 */
public class Person {

    private Double price;
    private String name;

    public Person(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        if (p.name.equals(this.name)) {
            if (p.price.equals(this.price)) {
                return true;
            }
        }
        return false;
    }
}


package com.closer;

/**
 * <p>Goods</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-01-31 11:56
 */
public class Goods implements Comparable{
    private Double price;
    private String name;

    public Goods(Double price, String name) {
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
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (goods.price > this.price) {
                return 1;
            } else if (goods.price < this.price) {
                return  -1;
            } else {
                return this.name.compareTo(goods.name);
            }

//            return Double.compare(goods.price, this.price);
        }
        throw new RuntimeException("数据类型不一致");
    }
}

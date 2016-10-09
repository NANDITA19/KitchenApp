package model;

import java.util.HashMap;

/**
 * Created by rutvik on 9/18/2016 at 10:09 AM.
 */

public class MenuItem
{

    public enum Status
    {
        FRESH(0),
        COOKING(1),
        READY(2),
        SERVED(3),
        CANCELED(-1);

        private final int value;

        Status(int value)
        {
            this.value = value;
        }
    }

    final String id, name;
    int quantity;
    double price;

    Status status;

    public MenuItem(final String id, final String name, int quantity, double price)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status=Status.FRESH;
    }

    public final HashMap<String, Object> toMap()
    {
        return new HashMap<String, Object>()
        {{

            put("status",status.value);
            put("id", id);
            put("name", name);
            put("quantity", quantity);
            put("price", price);

        }};
    }

    public final void setItemStatus(Status status)
    {
        this.status = status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public int getStatus()
    {
        return status.value;
    }
}

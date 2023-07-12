package ArrayLists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class order {

    private int orderID;
    private List<String> itemNames;
    public boolean cashOnDelivery;

    public order(int orderID, List<String> itemNames,boolean cashOnDelivery){
        this.orderID=orderID;
        this.itemNames=itemNames;
        this.cashOnDelivery=cashOnDelivery;
    }

    public int getOrderID() {
        return orderID;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public boolean isCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(boolean cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    @Override
    public String toString() {
        return "order{" +
                "OrderID =" + orderID +
                ", Item Names=" + itemNames +
                ", Cash On Delivery =" + cashOnDelivery +
                '}';
    }
}
class test12{
    public static List<String> getItems(List<order>orders){
        ListIterator<order> orderIT= orders.listIterator();
        while(orderIT.hasNext()){
            System.out.println(orderIT.next().getItemNames());
        }
        return null;
    }

    public static void main(String[] args){

        List<order>orders=new ArrayList<order>();

        List<String> items=new ArrayList<String>();
        items.add("Pizza");
        items.add("Noodles");
        orders.add(new order(101,items,true));

        List<String> items1=new ArrayList<String>();
        items1.add("Burger");
        items1.add("Momos");
        items1.add("Fried Rice");
        orders.add(new order(102,items1,true));

        List<String> items2=new ArrayList<String>();
        items2.add("Lasagna");
        items2.add("Fried Rice");
        items2.add("Rolls");
        items2.add("Soup");
        orders.add(new order(103,items2,false));

        List<String> items3=new ArrayList<String>();
        items3.add("Pizza");
        orders.add(new order(104,items3,true));

        List<String> items4=new ArrayList<String>();
        items4.add("Pizza");
        items4.add("Momos");
        orders.add(new order(105,items4,false));


        System.out.println("List of Items:");
        List<String> itemsALL=getItems(orders);


    }
}

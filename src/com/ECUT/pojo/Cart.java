package com.ECUT.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Integer totalcount;
    private BigDecimal totalprice;
    private Map<Integer,CartItem> Items=new LinkedHashMap<Integer,CartItem>();

    public Cart() {
    }

    public Cart(Integer totalcount, BigDecimal totalprice, Map<Integer, CartItem> items) {
        this.totalcount = totalcount;
        this.totalprice = totalprice;
        Items = items;
    }

    public Integer getTotalcount() {
        totalcount=0;
        for(Map.Entry<Integer,CartItem> entry: Items.entrySet()){
            totalcount+=entry.getValue().getCount();
        }
        return totalcount;
    }



    public BigDecimal getTotalprice() {
        totalprice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry: Items.entrySet()){
            totalprice=totalprice.add(entry.getValue().getTotalprice());
        }
        return totalprice;
    }



    public Map<Integer, CartItem> getItems() {
        return Items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        Items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalcount=" + getTotalcount() +
                ", totalprice=" + getTotalprice()+
                ", Items=" + Items +
                '}';
    }

    public void addItem(CartItem cartItem){
     CartItem Item=Items.get(cartItem.getId());
     if (Item==null){
         Items.put(cartItem.getId(),cartItem);
     }else {
         Item.setCount(Item.getCount()+1);
         Item.setTotalprice(Item.getPrice().multiply(new BigDecimal(Item.getCount() ) ));
     }
    }
    public void deleteItem(Integer id){
      Items.remove(id);
    }
    public void clear(){
   Items.clear();
    }
    public void updateCount(Integer id,Integer count){
        CartItem Item=Items.get(id);
        if (Item!=null){
            Item.setCount(count);
            Item.setTotalprice(Item.getPrice().multiply(new BigDecimal(Item.getCount() ) ));
        }
    }

}

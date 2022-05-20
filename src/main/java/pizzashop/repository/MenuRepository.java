package pizzashop.repository;

import pizzashop.model.OrderItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MenuRepository {
    private static String filename = "src/main/resources/data/menu.txt";
    private List<OrderItem> listMenu;

    public MenuRepository(){
            /*
    This is a comment
    // this is a nested comment
    This is another comment
    */
    }

    private void readMenu() throws IOException {
        this.listMenu= new ArrayList<>();
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)){
            String line = null;
            while(true){
                try {
                    if (!((line=br.readLine())!=null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                OrderItem menuItem=getMenuItem(line);
                listMenu.add(menuItem);
            }
        }
    }

    private OrderItem getMenuItem(String line){
        OrderItem item=null;
        if (line==null|| line.equals("")) return null;
        StringTokenizer st=new StringTokenizer(line, ",");
        String name= st.nextToken();
        double price = Double.parseDouble(st.nextToken());
        item = new OrderItem(name, 0, price);
        return item;
    }

    public List<OrderItem> getMenu() throws IOException {
        readMenu();//create a new menu for each table, on request
        return listMenu;
    }

}
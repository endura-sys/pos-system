package com.endura.pos_system.ui.order;

import java.util.ArrayList;

public class Month {

    private static ArrayList<Month> MonthArrayList;
    private final int id;
    private String name;

    public Month(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public static void initMonths()
    {
        MonthArrayList = new ArrayList<>();

        Month january = new Month(0,"January");
        MonthArrayList.add(january);

        Month february = new Month(1,"February");
        MonthArrayList.add(february);

        Month march = new Month(2,"March");
        MonthArrayList.add(march);

        Month april = new Month(3,"April");
        MonthArrayList.add(april);

        Month may = new Month(4,"May");
        MonthArrayList.add(may);

        Month june = new Month(5,"June");
        MonthArrayList.add(june);

        Month july = new Month(6,"July");
        MonthArrayList.add(july);

        Month august = new Month(7,"August");
        MonthArrayList.add(august);

        Month september = new Month(8,"September");
        MonthArrayList.add(september);

        Month october = new Month(9,"October");
        MonthArrayList.add(october);

        Month november = new Month(10,"November");
        MonthArrayList.add(november);

        Month december = new Month(11,"December");
        MonthArrayList.add(december);
    }

    public static ArrayList<Month> getMonthArrayList()
    {
        return MonthArrayList;
    }

    public static String[] monthNames()
    {
        String[] names = new String[MonthArrayList.size()];
        for(int i = 0; i< MonthArrayList.size(); i++)
        {
            names[i] = MonthArrayList.get(i).name;
        }
        return names;
    }

    public String getName() {
        return name;
    }
}
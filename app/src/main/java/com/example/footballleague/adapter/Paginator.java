package com.example.footballleague.adapter;

import com.example.footballleague.model.teams.TeamsItem;

import java.util.ArrayList;
import java.util.List;

public class Paginator {
    public static final int TOTAL_NUM_ITEMS=20;
    public static final int ITEMS_PER_PAGE=6;
    public static final int ITEMS_REMAINING=TOTAL_NUM_ITEMS % ITEMS_PER_PAGE;
    public static final int LAST_PAGE=TOTAL_NUM_ITEMS/ITEMS_PER_PAGE;
List<TeamsItem> x;
    public Paginator(List<TeamsItem> x
    ) {
    this.x=x;
    }

    public ArrayList<TeamsItem> generatePage(int currentPage)
    {
        int startItem=currentPage*ITEMS_PER_PAGE;
        int numOfData=ITEMS_PER_PAGE;
        ArrayList<TeamsItem> pageData=new ArrayList<>();

        if (currentPage==LAST_PAGE && ITEMS_REMAINING>0)
        {
            for (int i=startItem;i<startItem+ITEMS_REMAINING;i++)
            {
                if(i!=20) {
                    pageData.add(x.get(i));
                }
            }
        }else
        {
            for (int i=startItem;i<startItem+numOfData;i++)
            {
                if(i!=20) {
                    pageData.add(x.get(i));
                }
            }
        }
        return pageData;
    }
}
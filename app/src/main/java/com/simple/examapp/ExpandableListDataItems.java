package com.simple.examapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataItems {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

//        List<String> ebteday = new ArrayList<String>();
//        ebteday.add("الصف الأول الإبتدائي");
//        ebteday.add("الصف الثاني الإبتدائي");
//        ebteday.add("الصف الثالث الإبتدائي");
//        ebteday.add("الصف الرابع الإبتدائي");
//        ebteday.add("الصف الخامس الإبتدائي");
//        ebteday.add("الصف السادس الإبتدائي");

        List<String> eadady = new ArrayList<String>();
        eadady.add("الصف الأول الإعدادي");
        eadady.add("الصف الثاني الإعدادي");
        eadady.add("الصف الثالث الإعدادي");

        List<String> sanwy = new ArrayList<String>();
        sanwy.add("الصف الأول الثانوي");
        sanwy.add("الصف الثاني الثانوي");
        sanwy.add("الصف الثالث الثانوي");


        //expandableDetailList.put("المرحلة الإبتدائية", ebteday);
        expandableDetailList.put("المرحلة الإعدادية.", eadady);
        expandableDetailList.put("المرحلة الثانوية", sanwy);
        return expandableDetailList;
    }
}


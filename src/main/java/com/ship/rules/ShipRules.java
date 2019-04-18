package com.ship.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class ShipRules {

    /*
    Merge overlapping zip code ranges if any and returned the merged lists
     */
    public List<ZipCode> MergeZipCodRange(List<ZipCode> zips) {

        LinkedList<ZipCode> mergedList = new LinkedList<>();

        //Sort the list using custom comparator
        Collections.sort(zips, new ZipCodeComparator());

        //iterated through the list and merge the overlapping ranges
        for (ZipCode zip : zips) {
            //add the first item to the list OR
            //if the last item.end to next item.start add to the list
            if (mergedList.isEmpty() || mergedList.getLast().end < zip.start) {
                mergedList.add(zip);
            } else {
                //if last item.end > current item.start
                //update the last item.end = max(last item.end and current.end)
                mergedList.getLast().end = Math.max(mergedList.getLast().end, zip.end);
            }

        }
        return mergedList;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShipRules.class, args);
        List<ZipCode> zips = new ArrayList<>();
        zips.add(new ZipCode(94200, 94299));
        zips.add(new ZipCode(94226, 94399));
        zips.add(new ZipCode(94133, 94133));

        System.out.printf("Input \n");
        for (ZipCode zip1 : zips) {
            System.out.printf("start %s, end %s \n", zip1.start, zip1.end);
        }

        ShipRules shipRules = new ShipRules();

        System.out.printf("\n\n Merged List \n");
        List<ZipCode> mergedList = shipRules.MergeZipCodRange(zips);
        for (ZipCode zip1 : mergedList) {
            System.out.printf("start %s, end %s \n", zip1.start, zip1.end);
        }
    }



}

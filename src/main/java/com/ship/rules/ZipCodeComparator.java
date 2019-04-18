package com.ship.rules;

import java.util.Comparator;

/*
Custom implementation to compare zip code ranges
sorts list by zipcode.start in increasing order
Example [start,end]:  [94200,94299] [94600,94699] [94133,94133]
Sorted listed: [94133,94133] [94200,94299] [94600,94699]
 */
class ZipCodeComparator implements Comparator<ZipCode> {

    @Override
    public int compare(ZipCode zip1, ZipCode zip2) {
        if (zip1.start < zip2.start)
            return -1;
        else if (zip1.start == zip2.start)
            return 0;
        else
            return 1;
    }

}

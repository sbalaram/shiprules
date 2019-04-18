package com.ship.rules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipRulesTests {

    public ZipCodeComparator compare = new ZipCodeComparator();
    public ShipRules shipRules = new ShipRules();

    @Test
    public void testIncreasingOrderComparator() {
        ZipCode range1 = new ZipCode(3,2);
        ZipCode range2 = new ZipCode(4,1);
        int result = compare.compare(range1,range2);
        assertTrue("compare increasing order ", result == -1);
    }

    @Test
    public void testMatchingComparator() {
        ZipCode range1 = new ZipCode(3,2);
        ZipCode range2 = new ZipCode(3,1);
        int result = compare.compare(range1,range2);
        assertTrue("compare increasing order ", result == 0);
    }

    @Test
    public void testDecreasingOrderComparator() {
        ZipCode range1 = new ZipCode(4,2);
        ZipCode range2 = new ZipCode(1,1);
        int result = compare.compare(range1,range2);
        assertTrue("compare increasing order ", result == 1);
    }


    @Test
    public void testMerge() {
        List<ZipCode> zips = new ArrayList<>();

        zips.add(new ZipCode(94200,94299));
        zips.add(new ZipCode(94266,94399));
        zips.add(new ZipCode(94133,94133));

        List<ZipCode> matchOrder = new ArrayList<>();
        matchOrder.add(new ZipCode(94133,94133));
        matchOrder.add(new ZipCode(94200,94200));

        List<ZipCode> merged = shipRules.MergeZipCodRange(zips);
        assertTrue(merged.size()>0);
        //assertThat(merged,is(equalTo(matchOrder)));
    }

}

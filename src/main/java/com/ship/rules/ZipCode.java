package com.ship.rules;

/*
holds the start and end of the zip code
 */
public class ZipCode {

    int start;
    int end;
    public ZipCode(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

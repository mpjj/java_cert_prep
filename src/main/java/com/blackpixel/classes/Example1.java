package com.blackpixel.classes;

public class Example1 {
    public static void main(String[] args) {
        B bRef = new B();
        System.out.printf("i is %d, j is %d", bRef.getI(), bRef.getJ());
    }
}

class B {
    private int i,j;
    public B(){
        this(10);
        j=30;
        System.out.println("Finished in B() setting j to 30");
    }

    public B(int i){
        this(i,0);
        System.out.println("Finished in B(int)");
    }
    public B(int i, int j){
        this.i=i;
        this.j=j;
        System.out.println("Finished in B(int, int) setting i to 10 and j to 0");
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

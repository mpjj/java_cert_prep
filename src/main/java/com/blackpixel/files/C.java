package com.blackpixel.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class C {

    public static void main(String[] args) throws IOException {
    FileOutputStream fos = new FileOutputStream("file.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(new B());
}
}
class A{ private int i; }

class B implements Serializable {
    private A aRef = new A();
}




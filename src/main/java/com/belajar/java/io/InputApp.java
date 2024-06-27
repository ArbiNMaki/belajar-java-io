package com.belajar.java.io;

import java.util.Scanner;

public class InputApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NAMA: ");
        String name = scanner.nextLine();
        System.out.println("Halo : " + name);
    }
}

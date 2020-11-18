package com.fhict.server;

import com.fhict.server.products.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        // keep server running
        // while loop will eat CPU
        Thread.currentThread().join();
    }

}

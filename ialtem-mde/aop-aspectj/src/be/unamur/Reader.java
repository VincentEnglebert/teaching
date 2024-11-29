package be.unamur;

import java.util.Scanner;

import be.unamur.exceptions.AlreadyClosedException;

/**
 *  Classe Singleton Reader
 *  https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
 */

public class Reader {
    
    
    private Scanner reader;
    private static volatile Reader singleton;
    private boolean alreadyClosed;
    
    private Reader() {
        alreadyClosed = false;
        reader = new Scanner(System.in);
    }
    
    public static Reader getInstance() {
        if(singleton == null) {
        	synchronized(Reader.class) {
        		if(singleton == null) {
        			singleton = new Reader();
        		}
        	}
        }
        return singleton;
    }
    
    public int nextInt() throws AlreadyClosedException {
        if(!alreadyClosed) {
            return reader.nextInt();
        }
        throw new AlreadyClosedException(); //Custom exception
    }
    
    public Float nextFloat() throws AlreadyClosedException {
        if(!alreadyClosed) {
            return reader.nextFloat();
        }
        throw new AlreadyClosedException(); //Custom exception
    }
    
    public double nextDouble() throws AlreadyClosedException {
        if(!alreadyClosed) {
            return reader.nextDouble();
        }
        throw new AlreadyClosedException();
    }
    
    public String next() throws AlreadyClosedException {
        if(!alreadyClosed) {
            return reader.next();
        }
        throw new AlreadyClosedException();
    }
    
    public String nextLine() throws AlreadyClosedException {
        if(!alreadyClosed) {
            return reader.nextLine();
        }
        throw new AlreadyClosedException();
    }
    
    public void close() {
        alreadyClosed = true;
        reader.close();
    }   
}

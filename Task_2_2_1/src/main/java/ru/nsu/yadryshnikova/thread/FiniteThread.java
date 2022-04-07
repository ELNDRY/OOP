package ru.nsu.yadryshnikova.thread;

public class FiniteThread extends Thread {
    private boolean isCont = true;

    public boolean isCont() {
        return isCont;
    }

    public void breakWork(){
        isCont = false;
        this.interrupt();
    }
}
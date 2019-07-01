package com.art;

class Worker implements Runnable {

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" i   runed !");
        }
    }

}

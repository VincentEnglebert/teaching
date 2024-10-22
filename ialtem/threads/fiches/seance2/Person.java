package com.namur.sisters;

public class Person extends Agent{

    public Person(String identity, Canal inCanal, Canal outCanal) {
        super(identity, inCanal, outCanal);
    }

    public void run() {
        while (true) {
            Person person = (Person) Thread.currentThread();
            Message messageToSend;
            try {
                switch (person.getIdentity()) {
                    case "wendy":
                        messageToSend = this.inCanal.consume();
                        this.outCanal.produce(messageToSend);
                        break;
                    case "marine":
                        messageToSend = new Message("Cher maxence", "wndy@blabla.com");
                        this.outCanal.produce(messageToSend);
                        break;
                    case "maxence":
                        break;
                    default:
                        break;
                }

                // Waiting time before next attempt
                Thread.sleep(this.consumeTime);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

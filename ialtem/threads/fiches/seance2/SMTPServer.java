package com.namur.sisters;

public class SMTPServer extends Agent{

    public SMTPServer(Canal inCanal, Canal outCanal) {
        super("SMTP", inCanal, outCanal);
    }

    public void run()  {

        try {
            while (true) {
                Message message = this.inCanal.consume();
                System.out.println("[SMTP box] : " + message.getContent() + " <" + message.getFrom() +">");
                Thread.sleep(this.consumeTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

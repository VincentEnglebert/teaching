package be.unamur.aspects;

import be.unamur.Compte;
import be.unamur.impl.*;
import be.unamur.interfaces.INotificationChannel;
import be.unamur.interfaces.INotificationService;

public aspect NotificationAspect {

    // =========== NOTIFICATIONS PAR 1..* CANAUX CHOISI(S) ===============
    // Lier l'interface à une implémentation par défaut
    INotificationChannel[] notificationChannels = {
            new PushNotification(),
            //new EmailNotification(),
            //new SMSNotification(),
    }; 

    declare parents:Compte implements INotificationService;

    // Ajout le channel du client sur ce compte
    private INotificationChannel[] Compte.channels;
    // Le setter du channel
    public void Compte.setChannels(INotificationChannel[] channels){
        this.channels = channels;
    }
    //Le getter du channel
    public INotificationChannel[] Compte.getChannels(){
        return channels;
    }

    public void Compte.send() {
       // Diffuser aux channels choisis
        xxx
    }

    // === LIAISON DE 1..* CANAUX DANS LE CONSTRUCTEUR ==================
    pointcut sendNotification(): (
	initialization(be.unamur.Compte.new(..))
    );

    xxx(): sendNotification(){

        xxx

    }


    // === ALERTE ENTREE D'ARGENT =======================================
    pointcut entreeArgent(): (
        xxx
    );

    xxx(): entreeArgent(){
        xxx
	// Utiliser le channel choisi pour envoyer les notifications
	compte.send();
    }

}
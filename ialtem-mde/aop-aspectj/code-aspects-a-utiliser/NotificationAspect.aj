package be.unamur.aspects;

import be.unamur.Compte;
import be.unamur.impl.*;
import be.unamur.interfaces.*;

public aspect NotificationAspect {

    // =========== NOTIFICATIONS PAR 1..* CANAUX CHOISI(S) ===============
    // Lier l'interface à une implémentation par défaut
    INotificationChannel[] notificationChannels = {
            new PushNotification(),
            new EmailNotification(),
            new SMSNotification(),
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
       //TODO: Diffuser aux channels choisis
    }

    // === LIAISON DE 1..* CANAUX DANS LE CONSTRUCTEUR ==================
    pointcut sendNotification(): (
	initialization(be.unamur.Compte.new(..))
    );

    // TODO: Ajouter le code advice pour le pointcut sendNotification


    // TODO: Ajouter le poincut pour capturer les JoinPoint concernés par un dépôt d'argent

    // TODO: Ajouter le code advice qui notifie le client sur ses cannaux après un dépôt d'argent sur son compte

}
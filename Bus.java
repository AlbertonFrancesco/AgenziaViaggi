public class Bus implements Runnable{
    public synchronized void effettuareViaggio(GruppoTuristi gruppo) {
        gruppo.pagareBiglietti();
        gruppo.imbarcarsi();
        System.out.println("Partenza dal porto dei 25 " + gruppo.getNome() + ".");

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ritorno al porto del traghetto");
    }
    
}
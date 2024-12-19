import java.util.concurrent.BlockingQueue;

public class Bus extends Thread {
    private final GruppoTuristico gruppo;
    private final BlockingQueue<GruppoTuristico> codaPagamento;

    public Bus(GruppoTuristico gruppo, BlockingQueue<GruppoTuristico> codaPagamento) {
        this.gruppo = gruppo;
        this.codaPagamento = codaPagamento;
    }

    @Override
    public void run() {
         System.out.println("Partenza dagli alloggi dei 25 " + gruppo);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Arrivo al porto dei 25 " + gruppo);
        pagaBiglietti();
    }

    private void pagaBiglietti() {
        try {
            Thread.sleep((long) (Math.random() * 1000)); 
            System.out.println("Pagamento del biglietto completato dai 25 " + gruppo);
            codaPagamento.put(gruppo); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

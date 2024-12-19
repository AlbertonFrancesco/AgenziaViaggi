import java.util.concurrent.BlockingQueue;

public class Traghetto extends Thread {
    private final BlockingQueue<GruppoTuristico> codaPagamento;
    private final String nomeTraghetto;

    public Traghetto(String nomeTraghetto, BlockingQueue<GruppoTuristico> codaPagamento) {
        this.nomeTraghetto = nomeTraghetto;
        this.codaPagamento = codaPagamento;
    }

    @Override
    public void run() {
        while (true) {
            try {
                GruppoTuristico gruppo = codaPagamento.take();
                imbarcare(gruppo);
                viaggio(gruppo);
            } catch (InterruptedException e) {
                System.out.println(nomeTraghetto + " termina l'attività.");
                break;
            }
        }
    }

    private void imbarcare(GruppoTuristico gruppo) {
        System.out.println("Imbarco sul traghetto dei 25 " + gruppo);
    }

    private void viaggio(GruppoTuristico gruppo) {
        System.out.println(nomeTraghetto + " parte dal porto con i 25 " + gruppo + "...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nomeTraghetto + " ritorna al porto.");
    }
}

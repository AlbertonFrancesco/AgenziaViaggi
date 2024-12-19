import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<GruppoTuristico> codaPagamento = new ArrayBlockingQueue<>(3);

        Bus busFrancesi = new Bus(GruppoTuristico.FRANCESI, codaPagamento);
        Bus busTedeschi = new Bus(GruppoTuristico.TEDESCHI, codaPagamento);
        Bus busSpagnoli = new Bus(GruppoTuristico.SPAGNOLI, codaPagamento);

        Traghetto traghetto = new Traghetto("Traghetto 1", codaPagamento);

        traghetto.start();

        busFrancesi.start();
        busTedeschi.start();
        busSpagnoli.start();

        try {
            busFrancesi.join();
            busTedeschi.join();
            busSpagnoli.join();

            traghetto.interrupt();

            scriviRisultatiSuFile("viaggi.txt");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void scriviRisultatiSuFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Data: " + LocalDate.now() + "\n");
            writer.write("Viaggi completati in ordine di pagamento.\n");
            System.out.println("Risultati scritti su " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

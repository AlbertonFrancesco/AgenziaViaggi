    public enum GruppoTuristici {
        FRANCESI("Francesi"),
        TEDESCHI("Tedeschi"),
        SPAGNOLI("Spagnoli");

    private GruppoTuristici nome;

     GruppoTuristici(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void partire() {
        System.out.println("Partenza dagli alloggi dei 25 " + nome);
    }

    public void arrivareAlPorto() {
        System.out.println("Arrivo al porto dei 25 " + nome);
    }

    public void pagareBiglietti() {
        System.out.println("Pagamento del biglietto dei 25 " + nome);
    }

    public void imbarcarsi() {
        System.out.println("Imbarco sul traghetto dei 25 " + nome);
    }
}
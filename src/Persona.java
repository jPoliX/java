enum Tipologia{
    cellulare,abitazione,azienda;
}
public class Persona {
    public String nome;
    public String cognome;
    public String numDiTelefono;
    public String saldoTelefonico;
    public String password;
    public Tipologia tipo;
    public String anagrafica(){
        return String.format("Nome: %s Cognome: %s Telefono: %s Tipo: %s Saldo: %s",nome,cognome,numDiTelefono,tipo,saldoTelefonico);
    }
    public String visNascosti(){
        return String.format("\"Nome: %s Cognome: %s Telefono: %s Tipo: %s",nome,cognome,numDiTelefono,tipo);
    }
}
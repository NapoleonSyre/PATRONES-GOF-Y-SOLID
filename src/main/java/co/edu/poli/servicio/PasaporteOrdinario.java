package co.edu.poli.servicio;

import co.edu.poli.modelo.Pais;
import co.edu.poli.modelo.Titular;
import java.time.LocalDate;

public class PasaporteOrdinario implements Pasaporte {

    private int idPasaporte;
    private String numeroPasaporte;
    private LocalDate fechaEmision;
    private LocalDate fechaExpiracion;
    private Titular titular;
    private Pais pais;

    public PasaporteOrdinario(int id, String numero, LocalDate emision, LocalDate expiracion,
                              Titular titular, Pais pais) {
        this.idPasaporte = id;
        this.numeroPasaporte = numero;
        this.fechaEmision = emision;
        this.fechaExpiracion = expiracion;
        this.titular = titular;
        this.pais = pais;
    }

    @Override
    public String getTipo() {
        return "Ordinario";
    }

    // getters opcionales
    public int getIdPasaporte() { return idPasaporte; }
    public String getNumeroPasaporte() { return numeroPasaporte; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public LocalDate getFechaExpiracion() { return fechaExpiracion; }
    public Titular getTitular() { return titular; }
    public Pais getPais() { return pais; }

    @Override
    public String toString() {
        return "PasaporteOrdinario{" +
                "id=" + idPasaporte +
                ", numero='" + numeroPasaporte + '\'' +
                ", emision=" + fechaEmision +
                ", expiracion=" + fechaExpiracion +
                ", titular=" + titular +
                ", pais=" + pais +
                '}';
    }
}

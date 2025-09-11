package co.edu.poli.servicio;

import co.edu.poli.modelo.Pais;
import co.edu.poli.modelo.Titular;
import java.time.LocalDate;

public class PasaporteDiplomatico implements Pasaporte {

    private int idPasaporte;
    private String numeroPasaporte;
    private LocalDate fechaEmision;
    private LocalDate fechaExpiracion;
    private Titular titular;
    private Pais pais;
    private String paisRepresentado;

    public PasaporteDiplomatico(int id, String numero, LocalDate emision, LocalDate expiracion,
                                Titular titular, Pais pais, String paisRepresentado) {
        this.idPasaporte = id;
        this.numeroPasaporte = numero;
        this.fechaEmision = emision;
        this.fechaExpiracion = expiracion;
        this.titular = titular;
        this.pais = pais;
        this.paisRepresentado = paisRepresentado;
    }

    @Override
    public String getTipo() {
        return "Diplomático";
    }

    public String getPaisRepresentado() {
        return paisRepresentado;
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
        return "PasaporteDiplomatico{" +
                "id=" + idPasaporte +
                ", numero='" + numeroPasaporte + '\'' +
                ", emision=" + fechaEmision +
                ", expiracion=" + fechaExpiracion +
                ", titular=" + titular +
                ", pais=" + pais +
                ", paisRepresentado='" + paisRepresentado + '\'' +
                '}';
    }
}

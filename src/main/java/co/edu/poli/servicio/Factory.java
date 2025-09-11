package co.edu.poli.servicio;

import co.edu.poli.modelo.Pais;
import co.edu.poli.modelo.Titular;

import java.time.LocalDate;

public class Factory {

    public static Pasaporte crearPasaporteOrdinario(
            int idPasaporte,
            String numeroPasaporte,
            LocalDate fechaEmision,
            LocalDate fechaExpedicion,
            Titular titular,
            Pais pais) {

        return new PasaporteOrdinario(idPasaporte, numeroPasaporte, fechaEmision, fechaExpedicion, titular, pais);
    }

    public static Pasaporte crearPasaporteDiplomatico(
            int idPasaporte,
            String numeroPasaporte,
            LocalDate fechaEmision,
            LocalDate fechaExpedicion,
            Titular titular,
            Pais pais,
            String paisRepresentado) {

        return new PasaporteDiplomatico(idPasaporte, numeroPasaporte, fechaEmision, fechaExpedicion, titular, pais, paisRepresentado);
    }
}

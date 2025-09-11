package co.edu.poli.controlador;

import co.edu.poli.modelo.Pais;
import co.edu.poli.modelo.Titular;
import co.edu.poli.servicio.Factory;
import co.edu.poli.servicio.Pasaporte;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Controladorformulario {

    // === Campos del formulario ===
    @FXML private TextField txt1;   // ID PASAPORTE
    @FXML private TextField txt2;   // NUMERO DE PASAPORTE
    @FXML private TextField txt3;   // FECHA EMISION
    @FXML private TextField txt4;   // FECHA EXPEDICION
    @FXML private TextField txt5;   // ID PAIS
    @FXML private TextField txt6;   // PAIS
    @FXML private TextField txt7;   // CIUDAD
    @FXML private TextField txt8;   // ID PASAJERO
    @FXML private TextField txt9;   // NOMBRE PASAJERO
    @FXML private TextField txt10;  // ID PAIS NACIMIENTO
    @FXML private TextField txt11;  // PAIS (para diplomático)
    @FXML private TextField txt12;  // CIUDAD
    @FXML private TextField txt13;  // FECHA NACIMIENTO
    @FXML private TextField txt14;  // ¿TIENE VISA?

    @FXML private CheckBox opc1; // Pasaporte Ordinario
    @FXML private CheckBox opc2; // Pasaporte Diplomático

    // === Evento al dar click en CREAR ===
    @FXML
    private void click() {
        try {
            // ==== Validaciones básicas ====
            if (txt1.getText().isEmpty() || txt2.getText().isEmpty()) {
                System.out.println("⚠️ Debes llenar al menos ID de pasaporte y número de pasaporte.");
                return;
            }
            if (!opc1.isSelected() && !opc2.isSelected()) {
                System.out.println("⚠️ Debes seleccionar un tipo de pasaporte (Ordinario o Diplomático).");
                return;
            }

            // ==== Datos del pasaporte ====
            int idPasaporte = Integer.parseInt(txt1.getText());
            String numeroPasaporte = txt2.getText();
            LocalDate fechaEmision = txt3.getText().isEmpty() ? LocalDate.now() : LocalDate.parse(txt3.getText());
            LocalDate fechaExpedicion = txt4.getText().isEmpty() ? LocalDate.now() : LocalDate.parse(txt4.getText());

            int idPais = txt5.getText().isEmpty() ? 0 : Integer.parseInt(txt5.getText());
            String nombrePais = txt6.getText().isEmpty() ? "Desconocido" : txt6.getText();
            Pais pais = new Pais(idPais, nombrePais, null);

            // ==== Datos del titular ====
            int idPasajero = txt8.getText().isEmpty() ? 0 : Integer.parseInt(txt8.getText());
            String nombrePasajero = txt9.getText().isEmpty() ? "Sin nombre" : txt9.getText();
            String ciudad = txt12.getText().isEmpty() ? "Desconocida" : txt12.getText();
            boolean tieneVisa = txt14.getText().equalsIgnoreCase("SI");

            LocalDate fechaNacimiento = txt13.getText().isEmpty()
                    ? LocalDate.of(2000, 1, 1)
                    : LocalDate.parse(txt13.getText());

            Titular titular = new Titular(nombrePasajero, idPasajero, pais, ciudad, tieneVisa, fechaNacimiento);

            // ==== Crear pasaporte con Factory ====
            Pasaporte pasaporte;
            if (opc1.isSelected()) {
                // Ordinario
                pasaporte = Factory.crearPasaporteOrdinario(
                        idPasaporte,
                        numeroPasaporte,
                        fechaEmision,
                        fechaExpedicion,
                        titular,
                        pais
                );
            } else {
                // Diplomático
                String paisRepresentado = txt11.getText().isEmpty() ? "N/A" : txt11.getText();
                pasaporte = Factory.crearPasaporteDiplomatico(
                        idPasaporte,
                        numeroPasaporte,
                        fechaEmision,
                        fechaExpedicion,
                        titular,
                        pais,
                        paisRepresentado
                );
            }

            System.out.println("✅ Pasaporte creado correctamente:");
            System.out.println(pasaporte);

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: uno de los campos numéricos tiene formato inválido.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("❌ Error inesperado al crear pasaporte: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

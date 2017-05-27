package Modelo;

public class Prestamo {

    //Etiqueta del elemento a petición
    private int etiquetaInv;
    //Identificador del solicitante
    private long identificadorSol;
    //Fecha de devolución
    private String fecha;
    /*Si ya se devolvio es true de lo contrario será false */
    private String EstadoUSol;

    public int getEtiquetaInv() {
        return etiquetaInv;
    }

    public void setEtiquetaInv(int etiquetaInv) {
        this.etiquetaInv = etiquetaInv;
    }

    public long getIdentificadorSol() {
        return identificadorSol;
    }

    public void setIdentificadorSol(long identificadorSol) {
        this.identificadorSol = identificadorSol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoUSol() {
        return EstadoUSol;
    }

    public void setEstadoUSol(String EstadoUSol) {
        this.EstadoUSol = EstadoUSol;
    }

}

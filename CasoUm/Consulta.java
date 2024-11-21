package casoum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta implements Comparable<Consulta> {
    private String dataConsulta;
    private String status; // Agendada, Concluída ou Cancelada
    private Date data;
    private String paciente;

    public Consulta(String paciente, String data) throws ParseException { 
        this.paciente = paciente; setData(data);
    }

    public Consulta(String dataConsulta) throws ParseException {
        if (!dataConsulta.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Data no formato inválido. Use dd/mm/yyyy.");
        }
        this.dataConsulta = dataConsulta;
        this.status = "Agendada";
    }

    @Override
    public String toString() {
        return "Data: " + dataConsulta + ", Status: " + status;
    }

    /*@Override
    public int compareTo(Consulta outraConsulta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data1 = sdf.parse(this.dataConsulta);
            Date data2 = sdf.parse(outraConsulta.dataConsulta);
            return data1.compareTo(data2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }*/

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public void setData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.data = sdf.parse(data);
    }
    
    public String getPaciente() { 
    return paciente;
    }

    @Override 
    public int compareTo(Consulta o) { 
        return this.data.compareTo(o.data); 
    }

}

package pe.edu.cibertec.appcinecibertec.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder //Patrón de diseño, lo que hace cuando tenemos una clase encapsulada, internamente los utiliza, cuando enviado la data ya nos necesario poner set
public class ResultadoResponse {
	
	public Boolean respuesta;
	private String mensaje;

}

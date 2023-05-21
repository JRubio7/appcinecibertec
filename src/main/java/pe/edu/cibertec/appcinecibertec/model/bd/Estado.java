package pe.edu.cibertec.appcinecibertec.model.bd;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "estado")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idestado")
	private Integer idEstado;
	@Column(name= "descestado")
	private String descEstado;

	
	//Un estado puede estar en muchasa salas, este es opcional salvo que queremos el listado de estados con las salas asociadas
	@OneToMany(mappedBy= "estado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Sala> salaList;
}

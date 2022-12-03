package tg.ipnet.university.devoir.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Categorie extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -596654101938846893L;
	
	@Column(name="cle", length=60, nullable=false, unique=true)
	private String cle;
	
	@Column(name="libelle", length=60, nullable=false, unique=true)
	private String libelle;
	
	/*Ajout de la relation OneToMany entre Categorie et Medicament*/
	@OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    private Set<Medicament> medicaments;
	
	public Categorie() {
		
	}
	
	public Categorie(String cle, String libelle) {
		this.cle = cle;
		this.libelle = libelle;
	}

	public String getCle() {
		return cle;
	}

	public void setCle(String cle) {
		this.cle = cle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	
}

package tg.ipnet.university.devoir.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="cle", length=60, nullable=false, unique=true)
	private String cle;
	
	@Column(name="libelle", length=60, nullable=false, unique=true)
	private String libelle;
	
	@Column(name="prix_unitaire")
	private Double prixUnitaire;
	
	@Column(name="quantite_en_stock")
	private Integer quantiteEnStock;
	
	@Column(name="date_peremption")
	@Temporal(TemporalType.DATE)
	private Date datePeremption;
	
	/*Ajout de la relation ManyToOne entre Medicament et Categorie*/
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Medicament() {
    	
    }
    
	public Medicament(String cle, String libelle, Double prixUnitaire, Integer quantiteEnStock, Date datePeremption) {
		this.cle = cle;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.quantiteEnStock = quantiteEnStock;
		this.datePeremption = datePeremption;
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
	public Double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public Integer getQuantiteEnStock() {
		return quantiteEnStock;
	}
	public void setQuantiteEnStock(Integer quantiteEnStock) {
		this.quantiteEnStock = quantiteEnStock;
	}
	public Date getDatePeremption() {
		return datePeremption;
	}
	public void setDatePeremption(Date datePeremption) {
		this.datePeremption = datePeremption;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}

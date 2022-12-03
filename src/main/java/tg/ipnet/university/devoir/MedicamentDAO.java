package tg.ipnet.university.devoir;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import tg.ipnet.university.devoir.entities.Categorie;
import tg.ipnet.university.devoir.entities.Medicament;

public class MedicamentDAO {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	public MedicamentDAO() {
		
	}
	
	public void rechercheMedicamentParCle(String cle) {
		
		try {
			entityManager.getTransaction().begin();
			//Medicament medicament = (Medicament) entityManager.find(Medicament.class, cle);
			
			TypedQuery<Medicament> requete = entityManager.createQuery(
					  "SELECT m FROM Medicament m WHERE m.cle = :cle" , Medicament.class);
					
			Medicament medicament = requete.setParameter("cle", cle).getSingleResult();
					
			System.out.println("Cle du médicament : " + medicament.getCle());
			System.out.println("Libelle du medicament :" + medicament.getLibelle());
			System.out.println("Prix unitaire du medicament :" + medicament.getPrixUnitaire());
			System.out.println("Quantite en stock du medicament :" + medicament.getQuantiteEnStock());
			System.out.println("Date de péremption du medicament :" + medicament.getDatePeremption());
			System.out.println("Catégorie du medicament :" + medicament.getCategorie());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void rechercheMedicamentParLibelle(String libelle) {
		
		try {
			entityManager.getTransaction().begin();
			//Medicament medicament = (Medicament) entityManager.find(Medicament.class, cle);
			
			TypedQuery<Medicament> requete = entityManager.createQuery(
					  "SELECT m FROM Medicament m WHERE m.libelle = :libelle" , Medicament.class);
					
			Medicament medicament = requete.setParameter("libelle", libelle).getSingleResult();
					
			System.out.println("Cle du médicament : " + medicament.getCle());
			System.out.println("Libelle du medicament :" + medicament.getLibelle());
			System.out.println("Prix unitaire du medicament :" + medicament.getPrixUnitaire());
			System.out.println("Quantite en stock du medicament :" + medicament.getQuantiteEnStock());
			System.out.println("Date de péremption du medicament :" + medicament.getDatePeremption());
			System.out.println("Catégorie du medicament :" + medicament.getCategorie());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public Medicament ajoutMedicament(String cle, String libelle, Double prixUnitaire, Integer quantiteEnStock,
			Date datePeremption) {
		Medicament medicament = new Medicament();
		try {
			entityManager.getTransaction().begin();
			medicament.setCle(cle);
			medicament.setLibelle(libelle);
			medicament.setPrixUnitaire(prixUnitaire);
			medicament.setQuantiteEnStock(quantiteEnStock);
			medicament.setDatePeremption(datePeremption);
			medicament.setCategorie(new Categorie("CAT001", "Maladie drépanocitaire"));
			medicament = entityManager.merge(medicament);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return medicament;

	}

	public void listeMedicamentsParDate(Date datePeremption) {
		/*TypedQuery<Medicament> requete = entityManager.createQuery(
				  "SELECT m FROM Medicament m WHERE m.datePeremption = :datePeremption" , Medicament.class);
				
		Medicament medicament = requete.setParameter("datePeremption", datePeremption).getSingleResult();
		*/
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Medicament> requete = entityManager.createQuery(
					  "SELECT m FROM Medicament m WHERE m.datePeremption = :datePeremption" , Medicament.class);
					
			List<Medicament> medicaments = requete.setParameter("datePeremption", datePeremption).getResultList();
			for (Iterator<Medicament> iterator = medicaments.iterator(); iterator.hasNext();) {
				Medicament medicament = (Medicament) iterator.next();
				System.out.println("Cle du médicament : " + medicament.getCle());
				System.out.println("Libelle du medicament :" + medicament.getLibelle());
				System.out.println("Prix unitaire du medicament :" + medicament.getPrixUnitaire());
				System.out.println("Quantite en stock du medicament :" + medicament.getQuantiteEnStock());
				System.out.println("Date de péremption du medicament :" + medicament.getDatePeremption());
				System.out.println("Catégorie du medicament :" + medicament.getCategorie());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		
	}
	
	public void listeMedicamentsParCategorie(Date datePeremption, String categorie) {
		
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Medicament> requete = entityManager.createQuery(
					  "SELECT m FROM Medicament m INNER JOIN m.categorie c WHERE m.datePeremption = :datePeremption AND c.libelle = :categorie " , Medicament.class);
					
			List<Medicament> medicaments = requete.setParameter("datePeremption", datePeremption)
					.setParameter("categorie", categorie)
					.getResultList();
			for (Iterator<Medicament> iterator = medicaments.iterator(); iterator.hasNext();) {
				Medicament medicament = (Medicament) iterator.next();
				System.out.println("Cle du médicament : " + medicament.getCle());
				System.out.println("Libelle du medicament :" + medicament.getLibelle());
				System.out.println("Prix unitaire du medicament :" + medicament.getPrixUnitaire());
				System.out.println("Quantite en stock du medicament :" + medicament.getQuantiteEnStock());
				System.out.println("Date de péremption du medicament :" + medicament.getDatePeremption());
				System.out.println("Catégorie du medicament :" + medicament.getCategorie());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void listesMedicaments() {

		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Medicament> medicaments = entityManager.createQuery("FROM Medicament").getResultList();
			for (Iterator<Medicament> iterator = medicaments.iterator(); iterator.hasNext();) {
				Medicament medicament = (Medicament) iterator.next();
				System.out.println("Cle du médicament : " + medicament.getCle());
				System.out.println("Libelle du medicament :" + medicament.getLibelle());
				System.out.println("Prix unitaire du medicament :" + medicament.getPrixUnitaire());
				System.out.println("Quantite en stock du medicament :" + medicament.getQuantiteEnStock());
				System.out.println("Date de péremption du medicament :" + medicament.getDatePeremption());
				System.out.println("Catégorie du medicament :" + medicament.getCategorie());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void modifierMedicament(Long idMedicament, String cle, String libelle, Double prixUnitaire,
			Integer quantiteEnStock, Date datePeremption) {
		try {
			entityManager.getTransaction().begin();
			Medicament medicament = (Medicament) entityManager.find(Medicament.class, idMedicament);
			medicament.setCle(cle);
			medicament.setLibelle(libelle);
			medicament.setPrixUnitaire(prixUnitaire);
			medicament.setQuantiteEnStock(quantiteEnStock);
			medicament.setDatePeremption(datePeremption);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void supprimerMedicament(Long idMedicament) {
		try {
			entityManager.getTransaction().begin();
			Medicament medicament = (Medicament) entityManager.find(Medicament.class, idMedicament);
			entityManager.remove(medicament);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
}

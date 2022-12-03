package tg.ipnet.university.devoir;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Console {
	
	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub String nom; String prenom;
		MedicamentDAO medicamentDAO = new MedicamentDAO();
		try (Scanner scanner = new Scanner(System.in)) 
		{ 
			@SuppressWarnings("unused")
			boolean isRunning = true;
 
			while (true) 
			{ 
				System.out.println("\nHello Pharmacien !!");
				System.out.println("\nFaire votre choix !!");
				System.out.println("\n1. Ajouter un médicament");
				System.out.println("2. Lister tous les médicaments");
				System.out.println("3. Supprimer un médicament");
				System.out.println("4. Modifier un médicament");
				System.out.println("5. Rechercher un médicament");
				System.out.println("6. Lister tous les médicaments périmées");
				System.out.println("7. Lister tous les médicaments périmées d'une catégorie");
				System.out.println("8. Quitter\n"); System.out.print("Votre choix : ");
				
				int choix = scanner.nextInt(); switch (choix) 
				{ 
					case 1:
						System.out.println(">>> Insertion d'un médicament\n");
						System.out.print("Entrer la clé du médicament : "); 
						String cle = scanner.next();
						System.out.print("Entrer le libellé du médicament : "); 
						String libelle = scanner.next();
						System.out.print("Entrer le prix unitaire du médicament : "); 
						double prixUnitaire = scanner.nextDouble();
						System.out.print("Entrer la quantité en stock du médicament : "); 
						int quantite = scanner.nextInt();
						System.out.print("Entrer la date de péremption du médicament (dd-MM-yyyy) : "); 
						String date = scanner.next();
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						Date datePeremption = formatter.parse(date);
						medicamentDAO.ajoutMedicament(cle, libelle, prixUnitaire, quantite, datePeremption);
						break; 
					case 2:
						System.out.println(">>> Listes de tous les médicaments\n");
						medicamentDAO.listesMedicaments();
						break; 
					case 3:
						System.out.println(">>> Suppression d'un médicament\n");
						System.out.print("Entrer l'id du médicament : ");
						Long idMedicament = scanner.nextLong();
						medicamentDAO.supprimerMedicament(idMedicament);
						System.out.println("Suppression effectué avec succès!");
						break;
					case 4: 
						System.out.println(">>> Modification d'un médicament\n");
						System.out.println("Entrer l'id du médicament : ");
						System.out.print("Entrer la clé du médicament : "); 
						String cle1 = scanner.next();
						System.out.print("Entrer le libellé du médicament : "); 
						String libelle1 = scanner.next();
						System.out.print("Entrer le prix unitaire du médicament : "); 
						double prixUnitaire1 = scanner.nextDouble();
						System.out.print("Entrer la quantité en stock du médicament : "); 
						int quantite1 = scanner.nextInt();
						System.out.print("Entrer la date de péremption au format (dd-MM-yyyy) : "); 
						String date1 = scanner.next();
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
						Date datePeremption1 = formatter1.parse(date1);
						medicamentDAO.ajoutMedicament(cle1, libelle1, prixUnitaire1, quantite1, datePeremption1);
						System.out.println("Modification effectué avec succès!");
						break; 
					case 5:
						System.out.println(">>> Recherche d'un médicament\n");
						System.out.print("Entrer le libellé du médicament : "); 
						String libelle2 = scanner.next();
						medicamentDAO.rechercheMedicamentParLibelle(libelle2);
						break; 
					case 6:
						System.out.println(">>> Listes tous les médicaments périmées\n");
						System.out.print("Entrer une date de péremption au format (dd-MM-yyyy) : "); 
						String date3 = scanner.next();
						SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy");
						Date datePeremption3 = formatter3.parse(date3);
						medicamentDAO.listeMedicamentsParDate(datePeremption3);
						break;
					case 7:
						System.out.println(">>> Listes tous les médicaments périmées d'une catégorie\n");
						System.out.print("Entrer une date de péremption au format (dd-MM-yyyy) : "); 
						String date2 = scanner.next();
						SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
						Date datePeremption2 = formatter2.parse(date2);
						System.out.print("Entrer la catégorie du médicament : "); 
						String categorie = scanner.next();
						medicamentDAO.listeMedicamentsParCategorie(datePeremption2, categorie);
						break;
					case 8:
						System.out.println("Merci cher pharmacien. Visitez encore !"); 
						isRunning = false;
						break; 
					default: 
						System.out.println("Choix incorrect"); break; }
				
			} 
		} catch (NumberFormatException e) 
			{ // TODO Auto-generated catch block
			e.printStackTrace(); 
			}

	}
}

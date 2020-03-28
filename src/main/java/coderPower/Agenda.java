package coderPower;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Objectif
 *
 * Difficile de trouver un moment libre dans l'agenda de tous vos collègues pour organiser vos réunions d'équipe !
 * Vous décidez de leur demander de vous communiquer les créneaux où ils sont indisponibles.
 * En utilisant, ces données, votre objectif est de trouver un créneau de 60 minutes consécutives qui conviendra à tout le monde pendant la semaine à venir.
 *
 * Données
 *
 * Entrée
 *
 * Ligne 1 : un entier N compris entre 1 et 1000 représentant le nombre de créneaux impossibles pour la réunion
 * Lignes 2 à N + 1 : un créneau impossible pour un collègue au format jour hh:mm-hh:mm.
 * Le jour est au format ISO : 1 = lundi, 2 = mardi, etc. Les minutes de début et de fin sont incluses dans l'indisponibilité.
 * Les horaires de travail sont du lundi au vendredi de 8:00 à 17:59. Les créneaux impossibles sont inclus dans les horaires de travail de votre entreprise.
 *
 *
 * Sortie
 *
 * Une ligne au format jour hh:mm-hh:mm représentant l'horaire de réunion choisi. Il doit être :
 * - pendant les horaires de travail, sans les dépasser
 * - d'une durée d'exactement 60 minutes
 * - Les minutes de début et de fin sont incluses dans l'horaire donc une réunion de 08:00 à 8:59 ou de 9:20 à 10:19 font exactement 60 minutes
 * - n'être en intersection avec aucun créneau impossible d'aucun collègue
 * - il est garanti qu'il existe au moins une solution. S'il en existe plusieurs, vous pouvez donner n'importe quel horaire valide.
 *
 * Exemple
 * Pour l'entrée :
 * 5
 * 1 08:45-12:59
 * 3 11:09-11:28
 * 5 09:26-09:56
 * 5 16:15-16:34
 * 3 08:40-10:12
 *
 * Une solution possible est :
 * 1 13:00-13:59.
 * En effet, le premier jour il n'y a qu'un seul créneau impossible de 08:45 à 12:59.
 * En faisant par exemple commencer la réunion à 13:00 et en la terminant à 13:59, elle n'aura aucune intersection avec les créneaux impossibles.
 * Il existe par ailleurs de nombreuses autres solutions par exemple n'importe quel intervalle de 60 minutes durant les horaires de travail du jour 2.
 */
public class Agenda {
	/**
	 * (StartA <= EndB) and (EndA >= StartB)
	 * De Morgan's law
	 */
	public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int creneauxImpossibles = Integer.parseInt(sc.nextLine());
		Map<String,String> creneaux = new HashMap<>();
		for(int i =0;i<creneauxImpossibles;i++){
			String[] creneau = sc.nextLine().split(" ");
			creneaux.put(creneau[0],creneau[1]);
		}
		for (Map.Entry<String, String> entry : creneaux.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}

	class Calendrier {
		LocalTime debut;
		LocalTime fin;
		int dayOfWeek;

		public Calendrier(int dayOfWeek, LocalTime debut, LocalTime fin) {
			this.debut = debut;
			this.fin = fin;
			this.dayOfWeek = dayOfWeek;
		}
	}

}

//5
//1 08:45-12:59
//2 08:24-10:54
//1 14:45-14:47
//3 09:56-16:25
//5 15:16-16:28

//5
//1 08:00-17:59
//1 12:23-16:27
//4 09:49-16:14
//2 11:47-13:36
//2 12:47-15:05


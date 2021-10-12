import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import controller.EventHelper;
import model.Event;

/**
 * @author Elizabeth Allen - eallen12
 * CIS175 - Fall 2021
 * Oct 10, 2021
 */

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static EventHelper eh = new EventHelper();
	
			
	private static void addAnEvent() {
		// TODO Auto-generated method stub
		System.out.print("Enter an event: ");
		String eventName = in.nextLine();
		
		System.out.print("Enter the event date (ex. 2021-Oct-10): ");
		String userDate = in.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		formatter = formatter.withLocale(Locale.US);
		LocalDate eventDate = LocalDate.parse(userDate, formatter);
		
		Event toAdd = new Event(eventName, eventDate);
		eh.insertEvent(toAdd);
	}
	
	private static void deleteAnEvent() {
		// TODO Auto-generated method stub
		System.out.print("Enter the event to delete: ");
		String eventName = in.nextLine();
		System.out.print("Enter the event date to delete (ex. 2021-Oct-10): ");
		String userDate = in.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		formatter = formatter.withLocale(Locale.US);
		LocalDate eventDate = LocalDate.parse(userDate, formatter);
		
		Event toDelete = new Event(eventName, eventDate);
		eh.deleteEvent(toDelete);
	}

	private static void editAnEvent() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Event Name");
		System.out.println("2 : Search by Event Date");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<Event> foundEvents;
		if (searchBy == 1) {
			System.out.print("Enter the event name: ");
			String eventName = in.nextLine();
			foundEvents = eh.searchForEventByEvent(eventName);
			
		} else {
			System.out.print("Enter the event date (ex. 2021-OCT-10): ");
			String userDate = in.nextLine();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
			formatter = formatter.withLocale(Locale.US);
			LocalDate eventDate = LocalDate.parse(userDate, formatter);
			
			foundEvents = eh.searchForEventByDate(eventDate);
		}

		if (!foundEvents.isEmpty()) {
			System.out.println("Found Results.");
			for (Event n : foundEvents) {
				System.out.println(n.getId() + " : " + n.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Event toEdit = eh.searchForEventById(idToEdit);
			System.out.println("Retrieved " + toEdit.getId() + " from " + toEdit.getEventName());
			System.out.println("1 : Update Event Name");
			System.out.println("2 : Update Event Date");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Store: ");
				String newEventName = in.nextLine();
				toEdit.setEventName(newEventName);
				
			} else if (update == 2) {
				System.out.print("New Date: ");
				String newUserEventDate = in.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
				formatter = formatter.withLocale(Locale.US);
				LocalDate newEventDate = LocalDate.parse(newUserEventDate, formatter);			
				
				toEdit.setEventDate(newEventDate);
			}

			eh.updateEvent(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Events! ---");
		while (goAgain) {
			System.out.println("*  Select an event:");
			System.out.println("*  1 -- Add an event");
			System.out.println("*  2 -- Edit an event");
			System.out.println("*  3 -- Delete an event");
			System.out.println("*  4 -- View the list of events");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnEvent();
			} else if (selection == 2) {
				editAnEvent();
			} else if (selection == 3) {
				deleteAnEvent();
			} else if (selection == 4) {
				viewTheList();
			} else {
				eh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Event>allEvents=eh.showAllEvents();
		for(Event singleEvent : allEvents) {
			System.out.println(singleEvent.returnEventDetails());
		}
	}
	
}
